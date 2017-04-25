package com.jarcode.auth.remote;

import java.util.ArrayList;
import java.util.List;

import com.jarcode.auth.dao.ConnectionPool;
import com.jarcode.auth.dao.MessageDAO;
import com.jarcode.auth.dao.UserDAO;
import com.jarcode.auth.dto.MessageDTO;
import com.jarcode.auth.entity.Message;
import com.jarcode.auth.entity.User;
import com.jarcode.auth.utils.DateTimeUtils;

public class MessageAssembler {

	public MessageDTO getMessageDTO(int id) {
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());

		Message msg = mDAO.getMessage(id);
		User user = uDAO.getUserByID(msg.getUserId());

		return new MessageDTO(msg.getId(), user.getLogin(), msg.getText(), user.getColor(), DateTimeUtils.convertStampToDate(msg.getTimestamp()), msg.getBlock());
	}

	public List<MessageDTO> getAllMessagesDTO() {
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		List<Message> mList = mDAO.getAllMessages();
		List<MessageDTO> mDTOList = new ArrayList<>();

		for (Message msg : mList) {
			MessageDTO msgDTO = new MessageDTO();
			User user = uDAO.getUserByID(msg.getUserId());
			msgDTO.setId(msg.getId());
			msgDTO.setFromName(user.getLogin());
			msgDTO.setText(msg.getText());
			msgDTO.setColor(user.getColor());
			msgDTO.setTime(DateTimeUtils.convertStampToDate(msg.getTimestamp()));
			msgDTO.setBlock(msg.getBlock());
			mDTOList.add(msgDTO);
		}

		return mDTOList;

	}
	
	public List<MessageDTO> getAllMessagesByConvID(int id) {
		UserDAO uDAO = new UserDAO(ConnectionPool.getConnection());
		MessageDAO mDAO = new MessageDAO(ConnectionPool.getConnection());
		List<Message> mList = mDAO.getMessagesByConvId(id);
		List<MessageDTO> mDTOList = new ArrayList<>();

		for (Message msg : mList) {
			MessageDTO msgDTO = new MessageDTO();
			User user = uDAO.getUserByID(msg.getUserId());
			msgDTO.setId(msg.getId());
			msgDTO.setFromName(user.getLogin());
			msgDTO.setText(msg.getText());
			msgDTO.setColor(user.getColor());
			msgDTO.setTime(DateTimeUtils.convertStampToDate(msg.getTimestamp()));
			msgDTO.setBlock(msg.getBlock());
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
