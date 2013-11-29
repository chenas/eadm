package com.base.framwork.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.base.framwork.queryfilter.QueryFilter;

/**
 * 增删改查DAO
 * @author chenas
 * 2013.08.11
 */
@Component
public class CrudDao extends BaseDao implements ICrudDao{

	private static StringBuilder strBuilder = new StringBuilder();
	
	/**
	 *  保存记录
	 * @param obj
	 * @return true if success
	 */
	@Override
	public Boolean save(Object obj) {
		try{
			hibernateTemplate.saveOrUpdate(obj);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}
	
	/**
	 *  更新一条记录
	 * @param obj
	 * @return true if success
	 */
	@Override
	public Boolean update(Object obj) {
		try{
			hibernateTemplate.update(obj);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}

	/**
	 * 根据id更新实体
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
	@SuppressWarnings("unchecked")
	public int updateById(String clazz, String id, QueryFilter filter) throws Exception{
		if(filter != null){
			final String hql = getUpdateSQL(clazz, " where id='"+id+"'", filter);
log.info(hql);
			return update(hql);
		}
		return 0;
	}	
	

	/**
	 * 根据filter更新实体
	 * @param clazz
	 * 		com.eshop.model.UserBuyerModel
	 * @param id
	 * 				主键
	 * @param filter
	 * 				注：filter.getQueryString()不能为空
	 * @return
	 * 			更新记录数目
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateByFilter(String clazz, QueryFilter filter) throws Exception{
		if(filter != null){
			final String hql = getUpdateSQL(clazz, filter.getQueryString(), filter);
log.info(hql);
			return update(hql);
		}
		return 0;
	}	
	
	/**
	 *  自定义更新
	 * @param hql
	 * @return 
	 * 		更新的记录数目
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int update(String hql) {
		final String hql1 = hql;
log.info(hql);
		return ((Integer)hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql1);
				return query.executeUpdate();
			}
		})).intValue();
	}
	
	/**
	 * 根据id直接从数据库获取记录
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getById(Class clazz, Serializable id){
		Object entity = null;
		try{
			entity = hibernateTemplate.get(clazz, id);
		}catch(Exception ex){
			return null;
		}
		return entity;
	}
	
	/** 
	 * 加载实体
	 * @param clazz
	 * @param id
	 * @return
	 */
	@Override
	public Object loadById(Class clazz, Serializable id) {
		Object entity = null;
		try{
			entity = hibernateTemplate.load(clazz, id);
		}catch(Exception ex){
			return null;
		}
		return entity;
	}


	/**
	 *  根据id删除记录
	 * @param clazz
	 * @param id
	 * @return true if success
	 */
	@Override
	public Boolean delById(Class clazz, Serializable id) {
		return delObject(hibernateTemplate.load(clazz, id));
	}


	/**
	 * 删除记录
	 * @param object
	 * @return true if success
	 */
	@Override
	public Boolean delObject(Object object) {
		try{
			hibernateTemplate.delete(object);
		}catch(DataAccessException ex){
			return false;
		}
		return true;
	}

	/**
	 *  查找所有实体
	 * @param clazz
	 * @return
	 */
	@Override
	public List findAllObjList(String clazz) {
		return hibernateTemplate.find("from "+clazz+" as a order by a.id desc");
	}

	/**
	 * 自定义查找 不分页
	 * @param hql
	 * @param filter
	 * @return
	 */
	@Override
	public List findObjListByHql(String hql){
		return hibernateTemplate.find(hql);
	}

	/**
	 * 根据过滤条件查找实体
	 * 	将条件写出hql语句，赋值给orderByString
	 * @param clazz
	 * 					class name
	 * @return
	 */
	@Override
	public List findAllObjListByFilter(String clazz, QueryFilter filter){
		 strBuilder.append("from "+clazz+" as a");
		strBuilder.append(filter.getQueryString()==null?"" : " "+filter.getQueryString());
		if(filter.getOrderByString() !=null && !filter.getOrderByString().equals("")){
			strBuilder.append(" order by a."+filter.getOrderByString());
		}else{
			strBuilder.append(" order by a.id desc");
		}
log.info(strBuilder.toString());
		final String hql = strBuilder.toString();
		//清空
		strBuilder.setLength(0);
		return hibernateTemplate.find(hql);
	}
	
	/**
	 * 根据过滤条件查找实体
	 * @param clazz
	 * 		class name
	 * @return
	 */
	@Override
	public List findObjListByFilter(String clazz, QueryFilter filter) {
		//不分页
		if(filter.isLimited() == false){
			findAllObjListByFilter(clazz, filter);
		}
		//从第几行开始查询
		final int pSize = filter.getPageSize();
		final int pNo = (filter.getPageNo()-1)*pSize;
		strBuilder = strBuilder.append("from "+clazz+ " as a");
		strBuilder.append(filter.getQueryString()==null?"":" "+filter.getQueryString());
		if(filter.getOrderByString() != null && !filter.getOrderByString().equals("")){
			strBuilder.append(" order by a."+filter.getOrderByString());
		}else{
			strBuilder.append(" order by a.id desc");
		}
		final String hql = strBuilder.toString();
log.info(hql);
		//清空
		strBuilder.setLength(0);
		return findObjListLimit(pNo, pSize, hql);
	}

	/**
	 * 自定义查询记录
	 * @param hql
	 * @param filter
	 * @return
	 */
	@Override
	public List findObjListByHqlAndFilter(String hql,QueryFilter filter){
		//不分页
		if(filter.isLimited() == false){
			findObjListByHql(hql);
		}
		final int pSize = filter.getPageSize();
		final int pNo = (filter.getPageNo()-1)*pSize;
		final String hqlexe = hql;
log.info(hql);
		return findObjListLimit(pNo, pSize, hqlexe);
	}

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
	@SuppressWarnings("rawtypes")
	@Override
	public List findObjListLimit(final int startNum, final int listSize, final String hql){
		List list = hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				query.setMaxResults(listSize);
				query.setFirstResult(startNum);
				List result = query.list();
				if (!Hibernate.isInitialized(result))Hibernate.initialize(result);
				return result;
			}
		});	
		return list;
		
	}
	/**
	 *  统计所有的记录
	 * @param clazz
	 * @return
	 */
	@Override
	public int countObj(String clazz) {
		final String hql = "select count(*) from "+clazz+ " as a";
log.info(hql);
		return countObjByHql(hql);
	}

	/**
	 * 自定义统计记录
	 * @param hql
	 * @return
	 */
	@Override
	public int countObjByHql(String hql){
		final String hqlexe = hql;
log.info(hql);
		@SuppressWarnings("unchecked")
		Long count = (Long)hibernateTemplate.execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hqlexe);
				query.setMaxResults(1);
				return query.uniqueResult();
			}
		});	
		return count.intValue();
	}

	/**
	 *  根据过滤器统计记录数
	 * @param clazz
	 * @param filter
	 * 					需设置queryString的值
	 * @return
	 */
	@Override
	public int countObjByFilter(String clazz, QueryFilter filter) {
		strBuilder.append("select count(*) from "+clazz+ " as a");
		strBuilder.append(filter.getQueryString()==null?"":" "+filter.getQueryString());
		final String hql = strBuilder.toString();
log.info(hql);
		//清空
		strBuilder.setLength(0);
		return  countObjByHql(hql);
	}

	/**
	 *  获得jdbc连接
	 * @return
	 */
	@Override
	public Connection getConnection() {
		return hibernateTemplate.getSessionFactory().getCurrentSession().connection();
	}
	
	/*
	 * 
	 */
	protected String getSQL(){
		return "";
	}
	
	/**
	 * 由filter传的值获得sql
	 * @param clazz
	 * 		class name
	 * @param whereSuffix
	 * 						需更新的记录条件 where +...
	 * @param filter
	 * @return
	 * 		hql
	 * @throws Exception
	 */
	protected String getUpdateSQL(String clazz, String whereSuffix, QueryFilter filter){
		if(whereSuffix == null || whereSuffix.equals("")){
			log.error("whereSuffix can't be null");
			return null;
		}
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
