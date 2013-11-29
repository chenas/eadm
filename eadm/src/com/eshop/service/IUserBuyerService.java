package com.eshop.service;

import com.base.framwork.service.IEntityService;
import com.eshop.model.UserBuyerModel;

/**
 * UserBuyer业务接口
 * @author chenas
 *
 */
public interface IUserBuyerService extends IEntityService<UserBuyerModel>{
	
	/**
	 * 是否有此用户
	 * @param name
	 * @param password
	 * @return
	 * 		true if has
	 */
	public String hasUser(String name, String password);
	
	/**
	 * 此邮箱是否已被注册
	 * @param Email
	 * @return
	 * 		true if has
	 */
	public boolean hasEmail(String Email);
	
}
