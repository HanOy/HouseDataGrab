package com.oyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
	
	//数据库用户名  
    private static final String USERNAME = "dev";
    
    //数据库密码  
    private static final String PASSWORD = "CivoVeiko@666";
    
    //驱动信息   
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    //数据库地址  
    private static final String URL = "jdbc:mysql://localhost:3306/house";
    
    private Connection connection;
    
    private PreparedStatement pstmt;
    
    private ResultSet resultSet;
    
    public JdbcUtils() {  
        try {
            Class.forName(DRIVER);
            System.out.println("数据库连接成功！");
        } catch(Exception e){
        	e.printStackTrace();
        }
    }
    
    /**
     * 获得数据库的连接
     * @return
     */
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /** 
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     */  
    public boolean updateByPreparedStatement(String sql) throws SQLException {
        boolean flag = false;
        int result = -1;
        pstmt = connection.prepareStatement(sql);
        result = pstmt.executeUpdate();
        flag = result > 0 ? true : false;
        return flag;
    }
    
    /**
     * 释放数据库连接
     */
    public void releaseConn() {
    	if (resultSet != null) {
            try{
                resultSet.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
