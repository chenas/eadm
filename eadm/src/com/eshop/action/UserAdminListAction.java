package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.UserAdminFilter;
import com.eshop.model.UserAdminModel;
import com.eshop.service.IUserAdminService;

@Component
public class UserAdminListAction  extends EntityListAction<UserAdminModel>{
	@Resource
	private IUserAdminService userAdminService;
	
	private  UserAdminFilter  userAdminFilter;

	public IUserAdminService getUserAdminService() {
		return userAdminService;
	}

	public void setUserAdminService(IUserAdminService userAdminService) {
		this.userAdminService = userAdminService;
	}

	public UserAdminFilter getUserAdminFilter() {
		return userAdminFilter;
	}

	public void setUserAdminFilter(UserAdminFilter userAdminFilter) {
		this.userAdminFilter = userAdminFilter;
	}
	
}
