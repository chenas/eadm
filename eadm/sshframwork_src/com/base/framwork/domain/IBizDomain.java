package com.base.framwork.domain;

/**
 * 所有domain的通用接口
 * @author chenas
 *2013年08月11日
 */

public interface IBizDomain {
	
	/**
	 * 取得主键
	 */
	public String getId();
	
	/**
	 * 设置主键
	 */
	public void setId(String id);
	
	/**
	 * equals
	 * 
	 * @param o
	 *            比较对象
	 * @return 是否相等
	 */
	public boolean equals(Object o);

	/**
	 * hashCode
	 * 
	 * @return hashCode值
	 */
	public int hashCode();

}
