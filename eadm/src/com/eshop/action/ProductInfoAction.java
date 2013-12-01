package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.ProductInfoFilter;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IProductInfoService;


/**
 * 商品信息action
 * @author chenas
 *
 */
@Component
public class ProductInfoAction extends EntityCrudAction<ProductInfoModel> {
	
	@Resource
	private IProductInfoService productInfoService;
	
	private ProductInfoModel productInfoModel;
	
	private ProductInfoFilter productInfoFilter;

	//批量下架
	public String setManyDown(){
		String[] ids = getIds();
		for(int i=0; i<ids.length; i++){
			setOneDown(ids[i]);
		}
		return LIST;
	}

	//下架
	public String setDown(){
		setOneDown(id);
		return LIST;
	}
	
	//批量上架
	public String setManyUp(){
		for(int i=0; i<getIds().length; i++){
			setOneUp(getIds()[i]);
		}
		return LIST;
	}

	//上架
	public String setUp(){
		setOneUp(id);
		return LIST;
	}
	//促销
	public String setOnsale(){
		setOneOnsale(id);
		return LIST;
	}
	
	//批量促销
	public String setManyOnsale(){
		for(int i=0; i<getIds().length; i++){
			setOneOnsale(getIds()[i]);
		}
		return LIST;
	}
	//不促销
	public String setUnOnsale(){
		setOneUnOnsale(id);
		return LIST;
	}
	//批量不促销
	public String setManyUO(){
		for(int i=0; i<getIds().length; i++){
			setOneUnOnsale(getIds()[i]);
		}
		return LIST;
	}
	
	//设置促销
	public void setOneOnsale(String _id){
		productInfoModel = productInfoService.findEntityById(_id);
		productInfoModel.setIsOnsale("1");
		productInfoService.updateEntity(productInfoModel, getLoginUser());		
	}

	//设置不促销
	public void setOneUnOnsale(String _id){
		productInfoModel = productInfoService.findEntityById(_id);
		productInfoModel.setIsOnsale("0");
		productInfoService.updateEntity(productInfoModel, getLoginUser());		
	}
	
	//设置上架
	public void setOneUp(String _id){
		productInfoModel = productInfoService.findEntityById(_id);
		productInfoModel.setIsSale("1");
		productInfoService.updateEntity(productInfoModel, getLoginUser());
	}
	//设置下架
	public void setOneDown(String _id){
		productInfoModel = productInfoService.findEntityById(_id);
		productInfoModel.setIsSale("0");
		productInfoService.updateEntity(productInfoModel, getLoginUser());
	}
	
	public ProductInfoModel getProductInfoModel() {
		return productInfoModel;
	}

	public void setProductInfoModel(ProductInfoModel productInfoModel) {
		this.productInfoModel = productInfoModel;
	}

	public ProductInfoFilter getProductInfoFilter() {
		return productInfoFilter;
	}

	public void setProductInfoFilter(ProductInfoFilter productInfoFilter) {
		this.productInfoFilter = productInfoFilter;
	}

}
