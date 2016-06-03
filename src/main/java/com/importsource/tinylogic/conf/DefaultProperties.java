package com.importsource.tinylogic.conf;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.importsource.conf.Properties;
import com.importsource.conf.Source;
/**
 * use jarsource get file
 * @author Hezf
 *
 */
public class DefaultProperties  {
	/**
	 * 增加缓存能力
	 */
	protected static final HashMap<String, String> propertiesMap = new HashMap<String,String>();
	
	/**
	 * 默认文件路径
	 */
	protected static  String path="conf.xml";
	
	/**
	 * 如果使用这个构造函数，那么就是用默认路径
	 */
	public  DefaultProperties(){
		
	}
	
	/**
	 * 可以定制目录
	 * @param path  客户端指定的目录
	 */
	public DefaultProperties(String path){
		DefaultProperties.path=path;
	}
	
	private static DefaultProperties properties;


	public static DefaultProperties newInstance(String path) {
		if (properties == null) {
			properties = new DefaultProperties(path);
		}
		return properties;
	}
	
	public static DefaultProperties newInstance() {
		if (properties == null) {
			properties = new DefaultProperties(path);
		}
		return properties;
	}

	public  String get(String name, String defaultValue)  {
		String value =getFromCache(name);
		if(value==null){
			value=defaultValue;
			File myXML = new JarSource().getFile(path);
			SAXReader sr = new SAXReader();
			try {
				Document doc = sr.read(myXML);
				Element root = doc.getRootElement();
				for (@SuppressWarnings("unchecked")
				Iterator<Element> fathers = (Iterator<Element>) root.elementIterator(); fathers.hasNext();) {

					Element father = (Element) fathers.next();
					@SuppressWarnings("unchecked")
					Iterator<Element> childs = (Iterator<Element>) father.elementIterator();
					Element nameElement = null;
					Element valueElement = null;
					if (childs.hasNext()) {
						nameElement = (Element) childs.next();
					}
					if (childs.hasNext()) {
						valueElement = (Element) childs.next();
					}

					if (nameElement.getText().equals(name)) {
						value = valueElement.getText();
					}
					
					propertiesMap.put(name, value);

				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	protected static String getFromCache(String name) {
		return propertiesMap.get(name);
	}
	
}
