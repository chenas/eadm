package com.base.framwork.domain;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 *  用于封装当前分页数据的PaginatedList实现类
 * @author chenas
 *
 */
public class PageList {
	@SuppressWarnings("rawtypes")
	
	private List list;// 每页的列表
	
	private Map<?, ?> map; // 每页的列表
	
	private int pageNumber = 1;// 当前页码
	
	private int objectsPerPage = 60;// 每页记录数
	
	private int fullListSize = 0;// 总记录数
	
	private int totalPage = 0; // 一共有多少页

	private String sortCriterion;
	private String searchId;

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}

	public int getFullListSize() {
		return fullListSize;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public Map<?, ?> getMap() {
		return map;
	}

	public void setMap(Map<?, ?> map) {
		this.map = map;
	}

	public int getTotalPage() {
		if (fullListSize % objectsPerPage == 0) {
			this.totalPage = fullListSize / objectsPerPage;
		} else {
			this.totalPage = fullListSize / objectsPerPage + 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
