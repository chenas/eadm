package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.UserAdminFilter;
import com.eshop.model.UserAdminModel;
import com.eshop.service.IUserAdminService;

@Component
public class UserAdminAction  extends EntityCrudAction<UserAdminModel>{
	@Resource
	private IUserAdminService userAdminService;
	private  UserAdminModel   userAdminModel;
	private  UserAdminFilter  userAdminFilter;
	public IUserAdminService getUserAdminService() {
		return userAdminService;
	}
	public void setUserAdminService(IUserAdminService userAdminService) {
		this.userAdminService = userAdminService;
	}
	public UserAdminModel getUserAdminModel() {
		return userAdminModel;
	}
	public void setUserAdminModel(UserAdminModel userAdminModel) {
		this.userAdminModel = userAdminModel;
	}
	public UserAdminFilter getUserAdminFilter() {
		return userAdminFilter;
	}
	public void setUserAdminFilter(UserAdminFilter userAdminFilter) {
		this.userAdminFilter = userAdminFilter;
	}

}
