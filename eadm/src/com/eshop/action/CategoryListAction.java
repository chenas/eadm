package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.CategoryFilter;
import com.eshop.model.CategoryModel;
import com.eshop.service.ICategoryService;

@Component
public class CategoryListAction extends EntityListAction<CategoryModel>{
	@Resource
	private ICategoryService categoryService;
	
	private CategoryFilter categoryFilter;

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CategoryFilter getCategoryFilter() {
		return categoryFilter;
	}

	public void setCategoryFilter(CategoryFilter categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	

}
