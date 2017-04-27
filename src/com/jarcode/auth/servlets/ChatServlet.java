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
import com.jarcode.auth.dto.ConversationDTO;
import com.jarcode.auth.dto.MessageDTO;
import com.jarcode.auth.entity.Conversation;
import com.jarcode.auth.remote.ConversationAssembler;
import com.jarcode.auth.remote.MessageAssembler;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = (String) req.getSession().getAttribute("login");
		int roleId = (int) req.getSession().getAttribute("role");
		//get convId from user session
		String convId = (String)req.getSession().getAttribute("convId");
		int uid  = (Integer)req.getSession().getAttribute("uID");
		System.out.println("user ID : " + uid);
		
		MessageAssembler mDAO = new MessageAssembler();
		ConversationAssembler convDTO = new ConversationAssembler();
		List<MessageDTO> mList = null;
		
		List<ConversationDTO> cList = convDTO.getUsersConvById(uid);
		
		//check if cList size not bigger than convID
		if(convId != null){
			int id = Integer.valueOf(convId);
//			req.setAttribute("currentConv", id);
			mList = mDAO.getAllMessagesByConvID(id);
		}else{
			System.out.println("Set start page ");
			req.setAttribute("startPage", 1);
		}
		try {			
			
			req.setAttribute("mList", mList); //messages list
			req.setAttribute("cList", cList); //conversation list
			req.setAttribute("login", login);
			req.setAttribute("role", roleId);
			
			req.getRequestDispatcher("/chat.jsp").forward(req, resp);

		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
