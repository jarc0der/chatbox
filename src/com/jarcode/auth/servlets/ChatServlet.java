package com.jarcode.auth.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dto.MessageDTO;
import com.jarcode.auth.entity.Message;
import com.jarcode.auth.remote.MessageAssembler;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = (String) req.getSession().getAttribute("login");
		MessageAssembler mDAO = new MessageAssembler();
		try {
			List<MessageDTO> mList = mDAO.getAllMessagesDTO();
			req.setAttribute("mList", mList);
			req.setAttribute("login", login);
			req.getRequestDispatcher("/chat.jsp").forward(req, resp);

		} finally {
			System.out.println("Hello from chat servlet");
		}
	}

}
