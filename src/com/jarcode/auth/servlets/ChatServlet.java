package com.jarcode.auth.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.ConversatioDAO;
import com.jarcode.auth.dto.MessageDTO;
import com.jarcode.auth.entity.Conversation;
import com.jarcode.auth.remote.MessageAssembler;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = (String) req.getSession().getAttribute("login");
		int roleId = (int) req.getSession().getAttribute("role");
		//this is for conversation ID /chat?id=1
		int convId = 2;
		
		
		System.out.println("convID = " + convId);
		
		MessageAssembler mDAO = new MessageAssembler();
		ConversatioDAO convDAO = new ConversatioDAO(ConnectionPool.getConnection());
		List<MessageDTO> mList = null;
		
		if(convId > 0){
			System.out.println("Generate conv msg list with id " + convId);
			mList = mDAO.getAllMessagesByConvID(convId);
		}else{
			System.out.println("Generete all msgs");
			mList = mDAO.getAllMessagesDTO();
		}
		try {

			
			List<Conversation> cList = convDAO.getAllConv();
			
			req.setAttribute("mList", mList);
			req.setAttribute("cList", cList);
			req.setAttribute("login", login);
			req.setAttribute("role", roleId);
			
			req.getRequestDispatcher("/chat.jsp").forward(req, resp);

		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
