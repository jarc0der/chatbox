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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		User user = null;
		
		boolean result = false;
		try {
			result = uDAO.loginRequest(login, pass);
		} catch (SQLException e) {
			// TODO Exception
			e.printStackTrace();
		}
		
		if(result){
			user = uDAO.getUserByLogin(login);
			setSessionAttr(user, req.getSession());
		}else{
			System.out.println("bad data");
		}
		resp.sendRedirect("/chat");
	}
	
	private void setSessionAttr(User u, HttpSession s){
		System.out.println("set attr to session");
		if(u != null){
			s.setAttribute("login", u.getLogin());
			s.setAttribute("uID", u.getId());
			s.setAttribute("color", u.getColor());
			s.setAttribute("banLevel", u.getBan());
			s.setAttribute("role", u.getRoleId());
		}
	}
}
