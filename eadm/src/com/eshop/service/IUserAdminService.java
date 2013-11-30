package com.eshop.service;

import com.base.framwork.service.IEntityService;
import com.eshop.model.UserAdminModel;

public interface IUserAdminService   extends IEntityService<UserAdminModel>{
	
	/**
	 * 
	 * @param name
	 * @param password
	 * @return
	 * 				 id
	 */
	public String hasUser(String name, String password);
	
}
