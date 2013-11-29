package com.eshop.action;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.BuyerLevelFilter;
import com.eshop.model.BuyerLevelModel;
import com.eshop.service.IBuyerLevelService;

public class BuyerLevelListAction extends EntityListAction<BuyerLevelModel> {
	private IBuyerLevelService buyerLevelService;
	
	private BuyerLevelFilter buyerLevelFilter;

	public IBuyerLevelService getBuyerLevelService() {
		return buyerLevelService;
	}

	public void setBuyerLevelService(IBuyerLevelService buyerLevelService) {
		this.buyerLevelService = buyerLevelService;
	}

	public BuyerLevelFilter getBuyerLevelFilter() {
		return buyerLevelFilter;
	}

	public void setBuyerLevelFilter(BuyerLevelFilter buyerLevelFilter) {
		this.buyerLevelFilter = buyerLevelFilter;
	}
	
}
