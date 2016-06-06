package com.importsource.tinylogic.server.httpserver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.log.LogManager;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpHandler;
import com.importsource.tinylogic.server.httpserver.utils.StringUtils;
import com.importsource.tinylogic.server.httpserver.utils.XmlUtils;
import com.importsource.tinylogic.server.httpserver.utils.jar.AppClassLoader;
import com.importsource.tinylogic.server.httpserver.utils.jar.JarUtils;

/**
 * 上下文 
 * @author hezf
 * @version V1.0
 */
public class XmlContext extends Context implements ILoad {
	protected static Logger logger=LogManager.getLogger(XmlContext.class);
	public  void load(){
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

	

	protected static String getContextFile() {
		return getTinyLogicProjectPath()+"context.xml";
	}
	
	
	public static void main(String[] args){
		System.out.println(getAppJar());
	}
	
}
