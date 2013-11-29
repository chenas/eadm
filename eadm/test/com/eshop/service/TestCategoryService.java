package com.eshop.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.model.CategoryModel;

public class TestCategoryService {

	ICategoryService categoryService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService = (ICategoryService) ctx.getBean("categoryService");
	}
	
	@Test
	public void testInsert(){
		UserBuyer user = new UserBuyer();
		user.setRealname("Admin");
		List<CategoryModel> cms = new ArrayList<CategoryModel>();
			CategoryModel cm = new CategoryModel(); 
			cm.setName("美味的食品");
			cm.setDescription("美味的食品");
			cms.add(cm);

			CategoryModel cm1 = new CategoryModel(); 
			cm1.setName("好喝的饮品");
			cm1.setDescription("好喝的饮品");
			cms.add(cm1);

			CategoryModel cm2 = new CategoryModel(); 
			cm2.setName("必备日用品");
			cm2.setDescription("必备日用品");
			cms.add(cm2);

			CategoryModel cm3 = new CategoryModel(); 
			cm3.setName("土豪送的礼品");
			cm3.setDescription("土豪送的礼品");
			cms.add(cm3);
			for(int i=0; i<cms.size(); i++){
				
				categoryService.insertEntity(cms.get(i), user);
				
			}
	}
	
	@Test
	public void testFindAll(){
		UserBuyer user = new UserBuyer();
		user.setRealname("jack");
		List<CategoryModel> cms = categoryService.findEntityList();
		System.out.println(cms.size());
		for(int i=0; i<cms.size(); i++){
			categoryService.deleteEntity(cms.get(i), user);
		}
	}
	
	
}
