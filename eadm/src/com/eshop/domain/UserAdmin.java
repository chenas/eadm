package com.eshop.domain;

import com.base.framwork.domain.IUser;
import com.eshop.model.UserAdminModel;
/**
 * 
 * @author Administrator
 * 超级管理员domain
 *
 */

public class UserAdmin  extends UserAdminModel implements IUser{

	@Override
	public String getLoginId() {
		return getId();
	}

	@Override
	public String getTrueName() {
		return getAdminName();
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String getPhone() {
		return null;
	}

	@Override
	public String getEmail() {
		return null;
	}

}
