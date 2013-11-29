package com.eshop.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.base.framwork.domain.BaseModel;
/**
 * 
 * @author Administrator
 *管理员登录日志
 */
@Entity(name="ADMIN_LOG")
public class AdminLogModel  extends BaseModel {
	/**
	 * 对应admit中的admin_role
	 */
	private String logRole;
	/**
	 * 登录的pi地址
	 */
	private String logIp;
	/**
	 * 登录时间
	 */
	private Date logTime;
	
	@Column(name="log_role", length=20,nullable=false)
	public String getLogRole() {
		return logRole;
	}
	@Column(name="log_ip", length=20,nullable=false)
	public String getLogIp() {
		return logIp;
	}
	@Column(name="log_time")
	public Date getLogTime() {
		return logTime;
	}
	@Column(name="admin_id")
	public String getAdminId() {
		return adminId;
	}
	public void setLogRole(String logRole) {
		this.logRole = logRole;
	}
	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	private String adminId;

}
