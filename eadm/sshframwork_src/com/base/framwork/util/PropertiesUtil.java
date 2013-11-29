package com.base.framwork.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 实现任意properties文件读写 支持各种字符集
 * 
 * @Time 下午04:09:27
 * @author zhangwei
 */
public class PropertiesUtil extends ArrayList<String> {
	/**
	 * 默认字符集
	 */
	public static final String DEF_ENCODING = "UTF-8";

	/**
	 * 设置字符集
	 */
	private String encoding = "UTF-8";

	/**
	 * 属性文件名字符串
	 */
	private String fileName;

	/**
	 * 构造方法
	 * 
	 * @param fileName
	 *            属性文件名
	 * @param encoding
	 *            对文件名操作使用的编码格式
	 */
	public PropertiesUtil(String fileName, String encoding) {
		try {
			this.setFileName(fileName);
			this.setCharacterEncoding(encoding);
			if (!isFileExist(fileName))
				this.write("");
			this.addAll(Arrays.asList(read(fileName, encoding).split("\n")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 设置字符集
	 * 
	 * @param encoding
	 *            编码格式
	 * @throws UnsupportedEncodingException
	 *             异常
	 */
	private void setCharacterEncoding(String encoding)
			throws UnsupportedEncodingException {
		// TestInsertInvestigation the encoding is valid
		new String("".getBytes("iso8859_1"), encoding);
		// Getting here means we're valid, so set the encoding
		this.encoding = encoding;
	}

	/**
	 * 文件是否存在
	 * 
	 * @param fileName
	 *            文件名
	 * @return true表示文件是存在的
	 */
	public static boolean isFileExist(String fileName) {
		return new File(fileName).isFile();
	}

	/**
	 * read file as single strings
	 * 
	 * @param fileName
	 *            文件名
	 * @param encoding
	 *            编码格式
	 * @return 读取文件内容后形成的字符串
	 * @throws IOException
	 *             读取异常
	 */
	public static String read(String fileName, String encoding)
			throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s;
		while ((s = in.readLine()) != null) {
			// 为什么转换了反而会是乱码
			sb.append(s);// new String(s.getBytes("iso8859_1"), encoding));
			sb.append("\n");
		}
		in.close();
		return sb.toString();
	}

	/**
	 * write file as single strings
	 * 
	 * @param text
	 *            待写入文件的文本内容
	 * @throws IOException
	 *             读取异常
	 */
	public void write(String text) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				fileName)));
		out.print(text);
		out.close();
	}

	/**
	 * save the content to file
	 * 
	 * @throws IOException
	 *             读取异常
	 */
	public void save() throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				fileName)));
		String tmp;
		for (int i = 0; i < size(); i++) {
			tmp = get(i) + "";
			// tmp = new String(tmp.getBytes("iso8859_1"),encoding);
			out.println(tmp);
		}
		out.close();
	}

	/**
	 * set properties file with a par key and value
	 * 
	 * @param key
	 *            属性键值
	 * @param val
	 *            属性值
	 */
	public void setProperties(String key, String val) {
		int ipos = findKey(key);
		if (ipos >= 0)
			this.set(ipos, key + "=" + val);
		else
			this.add(key + "=" + val);
	}

	/**
	 * 查找KEY的序号
	 * 
	 * @param key
	 *            字符串键值
	 * @return 当前key在文件中的序号
	 */
	public int findKey(String key) {
		try {
			String tmp;
			for (int i = 0; i < size(); i++) {
				tmp = get(i) + "";
				tmp = new String(tmp.getBytes("iso8859_1"), DEF_ENCODING);
				if (tmp.indexOf(key) == 0) {
					return i;
				}
			}
		} catch (Exception e) {
		}
		return -1;
	}

	/**
	 * 增加备注
	 * 
	 * @param key
	 *            字符串键值
	 * @param memo
	 *            备注内容
	 */
	public void setMemo(String key, String memo) {
		if ("".equals(key)) {
			this.add("#" + memo);
			return;
		}
		String tmp;
		int ret = findKey(key);
		if (ret == -1) {// 如果没有找到
			this.add("#" + memo);
			this.add(key + "=");
		} else {
			int ipos = ret - 1;
			if (ipos < 0)
				this.add(ipos, "#" + memo);
			else {
				tmp = this.get(ipos) + "";
				if ("#".equals(tmp.substring(0, 1)))
					this.set(ipos, "#" + memo);
				else
					this.add(ipos + 1, "#" + memo);
			}
		}
	}

	/**
	 * 设置标题
	 * 
	 * @param title
	 *            标题
	 */
	public void setTitle(String title) {
		String tmp = this.get(0) + "";
		if (tmp == null || tmp.length() == 0)
			tmp = "";
		else
			tmp = tmp.substring(0, 1);

		if ("#".equals(tmp))
			this.set(0, "#" + title);
		else {
			this.add(0, "");
			this.add(0, "#" + title);
		}
	}

	/**
	 * get the value of a key
	 * 
	 * @param key
	 *            属性键值
	 * @return 属性值
	 */
	public String getProperties(String key) {
		return getProperties(key, "");
	}

	/**
	 * 查找属性值
	 * 
	 * @param key
	 *            属性键值
	 * @param defaultStr
	 *            默认值（没找到属性值时返回）
	 * @return 属性值
	 */
	public String getProperties(String key, String defaultStr) {
		String tmp;
		String ret;
		try {
			for (int i = 0; i < size(); i++) {
				tmp = get(i) + "";
				tmp = new String(tmp.getBytes("iso8859_1"), DEF_ENCODING);
				if (tmp.indexOf(key) == 0) {
					ret = tmp.substring(key.length() + 1);
					return ret;
				}
			}
		} catch (Exception e) {
		}
		return defaultStr;
	}

	/**
	 * 取得文件名
	 * 
	 * @return 文件名
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 设置文件名
	 * 
	 * @param fileName
	 *            文件名
	 */
	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding
	 *            the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

}
