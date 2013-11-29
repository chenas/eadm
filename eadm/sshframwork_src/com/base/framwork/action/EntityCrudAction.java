package com.base.framwork.action;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.stereotype.Component;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.util.ReflectUtil;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 增删改查action
 * @author chenas
 *
 * @param <T>
 */
@Component
public class EntityCrudAction<T extends BaseModel> extends EntityBaseAction<T>{
	
	//model类名
	protected String modelName;
	
	//提示信息
	private boolean enableMessage = true;
	
	/**
	 * 进入新增页面
	 * @return  
	 * @throws Exception
	 */
	@SkipValidation
	public String intoAdd() throws Exception{
		commonOperations();
		return ADD;
	}


	/**
	 * 进入编辑页面
	 * @return ִ
	 * @throws Exception
	 */
	@SkipValidation
	public String intoEdit() throws Exception {
		commonOperations();
		setEntity(getEntityService().findEntityById(getId()));
		return EDIT;
	}
	
	/**
	 * 进入查看页面
	 * @return 
	 * @throws Exception
	 */
	@SkipValidation
	public String intoView() throws Exception {
		commonOperations();
		setEntity(getEntityService().findEntityById(getId()));
		return VIEW;
	}

	/**
	 * 提交新增信息
	 * @return  
	 * @throws Exception
	 */
	public String submitAdd() throws Exception {
		log.info(getEntityService());
		getEntityService().insertEntity(getEntity(), getLoginUser());
		if (isEnableMessage()) {
			savedMessage();
		}
		return LIST;
	}
	
	/**
	 * 提交编辑信息
	 * @return 
	 * @throws Exception
	 */
	public String submitEdit() throws Exception {
		getEntityService().updateEntityByFilter(getEntity(), getEntityFilter(), getLoginUser());
		if (isEnableMessage()) {
			updatedMessage();
		}
		return LIST;
	}

	/**
	 * 删除
	 * @return �б�ҳ
	 * @throws Exception
	 */
	@SkipValidation
	public String submitDelete() throws Exception {
		getEntityService().deleteEntityById(getId(), getLoginUser());
		if (isEnableMessage()) {
			deletedOneMessage();
		}
		return LIST;
	}

	/**
	 * 批量删除
	 * @return 
	 * @throws Exception
	 */
	@SkipValidation
	public String submitDeleteMany() throws Exception {
		getEntityService().deleteManyEntityById(getIds(), getLoginUser());
		if (isEnableMessage()) {
			deletedOneMessage();
		}
		return LIST;
	}


	/**
	 * 消息提示
	 * 
	 */
	protected void savedMessage() {
		saveMessage("common.messages.saveSuccess");
	}

	/**
	 * 消息提示
	 * 
	 */
	protected void updatedMessage() {
		saveMessage("common.messages.updateSuccess");
	}

	/**
	 * 消息提示
	 * 
	 */
	protected void deletedOneMessage() {
		saveMessage("common.messages.deleteOneSuccess");
	}

	/**
	 * 消息提示
	 * 
	 */
	protected void deletedManyMessage() {
		saveMessage("common.messages.deleteManySuccess");
	}


	public T getEntity() {
		Object result;
		try {
			result = MethodUtils.invokeMethod(this, ReflectUtil
					.getGetterOfField(getModelName()),null);
		} catch (Exception e) {
			log.error("Reflect error, when get entity of "
					+ getClass().getName() + ".");
			result = null;
		}
		return (T) result;
	}


	public void setEntity(T entity) {
		try {
			MethodUtils.invokeMethod(this, ReflectUtil
					.getSetterOfField(getModelName()), entity);
		} catch (Exception e) {
			log.error("Reflect error, when set entity of "
					+ getClass().getName() + ".");
		}
	}


	public boolean isEnableMessage() {
		return enableMessage;
	}

	public void setEnableMessage(boolean enableMessage) {
		this.enableMessage = enableMessage;
	}

}
