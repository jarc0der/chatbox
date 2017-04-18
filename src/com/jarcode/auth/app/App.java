package com.jarcode.auth.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jarcode.auth.dao.IMessageDAO;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.entity.Message;
import com.jarcode.auth.entity.User;
import com.jarcode.auth.remote.MessageAssembler;

public class App {
	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/chatbox?useSSL=false";

	public static void main(String[] args) throws SQLException {
		
	}
	
}
