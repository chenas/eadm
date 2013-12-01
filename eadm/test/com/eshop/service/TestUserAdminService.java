package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.framwork.service.IUtilService;
import com.base.framwork.service.UtilService;
import com.eshop.domain.UserBuyer;
import com.eshop.model.UserAdminModel;
import com.eshop.model.UserShopModel;

public class TestUserAdminService {

	IUserAdminService userAdminService;
	IUtilService utilService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userAdminService = (IUserAdminService) ctx.getBean("userAdminService");
		utilService = (IUtilService) ctx.getBean("utilService");
	}
	
	@Test
	public void testInsert(){
		UserAdminModel adminModel = new UserAdminModel();
		adminModel.setAdminName("usstlife");
		adminModel.setAdminRole("admin");
		adminModel.setPassword(utilService.getMD5String("usstlife1010"));
		userAdminService.insertEntity(adminModel, null);
	}

}
