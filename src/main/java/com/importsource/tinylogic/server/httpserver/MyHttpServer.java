package com.importsource.tinylogic.server.httpserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.conf.DefaultProperties;
import com.importsource.tinylogic.conf.PropertiesTools;
import com.importsource.tinylogic.log.LogManager;
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
	protected static Logger logger=LogManager.getLogger(MyHttpServer.class);
	public static void main(String[] args) throws IOException {
		start();
	}

	/**
	 * 启动一个server
	 * @throws IOException
	 */
	public static void start() throws IOException {
		int port=getPort();
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();  
		for (int i = 0; i < urls.length; i++) {  
		    logger.i("load "+urls[i].toExternalForm());  
		}
		Class<?> loadClz=null;
		try {
			loadClz = Class.forName(getContext());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ILoad iLoad=null;
		try {
			iLoad = (ILoad)loadClz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iLoad.load();
		HttpServerProvider provider = HttpServerProvider.provider();
		HttpServer httpserver = provider.createHttpServer(new InetSocketAddress(port), getCount());// 监听端口8080,能同时接
		// 受100个请求
		logger.i("contextPath is "+Context.contextPath);
		httpserver.createContext(Context.contextPath, new MyHttpHandler());
		httpserver.setExecutor(null);
		httpserver.start();
		logger.i("ok!server started! at port:"+port);
	}
	
	private static String getContext() {
		DefaultProperties p=new DefaultProperties();
		return PropertiesTools.get(p, "tinylogic.server.context", "com.importsource.tinylogic.server.httpserver.XmlContext");
	}

	private static int getCount() {
		DefaultProperties p=new DefaultProperties();
		int count=Integer.parseInt(PropertiesTools.get(p, "tinylogic.server.count", "100"));
		return count;
	}
	private static int getPort() {
		DefaultProperties p=new DefaultProperties();
		int port=Integer.parseInt(PropertiesTools.get(p, "tinylogic.server.port", "8080"));
		return port;
	}
}
