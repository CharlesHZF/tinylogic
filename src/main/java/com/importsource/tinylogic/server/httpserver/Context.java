package com.importsource.tinylogic.server.httpserver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.log.LogManager;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpHandler;
import com.importsource.tinylogic.server.httpserver.utils.StringUtils;
import com.importsource.tinylogic.server.httpserver.utils.io.FileUtils;
import com.importsource.tinylogic.server.httpserver.utils.jar.JarUtils;

/**
 * 上下文
 * 
 * @author hezf
 * @version V1.0
 */
public class Context {
	protected static Logger logger = LogManager.getLogger(Context.class);
	protected static Map<String, HttpHandler> contextMap = new HashMap<String, HttpHandler>();
	public static String contextPath = "";

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static HttpHandler getHandler(String key) {
		return contextMap.get(key);
	}

	protected static String getAppJar() {
		String tinyProjectPath = getTinyLogicProjectPath();
		String webappPath = getWebAppPath();
		tinyProjectPath = webappPath + FileUtils.getFileName(webappPath).get(0);
		return tinyProjectPath;
	}

	/**
	 * 得到webapp的目录路径
	 * @param tinyProjectPath tinylogic的路径
	 * @return String webapp的目录路径
	 */
	public static String getWebAppPath() {
		return Context.getTinyLogicProjectPath() + "webapp" + File.separator;
	}
	
	/**
	 * 得到具体的app的lib的路径
	 * @return
	 */
	public static String getAppLibPath(){
		return Context.getWebAppPath()+"lib"+File.separator;
	}

	
    /**
     * 得到tinylogic项目的根目录
     * @return tinylogic项目的根目录
     */
	public static String getTinyLogicProjectPath() {
		final String jarPath = JarUtils.getJarPath();
		String appJar = "";
		// System.out.println(jarPath);
		if (StringUtils.isNotEmpty(jarPath)) {
			String[] pathItems = jarPath.split("\\\\");
			String lastItem = pathItems[pathItems.length - 1];
			// System.out.println(lastItem);
			appJar = jarPath.substring(0, jarPath.length() - lastItem.length());

		}
		return appJar;
	}

	/*public static void main(String[] args) {
		/// System.out.println(getAppJar());
	}*/

}
