package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.SearchKeywordsFilter;
import com.eshop.model.SearchKeywordModel;
import com.eshop.service.ISearchKeywordService;

@Component
public class SearchKeywordsAction extends EntityCrudAction<SearchKeywordModel> {
	
	 @Resource
	 private ISearchKeywordService searchKeywordsSrvice;
	 
	 private SearchKeywordModel    searchKeywordsModel;
	 
	 private SearchKeywordsFilter   searchKeywordsFilter;
	 
	public ISearchKeywordService getSearchKeywordsSrvice() {
		return searchKeywordsSrvice;
	}
	public SearchKeywordModel getSearchKeywordsModel() {
		return searchKeywordsModel;
	}
	public SearchKeywordsFilter getSearchKeywordsFilter() {
		return searchKeywordsFilter;
	}
	public void setSearchKeywordsSrvice(ISearchKeywordService searchKeywordsSrvice) {
		this.searchKeywordsSrvice = searchKeywordsSrvice;
	}
	public void setSearchKeywordsModel(SearchKeywordModel searchKeywordsModel) {
		this.searchKeywordsModel = searchKeywordsModel;
	}
	public void setSearchKeywordsFilter(SearchKeywordsFilter searchKeywordsFilter) {
		this.searchKeywordsFilter = searchKeywordsFilter;
	}

}
