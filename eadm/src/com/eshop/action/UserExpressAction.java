package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.UserExpressFilter;
import com.eshop.model.UserExpressModel;
import com.eshop.service.IUserExpressService;

@Component
public class UserExpressAction extends EntityCrudAction<UserExpressModel> {
	@Resource
	private IUserExpressService userExpressService;
	private  UserExpressModel   userExpressMOdel;
	private  UserExpressFilter  userExpressFilter;
	public IUserExpressService getUserExpressService() {
		return userExpressService;
	}
	public void setUserExpressService(IUserExpressService userExpressService) {
		this.userExpressService = userExpressService;
	}
	public UserExpressModel getUserExpressMOdel() {
		return userExpressMOdel;
	}
	public void setUserExpressMOdel(UserExpressModel userExpressMOdel) {
		this.userExpressMOdel = userExpressMOdel;
	}
	public UserExpressFilter getUserExpressFilter() {
		return userExpressFilter;
	}
	public void setUserExpressFilter(UserExpressFilter userExpressFilter) {
		this.userExpressFilter = userExpressFilter;
	}

}
