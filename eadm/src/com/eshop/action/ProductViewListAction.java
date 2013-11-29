package com.eshop.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.base.framwork.domain.PageList;
import com.eshop.filter.ProductViewFilter;
import com.eshop.service.IProductViewService;
import com.eshop.view.ProductViewModel;

/**
 * @author chenas
 *
 */
/**
 * @author chenas
 *
 */
@Component
public class ProductViewListAction extends EntityListAction<ProductViewModel> {

	@Resource
	private IProductViewService productViewService;
	
	//搜索关键词，分类名
	private String keyword;
	
	private int pageNum = 1;
	
	//总页数
	private int totalPage;
	
	//是否为搜索商品
	private String isShowProduct; 
	
	private ProductViewFilter productViewFilter;
	
	private List<ProductViewModel> productList;
	
	//展示促销商品
	public String onSaleProduct(){
		ProductViewFilter productFilter = new ProductViewFilter();
		productFilter.setPageSize(24);
		productFilter.setQueryString(" where a.isOnsale = '1'");
		productFilter.setOrderByString(" counter desc");
		productFilter.setPageNo(pageNum);
		productList = query(productFilter);
		totalPage = querySize(productFilter);
		return LIST;
	}
	
	//搜索商品
	public String searchProduct() { 
		ProductViewFilter productFilter = new ProductViewFilter();
		PageList productList = new PageList();
		productFilter.setQueryString(" where a.name like '%"+keyword+"%' or a.keyword like '%"+keyword+"%'");
		productFilter.setOrderByString(" counter desc");
		productFilter.setPageNo(pageNum);
		productList.setPageNumber(pageNum);
		productList.setList(query(productFilter));
		productList.setFullListSize(querySize(productFilter));
		ServletActionContext.getContext().put("productList", productList);
		return LIST;
	}
	
	//展示所有商品
	public String allProduct(){
		productViewFilter = new ProductViewFilter();
		productViewFilter.setPageNo(pageNum);
		return intoList();
	}
	
	//展示商品，根据分类列表的值展示商品
	public String showProduct() throws UnsupportedEncodingException{
		ProductViewFilter productFilter = new ProductViewFilter();
		productFilter.setQueryString(" where a.categoryName like '%"+java.net.URLDecoder.decode(keyword,"UTF-8")+"%' or a.cateDetailName like '%"+java.net.URLDecoder.decode(keyword,"UTF-8")+"%'");
		productFilter.setOrderByString(" counter desc");
		PageList productList = new PageList();
		productFilter.setPageNo(pageNum);
		productList.setPageNumber(pageNum);
		productList.setList(query(productFilter));
		productList.setFullListSize(querySize(productFilter));
		ServletActionContext.getContext().put("productList", productList);
		return LIST;
	}

	public ProductViewFilter getProductViewFilter() {
		return productViewFilter;
	}

	public void setProductViewFilter(ProductViewFilter productViewFilter) {
		this.productViewFilter = productViewFilter;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getIsShowProduct() {
		return isShowProduct;
	}

	public void setIsShowProduct(String isShowProduct) {
		this.isShowProduct = isShowProduct;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<ProductViewModel> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductViewModel> productList) {
		this.productList = productList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
