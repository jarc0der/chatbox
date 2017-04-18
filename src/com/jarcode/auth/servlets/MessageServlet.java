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

@WebServlet("/message")
public class MessageServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO: validate message
		String text = req.getParameter("msg");
		System.out.println("Add message");
	
		int uId = (int) req.getSession().getAttribute("uID");
		
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		mDAO.insertMessage(uId, text);
		
		resp.sendRedirect("/chat");
		return;
	}

	
}
