package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.model.UserShopModel;

public class TestUserShopService {

	IUserShopService userShopService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userShopService = (IUserShopService) ctx.getBean("userShopService");
	}
	
	@Test
	public void testInsert(){
		UserBuyer user = new UserBuyer();
		user.setName("Admin");
		user.setRealname("Admin");
		 
		UserShopModel us = new UserShopModel();
		us.setName("shop2");
		us.setStoreName("shop2");
		us.setStoreId("A-002");
		us.setPassword("usstshop2");
		us.setIsEshop("0");
		userShopService.insertEntity(us, user);
		
	}
	
	@Test
	public void testFindAllList(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");
		List<UserShopModel> lists = userShopService.findEntityList();
		for(int i=0; i<lists.size(); i++){
			System.out.println(lists.get(i).getId()+"  "+lists.get(i).getName());
			//userShopService.deleteEntity(lists.get(i), user);
		}
	}

}
