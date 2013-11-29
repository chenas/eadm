package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.AdvertisementFilter;
import com.eshop.model.AdvertisementModel;
import com.eshop.service.IAdvertisementService;

@Component
public class  AdvertisementListAction extends EntityListAction<AdvertisementModel> {
	@Resource
	private IAdvertisementService advertisementService;
	
	@Resource
	private  AdvertisementFilter  advertisementFilter;

	//首页显示
	public String intoWelcome(){
		advertisementFilter.setIsIndex("1");
		advertisementFilter.setLimited(false);
		advertisementFilter.setPageSize(4);
		advertisementFilter.setQueryString(" where a.isIndex='1'");
		return intoList();
	}
	
	
	public IAdvertisementService getAdvertisementService() {
		return advertisementService;
	}

	public void setAdvertisementService(IAdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}
	
	public AdvertisementFilter getAdvertisementFilter() {
		return advertisementFilter;
	}

	public void setAdvertisementFilter(AdvertisementFilter advertisementFilter) {
		this.advertisementFilter = advertisementFilter;
	}
	
}
