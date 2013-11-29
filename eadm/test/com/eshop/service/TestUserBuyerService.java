package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.framwork.domain.IUser;
import com.base.framwork.queryfilter.QueryFilter;
import com.eshop.domain.UserBuyer;
import com.eshop.model.UserBuyerModel;

public class TestUserBuyerService {
	
	IUserBuyerService userBuyerService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userBuyerService = (IUserBuyerService) ctx.getBean("userBuyerService");
	}

	@Test
	public void testInsert(){
		for(int i=0; i<10; i++){
			UserBuyerModel user = new UserBuyerModel();
			UserBuyer opt = new UserBuyer();
			opt.setName("jack");
			opt.setRealname("jack");
			user.setName("Tom"+i);
			user.setPassword("1234");
			user.setIsValidate("0");
			userBuyerService.insertEntity(user, opt);
		}
	}
	@Test
	public void testFindEntityListByFilter(){
		QueryFilter filter = new QueryFilter();
		List<UserBuyerModel> users = userBuyerService.findEntityListByFilter(filter);
		for(int i=0; i<users.size(); i++){
			System.out.println(users.get(i).getName());
		}
	}
	@Test
	public void testHasUser(){
		QueryFilter filter = new QueryFilter();
		System.out.println(userBuyerService.hasUser("Tom", "1234"));
		System.out.println(userBuyerService.countEntityByFilter(filter));
	}
	@Test
	public void testUpdate(){
		IUser optuser = new UserBuyer();
		UserBuyerModel user = userBuyerService.getEntityById("58a19f15-2cbc-4b07-b243-8208f158e9c0");
		user.setName("Jack");
		userBuyerService.updateEntity(user, optuser);
	}
	@Test
	public void testFindAllObjList(){
		List<UserBuyerModel> users = userBuyerService.findEntityList();
		System.out.println(users.size());
		for(int i=0; i<users.size(); i++){
			userBuyerService.deleteEntity(users.get(i), null);
		}
	}
}
