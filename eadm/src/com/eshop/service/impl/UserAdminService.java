package com.eshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.model.UserAdminModel;
import com.eshop.service.IUserAdminService;
/**
 * 
 * @author chenas
 * 
 *
 */
@Component
public class UserAdminService extends EntityService<UserAdminModel> implements IUserAdminService{

	/**
	 * 
	 * @param name
	 * @param password
	 * @return
	 * 				id
	 */
	public String hasUser(String name, String password){
		if(!name.equals("") && null != name && !password.equals("") && null != password){
			List<UserAdminModel> adm = null;
			adm = crudDao.findObjListByHql("from USER_ADMIN as a where a.adminName='"+name+"' and a.password='"+utilService.getMD5String(password)+"'");
			if(null != adm && adm.size()>0){
				return adm.get(0).getId();
			}
		}
		return null;
	}
}
