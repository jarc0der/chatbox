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
import com.jarcode.auth.enums.SystemMessage;

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
		String email = req.getParameter("email");
		
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		SystemMessage sysMsg = null;
		try {
			if(!uDAO.userExists(login)){
				uDAO.addUser(login, pass, email);
				resp.sendRedirect("/chat");
				sysMsg = new SystemMessage("SUCCESS", "Registration successful!");
			}else{
				sysMsg = new SystemMessage("WARN", "User with this login already exists!");
				resp.sendRedirect("/reg");
			}
		} catch (SQLException e) {
			// TODO Exception
			e.printStackTrace();
		} finally{
			setAttribute(sysMsg, req.getSession());
		}
	}

	private void setAttribute(SystemMessage msg, HttpSession s){
		s.setAttribute("msg", msg);
	}
	
}
