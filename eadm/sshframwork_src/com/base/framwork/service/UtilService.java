package com.base.framwork.service;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.base.framwork.util.DateUtil;

/**
 * 工具类Service
 * @author chenas
 *
 */
@Component
public class UtilService implements IUtilService{

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public Date getSystemDateTime() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * 获取系统时间
	 * 格式：yyyy-MM-dd
	 * 
	 * @return 
	 */
	public String getSystemDateString() {
		return DateUtil.getDateTime("yyyy-MM-dd", getSystemDateTime());
	}

	/**
	 * 获取系统时间
	 * 格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return 
	 */
	public String getSystemDateTimeString() {
		return DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", getSystemDateTime());
	}

	/**
	 * 获取系统时间
	 * 格式：yyMMddHHmmss
	 * 
	 * @return 
	 */
	public String getSystemTimeString(){
		return DateUtil.getDateTime("yyMMddHHmmss" ,getSystemDateTime());
	}
	
	/**
	 * 获取系统时间
	 * 格式：yyMMdd
	 * 
	 * @return 
	 */
	public String getSystem2DateString(){
		return DateUtil.getDateTime("yyMMdd" ,getSystemDateTime());
	}
	
	/**
	 * md5加密字符串
	 * @param resString
	 * @return
	 *  	md5
	 */
	public String getMD5String(String resString){
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
				return "";
			}
			char[] charArray = resString.toCharArray();
			byte[] byteArray = new byte[charArray.length];
			for (int i = 0; i < charArray.length; i++)
				byteArray[i] = (byte) charArray[i];
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
	}
	
	/*public static void main(String[] args){
		UtilService us = new UtilService();
//		String str = us.getMD5String("1234");
//		System.out.println(str);
//		System.out.println(us.getSystemDateTime());
		for(int i=0; i<10; i++){
			System.out.println(us.getSystem2DateString());
		}
		
	}*/
	
}
