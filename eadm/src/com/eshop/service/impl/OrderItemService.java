package com.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.filter.OrderItemFilter;
import com.eshop.model.OrderItemModel;
import com.eshop.service.IOrderItemService;
/**
 * 
 * @author tianziwang
 *
 */
@Component
public class OrderItemService extends EntityService<OrderItemModel> implements IOrderItemService{

	/**
	 * 从数据库获取购物车内容
	 * @param userId
	 * 					登录用户ID
	 * @return
	 * 					PageList
	 */
	public List<OrderItemModel> findOrderItemByUserId(String userId){
		List<OrderItemModel> orderItemModels = crudDao.findObjListByHql("from ORDERITEM as a where a.buyerId='"+userId+"' and a.isFinished='0'");
		if(null != orderItemModels && orderItemModels.size()>0){
			return orderItemModels;
		}
		return null;
	}
	
	/**
	 * 查找某个订单的订单项内容
	 * @param orderId
	 * 						订单主键
	 * @return
	 * 					订单项
	 */
	public List<OrderItemModel> findByOrderId(String orderId){
		return crudDao.findObjListByHql("from ORDERITEM as a where a.orderId = '"+orderId+"'");
	}
}
