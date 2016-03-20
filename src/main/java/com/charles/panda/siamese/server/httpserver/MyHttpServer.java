package com.charles.panda.siamese.server.httpserver;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;


/**
 * 
 * @author charles
 * @Description: 服务器启动类  ，入口类。
 * 
 * 下一步把参数通过配置的方式来做。然后做一个启动界面这样就ok了。就是一个容器了。然后再把docker加入进来。这样一切看起来一个微服务已经构建完毕。
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
