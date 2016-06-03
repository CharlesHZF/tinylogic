package com.importsource.tinylogic.server.httpserver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.log.LogManager;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpHandler;
import com.importsource.tinylogic.server.httpserver.utils.StringUtils;
import com.importsource.tinylogic.server.httpserver.utils.XmlUtils;
import com.importsource.tinylogic.server.httpserver.utils.jar.AppClassLoader;
import com.importsource.tinylogic.server.httpserver.utils.jar.MyPath;

/**
 * 上下文 
 * @author hezf
 * @version V1.0
 */
public class Context {
	protected static Logger logger=LogManager.getLogger(Context.class);
	private static Map<String,HttpHandler> contextMap = new HashMap<String,HttpHandler>();
	public static String contextPath = "";
	public static void load(){
		try{
			//Document doc = XmlUtils.load(Load.class.getResource("/").getPath()+"context.xml");
			Document doc=XmlUtils.load(new File(getContextFile()));
			Element root = doc.getDocumentElement();
			
			contextPath = XmlUtils.getAttribute(root,"context");
			Element[] handlers = XmlUtils.getChildrenByName(root, "handler");
			for(Element ele : handlers){
				String handle_class = XmlUtils.getChildText(ele, "handler-class");
				String url_pattern = XmlUtils.getChildText(ele, "url-pattern");
				
				Class<?> cls;
				try {
					cls = Class.forName(handle_class);
				} catch (ClassNotFoundException e) {
					AppClassLoader cl=AppClassLoader.getInstance(getAppJar());
					cls=cl.loadClass(handle_class);
				}
				Object newInstance = cls.newInstance();
				if(newInstance instanceof HttpHandler){
				    logger.i("load "+ cls.getName());
					contextMap.put(contextPath+url_pattern, (HttpHandler)newInstance);
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	private static String getAppJar() {
		String appJar = getTinyLogicProjectPath();
		appJar=appJar+"webapp"+File.separator+"tinylogic-demo-0.0.1-SNAPSHOT.jar";
		return appJar;
	}

	private static String getTinyLogicProjectPath() {
		final	String  jarPath=MyPath.getProjectPath();
		String appJar="";
		//System.out.println(jarPath);
		if(StringUtils.isNotEmpty(jarPath)){
			String[] pathItems=jarPath.split("\\\\");
			String lastItem=pathItems[pathItems.length-1];
			//System.out.println(lastItem);
			appJar=jarPath.substring(0,jarPath.length()-lastItem.length());
			
		}
		return appJar;
	}

	private static String getContextFile() {
		return getTinyLogicProjectPath()+"context.xml";
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static HttpHandler getHandler(String key){
		return contextMap.get(key);
	}
	
	public static void main(String[] args){
		System.out.println(getAppJar());
	}
	
}
