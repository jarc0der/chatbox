package com.jarcode.auth.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null){
			session.removeAttribute("login");
			session.invalidate();
		}
		
		System.out.println("session " + session.getId() + " is invalidated!");
		
		
		resp.sendRedirect("/");
		
		//redirect to index
	}
	
	

}
