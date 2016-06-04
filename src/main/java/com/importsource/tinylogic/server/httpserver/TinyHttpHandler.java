package com.importsource.tinylogic.server.httpserver;

import java.io.IOException;
import java.net.URI;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.log.LogManager;
import com.importsource.tinylogic.net.httpserver.HttpExchange;
import com.importsource.tinylogic.net.httpserver.HttpHandler;
import com.importsource.tinylogic.server.httpserver.core.Handler;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpRequest;
import com.importsource.tinylogic.server.httpserver.core.impl.HttpResponse;

/**
 * @author charles
 * @Description: 内部消息处理类
 * @version V1.0
 */
@SuppressWarnings("restriction")
public class TinyHttpHandler implements HttpHandler {
	protected  Logger logger=LogManager.getLogger(TinyHttpHandler.class);
	public void handle(HttpExchange httpExchange) throws IOException {
		HttpRequest request = new HttpRequest(httpExchange);
		HttpResponse response = new HttpResponse(httpExchange);
		
		URI reuestURI = request.getReuestURI();
		logger.i((reuestURI==null)+"");
		String path = reuestURI.getPath();
		Handler handler = Context.getHandler(path);
		if(handler==null){
			response.write("Can't find this microservice : "+path);
		}else{
			handler.service(request, response);
		}
		

	}
}
