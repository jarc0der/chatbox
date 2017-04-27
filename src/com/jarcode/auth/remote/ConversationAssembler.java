package com.jarcode.auth.remote;

import java.util.ArrayList;
import java.util.List;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.ConversatioDAO;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.dto.ConversationDTO;
import com.jarcode.auth.dto.MessageDTO;
import com.jarcode.auth.entity.Conversation;
import com.jarcode.auth.entity.Message;
import com.jarcode.auth.entity.User;

public class ConversationAssembler {

	public List<ConversationDTO> getAllConvDTO() {
		// DAO BLOCK
		MessageAssembler mAsm = new MessageAssembler();
		ConversatioDAO cDAO = new ConversatioDAO(ConnectionPool.getConnection());
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		ConversationDTO convDTO = null;

		// Domain BLOCK
		List<ConversationDTO> cList = new ArrayList<>();
		
		List<Conversation> convList = cDAO.getAllConv();
		for(Conversation conv : convList){
			cList.add(new ConversationDTO(
					conv.getId(),
					conv.getName(),
					uDAO.getUserByID(conv.getOwner()),
					uDAO.getUserByID(conv.getFriend()),
					conv.getIsActive(),
					mAsm.getAllMessagesByConvID(conv.getId())
					));
		}
		
		return cList;
		
	}
	
	public List<ConversationDTO> getUsersConvById(int uid) {
		// DAO BLOCK
		MessageAssembler mAsm = new MessageAssembler();
		ConversatioDAO cDAO = new ConversatioDAO(ConnectionPool.getConnection());
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		ConversationDTO convDTO = null;

		// Domain BLOCK
		List<ConversationDTO> cList = new ArrayList<>();
		
		List<Conversation> convList = cDAO.getUserConverByID(uid);
		for(Conversation conv : convList){
			cList.add(new ConversationDTO(
					conv.getId(),
					conv.getName(),
					uDAO.getUserByID(conv.getOwner()),
					uDAO.getUserByID(conv.getFriend()),
					conv.getIsActive(),
					mAsm.getAllMessagesByConvID(conv.getId())
					));
		}
		
		return cList;
		
	}

	public ConversationDTO getConvDTO(int id) {
		// DAO BLOCK
		MessageAssembler mAsm = new MessageAssembler();
		ConversatioDAO cDAO = new ConversatioDAO(ConnectionPool.getConnection());
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		ConversationDTO convDTO = null;

		// Domain BLOCK
		Conversation conver = cDAO.getConvById(id);
		System.out.println(conver);
		User owner = uDAO.getUserByID(conver.getOwner());
		User friend = uDAO.getUserByID(conver.getFriend());
		List<MessageDTO> mList = mAsm.getAllMessagesByConvID(id);

		return convDTO = new ConversationDTO(conver.getId(), conver.getName(), owner, friend, conver.getIsActive(),
				mList);

	}
}
