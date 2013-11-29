package com.eshop.service.ajax;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.service.BaseService;
import com.eshop.model.OrderItemModel;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IOrderItemService;
import com.eshop.service.IProductInfoService;
import com.eshop.service.IProductViewService;

/**
 * 前台交互
 * 商品加入购物车
 * 
 * @author chenas
 *
 */
@Component
public class ProductViewServiceAjax extends BaseService{
	
	@Resource
	private IProductViewService productViewService;
	
	@Resource
	private IProductInfoService productInfoService;
	
	@Resource
	private IOrderItemService orderItemService;
	
	/**
	 * 保存订单条目
	 * @param productId
	 * 						商品主键id
	 * @param buyNum
	 * 						购买数量
	 * @param userId
	 * 						用户主键id
	 * @return
	 * 						success if saved
	 */
	public boolean saveOrderItem(String productId, int buyNum, String userId){
		ProductInfoModel productInfoModel = productInfoService.findEntityById(productId);
		//库存量不够
		if(buyNum > productInfoModel.getRemainNumber()){
			return false;
		}
		OrderItemModel orderItemModel = new OrderItemModel();
		orderItemModel.setProductId(productId);
		orderItemModel.setProductName(productInfoModel.getName());
		orderItemModel.setPrice(productInfoModel.getPrice());
		orderItemModel.setItempris(buyNum*productInfoModel.getPrice());
		orderItemModel.setCount(buyNum);
		if(null != userId ||! "".equals(userId)){
			orderItemModel.setBuyerId(userId);
		}
		//保存mac地址
		//.......
		orderItemService.insertEntity(orderItemModel, null);
		log.info("orderItem has bean saved");
		return true;
	}

}
