package com.base.framwork.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.base.framwork.dao.ICrudDao;

/**
 * IBaseServiceʵ����
 * @author chenas
 * 2013.08.11
 */
public class BaseService implements IBaseService{
	
	@Resource
	protected ICrudDao crudDao;

	@Resource
	protected IUtilService utilService;

	/**
	 * 日志实例
	 */
	protected final Log log = LogFactory.getLog(getClass());
	
}
