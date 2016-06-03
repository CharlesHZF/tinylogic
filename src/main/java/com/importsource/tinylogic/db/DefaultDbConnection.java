package com.importsource.tinylogic.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.conf.DefaultProperties;
import com.importsource.tinylogic.conf.PropertiesTools;
import com.importsource.tinylogic.log.LogManager;

public class DefaultDbConnection  {
	protected static Logger logger=LogManager.getLogger(DefaultDbConnection.class);
	private static DataSource dataSource;
	private static Connection con;

	public DefaultDbConnection() {
	}

	public static Connection getConnection() {
		if (dataSource == null) {
			initDataSource();
		}
		try {
			con = dataSource.getConnection();
			print();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return con;

	}

	public static void initDataSource() {
		String driverClassName = null;
		String url = null;
		String username = null;
		String password = null;
		int initialSize = 0;
		int minIdle = 0;
		int maxIdle = 0;
		int maxWait = 0;
		int maxActive = 0;
		try {
			DefaultProperties p = DefaultProperties.newInstance();
			driverClassName = PropertiesTools.get(p, "dbcp.driverClassName", null);
			url = PropertiesTools.get(p, "dbcp.url", null);
			username = PropertiesTools.get(p, "dbcp.username", null);
			password = PropertiesTools.get(p, "dbcp.password", null);

			minIdle = Integer.parseInt(PropertiesTools.get(p, "dbcp.minIdle", null));
			maxIdle = Integer.parseInt(PropertiesTools.get(p, "dbcp.maxIdle", null));
			maxWait = Integer.parseInt(PropertiesTools.get(p, "dbcp.maxWait", null));
			maxActive = Integer.parseInt(PropertiesTools.get(p, "dbcp.maxActive", null));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		ds.setUsername(username);
		ds.setPassword(password);

		ds.setInitialSize(initialSize); // 初始的连接数；
		ds.setMaxActive(maxActive);
		ds.setMinIdle(minIdle);
		ds.setMaxIdle(maxIdle);
		ds.setMaxWait(maxWait);
		ds.setRemoveAbandoned(true);
		ds.setRemoveAbandonedTimeout(2000);
		dataSource = ds;

	}

	/* 用于测试连接状态的方法 */
	public static void print() {
		BasicDataSource ds = (BasicDataSource) dataSource;
		logger.i(ds.getInitialSize()+"");
		logger.i(ds.getNumActive()+"");
		logger.i(ds.getNumIdle()+"");
		logger.i(ds.getDefaultAutoCommit()+"");
	}

//	public static void main(String[] args) {
//		Connection con;
//		try {
//			con = DbcpConnection.getConnection();
//			// print();
//			Statement stmt = con.createStatement();
//			ResultSet result = stmt.executeQuery("select name from user");
//			while (result.next()) {
//				String name = result.getString("name");
//				System.out.println("name=" + name);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//		}
//	}
}
