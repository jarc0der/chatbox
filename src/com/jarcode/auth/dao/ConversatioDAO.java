package com.jarcode.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jarcode.auth.entity.Message;

public class ConversatioDAO implements IConversationDAO {

	private Connection con;

	public ConversatioDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public void createConversation(String name, int owner, int friend) {
		String sql = "INSERT INTO conversation(name, owner, friend) VALUES (?, ?, ?, ?)";
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

	@Override
	public void deleteConversation(int id) {
		throw new UnsupportedOperationException();
	}
}
