package com.eshop.service.impl;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.model.CategoryDetailModel;
import com.eshop.service.ICategoryDetailService;
/**
 * 
 * @author tianziwang
 *
 */
@Component
public class CategoryDetailService extends EntityService<CategoryDetailModel> implements ICategoryDetailService{

	/**
	 * 由名字获取CategoryDtailModel
	 * @param cateName
	 * @return
	 */
	public CategoryDetailModel getByName(String cateName){
		if("".equals(cateName) || cateName == null){
			return null;
		}
		return (CategoryDetailModel) crudDao.findObjListByHql("from CATEGORY_DETAIL as a where a.name='"+cateName+"'").get(0);
	}
}
