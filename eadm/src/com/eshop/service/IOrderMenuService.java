package com.eshop.service;

import java.util.List;

import com.base.framwork.service.IEntityService;
import com.eshop.model.OrderMenuModel;
/**
 * 
 * @authortianziwang
 *
 */

public interface IOrderMenuService  extends IEntityService<OrderMenuModel>{
	
	/**
	 * 由用户id加载订单列表
	 * @param userId
	 * 						用户主键
	 * @return
	 * 					订单里表
	 */
	public List<OrderMenuModel> findByUserId(String userId);
	
	/**
	 * 分页由用户id加载订单列表
	 * @param pageNo
	 * 						第几页
	 * @param listSize
	 * 						每页大小
	 * @param userId
	 * 						用户id 主键
	 * @return
	 */
	public List<OrderMenuModel> findByUserId(int pageNo, int listSize, String userId);
	
}
