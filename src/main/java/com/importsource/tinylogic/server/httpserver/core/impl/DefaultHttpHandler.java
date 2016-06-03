package com.importsource.tinylogic.server.httpserver.core.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.importsource.dbcp.common.CommonException;
import com.importsource.dbcp.core.DbcpConnection;
import com.importsource.ison.Ison;
import com.importsource.tinylogic.server.httpserver.core.Request;
import com.importsource.tinylogic.server.httpserver.core.Response;

/**
 * 含有db的handler
 * @author Hezf
 *
 */
public abstract class DefaultHttpHandler extends HttpHandler {

	protected static final Logger logger = LogManager.getLogger(DefaultHttpHandler.class);
    protected String verb="GET";
    
	protected Object obj;
    
    
	@Override
	public void doGet(Request request, Response response) {
		verb="GET";
		defaultStatement(request, response);

	}

	protected void defaultStatement(Request request, Response response) {
	    doIt(request, response);
		write(request,response);
		
	}
    /**
     * 如果你想要返回更多的信息。你可以重写这个方法来做更多的操作。
     * @param request
     * @param response
     */
	protected void write(Request request, Response response) {
		Ison gson=new Ison();
		if(null!=obj){
			response.write(gson.toJson(obj));
		}
	}

	@Override
	public void doPost(Request request, Response response) {
		verb="POST";
		defaultStatement(request, response);

	}

	public abstract void doIt(Request request, Response response);


}
