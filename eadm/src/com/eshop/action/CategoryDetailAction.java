package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.CategoryDetailFilter;
import com.eshop.model.CategoryDetailModel;
import com.eshop.service.ICategoryDetailService;

@Component
public class CategoryDetailAction extends EntityCrudAction<CategoryDetailModel> {
	
	@Resource
	private ICategoryDetailService categoryDetailService;
	
	private CategoryDetailModel categoryModel;
	
	private CategoryDetailFilter categoryFilter;

	public ICategoryDetailService getCategoryDetailService() {
		return categoryDetailService;
	}

	public void setCategoryDetailService(
			ICategoryDetailService categoryDetailService) {
		this.categoryDetailService = categoryDetailService;
	}

	public CategoryDetailModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryDetailModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public CategoryDetailFilter getCategoryFilter() {
		return categoryFilter;
	}

	public void setCategoryFilter(CategoryDetailFilter categoryFilter) {
		this.categoryFilter = categoryFilter;
	}

}