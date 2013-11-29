package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.AdminLogFilter;
import com.eshop.model.AdminLogModel;
import com.eshop.service.IAdminLogService;

@Component
public class AdminLogAction extends EntityCrudAction<AdminLogModel> {
	@Resource
	private IAdminLogService adminLogService;
	private AdminLogModel adminLogModel;
	private AdminLogFilter adminLogFilter;

	public IAdminLogService getAdminLogService() {
		return adminLogService;
	}

	public void setAdminLogService(IAdminLogService adminLogService) {
		this.adminLogService = adminLogService;
	}

	public AdminLogModel getAdminLogModel() {
		return adminLogModel;
	}

	public void setAdminLogModel(AdminLogModel adminLogModel) {
		this.adminLogModel = adminLogModel;
	}

	public AdminLogFilter getAdminLogFilter() {
		return adminLogFilter;
	}

	public void setAdminLogFilter(AdminLogFilter adminLogFilter) {
		this.adminLogFilter = adminLogFilter;
	}

}
