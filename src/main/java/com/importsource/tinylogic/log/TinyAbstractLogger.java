package com.importsource.tinylogic.log;


import com.importsource.log.core.AbstractLogger;
import com.importsource.tinylogic.conf.DefaultProperties;
import com.importsource.tinylogic.conf.PropertiesTools;

public abstract class TinyAbstractLogger extends AbstractLogger {
	protected  DefaultProperties p=Configuration.newPropertiesInstance();
	@Override
	protected String getLevel() {
		String level=PropertiesTools.get(p, LEVEL_KEY, INFO);
		return level.toUpperCase();
	}
	@Override
	protected abstract void log(String msg, String level) ;

}
