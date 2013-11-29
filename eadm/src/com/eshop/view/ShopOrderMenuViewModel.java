package com.eshop.view;

import javax.persistence.Entity;

import org.hibernate.annotations.Subselect;

import com.base.framwork.domain.BaseModel;

@Entity(name = "SHOP_ORDERMENU_VIEW")
@Subselect("select " 
		+ "ORDERMENU.id as id, "
		+ "ORDERMENU.orderid as orderid, "
		+ "ORDERMENU.orderdate as orderdate, " 
		+ "ORDERMENU.buyer_addr_id as addrId, "
		+ "ORDERMENU.status as status, " 
		+ "ORDERMENU.totalpris as totalpris, "
		+ "ORDERMENU.create_time AS create_time, "
		+ "ORDERMENU.create_user AS create_user, "
		+ "ORDERMENU.update_time AS update_time "
		+ "from " + "(ORDERMENU, USER_SHOP) " 
		+ "where "
		+ "ORDERMENU.shop_id = USER_SHOP.id ")
public class ShopOrderMenuViewModel extends BaseModel {

	private String orderid;

	private String orderdate;

	private String addrId;

	private String status;

	private double totalpris;

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getAddrId() {
		return addrId;
	}

	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalpris() {
		return totalpris;
	}

	public void setTotalpris(double totalpris) {
		this.totalpris = totalpris;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
}
