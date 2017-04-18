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

@WebServlet("/reg")
public class RegistationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/reg.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		System.out.println("POST");
		
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		try {
			if(!uDAO.userExists(login)){
				System.out.println("I add user " + login + " : " + pass);
				uDAO.addUser(login, pass);
				resp.sendRedirect("/chat");
			}else{
				System.out.println("error user exist");
				resp.sendRedirect("/reg");
			}
		} catch (SQLException e) {
			// TODO Exception
			e.printStackTrace();
		}
	}

	
	
}
