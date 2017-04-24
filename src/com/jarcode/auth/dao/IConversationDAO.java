package com.jarcode.auth.dao;

public interface IConversationDAO {
	public void createConversation(String name, int owner, int friend);
	
	public void deleteConversation(int id);
	
}
