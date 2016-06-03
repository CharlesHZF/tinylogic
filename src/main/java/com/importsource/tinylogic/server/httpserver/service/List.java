package com.importsource.tinylogic.server.httpserver.service;

import java.sql.Connection;

import com.importsource.dbcp.client.DBClient;
import com.importsource.tinylogic.server.httpserver.core.Request;
import com.importsource.tinylogic.server.httpserver.core.Response;
import com.importsource.tinylogic.server.httpserver.core.impl.DBHttpHandler;


/**
 * 你只需要在doit方法里写一句话了就实现了db的读写操作。
 * 
 * 当然这时候你可以觉得我需要进行一下验证。除了验证还有什么呢？其实也没什么了。
 * 
 * 验证和日志就这两个东西
 * @author Hezf
 *
 */
public class List extends DBHttpHandler{
	@Override
	public void doIt(Connection conn, Request request, Response response) {
		obj =  DBClient.list(conn, "select * from user where 1=?","1");
	}
	
}
