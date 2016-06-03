package com.importsource.tinylogic.server.httpserver.core.impl;

import com.importsource.tinylogic.server.httpserver.core.Handler;
import com.importsource.tinylogic.server.httpserver.core.Request;
import com.importsource.tinylogic.server.httpserver.core.Response;

public abstract class HttpHandler implements Handler {

	public void service(Request request, Response response) {
		request.initRequestHeader();
		request.initRequestParam();
		if(request.getMethod().equals(Request.GET)){
			doGet(request,response);
		}else if(request.getMethod().equals(Request.POST)){
			request.initRequestBody();
			doPost(request,response);
		}
	}

	public abstract void doGet(Request request, Response response);

	public abstract void doPost(Request request, Response response);

	
}
