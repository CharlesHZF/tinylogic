package com.charles.panda.siamese.server.httpserver;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;


/**
 * 
 * @author charles
 * @Description: 服务器启动类  ，入口类。
 * @version V1.0
 */
@SuppressWarnings("restriction")
public class MyHttpServer {
	public static void main(String[] args) throws IOException {
		
		Context.load();
		HttpServerProvider provider = HttpServerProvider.provider();
		HttpServer httpserver = provider.createHttpServer(new InetSocketAddress(8080), 100);// 监听端口8080,能同时接
		// 受100个请求
		httpserver.createContext(Context.contextPath, new MyHttpHandler());
		httpserver.setExecutor(null);
		httpserver.start();
		System.out.println("server started");
	}
}
