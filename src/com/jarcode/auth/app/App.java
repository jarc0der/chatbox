package com.jarcode.auth.app;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/chatbox?useSSL=false";

	public static void main(String[] args) throws SQLException, ParseException {
		String timeFromDB = "1492711199033";
		String time = new Timestamp(Long.valueOf(timeFromDB)).toString();
		
		System.out.println("TimeFromDB: " + time);
		
		System.out.println("Current timeST: " + getCurrentTime());
		
		DateFormat format = new SimpleDateFormat("hh:mm");
		System.out.println(format.parse(time).toString());
	}
	
	
	static String getCurrentTime(){
		return String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
	}
	
}
