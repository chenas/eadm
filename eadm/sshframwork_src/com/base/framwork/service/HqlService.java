package com.base.framwork.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.base.framwork.queryfilter.QueryFilter;

public class HqlService {

	/**
	 * 日志实例
	 */
	protected final Log log = LogFactory.getLog(getClass());
	
	private static StringBuilder strBuilder = new StringBuilder();
	
	/**
	 * 
	 * 模糊查询使用
	 * 拼接 select ... where  ... like...
	 * @param clazz
	 * @param filter
	 * @param isCount
	 * 					当为true时，拼接select  count（*） from clazz where...
	 * @return
	 */
	public String getSelectLikeHql(String clazz, QueryFilter filter, boolean isCount){
		return "";
	}
	
	/**
	 * 
	 * 准确查询，或区间查询
	 * 拼接 select ...  where  ... = .....
	 * 		select ...  where  ... >= .....
	 * @param clazz
	 * @param filter
	 * @param isCount
	 * 					当为true时，拼接select  count（*） from clazz where...
	 * @return
	 */
	public String getSelectEqHql(String clazz, QueryFilter filter, boolean isCount){
		return "";
	}
	
	/**
	 * 由filter传的值获得sql
	 * @param clazz
	 * 		class name
	 * @param whereSuffix
	 * 						需更新的记录条件 where +...
	 * 						option，空时则由filter的queryString代替
	 * @param filter
	 * @return
	 * 		hql
	 * @throws Exception
	 */
	public String getUpdateHql(String clazz, String whereSuffix, QueryFilter filter){
		strBuilder.append("update "+clazz+" set");
		Class filterClass = filter.getClass();
		Field[] fields = filterClass.getDeclaredFields();
		for(Field field : fields){
			Object value = null;
			if(!field.getName().equals("isLimited") && !field.getName().equals("pageNo") &&
					!field.getName().equals("pageSize") && !field.getName().equals("orderByString") &&
					!field.getName().equals("queryString"))
			{
				try {
					value = invokeMethod(filter, field.getName(), null);
				} catch (Exception e) {
					log.error("invokeMethod exception");
					log.error(e);
					e.printStackTrace();
				}
				if(value != null){
					if(field.getType().equals(int.class) || field.getType().equals(Double.class)
							|| field.getType().equals(float.class)){
						strBuilder.append(" "+field.getName()+"="+value+",");
					}else if(field.getType().equals(String.class)){
						strBuilder.append(" "+field.getName()+"='"+value+"',");
					}else if(field.getType().equals(Date.class)){
						strBuilder.append(" "+field.getName()+"="+value+",");
					}
					log.info(field.getName()+"\t"+value);
				}
			}
		}
		String hql = strBuilder.toString();
		//清空
		strBuilder.setLength(0);
		if(whereSuffix  == null || "".equals(whereSuffix)){
			return hql + filter.getQueryString();
		}
		return hql.substring(0, hql.length()-1)+whereSuffix;
	}

	/**
	 * 获得对象属性的值
	 */
	@SuppressWarnings("unchecked")
	private static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		methodName = methodName.substring(0, 1).toUpperCase()
				+ methodName.substring(1);
		Method method = null;
		try {
			method = ownerClass.getMethod("get" + methodName);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			return " can't find 'get" + methodName + "' method";
		}
		return method.invoke(owner);
	}
	
}
