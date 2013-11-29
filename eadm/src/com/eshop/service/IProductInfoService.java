package com.eshop.service;

import java.util.List;

import com.base.framwork.service.IEntityService;
import com.eshop.model.ProductInfoModel;

/**
 * 
 * @author tianziwng
 *
 */
public interface IProductInfoService   extends IEntityService<ProductInfoModel>{
	
	/**
	 * 由商店编号得到其商品
	 * @param shopId
	 * @return  List
	 */
	public List<ProductInfoModel> findByShopId(String shopId);

}
