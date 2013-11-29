package com.eshop.service;

import com.base.framwork.service.IEntityService;
import com.eshop.model.CategoryDetailModel;
/**
 * 
 * @author tianziwang
 *
 */

public interface ICategoryDetailService   extends IEntityService<CategoryDetailModel>{
	
	/**
	 * 由名字获取CategoryDtailModel
	 * @param cateName
	 * @return
	 */
	public CategoryDetailModel getByName(String cateName);

}
