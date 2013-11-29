package com.eshop.service.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.service.IUtilService;
import com.base.framwork.service.mail.IMailSenderService;
import com.eshop.model.BuyerAddrModel;
import com.eshop.model.OrderItemModel;
import com.eshop.model.OrderMenuModel;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IBuyerAddrService;
import com.eshop.service.IOrderItemService;
import com.eshop.service.IOrderMenuService;
import com.eshop.service.IUserBuyerService;

/**
 * 验证用户信息 ajax
 * 
 * @author chenas
 * 
 */
@Component
public class UserBuyerServiceAjax {

	@Resource
	private IUserBuyerService userBuyerService;
	
	@Resource
	private IMailSenderService mailSenderService;
	
	@Resource
	private IBuyerAddrService buyerAddrService;

	@Resource
	private IOrderMenuService orderMenuService;
	
	@Resource
	private IOrderItemService orderItemService;
	
	@Resource
	private IUtilService utilService;
	
	/**
	 * 用户名是否已经被注册
	 * 
	 * @param name
	 * @return true if has or name if null
	 */
	public boolean hasUser(String name) {
		if(name == null || "".equals(name)){
			return true;
		}
		if (userBuyerService.hasUser(name, null) != null) {
			return true;
		} else
			return false;
	}

	/**
	 * 此邮箱是否已被注册
	 * 
	 * @param Email
	 * @return true if has
	 */
	public boolean hasEmail(String Email) {
		if(null == Email || "".equals(Email)){
			return false;
		}
		if (userBuyerService.hasEmail(Email)) {
			return true;
		} else
			return false;
	}
	
	/**
	 * 检查邮箱是否真实存在
	 * @param Email
	 * @return
	 * 		true if exist
	 */
	public boolean existEmail(String Email){
		if(null == Email || "".equals(Email)){
			return false;
		}
		if(mailSenderService.checkEmail(Email)){
			return true;
		}else
			return false;
	}

	/**
	 * 取得用户地址
	 * @param userId
	 * 						用户主键
	 * @return
	 */
	public List<BuyerAddrModel> findAddrListByUserId(String userId){
		if(null == userId || "".equals(userId) || null == userBuyerService.findEntityById(userId)){
			return null;
		}
		List<BuyerAddrModel> addrList = buyerAddrService.findListByUserId(userId);
		return addrList;
	}
	
	/**
	 * 取得订单
	 * @param userId
	 * @return
	 */
	public Map findMenuItemMap(String userId){
		if(null == userId){
			return null;
		}
		Map<OrderMenuModel, List<OrderItemModel>> _menuItemMap = null;
		List<OrderMenuModel> orderList = orderMenuService.findByUserId(userId);
		if(null != orderList && orderList.size() > 0){
			_menuItemMap = new HashMap<OrderMenuModel, List<OrderItemModel>>();
			for(OrderMenuModel order : orderList){
				List<OrderItemModel> itemList = orderItemService.findByOrderId(order.getId());
				_menuItemMap.put(order, itemList);
			}
		}
		return _menuItemMap;
	}

	//修改密码
	public String changePwd(String userId, String oldPwd, String newPwd, String newPwd2){
		UserBuyerModel user = userBuyerService.findEntityById(userId);
		if(null == userId || "".equals(userId) || null == user){
			return "不解释，你懂的";
		}
		if(newPwd.length()<6){
			return "密码长度不能小于six";
		}
		if(!newPwd.equals(newPwd2)){
			return "擦。。。两次输入不一样。。";
		}
		if(!utilService.getMD5String(oldPwd).equals(user.getPassword().trim())){
			return "这是旧密码忘了么？";
		}
		user.setPassword(utilService.getMD5String(newPwd));
		userBuyerService.updateEntity(user, null);
		return "修改成功！";
	}
	
}
