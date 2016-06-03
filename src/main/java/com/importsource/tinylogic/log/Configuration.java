package com.importsource.tinylogic.log;

import com.importsource.tinylogic.conf.DefaultProperties;

public class Configuration {
   public static DefaultProperties newPropertiesInstance(){
	   DefaultProperties p = DefaultProperties.newInstance(null);
	   return p;
   }
}