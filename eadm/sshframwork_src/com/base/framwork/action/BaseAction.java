package com.base.framwork.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.base.framwork.Constants;
import com.base.framwork.domain.IUser;
import com.base.framwork.service.IUtilService;
import com.base.framwork.util.Mdcrypt;
import com.base.framwork.util.SpringBeanUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有action的基类
 * @author chenas
 *
 */
@Component
public class BaseAction extends ActionSupport implements SessionAware,
ServletRequestAware, ParameterAware, ServletResponseAware {

	/**
	 * 日志实例
	 */
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Edit
	 */
	protected static String EDIT = "Edit";

	/**
	 * Add
	 */
	protected static String ADD = "Add";

	/**
	 * View
	 */
	protected static String VIEW = "View";

	/**
	 * list
	 */
	protected static String LIST = "list";
	
	/**
	 * HTTP request
	 */
	private HttpServletRequest request;

	/**
	 * HTTP response
	 */
	private HttpServletResponse response;

	/**
	 * session a Map of HTTP session attribute name/value pairs
	 */
	private Map<String, Object> session = null;

	/**
	 * parameters a Map of parameters (name/value Strings).
	 */
	private Map<String, String[]> parameters = null;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	protected Map<String, Object> getSession(){
		return this.session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Map<String, String[]> getParameters() {
		return parameters;
	}
	
	@Resource
	protected IUtilService utilService;
	
	@Resource
	protected Mdcrypt mdcrypt;
	
	/**
	 * 获取登录用户
	 * 
	 * @return 
	 */
	public IUser getLoginUser() {
		IUser user = (IUser) doGetSessionObject(Constants.CURRENT_USER_KEY);
		if(null == user) return null;
		return user;
	}

	/**
	 * 将对象保存到session里面
	 * 
	 * @param key
	 *            键
	 * @param value
	 *           值
	 */
	public void doPutSessionObject(String key, Object value) {
		this.getSession().put(key, value);
	}

	/**
	 * 由key获取session对象
	 * 
	 * @param key
	 *  
	 *  return  
	 *  		sessionObj
	 */
	public Object doGetSessionObject(String key) {
		return getSession().get(key);
	}
	
	/**
	 * 由beanID获得实例化对象
	 */
	public Object getService(String serviceBeanId) {
		return SpringBeanUtil.getSpringService(serviceBeanId);
	}
	
}
