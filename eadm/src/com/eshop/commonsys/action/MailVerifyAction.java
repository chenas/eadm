package com.eshop.commonsys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.BaseAction;
import com.eshop.domain.UserBuyer;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IUserBuyerService;

/**
 * 注册成功后进行邮箱验证
 * @author chenas
 *
 */
@Component
public class MailVerifyAction extends BaseAction{

	@Resource
	private IUserBuyerService userBuyerService;
	
	//注册用户id
	private String id;

	@Override
	public String execute() throws Exception {
		UserBuyerModel user = userBuyerService.findEntityById(id);
		if(user == null){
			addActionMessage("亲，出错了");
		}
		else if(user.getIsValidate() != null && user.getIsValidate().equals("1")){
			addActionMessage("亲，已经验证，无需多此一步");
		}
		else{
			user.setIsValidate("1");
			userBuyerService.updateEntity(user, null);
			addActionMessage("亲，恭喜您！验证成功！祝您购物愉快！");
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
