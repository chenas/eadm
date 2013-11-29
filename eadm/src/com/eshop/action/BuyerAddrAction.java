package com.eshop.action;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.BuyerAddrFilter;
import com.eshop.model.BuyerAddrModel;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IBuyerAddrService;


@Component
public class BuyerAddrAction extends EntityCrudAction<UserBuyerModel> {
	
	@Resource
	private IBuyerAddrService buyerAddrService;
	
	private BuyerAddrModel    buyerAddrModel;
	
	private BuyerAddrFilter buyerAddrFilter;

	
	
	public BuyerAddrModel getBuyerAddrModel() {
		return buyerAddrModel;
	}
	public void setBuyerAddrModel(BuyerAddrModel buyerAddrModel) {
		this.buyerAddrModel = buyerAddrModel;
	}
	public BuyerAddrFilter getBuyerAddrFilter() {
		return buyerAddrFilter;
	}
	public void setBuyerAddrFilter(BuyerAddrFilter buyerAddrFilter) {
		this.buyerAddrFilter = buyerAddrFilter;
	}

	
}
