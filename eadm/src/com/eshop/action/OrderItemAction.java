package com.eshop.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityCrudAction;
import com.base.framwork.domain.PageList;
import com.eshop.filter.OrderItemFilter;
import com.eshop.model.OrderItemModel;
import com.eshop.model.ProductInfoModel;
import com.eshop.model.UserBuyerModel;
import com.eshop.service.IOrderItemService;
import com.eshop.service.IProductInfoService;
import com.eshop.util.GetMacAddrUtil;

@Component
public class OrderItemAction extends EntityCrudAction<OrderItemModel> {

	@Resource
	private IOrderItemService orderItemService;

	@Resource
	private IProductInfoService productInfoService;
	
	private OrderItemModel orderitemModel;
	
	private OrderItemFilter orderItemFilter;
	
	public OrderItemModel getOrderitemModel() {
		return orderitemModel;
	}

	public void setOrderitemModel(OrderItemModel orderitemModel) {
		this.orderitemModel = orderitemModel;
	}

	public OrderItemFilter getOrderItemFilter() {
		return orderItemFilter;
	}

	public void setOrderItemFilter(OrderItemFilter orderItemFilter) {
		this.orderItemFilter = orderItemFilter;
	}

}
