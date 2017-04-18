package com.jarcode.auth.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.entity.User;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet{
	
	UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		User user = null;
		System.out.println("POST: login: " + login + " - " + "pass " + pass);
		
		boolean result = false;
		try {
			result = uDAO.loginRequest(login, pass);
		} catch (SQLException e) {
			// TODO Exception
			e.printStackTrace();
		}
		
		if(result){
			user = uDAO.getUserByLogin(login);
			System.out.println("USERDAO: getID " + user.getId());
			setSessionAttr(user, req.getSession());
		}
		System.out.println("AUTH: " + login + ":" + pass + " is " + result);
		resp.sendRedirect("/chat");
	}
	
	private void setSessionAttr(User u, HttpSession s){
		if(u != null){
			s.setAttribute("login", u.getLogin());
			s.setAttribute("uID", u.getId());
		}
	}
}
