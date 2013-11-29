package com.base.framwork.domain;

/**
 * �û�domain�ӿ� �ھ����ҵ��ϵͳ�У��û��ʺ�domain User����ʵ�ִ˽ӿ�
 * @author chenas
 * 2013.08.11
 */

public interface IUser extends IBizDomain{
	
	/**
	 * ȡ���û���¼��
	 * 
	 * @return �û���¼��
	 */
	public String getLoginId();

	/**
	 * ȡ���û�����
	 * 
	 * @return �û�����
	 */
	public String getTrueName();

	/**
	 * ȡ���û�����
	 * 
	 * @return �û�����
	 */
	public String getPassword();

	/**
	 * ȡ���û�״̬���Ƿ񼤻�
	 * 
	 * @return �û�״̬
	 */
	public boolean isEnabled();

	/**
	 * ȡ��������ϵ�绰��ֵ
	 * 
	 * @return ��ϵ�绰
	 */
	public String getPhone();

	/**
	 * ȡ������email��ַ��ֵ
	 * 
	 * @return email��ַ
	 */
	public String getEmail();

}
