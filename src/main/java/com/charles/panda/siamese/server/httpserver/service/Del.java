package com.charles.panda.siamese.server.httpserver.service;

import java.sql.Connection;

import com.charles.panda.siamese.server.httpserver.core.Request;
import com.charles.panda.siamese.server.httpserver.core.Response;
import com.charles.panda.siamese.server.httpserver.core.impl.DBHttpHandler;
import com.importsource.dbcp.client.DBClient;


/**
 * 你只需要在doit方法里写一句话了就实现了db的读写操作。
 * 
 * 当然这时候你可以觉得我需要进行一下验证。除了验证还有什么呢？其实也没什么了。
 * 
 * 验证和日志就这两个东西
 * @author Hezf
 *
 */
public class Del extends DBHttpHandler{
	@Override
	public void doIt(Connection conn, Request request, Response response) {
		obj =  DBClient.del(conn, "delete from user where name=?", "贺卓凡");
	}
	
}
