package com.importsource.tinylogic.server.httpserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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
	protected Logger logger = LogManager.getLogger(TinyHttpHandler.class);

	public void handle(HttpExchange httpExchange) throws IOException {
		HttpRequest request = new HttpRequest(httpExchange);
		HttpResponse response = new HttpResponse(httpExchange);

		URI requestURI = request.getReuestURI();
		logger.i((requestURI) + "");
		if (requestURI != null && requestURI.toString().endsWith(".html")) {
			// 那么就去webapp下面找html就可以了.
			String projectPath = Context.getTinyLogicProjectPath();
			String filePath = projectPath + "webapp" + requestURI.toString();
			InputStreamReader isr=new InputStreamReader(new FileInputStream(filePath),"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			isr.close();
			logger.i(sb.toString());
			response.write(sb.toString().substring(1, sb.toString().length()));
		}
		String path = requestURI.getPath();
		Handler handler = Context.getHandler(path);
		if (handler == null) {
			response.write("Can't find this microservice : " + path);
		} else {
			handler.service(request, response);
		}

	}
}
