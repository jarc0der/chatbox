package com.jarcode.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jarcode.auth.entity.Conversation;
import com.jarcode.auth.entity.Message;

public class ConversatioDAO implements IConversationDAO {

	private Connection con;

	public ConversatioDAO(Connection con) {
		super();
		this.con = con;
	}

	public Conversation getConvById(int id){
		String sql = "select * from conversations where id = ?";
		Conversation conv = null;
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			conv = new Conversation(rs.getInt(1),
					rs.getString(2),
					rs.getInt(3),
					rs.getInt(4),
					rs.getInt(5));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return conv;
	}
	
	public List<Conversation> getUserConverByID(int uid){
		String sql = "Select * from conversations where owner_id = ? or friend_id = ?";
		List<Conversation> cList = new ArrayList<>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, uid);
			stmt.setInt(2, uid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				cList.add(new Conversation(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cList;
	}
	
	@Override
	public void createConversation(String name, int owner, int friend) {
		String sql = "INSERT INTO conversations(name, owner, friend) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, owner);
			ps.setInt(3, friend);
			// Default value for isActive state
			ps.setInt(4, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Conversation> getAllConv(){
		String sql = "select * from conversations";
		List<Conversation> cList = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				cList.add(new Conversation(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cList;
	}

	@Override
	public void deleteConversation(int id) {
		throw new UnsupportedOperationException();
	}
}
