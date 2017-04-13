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

public class App {
	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/chatbox?useSSL=false";

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = DriverManager.getConnection(URL, username, password);
		UserDAO uDAO = new UserDAO(con);
		IMessageDAO mDAO = new MessageDAO(con);
		
		System.out.println("Welcome to chatBOX");
		System.out.println("I need your name \ntype>");
		String uName = "temp";
		
//		uName = sc.nextLine();
		System.out.println("Typed name :" + uName);
		displayMessages(mDAO);
		
		System.out.println(uDAO.loginRequest("yarik", "yarik"));
		
	}
	
	public static void displayMessages(IMessageDAO mDAO){
		List<Message> mList = mDAO.getAllMessages();
		
		System.out.println("-------- box --------");
		System.out.println("Messages: " + mList.size());
		
		mList.stream().forEach((e) -> System.out.println(e));
		System.out.println("--------- end ----------");
	}
	
}
