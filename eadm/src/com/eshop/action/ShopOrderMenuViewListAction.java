package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.ShopOrderMenuViewFilter;
import com.eshop.service.IShopOrderMenuViewService;
import com.eshop.view.ShopOrderMenuViewModel;

@Component
public class ShopOrderMenuViewListAction extends EntityListAction<ShopOrderMenuViewModel>{
	
	@Resource
	private IShopOrderMenuViewService shopOrderMenuViewService;
	
	private ShopOrderMenuViewFilter shopOrderMenuViewFilter;
	
	public String shopOrder(){
		
		return intoList();
	}

	public ShopOrderMenuViewFilter getShopOrderMenuViewFilter() {
		return shopOrderMenuViewFilter;
	}

	public void setShopOrderMenuViewFilter(
			ShopOrderMenuViewFilter shopOrderMenuViewFilter) {
		this.shopOrderMenuViewFilter = shopOrderMenuViewFilter;
	}

}
