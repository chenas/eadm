package com.eshop.filter;

import org.springframework.stereotype.Component;

import com.base.framwork.queryfilter.QueryFilter;

@Component
public class AdvertisementFilter extends QueryFilter {
	
	//是否在首页显示 （1是 ）
	private String isIndex;

	public String getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(String isIndex) {
		this.isIndex = isIndex;
	}

	//首页显示4条记录
	@Override
	public int getPageSize() {
		return 4;
	}
	
}
