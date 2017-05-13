package com.jarcode.auth.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarcode.auth.app.Messages;
import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.enums.SystemMessage;
import com.jarcode.auth.utils.DateTimeUtils;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		// TODO: check if it's him message;
		if (id != null) {
			// call from DAO blockMessage(id);
			// TODO convert handler exception
			mDAO.blockMessage(Integer.valueOf(id));
			System.out.println("[Servlet]Message with id : " + id + " is blocked");
		}

		resp.sendRedirect("/chat");
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: validate message
		System.out.println("MY: ааббcc");
		String text = req.getParameter("msg");
		
		System.out.println(text);
		
		int uId = (int) req.getSession().getAttribute("uID");
		String timestamp = DateTimeUtils.getCurTimeStamp();
		String convId = req.getParameter("convId");
		String sem = req.getParameter("sem");

		// 0 - is default value
		int block = 0;
		int convID = Integer.valueOf(convId);
		int semValue = Integer.valueOf(sem);

		SystemMessage message = null;
		switch (semValue) {
		case 0:
			message = new SystemMessage("WARN", Messages.MSG_BLOCK);
			break;
		case 1:
			message = new SystemMessage("SUCCESS", Messages.MSG_SUCCESS);
			break;
		case 2:
			message = new SystemMessage("WARN", Messages.MSG_LINKS);
			break;
		case 3:
			message = new SystemMessage("WARN", Messages.MSG_ENCODE);
			break;
		case 4:
			message = new SystemMessage("WARN", Messages.MSG_WSIZE);
			break;
		default:
			message = new SystemMessage("WARN", "�������� ��� �������");
		}


		req.getSession().setAttribute("msg", message);

		if (message.getType().equals("WARN")) {
			resp.sendRedirect("/chat");
			return;
		}

		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		mDAO.insertMessage(uId, text, timestamp, convID, block);

		resp.sendRedirect("/chat");
		return;
	}

}
