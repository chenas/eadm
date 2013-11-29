package com.base.framwork.dao;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 所有dao的基类
 * @author chenas
 *2013��08��11��
 */
public class BaseDao implements IBaseDao{

	/**
	 * 操作数据库模板
	 */
	@Resource
	protected HibernateTemplate hibernateTemplate;

	/**
	 * 日志实例
	 */
	protected final Log log = LogFactory.getLog(getClass());

}
