package com.jarcode.auth.dao;

import java.util.List;

import com.jarcode.auth.entity.Message;

public interface IMessageDAO {
	public Message getMessage(int id);
	
	public List<Message> getAllMessages();
	
	public void insertMessage(int uId, String text, String timestamp, int convId, int block);

	List<Message> getMessagesByConvId(int id);

}
