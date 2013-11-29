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
		for(int i=0; i<getIds().length; i++){
			setOneDown(getIds()[i]);
		}
		return SUCCESS;
	}

	//下架
	public String setDown(){
		setOneDown(id);
		return SUCCESS;
	}
	
	//批量上架
	public String setManyUp(){
		for(int i=0; i<getIds().length; i++){
			setOneUp(getIds()[i]);
		}
		return SUCCESS;
	}

	//上架
	public String setUp(){
		setOneUp(id);
		return SUCCESS;
	}
	
	//设置上架
	public void setOneUp(String id){
		productInfoModel = productInfoService.findEntityById(id);
		productInfoModel.setIsSale("1");
		productInfoService.updateEntity(productInfoModel, getLoginUser());
	}
	//设置下架
	public void setOneDown(String id){
		productInfoModel = productInfoService.findEntityById(id);
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
