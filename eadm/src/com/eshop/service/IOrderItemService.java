package com.eshop.service;

import java.util.List;

import com.base.framwork.service.IEntityService;
import com.eshop.model.OrderItemModel;
/**
 * 
 * @author tianziwang
 *
 */

public interface IOrderItemService   extends IEntityService<OrderItemModel>{

	/**
	 * 从数据库获取购物车内容
	 * @param userId
	 * 					登录用户ID
	 * @return
	 * 					PageList
	 */
	public List findOrderItemByUserId(String userId);
	
	/**
	 * 查找某个订单的订单项内容
	 * @param orderId
	 * 						订单主键
	 * @return
	 * 					订单项
	 */
	public List<OrderItemModel> findByOrderId(String orderId);

}
