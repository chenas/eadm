package com.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;

/**
 * 送货人信息
 * 
 * @author Administrator
 * 
 */
@Entity(name = "USER_EXPRESS")
public class UserExpressModel extends BaseModel {
	/**
	 * 送货人姓名
	 */
	private String name;
	/**
	 * 配送人联系方式
	 */
	private String phone;
	/**
	 * 学号
	 */
	private String studentid;

	@Column(name = "name", length = 8)
	public String getName() {
		return name;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return phone;
	}

	@Column(name = "studentid", length = 15)
	public String getStudentid() {
		return studentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

}
