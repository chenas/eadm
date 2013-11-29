package com.base.framwork.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

/**
 * 加密程序
 * 
 * Md5加密是不可逆算法
 * 
 * */

@Component
public class Mdcrypt {
	// MD5加码。32位,不可逆,用于加密密码
	public String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
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

	// 可逆的加密算法
	public String jiami(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}

	// 加密后解密
	public String jiemi(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}
	
/*	public static void main(String[] args){
		Mdcrypt mc = new Mdcrypt();
		System.out.println(mc.MD5("usstqzwlsyb"));
		String s = "34 45 43 ";
		String[] st = s.split(" ");
		System.out.println(s.split(" ").length);
		for(int i=0; i<st.length; i++){
			System.out.println(st[i]);
		}
	}*/
}
