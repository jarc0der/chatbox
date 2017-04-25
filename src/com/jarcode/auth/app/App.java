package com.jarcode.auth.app;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.ConversatioDAO;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dto.ConversationDTO;
import com.jarcode.auth.remote.ConversationAssembler;

public class App {
	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/chatbox?useSSL=false";

	public static void main(String[] args) throws SQLException, ParseException {
		
		ConversationDTO dto = new ConversationAssembler().getConvDTO(1);
		System.out.println(dto);
	}
	
}
