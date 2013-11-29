package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.UserBuyerFilter;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

/**
 * 增删改查action
 * @author chenas
 *
 */
@Component
public class UserBuyerAction extends EntityCrudAction<UserBuyerModel>{

	@Resource
	private IUserBuyerService userBuyerService;
	
	//将数据传到页面
	private UserBuyerModel userBuyerModel;
	
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

	public void setUserBuyerService(IUserBuyerService userBuyerService) {
		this.userBuyerService = userBuyerService;
	}

	public UserBuyerModel getUserBuyerModel() {
		return userBuyerModel;
	}

	public void setUserBuyerModel(UserBuyerModel userBuyerModel) {
		this.userBuyerModel = userBuyerModel;
	}
	
}
