package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.BuyerAddrFilter;
import com.eshop.filter.UserBuyerFilter;
import com.eshop.model.BuyerAddrModel;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IBuyerAddrService;
import com.eshop.service.IUserBuyerService;


@Component
public class BuyerAddrListAction extends EntityListAction<UserBuyerModel> {
	@Resource
	private IBuyerAddrService buyerAddrService;
	
	private BuyerAddrFilter buyerAddrFilter;

	public IBuyerAddrService getBuyerAddrService() {
		return buyerAddrService;
	}

	public void setBuyerAddrService(IBuyerAddrService buyerAddrService) {
		this.buyerAddrService = buyerAddrService;
	}

	public BuyerAddrFilter getBuyerAddrFilter() {
		return buyerAddrFilter;
	}

	public void setBuyerAddrFilter(BuyerAddrFilter buyerAddrFilter) {
		this.buyerAddrFilter = buyerAddrFilter;
	}

	
}
