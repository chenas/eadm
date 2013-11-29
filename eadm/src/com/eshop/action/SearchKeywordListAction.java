package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.SearchKeywordsFilter;
import com.eshop.model.SearchKeywordModel;
import com.eshop.service.ISearchKeywordService;

@Component
public class SearchKeywordListAction extends EntityListAction<SearchKeywordModel> {
	
	 @Resource
	 private ISearchKeywordService searchKeywordsSrvice;
	
	 private SearchKeywordsFilter   searchKeywordsFilter;

	public ISearchKeywordService getSearchKeywordsSrvice() {
		return searchKeywordsSrvice;
	}

	public SearchKeywordsFilter getSearchKeywordsFilter() {
		return searchKeywordsFilter;
	}

	public void setSearchKeywordsSrvice(ISearchKeywordService searchKeywordsSrvice) {
		this.searchKeywordsSrvice = searchKeywordsSrvice;
	}

	public void setSearchKeywordsFilter(SearchKeywordsFilter searchKeywordsFilter) {
		this.searchKeywordsFilter = searchKeywordsFilter;
	}

}
