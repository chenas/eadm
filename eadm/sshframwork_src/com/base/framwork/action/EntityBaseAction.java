package com.base.framwork.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.struts2.ServletActionContext;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.queryfilter.QueryFilter;
import com.base.framwork.service.IEntityService;
import com.base.framwork.util.ReflectUtil;
import com.base.framwork.util.SpringBeanUtil;


/**
 * 实体类action
 * @author chenas
 *
 * @param <T>
 */
public class EntityBaseAction<T extends BaseModel> extends BaseAction {
	
	//action
	protected String id;
	
	/**
	 * domain
	 */
	protected String modelName = null;

	/**
	 * 由BeanID获得Service
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public IEntityService<T> getEntityService() {
		//5为model的长度
		String serviceName = getModelName().substring(0, getModelName().length()-5)+"Service";
		String beanId = serviceName.substring(0, 1).toLowerCase()+serviceName.substring(1);
		log.info("beanId: "+beanId+" seviceName: "+serviceName);
		return (IEntityService<T>) SpringBeanUtil.getSpringService(beanId);
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 *             
	 */
	protected void commonOperations() throws Exception {
	}

	/**
	 * 
	 * 
	 * @param paramString
	 *           
	 */
	protected void saveMessage(String paramString) {
		String str = getText(paramString);
		ServletActionContext.getContext().put("message", str);
		//getRequest().getSession().setAttribute(Constants.POP_MESSAGE_KEY, str);
	}
	/**
	 * ���ǰ̨�ύ��id
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * ����ǰ̨�ύ��id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 以逗号+空格隔开
	 * @return id����
	 */
	public String[] getIds() {
		if (StringUtils.isNotEmpty(id)) {
			return id.split(", ");// 
		} else {
			return new String[0];
		}
	}

	/**
	 * ModelName
	 * @return
	 */
	public String getModelName() {
		String actionName = this.getClass().getSimpleName();
		String suffix = "Action";
		if(this instanceof EntityListAction<?>){
			suffix = "ListAction";
		}
		return actionName.substring(0, actionName.length()-suffix.length())+"Model";
	}

	public void setModelName(String domainName) {
		this.modelName = domainName;
	}


	/**
	 * Domain+filter
	 * 获得实体的查询条件（列表页面简单查询）
	 * @return 查询条件
	 */
	public QueryFilter getEntityFilter(){
		QueryFilter filter = null;
		try{
log.info(ReflectUtil.getGetterOfField(getModelName().substring(0, getModelName().indexOf("Model")) + "Filter"));
			filter = (QueryFilter)MethodUtils.invokeMethod(this, ReflectUtil.getGetterOfField(getModelName().substring(0, getModelName().indexOf("Model")) + "Filter"), null);
			if(filter == null){
log.info(getFilterPackage() + "." + ReflectUtil.firstUpperCase(getModelName().substring(0, getModelName().indexOf("Model")) + "Filter"));
				Class<?> type = Class.forName(getFilterPackage() + "." + ReflectUtil.firstUpperCase(getModelName().substring(0, getModelName().indexOf("Model")) + "Filter"));
				filter = (QueryFilter)type.newInstance();
			}
		}catch (Exception e) {
			log.error("Reflect error, when get entity filter of "+ getClass().getName()+ ".");
		}
		return filter;
	}
	
	/**
	 * 设置实体的查询条件
	 * @param filter 查询条件
	 */
	public void setEntityFilter(QueryFilter filter){
		try{
			MethodUtils.invokeMethod(this, ReflectUtil.getSetterOfField("filter"), filter);
		}catch (Exception e) {
			log.error("Reflect error, when set entity filter of "+ getClass().getName()+ ".");
		}
	}

	/**
	 * 获得翻页条件类所在的包的名称
	 * @return
	 * 				 com.eshop.filter
	 */
	public String getFilterPackage(){
		return "com.eshop.filter";
	}
}
