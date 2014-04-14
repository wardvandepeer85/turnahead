package com.programmeren4.turnahead.server.database;

import java.sql.*;


public class DBConnector {
	//Gegevens testdb "turnaheadtest"
	//JBDC Connection URL: jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_turnaheadtest
	//DatabaseName: cb_turnaheadtest
	//USN: beae58204ee11c
	//PW: b31565a0
	
	//Gegevens DB programmeren4
	//JBDC Connection URL: 
	//DatabaseName: cb_programmeren4
	//USN: prog4
	//PW: programmeren4
	
	
	private static Connection CONN = null;
	public static final String URL = "jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_turnaheadtest";
    public static final String USER = "Ybeae58204ee11c";
    public static final String PASSWORD = "b31565a0";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
	
	
	//constructor 
	public DBConnector() {
		initConn();
	}
	
	//method
	private void initConn() {
		System.out.println("Connection initiated");
		try {
			DBConnector.CONN = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection set");
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
		}		
		System.out.println("Connection confirmed");
	}
	
	public static Connection getConn() {
		return CONN;
	}
	
	public static void closeConn() {
		try {
			getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
