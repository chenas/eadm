package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 商店用户表
 * @author chenas
 *
 */
@Entity(name="USER_SHOP")
public class UserShopModel extends BaseModel{

	/**
	 * 登录名
	 */
	private String name;
	
	private String password;
	
	private String storeName;
	
	private String storeId;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	/**
	 * 是否属于自有商店
	 * 1 是，0 否
	 */
	private String isEshop;

	@Column(name="name", length=15, nullable=false)
	public String getName() {
		return name;
	}

	@Column(name="password", length=200, nullable=false)
	public String getPassword() {
		return password;
	}

	@Column(name="store_name", length=50, nullable=false)
	public String getStoreName() {
		return storeName;
	}

	@Column(name="store_id", length=5, nullable=false)
	public String getStoreId() {
		return storeId;
	}

	@Column(name="address", length=100)
	public String getAddress() {
		return address;
	}

	@Column(name="phone", length=15)
	public String getPhone() {
		return phone;
	}

	@Column(name="email", length=30)
	public String getEmail() {
		return email;
	}

	@Column(name="is_eshop", length=1, nullable=true, columnDefinition=" varchar(1) default '0'")
	public String getIsEshop() {
		return isEshop;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIsEshop(String isEshop) {
		this.isEshop = isEshop;
	}
}
