package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 
 * @author Administrator 页面搜索关键词 记录用户输入的关键词
 * 
 */
@Entity(name = "SEARCH_KEYWORDS")
public class SearchKeywordModel extends BaseModel {
	/**
	 * 关键词
	 */
	private String keyword;
	/**
	 * 出现次数
	 */
	private int count;

	@Column(name = "keyword", length = 50, nullable = false)
	public String getKeyword() {
		return keyword;
	}

	@Column(name = "count")
	public int getCount() {
		return count;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
