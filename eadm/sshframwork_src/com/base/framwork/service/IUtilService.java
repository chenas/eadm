package com.base.framwork.service;

import java.util.Date;

public interface IUtilService {
	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public Date getSystemDateTime();

	/**
	 * 获取系统时间
	 * 格式：yyyy-MM-dd
	 * 
	 * @return 
	 */
	public String getSystemDateString();

	/**
	 * 获取系统时间
	 * 格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return 
	 */
	public String getSystemDateTimeString();
	
	/**
	 * 获取系统时间
	 * 格式：yyMMddHHmmss
	 * 
	 * @return 
	 */
	public String getSystemTimeString();

	/**
	 * 获取系统时间
	 * 格式：yyMMdd
	 * 
	 * @return 
	 */
	public String getSystem2DateString();
	
	/**
	 * md5加密字符串
	 * @param resString
	 * @return
	 *  	md5
	 */
	public String getMD5String(String resString);

}
