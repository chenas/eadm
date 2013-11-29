package com.base.framwork.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import com.base.framwork.queryfilter.QueryFilter;

/**
 * 增删改查dao
 * @author chenas
 * 2013��08��11��
 */

public interface ICrudDao extends IBaseDao{
	
	/**
	 *  
	 * @param obj
	 * @return true if success
	 */
	public Boolean save(Object obj);

	/**
	 *  
	 * @param obj
	 * @return true if success
	 */
	public Boolean update(Object obj);

	/**
	 *  自定义更新
	 * @param hql
	 * @return 
	 * 		更新的记录数目
	 */
	public int update(String hqlString);
	
	/**
	 * 根据id更新记录
	 * @param clazz
	 * 		      eg：com.eshop.model.UserBuyerModel
	 * @param id
	 * 				主键
	 * @param filter
	 * 					保存需更新的值
	 * @return
	 * 			更新记录数目
	 * @throws Exception
	 */
	public int updateById(String clazz, String id, QueryFilter filter) throws Exception;
	
	/**
	 * 根据filter更新记录
	 * @param clazz
	 * 		class name
	 * @param id
	 * 		主键
	 * @param filter
	 * @return
	 * 		更新记录数目
	 * @throws Exception
	 */
	public int updateByFilter(String clazz, QueryFilter filter) throws Exception;
	
	/**
	 * 根据id直接从数据库获取记录
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getById(Class clazz, Serializable id);
	
	/** 
	 * 加载记录
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object loadById(Class clazz,Serializable id);
	
	/**
	 *  根据id删除记录
	 * @param clazz
	 * @param id
	 * @return true if success
	 */
	@SuppressWarnings("rawtypes")
	public Boolean delById(Class clazz,Serializable id);
	
	/**
	 * 删除记录
	 * @param object
	 * @return true if success
	 */
	public Boolean delObject(Object object);
	
	/**
	 * 根据过滤条件查找实体
	 * 	将条件写出hql语句，赋值给orderByString
	 * @param clazz
	 * 					class name
	 * @return
	 */
	public List findAllObjListByFilter(String clazz, QueryFilter filter);

	/**
	 *  查找所有实体
	 * @param clazz
	 * @return
	 */
	public List findAllObjList(String clazz);

	/**
	 * 自定义查找 
	 * @param hql
	 * @param filter
	 * @return
	 */
	public List findObjListByHql(String hqlString);
	
	/**
	 * 根据过滤条件查找实体
	 * 	将条件写出hql语句，赋值给orderByString
	 * @param clazz
	 * 		class name
	 * @return
	 */
	public List findObjListByFilter(String clazz,QueryFilter filter);
	
	/**
	 * 自定义过滤查询记录
	 * @param hql
	 * @param filter
	 * @return
	 */
	public List findObjListByHqlAndFilter(String hqlString,QueryFilter filter);
	
	/**
	 * 分页查找记录
	 * @param startNum
	 * 					起始行（mysql从0开始）
	 * @param listSize
	 * 					查询记录数目
	 * @param hql
	 * 					hql语句
	 * @return
	 * 					记录
	 */
	public List findObjListLimit(final int startNum, final int listSize, final String hql);
	
	/**
	 *  统计所有的记录
	 * @param clazz
	 * @return
	 */
	public int countObj(String clazz);

	
	/**
	 * 自定义统计记录
	 * @param hql
	 * @return
	 */
	public int countObjByHql(String hqlString);
	
	/**
	 *  根据过滤器统计记录数
	 * @param clazz
	 * @param filter
	 * @return
	 */
	public int countObjByFilter(String clazz, QueryFilter filter);
	
	/**
	 *  获得jdbc连接
	 * @return
	 */
	public Connection getConnection();

}
