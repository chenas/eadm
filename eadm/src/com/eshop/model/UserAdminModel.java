package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 
 * @author Administrator 超级管理员
 */
@Entity(name = "USER_ADMIN")
public class UserAdminModel extends BaseModel {
	/**
	 * 登录名
	 */
	private String adminName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 管理角色（如商品管理员、订单管理员）
	 */
	private String adminRole;

	@Column(name = "admin_name", length = 12, nullable = false)
	public String getAdminName() {
		return adminName;
	}

	@Column(name = "password", length = 200, nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(name = "admin_role", length = 20)
	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

}
