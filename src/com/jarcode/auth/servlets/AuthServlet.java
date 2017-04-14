package com.jarcode.auth.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.UserDAO;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		System.out.println("POST: login: " + login + " - " + "pass " + pass);
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		boolean b = false;
		try {
			b = uDAO.loginRequest(login, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("AUTH: " + login + ":" + pass + " is " + b);
		req.getSession().setAttribute("login", login);
		
		// /auth and chat.jsp page
//		req.getRequestDispatcher("/chat.jsp").forward(req, resp);
		
		resp.sendRedirect("/chat");
	}
	
}
