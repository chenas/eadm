package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.eshop.filter.OrderMenuFilter;
import com.eshop.model.OrderMenuModel;
import com.eshop.service.IOrderItemService;
import com.eshop.service.IOrderMenuService;

@Component
public class OrderMenuAction extends EntityCrudAction<OrderMenuModel> {
	
	@Resource
	private IOrderMenuService orderMenuService;
	
	@Resource
	private IOrderItemService orderItemService;
	
	private OrderMenuModel orderMenuModel;
	
	private OrderMenuFilter orderMenuFilter;
	

	public OrderMenuModel getOrderMenuModel() {
		return orderMenuModel;
	}

	public void setOrderMenuModel(OrderMenuModel orderMenuModel) {
		this.orderMenuModel = orderMenuModel;
	}

	public OrderMenuFilter getOrderMenuFilter() {
		return orderMenuFilter;
	}

	public void setOrderMenuFilter(OrderMenuFilter orderMenuFilter) {
		this.orderMenuFilter = orderMenuFilter;
	}

}
