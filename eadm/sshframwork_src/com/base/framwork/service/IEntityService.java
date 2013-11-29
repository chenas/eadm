package com.base.framwork.service;

import java.util.List;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.BaseObject;
import com.base.framwork.domain.IUser;
import com.base.framwork.queryfilter.QueryFilter;

/**
 * 实体类service接口
 * @author chenas
 *
 * @param <T>
 * 2013.08.11
 */

public interface IEntityService<T extends BaseObject> extends IBaseService {
	
	/**
	 * 根据id取得记录	
	 * 		先从缓存去，找不到才到数据库找
	 * @param id
	 * 		主键
	 * @return
	 */
	public T findEntityById(String id);

	/**
	 * 由id取得记录
	 * 	直接从数据库取
	 * @param id
	 * 			主键
	 * @return
	 */
	public T getEntityById(String id);
	
	/**
	 * 查找所有实体
	 * @return
	 */
	public List<T> findEntityList();
	
	/**
	 * 根据过滤器查找实体
	 * @param filter
	 * @return
	 */
	public List<T> findEntityListByFilter(QueryFilter filter);
	
	/**
	 * 插入记录
	 * 	如果是已经存在的实体，则执行更新
	 * @param entity
	 *           实体类
	 * @param user
	 * @return id
	 */
	public String insertEntity(T entity, IUser optUser);

	/**
	 * 删除记录
	 * @param entity
	 * @param optUser
	 */  
	public void deleteEntity(T entity, IUser optUser);
	
	/**
	 * 删除记录
	 * @param entity
	 * @param optUser
	 */     
	public void deleteEntityById(String id, IUser optUser);
	
	/**
	 * 批量删除
	 * @param entitys
	 * @param optUser
	 */
	public void deleteManyEntityById(String[] ids, IUser optUser);
	
	/**
	 * 批量删除
	 * @param entitys
	 * @param optUser
	 */
	public void deleteManyEntity(List<T> entitys, IUser optUser);

	/**
	 * 更新对象
	 * 	适合于更新整个对象
	 * 
	 * @param entity
	 *            实体类
	 * @param optUser
	 *            操作用户
	 */
	public void updateEntity(T entity, IUser optUser);

	/**
	 * 根据过滤器更新记录
	 * @param entity
	 * @param filter
	 * @param optUser
	 * @throws Exception
	 */
	public void updateEntityByFilter(T entity, QueryFilter filter, IUser optUser) throws Exception;
	
	/**
	 * 根据过滤条件统计记录数
	 * @param entity
	 * @param filter
	 * @return
	 */
	public int countEntityByFilter(QueryFilter filter);
	
	/**
	 * 自定义统计数量
	 * @param entity
	 * @return
	 */
	public int countEntityByHql(String hql);
	
}
