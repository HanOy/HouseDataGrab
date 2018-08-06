package com.oyh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtils {
	
	//数据库用户名  
    private static final String USERNAME = "dev";
    
    //数据库密码  
    private static final String PASSWORD = "CivoVeiko@666";
    
    //驱动信息   
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    //数据库地址  
    private static final String URL = "jdbc:mysql://localhost:3306/house?useSSL=false&serverTimezone=GMT";
    
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

	public void insertHouseList(List<HousePojo> resultList) throws SQLException {
		for (HousePojo house : resultList) {
			String sql = "insert into house (`room`, `hall`, `toilet`, `community`, `area`, `price`, `average`, `year`, `floor`, `district`, `address`, `subway`, `elevator`, `visit`, `href`) VALUES ('";
			sql += house.getRoom() + "','";
			sql += house.getHall() + "','";
			sql += house.getToilet() + "','";
			sql += house.getCommunity() + "','";
			sql += house.getArea() + "','";
			sql += house.getPrice() + "','";
			sql += house.getAverage() + "','";
			sql += house.getYear() + "','";
			sql += house.getFloor() + "','";
			sql += house.getDistrict() + "','";
			sql += house.getAddress() + "','";
			sql += house.getSubway() + "','";
			sql += house.getElevator() + "','";
			sql += house.getVisit() + "','";
			sql += house.getHref() + "')";
			
			updateByPreparedStatement(sql);
		}
	}
	
	/**
	 * 执行查询操作
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            执行参数
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findResult(String sql, List<?> params)
			throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}

}
