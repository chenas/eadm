package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.ProductCommentFilter;
import com.eshop.model.ProductCommentModel;
import com.eshop.service.IProductCommentService;

@Component

public class ProductCommentAction  extends EntityCrudAction<ProductCommentModel>{
	@Resource
	private IProductCommentService productCommentService;
	private  ProductCommentModel   productCommentModel;
	private  ProductCommentFilter  productCommentFilter;
	public IProductCommentService getProductCommentService() {
		return productCommentService;
	}
	public void setProductCommentService(
			IProductCommentService productCommentService) {
		this.productCommentService = productCommentService;
	}
	public ProductCommentModel getProductCommentModel() {
		return productCommentModel;
	}
	public void setProductCommentModel(ProductCommentModel productCommentModel) {
		this.productCommentModel = productCommentModel;
	}
	public ProductCommentFilter getProductCommentFilter() {
		return productCommentFilter;
	}
	public void setProductCommentFilter(ProductCommentFilter productCommentFilter) {
		this.productCommentFilter = productCommentFilter;
	}
    
}
