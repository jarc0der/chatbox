package com.jarcode.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//http://cse.csusb.edu/turner/java_web_programming/security/filter/

import com.jarcode.auth.entity.User;


public class UserDAO {
	private Connection con;

	public UserDAO(Connection con2) {
		con = con2;
	}

	public void addUser(String login, String pass) throws SQLException {
		con.setAutoCommit(false);
		PreparedStatement stmt = con.prepareStatement("Insert into users(login, pass) values (?, ?)");
		stmt.setString(1, login);
		stmt.setString(2, pass);
		stmt.executeUpdate();
		con.commit();
	}

	public User getUser(String sql){
		Statement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = con.createStatement();
			rs = ps.executeQuery(sql);
			rs.next();
			int id = rs.getInt(1);
			String login =  rs.getString(2);
			String pass = rs.getString(3);
			user = new User(id, login, pass);
		} catch (SQLException e) {
			// TODO: Exception!
			e.printStackTrace();
		}
		
		return user;
	}

	public User getUserByID(int id){
		return getUser("SELECT * from users where id = "+id+"");
	}
	
	public User getUserByLogin(String login){
		return getUser("SELECT * from users where login = '"+login+"'");
	}
	
	public List<User> getAllUsers() throws SQLException {
		String sql = "SELECT * from users";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		List<User> uList = new ArrayList<>();
		
		while(rs.next()){
			uList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		return uList;
	}
	
	public boolean loginRequest(String login, String pass) throws SQLException{
		if(userExists(login)){
			return checkPassword(login, pass);
		}else{
			System.out.println("LoginReq. from " + login + " failed. User don't exists");
			return false;
		}
	}
	
	public boolean userExists(String login) throws SQLException{
		String sql = "select login from users where login = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, login);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs.next();
	}
	
	private boolean checkPassword(String login, String pass) throws SQLException{
		String sql = "select login from users where login = ? and pass = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, pass);
		rs = stmt.executeQuery();
		
		return rs.next();
	}
	
}
