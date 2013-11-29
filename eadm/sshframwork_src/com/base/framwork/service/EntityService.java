package com.base.framwork.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.IUser;
import com.base.framwork.queryfilter.QueryFilter;

/**
 * 实体类service
 * @author chenas
 *
 * @param <T>
 * 
 * 2013.09.13
 */
@Component
public class EntityService<T extends BaseModel> extends BaseService implements IEntityService<T>{

	/**
	 * 根据id取得记录	
	 * 		先从缓存去，找不到才到数据库找
	 * @param id
	 * 		主键
	 * @return
	 */
	@Override
	public T findEntityById(String id) {
		return (T) crudDao.loadById(getTClass(), id);
	}

	/**
	 * 由id取得记录
	 * 	直接从数据库取
	 * @param id
	 * 			主键
	 * @return
	 */
	@Override
	public T getEntityById(String id) {
		return (T) crudDao.getById(getTClass(), id);
	}

	/**
	 * 查找所有实体
	 * @return
	 */
	@Override
	public List<T> findEntityList() {
		return crudDao.findAllObjList(getTClass().getName());
	}

	/**
	 * 根据过滤器查找实体
	 * @param filter
	 * @return
	 */
	@Override
	public List<T> findEntityListByFilter(QueryFilter filter) {
		return crudDao.findObjListByFilter(getTClass().getName(), filter);
	}

	/**
	 * 插入记录
	 * @param entity
	 *           实体类
	 * @param user
	 * @return id
	 */
	@Override
	public String insertEntity(T entity, IUser optUser) {
		entity.setCreateTime(utilService.getSystemDateTimeString());
		if(optUser != null){
			entity.setCreateUser(optUser.getTrueName());
		}
		beforeInsertEntity(entity, optUser);
		crudDao.save(entity);
		afterInsertEntity(entity, optUser);;
		return null;//(T) crudDao.findObjListByHql("from "+getTClass().getName()+" as a where a.createTime = '"+entity.getCreateTime()+"'").get(0);
	}

	//����һ����¼֮ǰ�Ĳ���
	protected void beforeInsertEntity(T entity, IUser optUser){
		
	}
	//����һ����¼֮���Ĳ���
	protected void afterInsertEntity(T entity, IUser optUser){
		
	}


	/**
	 * 删除记录
	 * @param entity
	 * @param optUser
	 */
	@Override
	public void deleteEntity(T entity, IUser optUser){
		beforeDeleteEntity(entity, optUser);
		crudDao.delObject(entity);
		AfterDeleteEntity(entity, optUser);
		
	}
	
	/**
	 * 实体类主键
	 * 
	 * @param id
	 *         主键
	 * @param optUser
	 *         操作用户
	 *            
	 */  
	@Override
	public void deleteEntityById(String id, IUser optUser) {
		beforeDeleteEntity(id, optUser);
		crudDao.delById(getTClass(), id);
		AfterDeleteEntity(id, optUser);
	}
	
	//ɾ������֮ǰ
	protected void beforeDeleteEntity(T entity, IUser optUser){
		
	}
	//ɾ������֮��
	protected void AfterDeleteEntity(T entity, IUser optUser){
		
	}
	
	//ɾ������֮ǰ
	protected void beforeDeleteEntity(String id, IUser optUser){
		
	}
	//ɾ������֮��
	protected void AfterDeleteEntity(String id, IUser optUser){
		
	}

	/**
	 * 实体类id
	 * 
	 * @param ids
	 *          主键数组
	 * @param optUser
	 *          操作用户
	 */
	@Override
	public void deleteManyEntityById(String[] ids, IUser optUser) {
		if(ids != null && ids.length>0){
			for(int i=0; i<ids.length; i++){
				deleteEntityById(ids[i], optUser);
			}
		}
	}
	
	/**
	 * 批量删除
	 * @param entitys
	 * @param optUser
	 */
	@Override
	public void deleteManyEntity(List<T> entitys, IUser optUser){
		if(entitys != null && entitys.size()>0){
			for(int i=0; i<entitys.size(); i++){
				deleteEntity(entitys.get(i), optUser);
			}
		}
	}

	/**
	 * 更新对象
	 * 	适合于更新整个对象
	 * 
	 * @param entity
	 *            实体类
	 * @param optUser
	 *            操作用户
	 */
	@Override
	public void updateEntity(T entity, IUser optUser) {
		entity.setUpdateTime(utilService.getSystemDateTimeString());
		beforUpdate(entity, optUser);
		crudDao.update(entity);
		afterUpdate(entity, optUser);
	}

	/**
	 * 根据过滤器更新记录
	 * @param entity
	 * @param filter
	 * @param optUser
	 * @throws Exception
	 */
	public void updateEntityByFilter(T entity, QueryFilter filter, IUser optUser) throws Exception {
		entity.setUpdateTime(utilService.getSystemDateTimeString());
		beforUpdate(entity, optUser);
		crudDao.updateById(getTClass().getName(), entity.getId(), filter);
		afterUpdate(entity, optUser);
	}

	//����ǰ����
	protected void beforUpdate(T entity, IUser optUser){
		
	}
	//���º�����
	protected void afterUpdate(T entity, IUser optUser){
		
	}

	/**
	 * 根据过滤条件统计记录数
	 * @param entity
	 * @param filter
	 * @return
	 */
	@Override
	public int countEntityByFilter(QueryFilter filter){
		return crudDao.countObjByFilter(getTClass().getName(), filter);
	}
	
	/**
	 * 自定义统计数量
	 * @param entity
	 * @return
	 */
	@Override
	public int countEntityByHql(String hql){
		return crudDao.countObjByHql(hql);
	}
	
	//得到获得T.class
	@SuppressWarnings("unchecked")
	public Class<T> getTClass(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
