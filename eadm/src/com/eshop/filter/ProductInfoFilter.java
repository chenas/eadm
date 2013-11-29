package com.eshop.filter;

import org.springframework.stereotype.Component;

import com.base.framwork.queryfilter.QueryFilter;

@Component
public class ProductInfoFilter extends QueryFilter {
	
	//商品名称
	private String name;
	
	//商品关键词
	private String keyword;

	public String getName() {
		return name;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
