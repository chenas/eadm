package com.eshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IProductInfoService;
/**
 * 
 * @author tianziwang
 *
 */
@Component
public class ProductInfoService extends EntityService<ProductInfoModel> implements IProductInfoService{

	/**
	 * 由商店编号得到其商品
	 * @param shopId
	 * @return  List
	 */
	@Override
	public List<ProductInfoModel> findByShopId(String shopId){
		return crudDao.findObjListByHql("from PRODUCT_INFO as a where a.shopId='"+shopId+"'");
	}
	
}
