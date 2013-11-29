package com.base.framwork.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.base.framwork.domain.BaseModel;
import com.base.framwork.domain.PageList;
import com.base.framwork.queryfilter.QueryFilter;
/**
 * 列表action
 * @author chenas
 *
 * @param <T>
 */
@Component
public class EntityListAction<T extends BaseModel> extends EntityBaseAction<T> {
	
	//
	private PageList pageList;
	
	public String execute() throws Exception {
		commonOperations();	
		return intoList();
	}
	
	/**
	 * 进入列表
	 * @return
	 */
	public String intoList(){
//		getEntityFilter().setPageNo(pageNo);
		pageList = new PageList();
		pageList.setFullListSize(querySize(getEntityFilter()));
		pageList.setPageNumber(getEntityFilter().getPageNo());
		pageList.setObjectsPerPage(getEntityFilter().getPageSize());
		pageList.setList(query(getEntityFilter()));
		ServletActionContext.getContext().put("pageList", pageList);
		return "list";
	}
	
	/**
	 * 查询记录,子类可重写此方法
	 * @param filter
	 * @return
	 * 				List<T>
	 */
	public List<T> query(QueryFilter filter){
		return getEntityService().findEntityListByFilter(filter);
	}
	
	/**
	 * 统计记录数目，与query配合使用
	 * @param filter
	 * @return
	 * 				int
	 */
	public int querySize(QueryFilter filter){
		return getEntityService().countEntityByFilter(filter);
	}
	
	public PageList getPageList() {
		return pageList;
	}

	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}

}
