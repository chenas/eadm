package com.base.framwork.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
/**
 * 反射工具类
 * 
 */
public class ReflectUtil {

	/**
	 * 检查字段字符串是不是包含空格
	 * @param fieldString
	 */
	private static void checkFormat(String fieldString) {
		if (StringUtils.isBlank(fieldString)) {
			throw new RuntimeException("fieldString can't be empty!");
		}
	}

	/**
	 * 将字符串第一个字符变成大写
	 * @param fieldString
	 * @return
	 */
	public static String firstUpperCase(String fieldString) {
		checkFormat(fieldString);
		return Character.toUpperCase(fieldString.charAt(0))
				+ fieldString.substring(1);
	}

	/**
	 * 根据属性获得set方法名
	 * @param fieldString
	 * @return
	 */
	public static String getSetterOfField(String fieldString) {
		return "set" + firstUpperCase(fieldString);
	}

	/**
	 * 根据属性获得get方法名
	 * @param fieldString
	 * @return
	 */
	public static String getGetterOfField(String fieldString) {
		return "get" + firstUpperCase(fieldString);
	}

	/**
	 * 根据一个OGNL表达式获取某对象属性的类型"user.contact.email"
	 * @param object
	 * @param expression
	 * @return
	 */
	public static Class<?> getPropertyTypeByOgnlExpression(
			Object object, String expression) {
		if (StringUtils.isBlank(expression) || object == null)
				throw new IllegalArgumentException("expression or object cannot be null");
		try {
			String[] tokens = expression.split("\\.");
			
			Field field = null;
			Class<?> clz = object.getClass();
			for (int i = 0; i < tokens.length; i++) {
				String token = tokens[i];
				field = clz.getDeclaredField(token);
				clz = field.getType();
			}
			
			return clz;
		} catch (Exception e) {
			throw new RuntimeException("illegal ognl expression: " + expression);		
		}
	}

	/**
	 * 获得一个对象各个属性的字节流
	 */
	@SuppressWarnings("unchecked")
	public static void getProperty(Object entityName) throws Exception {
		Class c = entityName.getClass();
		Field field[] = c.getDeclaredFields();
		for (Field f : field) {
			Object v = invokeMethod(entityName, f.getName(), null);
			System.out.println(f.getName() + "\t" + v + "\t" + f.getType());
		}
	}
	/**
	 * 获得对象属性的值
	 */
	@SuppressWarnings("unchecked")
	private static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		methodName = methodName.substring(0, 1).toUpperCase()
				+ methodName.substring(1);
		Method method = null;
		try {
			method = ownerClass.getMethod("get" + methodName);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			return " can't find 'get" + methodName + "' method";
		}
		return method.invoke(owner);
	}

}
