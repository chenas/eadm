package com.eshop.util;

import com.base.framwork.service.IUtilService;
import com.base.framwork.service.UtilService;

/**
 * 产生唯一的订单编号
 * @author chenas
 *
 */
public class GetOrderIdUtil {
	
	private static IUtilService utilService = new UtilService();
	
	private static String PREFIX = "DD";
	private static long code;
	
	  public static synchronized String nextCode() {
	        code++;
	        String str = utilService.getSystem2DateString();
	        long m = Long.parseLong((str)) * 10000;
	        m += code;
	        return PREFIX + m;
	    }	  
}
