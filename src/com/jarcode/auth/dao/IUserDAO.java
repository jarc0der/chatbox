package com.jarcode.auth.dao;


import java.util.List;

import com.jarcode.auth.entity.User;

public interface IUserDAO {
	
	public User getUser(String sql);
	
	public List<User> getAllUsers();
	
	public void addUser(String login, String pass);
	
}
