package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * @author supriseli email:supriseli007@gmail.com date:19-9-2013 function: this
 *         class mainly contains the information of orderItem;
 */
@Entity(name = "ORDERITEM")
public class OrderItemModel extends BaseModel {

	private double price;
	//购买数量
	private int count;
	//订单主键id
	private String orderId;
	//商品的主键id
	private String productId;
	// 每项总价格
	private double itempris;
	
	private String productName;
	// 产品是否有剩余
	private String isRemain;
	
	private String buyerId;
	//客户端ip地址
	private String ipAddr;
	
	private String imageurl;
	
	//是否已经完成，即是否已结算
	// 0未完成，1完成, 2表示用户已经确认收货
	private String isFinished;

	@Column(name = "ip_addr", length = 35, nullable = true)
	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	@Column(name = "is_finished", length = 1, columnDefinition="varchar(1) default '0'")
	public String getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}

	@Column(name = "imageurl", length = 60, nullable = true)
	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Column(name = "price", length = 10, nullable = false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "count", length = 10, nullable = true)
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Column(name = "order_id", length = 64, nullable = true)
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "product_id", length = 64, nullable = false)
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "itempris", length = 64, nullable = true)
	public double getItempris() {
		return itempris;
	}

	public void setItempris(double itempris) {
		this.itempris = itempris;
	}

	@Column(name = "product_name", length = 64, nullable = true)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "buyer_id", length = 64, nullable = true)
	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	@Column(name = "is_remain", length = 1, columnDefinition="varchar(1) default '1'")
	public String getIsRemain() {
		return isRemain;
	}

	public void setIsRemain(String isRemain) {
		this.isRemain = isRemain;
	}
}