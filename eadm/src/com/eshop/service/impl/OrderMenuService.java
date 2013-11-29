package com.eshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.model.OrderMenuModel;
import com.eshop.service.IOrderMenuService;
/**
 * 
 * @author tianziwang
 *
 */
@Component
public class OrderMenuService extends EntityService<OrderMenuModel> implements IOrderMenuService{

	/**
	 * 由用户id加载订单列表
	 * @param userId
	 * 						用户主键
	 * @return
	 * 					订单里表
	 */
	public List<OrderMenuModel> findByUserId(String userId){
		return crudDao.findObjListByHql("from ORDERMENU as a where a.buyerId = '"+userId+"'");
	}
	

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
	public List<OrderMenuModel> findByUserId(int pageNo, int listSize,
			String userId) {
		int startNum = (pageNo -1 )*listSize;
		return crudDao.findObjListLimit(startNum, listSize, "from ORDERMENU  as a where a.buyerId = '"+userId+"' order by a.orderid desc, a.orderdate desc" );
	}

}
