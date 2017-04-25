package com.jarcode.auth.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.utils.DateTimeUtils;

@WebServlet("/message")
public class MessageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		//TODO: check if it's him message;
		if(id != null){
			//call from DAO blockMessage(id);
			//TODO convert handler exception
			mDAO.blockMessage(Integer.valueOf(id));
			System.out.println("[Servlet]Message with id : " + id + " is blocked");
		}
		
		resp.sendRedirect("/chat");
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO: validate message
		String text = req.getParameter("msg");
		int uId = (int) req.getSession().getAttribute("uID");
		String timestamp = DateTimeUtils.getCurTimeStamp();
		int convId = Integer.getInteger(req.getParameter("convId"));
		
		//0 - is default value
		int block = 0;
		
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		

		//TODO set convId value
		mDAO.insertMessage(uId, text, timestamp, 1, block);
		
		resp.sendRedirect("/chat");
		return;
	}

	
}
