package com.eshop.view;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Subselect;

import com.base.framwork.domain.BaseModel;

/**
 * 商品视图
 * @author chenas
 *
 */
@Entity(name="PRODUCT_VIEW")
@Subselect(	"select  "
		+ "PRODUCT_INFO.id AS id, "
		+ "PRODUCT_INFO.name AS name, "
		+ "PRODUCT_INFO.price AS price, "
		+ "PRODUCT_INFO.onsale_price AS onsale_price," 
		+ "PRODUCT_INFO.remain_number AS remain_number," 
		+ "PRODUCT_INFO.image_big AS image_big, "
		+ " PRODUCT_INFO.is_onsale AS is_onsale, "
		+ "PRODUCT_INFO.update_date AS update_date, "
		+ "PRODUCT_INFO.salenumber AS salenumber, "
		+ "PRODUCT_INFO.onsale_num AS onsale_num, "
		+ "PRODUCT_INFO.description AS description, "
		+ "PRODUCT_INFO.counter AS counter, "
		+ "PRODUCT_INFO.is_eshop AS is_eshop, "
		+ "PRODUCT_INFO.keyword AS keyword, "
		+ "PRODUCT_INFO.priority AS priority, "
		+ "PRODUCT_INFO.create_time AS create_time, "
		+ "PRODUCT_INFO.create_user AS create_user, "
		+ "PRODUCT_INFO.update_time AS update_time, "
		+ "CATEGORY.name AS category_name, "
		+ "CATEGORY_DETAIL.name AS category_detail_name, "
		+ "USER_SHOP.id AS shop_id,"
		+ " CATEGORY.id AS category_id , "
		+ "CATEGORY_DETAIL.id AS category_detail_id "
		+ " from "
		+ "(PRODUCT_INFO, USER_SHOP, CATEGORY, CATEGORY_DETAIL)"
		+ " where "
		+ "PRODUCT_INFO.shop_id = USER_SHOP.id and PRODUCT_INFO.category_id = CATEGORY.id and" +
		" PRODUCT_INFO.category_detail_id = category_detail.id and PRODUCT_INFO.is_sale = '1'")
public class ProductViewModel extends BaseModel{

	// 商品名称
	private String name;
	// 商品价格
	private double price;
	// 促销价
	private double onsalePrice;
	// 库存量
	private int remainNumber;
	// 图片路径
	private String imageBig;
	// 促销，默认为否0
	private String isOnsale;
	// 描述
	private String description;
	// 销售数量
	private int salenumber;
	// 点击量
	private int counter;
	// 用于促销的数量
	private int onsaleNum;
	// 最近的修改时间
	private Date updateDate;
	// 是否为自销商品
	private char isEshop;

	/**
	 * 关键词，可用于虚拟分类
	 * 搜索
	 */
	private String keyword;
	
	//优先级，越大优先级越高，商品越有可能显示在前面
	private int priority;
	
	//一级分类名称
	private String categoryName;
	
	//一级分类名称
	private String cateDetailName;
	
	// 商店主键
	private String shopId;

	//一级分类主键
	private String categoryId;
	//二级分类主键
	private String categoryDetailId;
	
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

	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "category_detail_name")
	public String getCateDetailName() {
		return cateDetailName;
	}

	public void setCateDetailName(String cateDetailName) {
		this.cateDetailName = cateDetailName;
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
