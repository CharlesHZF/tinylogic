package com.importsource.tinylogic.log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.conf.DefaultProperties;
import com.importsource.tinylogic.conf.PropertiesTools;


/**
 * Tiny定制的日志管理器
 * @author Hezf
 *
 */
public class LogManager {
	private static final String LOGGER_PKG = "com.importsource.tinylogic.log.";
	private static DefaultProperties p=Configuration.newPropertiesInstance();

	/**
	 * 得到日志类
	 * @param clazz 日志所在类
	 * @return Logger 日志对象
	 */
	public static Logger getLogger(Class clazz) {
		String loggerStr = PropertiesTools.get(p, "clog.logger", null);
		Logger logger=null;
		Class[] paraTypes = {Class.class};
		Object[] paras = {clazz};
		try {
			Class clas = Class.forName(LOGGER_PKG+loggerStr);
			Constructor cons = clas.getConstructor(paraTypes);
			logger = (Logger)cons.newInstance(paras);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return logger;
	}

}
