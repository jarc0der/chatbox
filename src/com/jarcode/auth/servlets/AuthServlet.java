package com.jarcode.auth.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.entity.Message;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		System.out.println("POST: login: " + login + " - " + "pass " + pass);
		
		
		req.getSession().setAttribute("login", login);
		
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		try {
			boolean b = uDAO.loginRequest(login, pass);
			System.out.println("AUTH: " + login + ":" + pass + " is " + b);
			if(b){
				List<Message> mList = mDAO.getAllMessages();
				req.setAttribute("mList", mList);
				req.setAttribute("login", login);
//				req.getRequestDispatcher("/chat.jsp").forward(req, resp);
				resp.sendRedirect("/chat");
				
			}else{
				resp.sendRedirect("/error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
