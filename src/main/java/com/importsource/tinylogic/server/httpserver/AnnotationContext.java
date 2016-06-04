package com.importsource.tinylogic.server.httpserver;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Enumeration;
import java.util.jar.JarFile;


import com.importsource.tinylogic.server.httpserver.annoation.MicroService;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpHandler;
import com.importsource.tinylogic.server.httpserver.utils.jar.AppClassLoader;

/**
 * 基于annotation的Context
 * @author Hezf
 *
 */
public class AnnotationContext extends Context implements ILoad {
	public  void load(){
		try {
			logger.i("jar path is "+getAppJar());
			scanJar(getAppJar());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(getContextPath("/apps/hello1"));
		scanJar("C:\\Users\\Hezf\\Documents\\dev\\svn\\alogic\\workspace\\tinylogic-demo\\target\\tinylogic-demo-0.0.1-SNAPSHOT.jar"); 
	}

	private static void scanJar(String jarPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		JarFile jar=null;
		try {
			jar = new JarFile(jarPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ClassLoader cl=AppClassLoader.getInstance(jar.getName());
		Enumeration enumeration = jar.entries(); 
		while(enumeration.hasMoreElements()){ 
			Object element=enumeration.nextElement();
			String elementString=element.toString();
			if(elementString.endsWith(".class")){
				String newElementString=elementString.replaceAll("/", ".");
				//System.out.println("截取后的效果："+newElementString);
				String className=newElementString.substring(0, newElementString.indexOf(".class"));
				//System.out.println("jarName:"+jar.getName());
				Class class1=cl.loadClass(className);
				Annotation annotation=class1.getAnnotation(MicroService.class);
				String key=getValue(annotation);
				setContextPath(key);
				System.out.println("value:"+key);
				System.out.println("className:"+class1.getName());
				Object ins=class1.newInstance();
				if(ins instanceof HttpHandler){
				  HttpHandler handler=	(HttpHandler)ins;
				  contextMap.put(key, handler);
				}
				
			}
		
		}
	}

	private static void setContextPath(String key) {
		String contextPath=getContextPath(key);
		Context.contextPath=contextPath;
		
	}

	private static String getContextPath(String key) {
		String[] strings=key.split("/");
		return "/"+strings[1];
	}

	private static String getValue(Annotation annotation) {
		String value="";
		String[] arrrs=annotation.toString().split("[( )]");
		for (String string : arrrs) {
			if(string.startsWith("value")){
				String[] keyvalue=string.split("=");
				value=keyvalue[1];
				break;
			}
		}
		return value;
	}
}
