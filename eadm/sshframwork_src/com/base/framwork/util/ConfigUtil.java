package com.base.framwork.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 可编程的热部署 功能：如果你没有修改配置文件，那么就直接从内存中取配置项，而无需每次都去读配置文件；
 * 如果你修改了配置文件，他会重新读一次配置文件，而无需重新reload应用。
 * 具体实现：第一次读配置文件的时候，记录文件被修改的时间，并且将配置内容读到内容缓存；
 * 以后每次读配置的时候，先去读文件被修改的时间，和记录下来的时间做对比， 如果一致，就直接读内存缓存的配置项，否则的话，就重新从硬盘读配置项，
 * 并且更新文件修改时间的变量。
 * 其中：global.properties是配置文件，可以放到任意CLASSPATH路径下面，例如WEB-INF/classes下面
 * 
 * @time: 10:08:54
 * @author zhangwei
 */
public class ConfigUtil {
	/**
	 * 属性对象
	 */
	private static Properties props = null;

	/**
	 * 属性配置文件
	 */
	private static File configFile = null;

	/**
	 * 上次修改时间
	 */
	private static long fileLastModified = 0L;

	/**
	 * 全局属性配置文件【默认】
	 */
	private static String configFileName = "commonsys.properties";

	/**
	 * 初始化默认的配置文件
	 * 
	 */
	private static void init() {
		URL url = ConfigUtil.class.getClassLoader().getResource(configFileName);
		configFile = new File(url.getFile());
		fileLastModified = configFile.lastModified();
		props = new Properties();
		load();
	}

	/**
	 * 加载各个配置到默认的props属性中
	 */
	private static void load() {
		try {
			props.load(new FileInputStream(configFile));
			fileLastModified = configFile.lastModified();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 从默认的配置文件中取得某个key所对应的值
	 * 
	 * @param key
	 *            键
	 * @return 值
	 */
	public static String getConfig(String key) {
		if ((configFile == null) || (props == null))
			init();
		if (configFile.lastModified() > fileLastModified)
			load();
		return props.getProperty(key);
	}

	/**
	 * 从指定的配置文件中中取得某个key所对应的值
	 * 
	 * @param configFileName
	 *            指定的配置文件
	 * @param key
	 *            键
	 * @return 值
	 */
	public static String getConfig(String configFileName, String key) {
		URL url = ConfigUtil.class.getClassLoader().getResource(configFileName);
		File config = new File(url.getFile());
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(config));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return properties.getProperty(key);
	}

	/**
	 * 保存key的值为value
	 * 
	 * @param key
	 *            参数名
	 * @param value
	 *            参数值
	 * @throws IOException
	 *             文件访问异常
	 */
	public static void saveConfig(String key, String value) throws IOException {
		URL apurl = ConfigUtil.class.getClassLoader().getResource(
				configFileName);
		File appconfig = new File(apurl.getFile());
		PropertiesUtil apppro = new PropertiesUtil(appconfig.getAbsolutePath(),
				PropertiesUtil.DEF_ENCODING);

		apppro.setProperties(key, value);

		apppro.save();
	}

	/**
	 * 保存key的值为value
	 * 
	 * @param configFileName
	 *            配置文件名
	 * @param key
	 *            参数名
	 * @param value
	 *            参数值
	 * @throws IOException
	 *             文件访问异常
	 */
	public static void saveConfig(String configFileName, String key,
			String value) throws IOException {
		URL apurl = ConfigUtil.class.getClassLoader().getResource(
				configFileName);
		File appconfig = new File(apurl.getFile());
		PropertiesUtil apppro = new PropertiesUtil(appconfig.getAbsolutePath(),
				PropertiesUtil.DEF_ENCODING);

		apppro.setProperties(key, value);

		apppro.save();
	}
}
