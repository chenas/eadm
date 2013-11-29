package com.eshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.base.framwork.domain.IUser;
import com.base.framwork.service.EntityService;
import com.eshop.model.BuyerAddrModel;
import com.eshop.service.IBuyerAddrService;
/**
 * 
 * @author tianziwang
 *
 */
@Component
public class BuyerAddrService extends EntityService<BuyerAddrModel> implements IBuyerAddrService{
	
	/**
	 * 取得用户的默认地址
	 * @param userId
	 * 						用户主键
	 * @return
	 */
	public BuyerAddrModel findByUserId(String userId){
		List<BuyerAddrModel> addrs = crudDao.findObjListByHql("from BUYER_ADDR as a where a.buyerId = '"+userId+"' and a.isDefault = '1'");
		if(null != addrs && 0<addrs.size()){
			return addrs.get(0);
		}
		return null;
	}

	/**
	 * 取得用户地址
	 * @param userId
	 * 						用户主键
	 * @return
	 */
	public List<BuyerAddrModel> findListByUserId(String userId){
		List<BuyerAddrModel> addrList = crudDao.findObjListByHql("from BUYER_ADDR as a where a.buyerId = '"+userId+"'");
		return addrList;
	}
}
