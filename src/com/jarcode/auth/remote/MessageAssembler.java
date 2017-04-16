package com.jarcode.auth.remote;

import java.util.ArrayList;
import java.util.List;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.dto.MessageDTO;
import com.jarcode.auth.entity.Message;
import com.jarcode.auth.entity.User;

public class MessageAssembler {

	public MessageDTO getMessageDTO(int id) {
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());

		Message msg = mDAO.getMessage(id);
		User user = uDAO.getUserByID(msg.getUserId());

		return new MessageDTO(msg.getId(), user.getLogin(), msg.getText());
	}

	public List<MessageDTO> getAllMessagesDTO() {
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		List<Message> mList = mDAO.getAllMessages();
		List<MessageDTO> mDTOList = new ArrayList<>();

		for (Message msg : mList) {
			MessageDTO msgDTO = new MessageDTO();
			User user = uDAO.getUserByID(msg.getUserId());
			System.out.println(user);
			msgDTO.setId(msg.getId());
			msgDTO.setFromName(user.getLogin());
			msgDTO.setText(msg.getText());
			mDTOList.add(msgDTO);
		}

		return mDTOList;

	}

	public void updateMessageDTO(int id, MessageDTO msgDTO) {
		throw new UnsupportedOperationException();
	}

	public void deleteMessageDTO(int id) {
		throw new UnsupportedOperationException();
	}

	public void createMessageDTO(String[] params) {
		throw new UnsupportedOperationException();
	}

}
