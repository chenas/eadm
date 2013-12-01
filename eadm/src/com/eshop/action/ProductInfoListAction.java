package com.eshop.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.eshop.filter.ProductInfoFilter;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IProductInfoService;


@Component
public class ProductInfoListAction extends EntityListAction<ProductInfoModel> {
	
	@Resource
	private IProductInfoService productInfoService;

	private ProductInfoFilter productInfoFilter;

	//搜索关键词
	private String keyword;
	
	//条件查询
	private String queryStr;
	
	@Override
	protected void commonOperations() throws Exception {
		productInfoFilter.setQueryString(" where a.name like '"+keyword+"' or a.keyword like '"+keyword+"'");
	}
	
	//搜索商品
	public String searchProduct(){
		productInfoFilter.setKeyword(keyword);
		productInfoFilter.setName(keyword);
		productInfoFilter.setQueryString(" where a.name like '%"+keyword+"%' or a.keyword like '%"+keyword+"%'");
		productInfoFilter.setOrderByString(" counter desc");
		return intoList();
	}
	
	//展示所有商品
	public String allProduct() throws UnsupportedEncodingException{
		if(queryStr != null && !"".equals(queryStr)){
			queryStr = java.net.URLDecoder.decode(queryStr, "UTF-8");
		}
		if(queryStr == null || "".equals(queryStr)){
			productInfoFilter.setQueryString(null);
		}
		//productInfoFilter.setQueryString(getQueryString(queryStr));
		return intoList();
	}
	
	//展示商品，根据分类列表的值展示商品
	public String showProduct(){
		productInfoFilter.setOrderByString(" counter desc");
		return intoList();
	}
	
	//暂时没用到
	public String getQueryString(String queryStr){
		if(null == queryStr){
			return null;
		}
		String[] str = queryStr.split(",");
		if(str == null || str.length<1){
			return null;
		}
		String _queryStr = " where ";
		switch (str.length) {
		case 1:
			_queryStr += "a.shopId='"+str[0]+"'";
			break;
		case 2:
			_queryStr += "a.shopId='"+str[0]+"' and a.isSale='"+str[1]+"'";
			break;
		case 3:
			_queryStr += "a.shopId='"+str[0]+"' and a.isSale='"+str[1]+"' and a.isOnsale='"+str[2]+"'";
		default:
			break;
		}
		return _queryStr;
	}
	
	public IProductInfoService getProductInfoService() {
		return productInfoService;
	}

	public void setProductInfoService(IProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	public ProductInfoFilter getProductInfoFilter() {
		return productInfoFilter;
	}

	public void setProductInfoFilter(ProductInfoFilter productInfoFilter) {
		this.productInfoFilter = productInfoFilter;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

}
