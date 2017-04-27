package com.jarcode.auth.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/chatbox?useSSL=false";

	public static void main(String[] args) throws SQLException, ParseException {
		// MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		// mDAO.insertMessage(1, "1", "1", 2, 0);
		// System.out.println(mDAO.getAllMessages());

		Pattern p = Pattern.compile("(\\d+)\\:(\\d+)");  
        Matcher m = p.matcher("2017-04-20 21:52:30.492" );
        if(m.find()){
        	System.out.println(m.group(1) + "-" + m.group(2));
        }
	}

}
