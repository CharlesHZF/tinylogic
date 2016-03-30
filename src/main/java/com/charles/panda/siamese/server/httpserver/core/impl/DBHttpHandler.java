package com.charles.panda.siamese.server.httpserver.core.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.charles.panda.siamese.server.httpserver.core.Request;
import com.charles.panda.siamese.server.httpserver.core.Response;
import com.importsource.dbcp.common.CommonException;
import com.importsource.dbcp.core.DbcpConnection;
import com.importsource.ison.Ison;

/**
 * 含有db的handler
 * @author Hezf
 *
 */
public abstract class DBHttpHandler extends HttpHandler {

	protected static final Logger logger = LogManager.getLogger(DBHttpHandler.class);
    protected String verb="GET";
    
	protected Object obj;
    
    
	@Override
	public void doGet(Request request, Response response) {
		verb="GET";
		dbStatement(request, response);

	}

	protected void dbStatement(Request request, Response response) {
		Connection conn = DbcpConnection.getConnection();
		if (conn == null) {
			logger.error("The database connection is null!");
		}
		boolean autoCommit = true;
		try {
			autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			doIt(conn, request, response);
			conn.commit();
			conn.setAutoCommit(autoCommit);
		} catch (Exception ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			logger.error(ex.getMessage(), ex);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new CommonException("sql_exception", "Dbcp connection can't be closed");
			}

		}
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
		dbStatement(request, response);

	}

	public abstract void doIt(Connection conn, Request request, Response response);


}
