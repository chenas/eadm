package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * @author supriseli email:supriseli007@gmail.com date:19-9-2013 function: this
 *         class mainly contains the information of ordermenu;
 */
@Entity(name = "ORDERMENU")
public class OrderMenuModel extends BaseModel {

	//订单编号，自定义
	private String orderid;

	//地址信息关联id
	private String addrId;
	
	//用户主键id
	private String buyerId;
	//商店主键id
	private String shopId;
	//下单时间
	private String orderdate;
	private String arrivtime;

	/*
	 * 0表示未处理（刚下单）， 
	 * 1表示某个商店收到订单（确认），
	 *  2表示已出货（出货），
	 *  3买家确认收货（规定内自动确认）
	 * 4表示作废（买家在订单没被确认时，可以取消订单）
	 */
	private String status;
	// the total price
	private double totalpris;
	// the location of 2-dimensionalbarcode
	private String qrcode;

	@Column(name = "buyer_id", length = 64, nullable = true)
	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	@Column(name = "orderdate", length = 30, nullable = false)
	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	@Column(name = "arrivtime", length = 100, nullable = true)
	public String getArrivtime() {
		return arrivtime;
	}

	public void setArrivtime(String arrivtime) {
		this.arrivtime = arrivtime;
	}

	@Column(name = "status", length = 1, columnDefinition="varchar(1) default '0'")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "totalpris", length = 10, nullable = false)
	public double getTotalpris() {
		return totalpris;
	}

	public void setTotalpris(double totalpris) {
		this.totalpris = totalpris;
	}

	@Column(name = "qrcode", length = 100, nullable = true)
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	@Column(name = "shop_id", length = 64, nullable = false)
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Column(name = "orderid", length = 50, nullable = false)
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Column(name = "buyer_addr_id", length = 64, nullable = true)
	public String getAddrId() {
		return addrId;
	}

	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

}