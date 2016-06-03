package com.charles.panda.siamese.server.httpserver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.charles.panda.siamese.server.httpserver.core.impl.HttpHandler;
import com.charles.panda.siamese.server.httpserver.utils.XmlUtils;
import com.charles.panda.siamese.server.httpserver.utils.jar.MyPath;

import default1.Load;
/**
 * 
 * @author charles
 * @Description: 上下文 
 * @version V1.0
 */
public class Context {
	private static Map<String,HttpHandler> contextMap = new HashMap<String,HttpHandler>();
	public static String contextPath = "";
	public static void load(){
		try{
			//Document doc = XmlUtils.load(Load.class.getResource("/").getPath()+"context.xml");
			Document doc=XmlUtils.load(new File(MyPath.getProjectPath()+"/context.xml"));
			Element root = doc.getDocumentElement();
			
			contextPath = XmlUtils.getAttribute(root,"context");
			Element[] handlers = XmlUtils.getChildrenByName(root, "handler");
			for(Element ele : handlers){
				String handle_class = XmlUtils.getChildText(ele, "handler-class");
				String url_pattern = XmlUtils.getChildText(ele, "url-pattern");
				
				Class<?> cls = Class.forName(handle_class);
				Object newInstance = cls.newInstance();
				if(newInstance instanceof HttpHandler){
					contextMap.put(contextPath+url_pattern, (HttpHandler)newInstance);
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static HttpHandler getHandler(String key){
		return contextMap.get(key);
	}
	
}
