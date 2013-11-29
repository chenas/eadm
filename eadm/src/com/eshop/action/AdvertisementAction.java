package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.AdvertisementFilter;
import com.eshop.model.AdvertisementModel;
import com.eshop.service.IAdvertisementService;

@Component
public class AdvertisementAction extends EntityCrudAction<AdvertisementModel> {
	
	@Resource
	private IAdvertisementService advertisementService;
	
	private AdvertisementModel advertisementModel;
	
	private AdvertisementFilter advertisementFilter;
	
	public IAdvertisementService getAdvertisementService() {
		return advertisementService;
	}

	public void setAdvertisementService(
			IAdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}

	public AdvertisementModel getAdvertisementModel() {
		return advertisementModel;
	}

	public void setAdvertisementModel(AdvertisementModel advertisementModel) {
		this.advertisementModel = advertisementModel;
	}

	public AdvertisementFilter getAdvertisementFilter() {
		return advertisementFilter;
	}

	public void setAdvertisementFilter(AdvertisementFilter advertisementFilter) {
		this.advertisementFilter = advertisementFilter;
	}

}
