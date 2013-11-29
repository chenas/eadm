package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.UserExpressFilter;
import com.eshop.model.UserExpressModel;
import com.eshop.service.IUserExpressService;

@Component
public class UserExpressListAction extends EntityListAction<UserExpressModel> {
	@Resource
	private IUserExpressService userExpressService;
	
	private  UserExpressFilter  userExpressFilter;

	public IUserExpressService getUserExpressService() {
		return userExpressService;
	}

	public void setUserExpressService(IUserExpressService userExpressService) {
		this.userExpressService = userExpressService;
	}

	public UserExpressFilter getUserExpressFilter() {
		return userExpressFilter;
	}

	public void setUserExpressFilter(UserExpressFilter userExpressFilter) {
		this.userExpressFilter = userExpressFilter;
	}
	
}
