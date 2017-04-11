package com.jarcode.auth.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.entity.User;

public class App {
	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/chatbox?useSSL=false";

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(URL, username, password);
		UserDAO uDAO = new UserDAO(con);
		User u = uDAO.getUser(1);
		
		System.out.println(u);
	}
}
