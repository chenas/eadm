package com.eshop.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.UserShopFilter;
import com.eshop.model.UserShopModel;
import com.eshop.service.IUserShopService;

@Component
public class UserShopAction extends EntityCrudAction<UserShopModel> {
	
	@Resource
	private IUserShopService userShopService;
	
	private  UserShopModel userShopModel;
	
	private UserShopFilter uesrShopFilter;
	
	public IUserShopService getUserShopService() {
		return userShopService;
	}

	public UserShopModel getUserShopModel() {
		return userShopModel;
	}

	public UserShopFilter getUesrShopFilter() {
		return uesrShopFilter;
	}

	public void setUserShopService(IUserShopService userShopService) {
		this.userShopService = userShopService;
	}

	public void setUserShopModel(UserShopModel userShopModel) {
		this.userShopModel = userShopModel;
	}

	public void setUesrShopFilter(UserShopFilter uesrShopFilter) {
		this.uesrShopFilter = uesrShopFilter;
	}

}
