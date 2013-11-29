package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.ProductCommentFilter;
import com.eshop.model.ProductCommentModel;
import com.eshop.service.IProductCommentService;

@Component

public class ProductCommentListAction  extends EntityListAction<ProductCommentModel>{
	@Resource
	private IProductCommentService productCommentService;
	
	private  ProductCommentFilter  productCommentFilter;

	public IProductCommentService getProductCommentService() {
		return productCommentService;
	}

	public void setProductCommentService(
			IProductCommentService productCommentService) {
		this.productCommentService = productCommentService;
	}

	public ProductCommentFilter getProductCommentFilter() {
		return productCommentFilter;
	}

	public void setProductCommentFilter(ProductCommentFilter productCommentFilter) {
		this.productCommentFilter = productCommentFilter;
	}
	
}
