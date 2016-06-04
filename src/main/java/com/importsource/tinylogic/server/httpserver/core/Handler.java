package com.importsource.tinylogic.server.httpserver.core;
/**
 *  消息处理接口
 * @author hezf
 */
public interface Handler {
	public void service(Request request, Response response);
	public void doGet(Request request, Response response);
	public void doPost(Request request, Response response);

}
