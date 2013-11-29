package com.eshop.service.impl;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.model.UserShopModel;
import com.eshop.service.IUserShopService;
/**
 * 
 * @author tianziwang
 *
 */
@Component
public class UserShopService extends EntityService<UserShopModel> implements IUserShopService{
	
	/**
	 * 根据商店编号找到商店实体
	 * @param storeId
	 * @return
	 * 			UserShopModel
	 */
	public UserShopModel findByStoreId(String storeId){
		return (UserShopModel) crudDao.findObjListByHql("from USER_SHOP as a where a.storeId='"+storeId+"'").get(0);
	}

}
