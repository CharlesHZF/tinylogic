package com.importsource.tinylogic.server.httpserver.service;


import com.importsource.tinylogic.server.httpserver.core.Request;
import com.importsource.tinylogic.server.httpserver.core.Response;
import com.importsource.tinylogic.server.httpserver.core.impl.DefaultHttpHandler;


/**
 * hello world
 * @author Hezf
 *
 */
public class Hello extends DefaultHttpHandler{
	@Override
	public void doIt(Request request, Response response) {
		obj =  "HelloWorld";
	}
	
}
