package com.charles.panda.siamese.server.httpserver.core;
/**
 * @author charles
 * @Description: 消息处理接口
 * @version V1.0
 */
public interface Handler {
	public void service(Request request, Response response);
	public void doGet(Request request, Response response);
	public void doPost(Request request, Response response);

}
