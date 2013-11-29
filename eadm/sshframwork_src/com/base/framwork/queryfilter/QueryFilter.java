package com.base.framwork.queryfilter;

/**
 * 过滤器
 * 设置过滤条件
 * 属性名称与
 * @author chenas
 */
public class QueryFilter{
	
	/**
	 * 是否分页
	 * true 分页
	 */
	private boolean isLimited = true;
	
	/**
	 * 页码
	 */
	private int pageNo = 1;
	
	/**
	 * 默认每页实体的大小
	 */
	private int pageSize = 18;
	
	/**
	 * 排序语句
	 * 实例格式：" price asc" 按价格从低到高
	 */
	private String orderByString;
	
	/**
	 * 查询语句  可以count结合使用
	 * 	where +
	 * 	between
	 */
	private String queryString;

	public boolean isLimited() {
		return isLimited;
	}

	public void setLimited(boolean isLimited) {
		this.isLimited = isLimited;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderByString() {
		return orderByString;
	}

	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
}
