package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.action.EntityListAction;
import com.eshop.filter.AdminLogFilter;
import com.eshop.model.AdminLogModel;
import com.eshop.service.IAdminLogService;

@Component
public class AdminLogListAction extends EntityListAction<AdminLogModel> {
	@Resource
	private IAdminLogService adminLogService;
	
	private  AdminLogFilter  adminLogFilter;

	public IAdminLogService getAdminLogService() {
		return adminLogService;
	}

	public void setAdminLogService(IAdminLogService adminLogService) {
		this.adminLogService = adminLogService;
	}

	public AdminLogFilter getAdminLogFilter() {
		return adminLogFilter;
	}

	public void setAdminLogFilter(AdminLogFilter adminLogFilter) {
		this.adminLogFilter = adminLogFilter;
	}
	
}
