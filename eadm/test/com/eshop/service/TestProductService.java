package com.eshop.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.domain.UserBuyer;
import com.eshop.filter.CategoryDetailFilter;
import com.eshop.filter.CategoryFilter;
import com.eshop.filter.ProductInfoFilter;
import com.eshop.filter.UserShopFilter;
import com.eshop.model.CategoryDetailModel;
import com.eshop.model.CategoryModel;
import com.eshop.model.ProductInfoModel;
import com.eshop.model.UserShopModel;

public class TestProductService {

	IProductInfoService productInfoService;

	ICategoryDetailService categoryDetailService;
	
	ICategoryService categoryService;
	
	IUserShopService userShopService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		productInfoService = (IProductInfoService) ctx.getBean("productInfoService");
		categoryDetailService = (ICategoryDetailService) ctx.getBean("categoryDetailService");
		categoryService = (ICategoryService) ctx.getBean("categoryService");
		userShopService = (IUserShopService) ctx.getBean("userShopService");
	}
	
	@Test
	public void testInsert(){
		String[] names = {"康康", "国术", "青松"};
		String[] cate = {"美味的食品", "好喝的饮品", "必备日用品", "土豪送的礼品"};
		String[] d1 = {"饼干/糕点", "糖果/巧克力", "方便速食", "坚果/蜜饯", "肉/豆制品"};
		String[] d2 = {"水", "碳酸饮料", "功能饮料", "茶/咖啡饮料", "牛奶乳品", "果汁"};
		String[] d3 = {"插线板", "雨伞", "纸制品", "美容洗护", "清洁/收纳"};
		String[] d4 = {"明信片", "书签", "挂件/饰品", "包包包包"};
		UserBuyer user = new UserBuyer();
		user.setName("jack");
		user.setRealname("Tom");

		
		UserShopFilter usf = new UserShopFilter();
		usf.setQueryString(" where a.name='"+"usst"+"'");
		UserShopModel us =  userShopService.findEntityListByFilter(usf).get(0);
		
		for(int i=1000; i<1400; i++){
			ProductInfoModel p = new ProductInfoModel();
			p.setName(names[(int)(Math.random()*10%3)]+i);
			p.setImageBig("images/t"+i%5+".jpg");
			p.setRemainNumber(i);
			p.setPrice(i);
			p.setCounter(i);
			p.setProductid("1234"+i);
			p.setKeyword(names[(int)(Math.random()*10%3)]+i);
			p.setDescription(names[(int)(Math.random()*10%3)]);
			p.setIsSale("1");
			
			String category = cate[(int)(Math.random()*10%4)];

			String dec = "";
			
			if(category.equals("美味的食品")){
				dec = d1[(int)(Math.random()*10%4)];
			}else if(category.equals("好喝的饮品")){
				dec = d2[(int)(Math.random()*10%6)];
			}else if(category.equals("必备日用品")){
				dec = d3[(int)(Math.random()*10%5)];
			}else if(category.equals("土豪送的礼品")){
				dec = d4[(int)(Math.random()*10%4)];
			}
			
			CategoryFilter cf = new CategoryFilter();
			cf.setQueryString(" where a.name='"+category+"'");
			CategoryModel c = categoryService.findEntityListByFilter(cf).get(0);
			
			CategoryDetailFilter cdf = new CategoryDetailFilter();
			cdf.setQueryString(" where a.name='"+dec+"'");
			CategoryDetailModel cdm = categoryDetailService.findEntityListByFilter(cdf).get(0);
			
			p.setCategoryId(c.getId());
			p.setCategoryDetailId(cdm.getId());
			p.setShopId(us.getId());
			productInfoService.insertEntity(p, user);
		}
	}
	
	@Test
	public void testFindAllList(){
		UserBuyer user = new UserBuyer();
		user.setName("Admin");
		user.setRealname("Admin");
		List<ProductInfoModel> lists = productInfoService.findEntityList();
		System.out.println(lists.size());
		for(int i=0; i<lists.size(); i++){
			ProductInfoModel p = lists.get(i);
			String str = p.getImageBig();
			if(str.indexOf(".JPG") != -1 && str.indexOf(".jpg")!=-1){
				str = str.replace(".JPG", "");
				System.out.println(str);
				p.setImageBig(str);
				productInfoService.updateEntity(p, user);
			}
		}
	}
	
	@Test
	public void testFindByShopId(){
		//校铭A-001
		//思源A-002
		UserShopModel shop = userShopService.findByStoreId("A-002");
		List<ProductInfoModel> ps = productInfoService.findByShopId(shop.getId());
		for(int i=0; i<ps.size(); i++){
			//删除
			productInfoService.deleteEntity(ps.get(i), null);
			//ps.get(i).setImageBig(ps.get(i).getImageBig()+".JPG");
			//productInfoService.updateEntity(ps.get(i), null);
		}
	}
	
	//将促销商品设置成非促销，isOnsale = 2，区别正常的商品
	@Test
	public void testFindByStatus(){
		ProductInfoFilter filter = new ProductInfoFilter();
		filter.setQueryString("where a.isOnsale = '1'");
		List<ProductInfoModel> ps = productInfoService.findEntityListByFilter(filter);
		for(int i=0; i<ps.size(); i++){
			//System.out.println(ps.get(i).getIsOnsale());
			ps.get(i).setIsOnsale("2");
			productInfoService.updateEntity(ps.get(i), null);
		}
	}
	
}
