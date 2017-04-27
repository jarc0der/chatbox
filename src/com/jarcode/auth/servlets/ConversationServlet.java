package com.jarcode.auth.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conv")
public class ConversationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		//if id not null, set it in the session.
		//else set value 0, zero is conversation with BOT
		
		req.getSession().setAttribute("convId", id);
		System.out.println("Conversation setted ID: " + id);
		
		resp.sendRedirect("/chat");
		return;
	}
}
