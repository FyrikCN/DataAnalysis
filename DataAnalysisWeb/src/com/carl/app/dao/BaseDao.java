package com.carl.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.carl.app.tools.ConfigManager;

public class BaseDao {
	/**
	 * Get database connection
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection = null;
		String driver=ConfigManager.getInstance().getValue("driver");
		String url=ConfigManager.getInstance().getValue("url");
		String user=ConfigManager.getInstance().getValue("user");
		String password=ConfigManager.getInstance().getValue("password");
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static ResultSet execute(Connection connection,PreparedStatement pstm,ResultSet rs,
			String sql,Object[] params) throws Exception{
		pstm = connection.prepareStatement(sql);
		for(int i = 0; i < params.length; i++){
			pstm.setObject(i+1, params[i]);
		}
		rs = pstm.executeQuery();
		return rs;
	}
	
	public static int execute(Connection connection,PreparedStatement pstm,
		String sql,Object[] params) throws Exception{
		int updateRows = 0;
		pstm = connection.prepareStatement(sql);
		for(int i = 0; i < params.length; i++){
			pstm.setObject(i+1, params[i]);
		}
		updateRows = pstm.executeUpdate();
		return updateRows;
	}
	
	public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
		boolean flag = true;
		if(rs != null){
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		if(pstm != null){
			try {
				pstm.close();
				pstm = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		if(connection != null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		
		return flag;
	}
}
