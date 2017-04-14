package com.jarcode.auth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/chatbox?useSSL=false";
	
	private static Connection _con;
	
	public static Connection getConnection(){
		if(_con == null){
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				_con = DriverManager.getConnection(URL, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return _con;
	}
}
