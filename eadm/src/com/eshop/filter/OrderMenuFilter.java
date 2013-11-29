package com.eshop.filter;

import org.springframework.stereotype.Component;

import com.base.framwork.queryfilter.QueryFilter;

@Component
public class OrderMenuFilter extends QueryFilter {

	//设置每页十个
	@Override
	public int getPageSize() {
		return 10;
	}
	
	

}
