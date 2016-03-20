package com.charles.panda.siamese.server.httpserver.core.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import com.charles.panda.siamese.server.httpserver.core.Response;
import com.sun.net.httpserver.HttpExchange;

public class HttpResponse implements Response{
	private HttpExchange httpExchange;
	public HttpResponse(HttpExchange httpExchange){
		this.httpExchange = httpExchange;
	}
	
	
	public void write(String result) {
		try {
			//httpExchange.sendResponseHeaders(200, result.length());// 设置响应头属性及响应信息的长度
			httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, result.getBytes("GBK").length);
			OutputStream out = httpExchange.getResponseBody(); // 获得输出流
			out.write(result.getBytes("GBK"));
			out.flush();
			httpExchange.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	
}
