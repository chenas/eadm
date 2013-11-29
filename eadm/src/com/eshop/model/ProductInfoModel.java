package com.eshop.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * @author supriseli email:supriseli007@gmail.com
 */
@Entity(name = "PRODUCT_INFO")
public class ProductInfoModel extends BaseModel {
	
	// 商品编号
	private String productid;
	// 商品名称
	private String name;
	// 商品价格
	private double price;
	// 商品进价
	private double inprice;
	// 促销价
	private double onsalePrice;
	// 库存量
	private int remainNumber;
	// 图片路径
	private String imageBig;
	// 促销，默认为否0
	private String isOnsale;
	// 状态，默认上架
	private String isSale;
	// 描述
	private String description;
	//  销售数量
	private int salenumber;
	// 点击量
	private int counter;
	// 上架时间
	private Date uploadate;
	// 下架时间
	private Date downdate;
	// 用于促销的数量
	private int onsaleNum;
	// 最近的修改时间
	private Date updateDate;
	// 是否为自销商品
	private char isEshop;
	// id
	private String shopId;
	//一级分类主键
	private String categoryId;
	//二级分类主键
	private String categoryDetailId;
	
	/**
	 * 关键词，可用于虚拟分类
	 * 搜索
	 */
	private String keyword;
	
	//优先级，越大优先级越高，商品越有可能显示在前面
	private int priority;

	@Column(name = "productid", length = 50, nullable = false)
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	@Column(name = "name", length = 100, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", length = 10, nullable = true)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "inprice", length = 10, nullable = true)
	public double getInprice() {
		return inprice;
	}

	public void setInprice(double inprice) {
		this.inprice = inprice;
	}

	@Column(name = "onsale_price", length = 10, nullable = true)
	public double getOnsalePrice() {
		return onsalePrice;
	}

	public void setOnsalePrice(double onsalePrice) {
		this.onsalePrice = onsalePrice;
	}

	@Column(name = "remain_number", length = 10, nullable = true)
	public int getRemainNumber() {
		return remainNumber;
	}

	public void setRemainNumber(int remainNumber) {
		this.remainNumber = remainNumber;
	}

	@Column(name = "image_big", length = 100, nullable = true)
	public String getImageBig() {
		return imageBig;
	}

	public void setImageBig(String imageBig) {
		this.imageBig = imageBig;
	}

	@Column(name = "is_sale", length = 1, nullable = true)
	public String getIsSale() {
		return isSale;
	}

	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}

	@Column(name = "description", length = 200, nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "salenumber", length = 10, nullable = true)
	public int getSalenumber() {
		return salenumber;
	}

	public void setSalenumber(int salenumber) {
		this.salenumber = salenumber;
	}

	@Column(name = "counter", length = 10, nullable = true)
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Column(name = "uploadate", length = 10, nullable = true)
	public Date getUploadate() {
		return uploadate;
	}

	@Column(name = "update_date", length = 10, nullable = true)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "shop_id", length = 64, nullable = true)
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public void setUploadate(Date uploadate) {
		this.uploadate = uploadate;
	}

	@Column(name = "downdate", length = 10, nullable = true)
	public Date getDowndate() {
		return downdate;
	}

	@Column(name = "keyword", length = 30, nullable = true)
	public String getKeyword() {
		return keyword;
	}

	@Column(name = "priority", length = 10, nullable = true)
	public int getPriority() {
		return priority;
	}

	@Column(name = "onsale_num", length = 10, nullable = true)
	public int getOnsaleNum() {
		return onsaleNum;
	}

	public void setOnsaleNum(int onsaleNum) {
		this.onsaleNum = onsaleNum;
	}

	@Column(name = "is_eshop", length = 1, nullable = true)
	public char getIsEshop() {
		return isEshop;
	}

	public void setIsEshop(char isEshop) {
		this.isEshop = isEshop;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setDowndate(Date downdate) {
		this.downdate = downdate;
	}

	public void setIsOnsale(String isOnsale) {
		this.isOnsale = isOnsale;
	}

	@Column(name = "is_onsale", length = 1, nullable = true)
	public String getIsOnsale() {
		return isOnsale;
	}
	
	@Column(name="category_id", length=64, nullable=true)
	public String getCategoryId() {
		return categoryId;
	}

	@Column(name="category_detail_id", length=64, nullable=true)
	public String getCategoryDetailId() {
		return categoryDetailId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryDetailId(String categoryDetailId) {
		this.categoryDetailId = categoryDetailId;
	}

}