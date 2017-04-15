package com.jarcode.auth.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.entity.Message;



@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	
	private MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = (String) req.getSession().getAttribute("login");
		
		try {
				List<Message> mList = mDAO.getAllMessages();
				req.setAttribute("mList", mList);
				req.setAttribute("login", login);
				req.getRequestDispatcher("/chat.jsp").forward(req, resp);
				
			}finally{
				System.out.println("Hello from chat servlet");
			}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO: validate message
		String text = req.getParameter("msg");
		System.out.println("Add message");
	
		//TODO: User's ID in Sessio
		int uId = 0;
		
		mDAO.insertMessage(uId, text);
		
//		resp.sendRedirect("/chat");
		req.getRequestDispatcher("/chat.jsp").forward(req, resp);
		
		
		
	}
	
	
	
	
}
