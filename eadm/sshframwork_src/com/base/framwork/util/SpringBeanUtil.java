package com.base.framwork.util;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Spring bean������
 * 
 */
public class SpringBeanUtil {
	/**
	 * 根据beanId获得实例化对象
	 * @param beanId
	 * @return bean
	 */
	public static Object getSpringService(String beanId) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(ServletActionContext.getServletContext());
		Object bean = null;
		try{
			bean = ctx.getBean(beanId);
		}catch (Exception e) {
			System.out.println("no such bean found");
		}
		return bean;
	}
}
