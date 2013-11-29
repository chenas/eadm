package com.eshop.service;

import com.base.framwork.service.IEntityService;
import com.eshop.model.UserShopModel;
/**
 * 
 * @author tianziwang
 */
public interface IUserShopService  extends IEntityService<UserShopModel>{
	/**
	 * 根据商店编号找到商店实体
	 * @param storeId
	 * @return
	 * 			UserShopModel
	 */
	public UserShopModel findByStoreId(String storeId);

}
