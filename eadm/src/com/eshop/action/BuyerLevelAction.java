package com.eshop.action;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.BuyerLevelFilter;
import com.eshop.model.BuyerLevelModel;
import com.eshop.service.IBuyerLevelService;

public class BuyerLevelAction extends EntityCrudAction<BuyerLevelModel> {
	private IBuyerLevelService buyerLevelService;
	private BuyerLevelModel buyerLevelModel;
	private BuyerLevelFilter buyerLevelFilter;
	public IBuyerLevelService getBuyerLevelService() {
		return buyerLevelService;
	}
	public void setBuyerLevelService(IBuyerLevelService buyerLevelService) {
		this.buyerLevelService = buyerLevelService;
	}
	public BuyerLevelModel getBuyerLevelModel() {
		return buyerLevelModel;
	}
	public void setBuyerLevelModel(BuyerLevelModel buyerLevelModel) {
		this.buyerLevelModel = buyerLevelModel;
	}
	public BuyerLevelFilter getBuyerLevelFilter() {
		return buyerLevelFilter;
	}
	public void setBuyerLevelFilter(BuyerLevelFilter buyerLevelFilter) {
		this.buyerLevelFilter = buyerLevelFilter;
	}
	
	

}
