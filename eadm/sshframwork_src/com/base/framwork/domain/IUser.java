package com.base.framwork.domain;

/**
 * 用户domain接口 在具体的业务系统中，用户帐号domain User必须实现此接口
 * @author chenas
 * 2013.08.11
 */

public interface IUser extends IBizDomain{
	
	/**
	 * 取得用户登录名
	 * 
	 * @return 用户登录名
	 */
	public String getLoginId();

	/**
	 * 取得用户姓名
	 * 
	 * @return 用户姓名
	 */
	public String getTrueName();

	/**
	 * 取得用户密码
	 * 
	 * @return 用户密码
	 */
	public String getPassword();

	/**
	 * 取得用户状态，是否激活
	 * 
	 * @return 用户状态
	 */
	public boolean isEnabled();

	/**
	 * 取得属性联系电话的值
	 * 
	 * @return 联系电话
	 */
	public String getPhone();

	/**
	 * 取得属性email地址的值
	 * 
	 * @return email地址
	 */
	public String getEmail();

}
