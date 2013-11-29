package com.eshop.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.UserShopFilter;
import com.eshop.model.UserShopModel;
import com.eshop.service.IUserShopService;

@Component
public class UserShopListAction extends EntityListAction<UserShopModel> {
	
	@Resource
	private IUserShopService userShopService;

	private UserShopFilter  userShopFilter;
	
	private List<UserShopModel>  shopList;

	public String allShop(){
		shopList = userShopService.findEntityList();
		return LIST;
	}
	public UserShopFilter getUserShopFilter() {
		return userShopFilter;
	}

	public void setUserShopFilter(UserShopFilter userShopFilter) {
		this.userShopFilter = userShopFilter;
	}
	public List<UserShopModel> getShopList() {
		return shopList;
	}
	public void setShopList(List<UserShopModel> shopList) {
		this.shopList = shopList;
	}
	
}
