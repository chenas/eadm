package com.eshop.commonsys.action;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.stereotype.Component;

import com.base.framwork.action.BaseAction;
import com.eshop.domain.UserAdmin;
import com.eshop.model.UserAdminModel;
import com.eshop.service.IUserAdminService;

@Component
public class AdmLoginAction extends BaseAction{
	
	private String name;
	
	private String password;
	
	private String securityCode;
	
	@Resource
	private IUserAdminService userAdminService;
	
	public String doLogin(){
		if(!securityCode.equals((String)doGetSessionObject("SESSION_SECURITY_CODE"))){
			return INPUT;
		}
		String admID = userAdminService.hasUser(name, password);
		if(null == admID || "".equals(admID)){
			return INPUT;
		}
		UserAdminModel userAdm = userAdminService.findEntityById(admID);
		UserAdmin user = new UserAdmin();
		user.setId(userAdm.getId());
		user.setAdminName(userAdm.getAdminName());
		user.setPassword(userAdm.getPassword());
		doPutSessionObject("userAdm", user);
		return SUCCESS;
	}

	@SkipValidation
	public String doLogout(){
		if(doGetSessionObject("userAdm") != null){
			getSession().remove("userAdm");
		}
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

}
