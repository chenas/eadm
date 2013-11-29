package com.eshop.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.base.framwork.action.EntityListAction;
import com.base.framwork.domain.IUser;
import com.base.framwork.domain.PageList;
import com.eshop.filter.OrderMenuFilter;
import com.eshop.model.OrderItemModel;
import com.eshop.model.OrderMenuModel;
import com.eshop.service.IOrderItemService;
import com.eshop.service.IOrderMenuService;

@Component
public class OrderMenuListAction extends EntityListAction<OrderMenuModel> {

	@Resource
	private IOrderMenuService orderMenuService;

	@Resource
	private IOrderItemService orderItemService;
	
	private Map<OrderMenuModel, List<OrderItemModel>> orderMapList;
	
	private int pageNum = 1;
	
	private OrderMenuFilter orderMenuFilter;

	public String newOrder(){
		orderMenuFilter.setQueryString(" where a.status='o'");
		orderMenuFilter.setOrderByString(" orderdate desc");
		/*PageList pageList = new PageList();
		pageList.setFullListSize(querySize(orderMenuFilter));
		pageList.setObjectsPerPage(orderMenuFilter.getPageSize());
		pageList.setList(query(orderMenuFilter));
		ServletActionContext.getContext().put("pageList", pageList);*/
		return intoList();
	}
	

	public String listOrder(){
		IUser user = (IUser) doGetSessionObject("loginUser");
		if(user == null){
			return "login";
		}
		OrderMenuFilter orderFilter = new OrderMenuFilter();
		orderFilter.setPageNo(pageNum);
		orderFilter.setQueryString(" where a.userId ='"+user.getId()+"'");
		orderFilter.setOrderByString(" orderdate desc");
		PageList pageList = new PageList();
		pageList.setFullListSize(querySize(orderFilter));
		List<OrderMenuModel> orderList = query(orderFilter);
		pageList.setList(orderList);
		for(OrderMenuModel order : orderList){
			List<OrderItemModel> itemList = orderItemService.findByOrderId(order.getId());
			orderMapList.put(order, itemList);
		}
		pageList.setMap(orderMapList);
		ServletActionContext.getContext().put("pageList", pageList);
		return SUCCESS;
	}

	public OrderMenuFilter getOrderMenuFilter() {
		return orderMenuFilter;
	}

	public void setOrderMenuFilter(OrderMenuFilter orderMenuFilter) {
		this.orderMenuFilter = orderMenuFilter;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
