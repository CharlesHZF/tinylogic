package com.importsource.tinylogic.server.httpserver.core;

import java.net.InetSocketAddress;
import java.net.URI;
/**
 * @author charles
 * @Description: 请求接口
 * @version V1.0
 */
public interface Request {
	public final static String GET = "GET";
	public final static String POST = "POST";

	public String getParamter(String param);

	public String getMethod();

	public URI getReuestURI();

	public void initRequestHeader();
	
	public void initRequestParam();

	public void initRequestBody();

	public String getRequestBody();
	
	 public InetSocketAddress getLocalAddress();
}
