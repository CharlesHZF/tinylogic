package com.importsource.tinylogic.server.httpserver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.log.LogManager;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpHandler;
import com.importsource.tinylogic.server.httpserver.utils.StringUtils;
import com.importsource.tinylogic.server.httpserver.utils.jar.MyPath;

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
		String appJar = getTinyLogicProjectPath();
		String webappPath = appJar + "webapp" + File.separator;
		appJar = webappPath + getFileName(webappPath).get(0);
		return appJar;
	}

	protected static List<String> getFileName(String dir) {
		File f = new File(dir);
		List<String> lst = new ArrayList<String>();
		if (!f.exists()) {
			System.out.println(dir + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (!fs.isDirectory()) {
				lst.add(fs.getName());
			}

		}
		return lst;
	}

	public static String getTinyLogicProjectPath() {
		final String jarPath = MyPath.getProjectPath();
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
