package com.eshop.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.filter.CategoryDetailFilter;
import com.eshop.model.CategoryDetailModel;
import com.eshop.model.CategoryModel;

public class TestCategoryDetailService {

	ICategoryDetailService categoryDetailService;
	ICategoryService categoryService;
	
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryDetailService = (ICategoryDetailService) ctx.getBean("categoryDetailService");
		categoryService = (ICategoryService) ctx.getBean("categoryService");
	}
	
	@Test
	public void testInsert1(){
		UserBuyer user = new UserBuyer();
		CategoryDetailFilter cdf = new CategoryDetailFilter();
		cdf.setQueryString(" where a.name='"+"美味的食品"+"'");
		System.out.println( categoryService.findEntityListByFilter(cdf));
		CategoryModel c = categoryService.findEntityListByFilter(cdf).get(0);
		user.setRealname("Admin");
		List<CategoryDetailModel> cms = new ArrayList<CategoryDetailModel>();
			CategoryDetailModel cm = new CategoryDetailModel(); 
			cm.setName("饼干/糕点");
			cm.setDescription("饼干/糕点");
			cm.setCategoryId(c.getId());
			cms.add(cm);

			CategoryDetailModel cm1 = new CategoryDetailModel(); 
			cm1.setName("糖果/巧克力");
			cm1.setDescription("糖果/巧克力");
			cm1.setCategoryId(c.getId());
			cms.add(cm1);

			CategoryDetailModel cm2 = new CategoryDetailModel(); 
			cm2.setName("方便速食");
			cm2.setDescription("方便速食");
			cm2.setCategoryId(c.getId());
			cms.add(cm2);

			CategoryDetailModel cm3 = new CategoryDetailModel(); 
			cm3.setName("坚果/蜜饯");
			cm3.setDescription("坚果/蜜饯");
			cm3.setCategoryId(c.getId());	
			cms.add(cm3);

			CategoryDetailModel cm4 = new CategoryDetailModel(); 
			cm4.setName("肉/豆制品");
			cm4.setDescription("肉/豆制品");
			cm4.setCategoryId(c.getId());	
			cms.add(cm4);
			System.out.println(cms.size()+ "" +cms);
			for(int i=0; i<cms.size(); i++){
				
				categoryDetailService.insertEntity(cms.get(i), user);
				
			}
	}

	@Test
	public void testInsert2(){
		UserBuyer user = new UserBuyer();
		CategoryDetailFilter cdf = new CategoryDetailFilter();
		cdf.setQueryString(" where a.name='"+"好喝的饮品"+"'");
		CategoryModel c = categoryService.findEntityListByFilter(cdf).get(0);
		user.setRealname("Admin");
		List<CategoryDetailModel> cms = new ArrayList<CategoryDetailModel>();
			CategoryDetailModel cm = new CategoryDetailModel(); 
			cm.setName("水");
			cm.setDescription("水");
			cm.setCategoryId(c.getId());
			cms.add(cm);

			CategoryDetailModel cm1 = new CategoryDetailModel(); 
			cm1.setName("碳酸饮料");
			cm1.setDescription("碳酸饮料");
			cm1.setCategoryId(c.getId());
			cms.add(cm1);

			CategoryDetailModel cm2 = new CategoryDetailModel(); 
			cm2.setName("功能饮料");
			cm2.setDescription("功能饮料");
			cm2.setCategoryId(c.getId());
			cms.add(cm2);

			CategoryDetailModel cm3 = new CategoryDetailModel(); 
			cm3.setName("茶/咖啡饮料");
			cm3.setDescription("茶/咖啡饮料");
			cm3.setCategoryId(c.getId());	
			cms.add(cm3);

			CategoryDetailModel cm4 = new CategoryDetailModel(); 
			cm4.setName("牛奶乳品");
			cm4.setDescription("牛奶乳品");
			cm4.setCategoryId(c.getId());	
			cms.add(cm4);

			CategoryDetailModel cm5 = new CategoryDetailModel(); 
			cm5.setName("果汁");
			cm5.setDescription("果汁");
			cm5.setCategoryId(c.getId());	
			cms.add(cm5);
			
			for(int i=0; i<cms.size(); i++){
				
				categoryDetailService.insertEntity(cms.get(i), user);
				
			}
	}
	
	@Test
	public void testInsert3(){
		UserBuyer user = new UserBuyer();
		CategoryDetailFilter cdf = new CategoryDetailFilter();
		cdf.setQueryString(" where a.name='"+"必备日用品"+"'");
		System.out.println( categoryService.findEntityListByFilter(cdf));
		CategoryModel c = categoryService.findEntityListByFilter(cdf).get(0);
		user.setRealname("Admin");
		List<CategoryDetailModel> cms = new ArrayList<CategoryDetailModel>();
			CategoryDetailModel cm = new CategoryDetailModel(); 
			cm.setName("插线板");
			cm.setDescription("插线板");
			cm.setCategoryId(c.getId());
			cms.add(cm);

			CategoryDetailModel cm1 = new CategoryDetailModel(); 
			cm1.setName("雨伞");
			cm1.setDescription("雨伞");
			cm1.setCategoryId(c.getId());
			cms.add(cm1);

			CategoryDetailModel cm2 = new CategoryDetailModel(); 
			cm2.setName("纸制品");
			cm2.setDescription("纸制品");
			cm2.setCategoryId(c.getId());
			cms.add(cm2);

			CategoryDetailModel cm3 = new CategoryDetailModel(); 
			cm3.setName("美容洗护");
			cm3.setDescription("美容洗护");
			cm3.setCategoryId(c.getId());	
			cms.add(cm3);

			CategoryDetailModel cm4 = new CategoryDetailModel(); 
			cm4.setName("清洁/收纳");
			cm4.setDescription("清洁/收纳");
			cm4.setCategoryId(c.getId());	
			cms.add(cm4);
			
			for(int i=0; i<cms.size(); i++){
				
				categoryDetailService.insertEntity(cms.get(i), user);
				
			}
	}

	@Test
	public void testInsert4(){
		UserBuyer user = new UserBuyer();
		CategoryDetailFilter cdf = new CategoryDetailFilter();
		cdf.setQueryString(" where a.name='"+"土豪送的礼品"+"'");
		System.out.println( categoryService.findEntityListByFilter(cdf));
		CategoryModel c = categoryService.findEntityListByFilter(cdf).get(0);
		user.setRealname("Admin");
		List<CategoryDetailModel> cms = new ArrayList<CategoryDetailModel>();
			CategoryDetailModel cm = new CategoryDetailModel(); 
			cm.setName("明信片");
			cm.setDescription("明信片");
			cm.setCategoryId(c.getId());
			cms.add(cm);

			CategoryDetailModel cm1 = new CategoryDetailModel(); 
			cm1.setName("书签");
			cm1.setDescription("书签");
			cm1.setCategoryId(c.getId());
			cms.add(cm1);

			CategoryDetailModel cm2 = new CategoryDetailModel(); 
			cm2.setName("挂件/饰品");
			cm2.setDescription("挂件/饰品");
			cm2.setCategoryId(c.getId());
			cms.add(cm2);

			CategoryDetailModel cm3 = new CategoryDetailModel(); 
			cm3.setName("包包包包");
			cm3.setDescription("包包包包");
			cm3.setCategoryId(c.getId());	
			cms.add(cm3);
			
			for(int i=0; i<cms.size(); i++){
				
				categoryDetailService.insertEntity(cms.get(i), user);
				
			}
	}
	
/*	@Test
	public void testFindAll(){
		UserBuyer user = new UserBuyer();
		user.setRealname("Admin");
		List<CategoryDetailModel> cms = categoryDetailService.findEntityList();
		System.out.println(cms.size());
		for(int i=0; i<cms.size(); i++){
			categoryDetailService.deleteEntity(cms.get(i), user);
		}
	}*/
	
	
}
