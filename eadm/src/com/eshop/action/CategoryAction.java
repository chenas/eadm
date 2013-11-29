package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.CategoryFilter;
import com.eshop.model.CategoryModel;
import com.eshop.service.ICategoryService;

@Component
public class CategoryAction extends EntityCrudAction<CategoryModel>{
	@Resource
	private ICategoryService categoryService;
	private CategoryModel categoryModel;
	private CategoryFilter categoryFilter;
	public ICategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public CategoryModel getCategoryModel() {
		return categoryModel;
	}
	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}
	public CategoryFilter getCategoryFilter() {
		return categoryFilter;
	}
	public void setCategoryFilter(CategoryFilter categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	
	

}
