package com.base.framwork.domain;

import java.io.Serializable;

/**
 * 所有model的抽象基类
 * 子类必须实现toString、equals、hashCode方法
 * @author chenas
 *2013年08月11日
 */
public abstract class BaseObject implements Serializable{
	
	/**
	 * toString方法
	 * @return 对象的序列化结果
	 */
	public abstract String toString();

	/**
	 * 重写的equals方法
	 * @param o 比较对象
	 * @return 比较结果
	 */
	public abstract boolean equals(Object o);

	/**
	 * 重写的hashCode方法
	 * @return hashCode
	 */
	public abstract int hashCode();

}
