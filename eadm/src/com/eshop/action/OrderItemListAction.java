package com.eshop.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.base.framwork.domain.IUser;
import com.eshop.domain.CartList;
import com.eshop.domain.UserBuyer;
import com.eshop.filter.OrderItemFilter;
import com.eshop.model.OrderItemModel;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IOrderItemService;
import com.eshop.service.IProductInfoService;
import com.eshop.util.DoubleUtil;
import com.eshop.util.GetMacAddrUtil;

@Component
public class OrderItemListAction extends EntityListAction<OrderItemModel> {
	
	@Resource
	private IOrderItemService orderItemService;

	private OrderItemFilter orderItemFilter;

	@Resource
	private IProductInfoService productInfoService;
	
	@Resource
	private GetMacAddrUtil getMacAddrUtil;
	
	//保存购物车商品列表
	private CartList cartList;
	
	//购买数量
	private int buyNum;
	
	//从页面传入的字符串，记录许多商品的购买数量（来自cookie）
	private String buyNums;

	//操作状态，加减商品是否成功.1表示成功
	private String isSuccess = "1";
	
	//加入购物车
	public String saveOrderItem() throws Exception{
		UserBuyer user = (UserBuyer) doGetSessionObject("loginUser");
		ProductInfoModel productInfoModel = productInfoService.findEntityById(id);
		//库存量不够
		if(buyNum > productInfoModel.getRemainNumber()){
			buyNum = 0;
			return SUCCESS;
		}
		cartList = (CartList) doGetSessionObject("cartList");
		if(cartList != null && cartList.isExist(id)){
			if(buyNum > 0){
				cartList.setNum(id, buyNum);
				orderItemService.updateEntity(cartList.getItemById(id), user);
			}
			return SUCCESS;
		}
		if(cartList == null){
			cartList = new CartList();
		}
		//点击量加1
		productInfoModel.setCounter(productInfoModel.getCounter()+1);
		OrderItemModel orderItemModel = new OrderItemModel();
		orderItemModel.setProductId(productInfoModel.getId());
		log.info("product id："+productInfoModel.getId()+"  name:  "+productInfoModel.getName());
		orderItemModel.setProductName(productInfoModel.getName());
		//促销
		if("1".equals(productInfoModel.getIsOnsale())){
			orderItemModel.setPrice(productInfoModel.getOnsalePrice());
		}else{
			orderItemModel.setPrice(productInfoModel.getPrice());
		}
		
		orderItemModel.setItempris(DoubleUtil.mul(buyNum, orderItemModel.getPrice()));
		orderItemModel.setCount(buyNum);
		orderItemModel.setImageurl(productInfoModel.getImageBig());
		orderItemModel.setIpAddr(getRequest().getRemoteAddr()); //设置ip地址
		orderItemModel.setIsFinished("0");
		if(null != user){
			orderItemModel.setBuyerId(user.getId());
			orderItemService.insertEntity(orderItemModel, null);
			log.info("orderItem has bean saved  " +" ip:"+getMacAddrUtil.getClientIp(getRequest()));
		}
		cartList.addOrderItem(orderItemModel);
		productInfoService.insertEntity(productInfoModel, null);
		doPutSessionObject("cartList", cartList);
		return SUCCESS;
	}

	//购物车商品列表
	public String cartList(){
		IUser loginUser = (IUser) doGetSessionObject("loginUser");
		cartList = (CartList) doGetSessionObject("cartList");
		if(null == cartList){
			cartList = new CartList();
		}
		if(loginUser != null){
			//刚开始登录时已经初始化
		}else if(null != id &&!"".equals(id) && null != buyNums && !"".equals(buyNums)){
			cartList.getItems().addAll(getOrderItem(id, buyNums));
		}
		doPutSessionObject("cartList", cartList);
		return LIST;
	}
	

	//增加数量
	public String addProduct(){
		cartList = (CartList) doGetSessionObject("cartList");
		if(cartList == null){
			isSuccess = "0";
			return SUCCESS;
		}
		ProductInfoModel productInfoModel = productInfoService.findEntityById(id);
		cartList.addNum(id, 1);
		if(productInfoModel.getRemainNumber() < cartList.getItemById(id).getCount()){
			cartList.decreasNum(id, 1);
			isSuccess = "0";
		}
		isSuccess = "1";
		doPutSessionObject("cartList", cartList);
		return SUCCESS;
	}

	//减少数量
	public String decProduct(){
		cartList = (CartList) doGetSessionObject("cartList");
		if(cartList == null){
			isSuccess = "0";
			return SUCCESS;
		}
		cartList.decreasNum(id, 1);
		isSuccess = "1";
		doPutSessionObject("cartList", cartList);
		return SUCCESS;
	}
	
	//设置购物车中某个商品的购买数量
	public String setProduct(){
		UserBuyer user = (UserBuyer) doGetSessionObject("loginUser");
		cartList = (CartList) doGetSessionObject("cartList");
		if(cartList == null){
			isSuccess = "0";
			return SUCCESS;
		}
		if(buyNum < 0){
			isSuccess = "0";
			return SUCCESS;
		}
		ProductInfoModel productInfoModel = productInfoService.findEntityById(id);
		if(productInfoModel.getRemainNumber() < buyNum){
			isSuccess = "0";
			return SUCCESS;
		}
		if(buyNum == 0){
			if(null != cartList.getItemById(id)){
				//将数据库中的记录一起删除
				if(null != orderItemService.findEntityById(cartList.getItemById(id).getId())){
					orderItemService.deleteEntityById(cartList.getItemById(id).getId(), null);
				}
			}
			cartList.deleteItemById(id);
		}else{
			//设置购买数量
			cartList.setNum(id, buyNum);
			if(null != user){
				orderItemService.updateEntity(cartList.getItemById(id), user);
			}
		}
		isSuccess = "1";
		doPutSessionObject("cartList", cartList);
		return SUCCESS;
	}
	
	/**
	 * 根据前台cookie传入的id字符串与购买数量字符串初始化购物车内容
	 * @param productIds
	 * 						商品主键，以逗号加空格隔开，如“1， 2， 3...”
	 * @param buyNums
	 * 						购买数量，以逗号空格隔开
	 * @return
	 * 					PageList
	 */
	private List getOrderItem(String productIds, String buyNums){
		String[] id = productIds.split(", ");
		String[] buyNum = buyNums.split(", ");
		List<OrderItemModel> itemList = new ArrayList<OrderItemModel>();
		for(int i=0; i<id.length; i++){
			OrderItemModel orderItemModel = new OrderItemModel();
			ProductInfoModel productInfoModel = productInfoService.findEntityById(id[i]);
			orderItemModel.setProductId(productInfoModel.getId());
			orderItemModel.setProductName(productInfoModel.getName());
			orderItemModel.setPrice(productInfoModel.getPrice());
			orderItemModel.setItempris(DoubleUtil.mul(Integer.parseInt(buyNum[i]), productInfoModel.getPrice()));
			orderItemModel.setCount(Integer.parseInt(buyNum[i]));
			orderItemModel.setImageurl(productInfoModel.getImageBig());
			orderItemModel.setIpAddr(getRequest().getRemoteAddr()); //设置ip地址
			itemList.add(orderItemModel);
		}
		return itemList;
	}

	public OrderItemFilter getOrderItemFilter() {
		return orderItemFilter;
	}

	public void setOrderItemFilter(OrderItemFilter orderItemFilter) {
		this.orderItemFilter = orderItemFilter;
	}

	public CartList getCartList() {
		return cartList;
	}

	public void setCartList(CartList cartList) {
		this.cartList = cartList;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public String getBuyNums() {
		return buyNums;
	}

	public void setBuyNums(String buyNums) {
		this.buyNums = buyNums;
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
}
