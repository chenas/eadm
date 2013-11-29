package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * @author supriseli email:supriseli007@gmail.com
 */

@Entity(name = "BUYER_ADDR")
public class BuyerAddrModel extends BaseModel {

	// 收货人姓名
	private String consignee;
	// 校区
	private String schoolArea;
	// 教学楼/办公楼/具体
	private String building;
	// 详细地址/备注
	private String address;
	// 联系方式
	private String phone;
	// 邮箱
	private String email;
	// 是否为默认地址
	private String isDefault;
	private String buyerId;

	@Column(name = "consignee", length = 10, nullable = false)
	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Column(name = "school_area", length = 10, nullable = false)
	public String getSchoolArea() {
		return schoolArea;
	}

	public void setSchoolArea(String schoolArea) {
		this.schoolArea = schoolArea;
	}

	@Column(name = "building", length = 20, nullable = false)
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Column(name = "address", length = 100, nullable = true)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", length = 15, nullable = true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 30, nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "is_default", length = 1, nullable = true)
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Column(name = "buyer_id", length = 64, nullable = true)
	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

}