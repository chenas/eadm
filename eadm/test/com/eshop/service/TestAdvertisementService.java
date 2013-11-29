package com.eshop.service;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.model.AdvertisementModel;

public class TestAdvertisementService {

	IAdvertisementService advertisementService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		advertisementService = (IAdvertisementService) ctx.getBean("advertisementService");
	}
	
	@Test
	public void testInsert(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");
		for(int i=1; i<5 ; i++){
			AdvertisementModel adm = new AdvertisementModel();
			adm.setImageurl("images/ban/"+i+".jpg");
			adm.setAdBegin(new Date());
			adm.setAdEnd(new Date());
			adm.setIsIndex("1");
			adm.setContent("nice!");
			advertisementService.insertEntity(adm, user);
		}
	}
	
	@Test
	public void testFindAllList(){
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");
		List<AdvertisementModel> lists = advertisementService.findEntityList();
		System.out.println(advertisementService);
		/*for(int i=0; i<lists.size(); i++){
			advertisementService.deleteEntity(lists.get(i), user);
		}*/
	}

}
