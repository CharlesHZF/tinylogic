package com.charles.panda.siamese.server.httpserver.service;

import com.charles.panda.siamese.server.httpserver.core.Request;
import com.charles.panda.siamese.server.httpserver.core.Response;
import com.charles.panda.siamese.server.httpserver.core.impl.HttpHandler;


public class FirstHandler extends HttpHandler{

	@Override
	public void doGet(Request request, Response response) {
		System.out.println("doGet");
		
		System.out.println(request.getParamter("aaa"));
		System.out.println(request.getParamter("bbb"));
		
		response.write("<a href='http://baidu.com'>baidu</a>");
	}

	
	@Override
	public void doPost(Request request, Response response) {
		System.out.println("doPost");
		System.out.println(request.getRequestBody());
		
		response.write("hsdfsdfsdfsdfelloWorld.....");
	}

	
}
