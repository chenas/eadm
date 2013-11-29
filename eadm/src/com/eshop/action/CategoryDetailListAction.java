package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.CategoryDetailFilter;
import com.eshop.model.CategoryDetailModel;
import com.eshop.service.ICategoryDetailService;

@Component
public class CategoryDetailListAction extends EntityListAction<CategoryDetailModel>{
	@Resource
	private ICategoryDetailService categoryDetailService;
	
	private CategoryDetailFilter categoryFilter;

	public ICategoryDetailService getCategoryDetailService() {
		return categoryDetailService;
	}

	public void setCategoryDetailService(
			ICategoryDetailService categoryDetailService) {
		this.categoryDetailService = categoryDetailService;
	}

	public CategoryDetailFilter getCategoryFilter() {
		return categoryFilter;
	}

	public void setCategoryFilter(CategoryDetailFilter categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	
}