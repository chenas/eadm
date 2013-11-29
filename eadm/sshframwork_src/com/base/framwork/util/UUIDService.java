package com.base.framwork.util;

/**
 * 
 * A singleton responsible to create valid uuid identifiers.
 */
public class UUIDService {

	/**
	 * 单例对象
	 */
	private static UUIDService instance = new UUIDService();

	/**
	 * 取得实例
	 * @return 实例
	 */
	public static UUIDService getInstance() {
		return instance;
	}

	/**
	 * 有分隔符的UUID字符串
	 * @param separator 分隔符 
	 * @return UUID字符串
	 */
	public String simpleHex(String separator) {
		return (String) new UUIDHexGenerator(separator).generate();
	}

	/**
	 * 无分隔符的UUID字符串
	 * @return UUID字符串
	 */
	public String simpleHex() {
		return (String) new UUIDHexGenerator().generate();
	}
}
