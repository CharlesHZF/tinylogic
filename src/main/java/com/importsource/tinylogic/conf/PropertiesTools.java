package com.importsource.tinylogic.conf;
public class PropertiesTools {
	public static String get(DefaultProperties props,String name,String defaultValue) {
		
		return props.get(name, defaultValue);
	}
}