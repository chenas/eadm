package com.eshop.service;

import java.util.List;

import com.base.framwork.service.IEntityService;
import com.eshop.model.BuyerAddrModel;
/**
 * 
 * @author tianziwang
 * 
 */

public interface IBuyerAddrService   extends IEntityService<BuyerAddrModel>{

	/**
	 * 取得用户的默认地址
	 * @param userId
	 * 						用户主键
	 * @return
	 */
	public BuyerAddrModel findByUserId(String userId);


	/**
	 * 取得用户地址
	 * @param userId
	 * 						用户主键
	 * @return
	 */
	public List<BuyerAddrModel> findListByUserId(String userId);

}
