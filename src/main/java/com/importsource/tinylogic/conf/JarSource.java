package com.importsource.tinylogic.conf;

import java.io.File;

import com.importsource.conf.Source;
import com.importsource.tinylogic.server.httpserver.utils.StringUtils;
import com.importsource.tinylogic.server.httpserver.utils.jar.MyPath;

/**
 * 基于tinylogic的定制化实现.
 * 专门服务于tinylogic
 * @author Hezf
 *
 */
public class JarSource{
	protected static File file;
	
	public File getFile(String path) {
		return getFile1(path);
	}

	protected File getFile1(String path) {
		if (file == null) {
			
			file=new File(getConfFile());

		}
		return file;
	}
	
	private static String getTinyLogicProjectPath() {
		final	String  jarPath=MyPath.getProjectPath();
		String appJar="";
		System.out.println(jarPath);
		if(StringUtils.isNotEmpty(jarPath)){
			String[] pathItems=jarPath.split("\\\\");
			String lastItem=pathItems[pathItems.length-1];
			System.out.println(lastItem);
			appJar=jarPath.substring(0,jarPath.length()-lastItem.length());
			
		}
		return appJar;
	}
	
	private static String getConfFile() {
		return getTinyLogicProjectPath()+"conf.xml";
	}
}
