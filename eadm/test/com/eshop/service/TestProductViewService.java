package com.eshop.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.view.ProductViewModel;

public class TestProductViewService {

	IProductViewService productViewService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		productViewService = (IProductViewService) ctx.getBean("productViewService");
	}
	
	@Test
	public void testInsert(){
		UserBuyer user = new UserBuyer();
		user.setRealname("jack");
		for(int i=1; i<10; i++){
			ProductViewModel p = new ProductViewModel();
			p.setName("pppp"+i);
			productViewService.insertEntity(p, user);
		}
	}
	
	
	
}
