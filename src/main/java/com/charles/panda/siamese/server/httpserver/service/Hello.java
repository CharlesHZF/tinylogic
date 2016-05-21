package com.charles.panda.siamese.server.httpserver.service;


import com.charles.panda.siamese.server.httpserver.core.Request;
import com.charles.panda.siamese.server.httpserver.core.Response;
import com.charles.panda.siamese.server.httpserver.core.impl.DefaultHttpHandler;


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
