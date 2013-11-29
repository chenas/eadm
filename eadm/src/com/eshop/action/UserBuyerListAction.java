package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.UserBuyerFilter;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

@Component
public class UserBuyerListAction extends EntityListAction<UserBuyerModel>{

	@Resource
	private IUserBuyerService userBuyerService;

	//设置筛选条件
	private UserBuyerFilter userBuyerFilter;

	public UserBuyerFilter getUserBuyerFilter() {
		return userBuyerFilter;
	}

	public IUserBuyerService getUserBuyerService() {
		return userBuyerService;
	}

	public void setUserBuyerFilter(UserBuyerFilter userBuyerFilter) {
		this.userBuyerFilter = userBuyerFilter;
	}
}

