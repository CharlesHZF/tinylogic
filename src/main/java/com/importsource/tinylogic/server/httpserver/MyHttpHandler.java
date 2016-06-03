package com.importsource.tinylogic.server.httpserver;

import java.io.IOException;

import com.importsource.tinylogic.server.httpserver.core.Handler;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpRequest;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpResponse;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author charles
 * @Description: 内部消息处理类
 * @version V1.0
 */
@SuppressWarnings("restriction")
public class MyHttpHandler implements HttpHandler {

	public void handle(HttpExchange httpExchange) throws IOException {
		HttpRequest request = new HttpRequest(httpExchange);
		HttpResponse response = new HttpResponse(httpExchange);
		Handler handler = Context.getHandler(request.getReuestURI().getPath());
		handler.service(request, response);

	}
}
