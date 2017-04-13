package com.jarcode.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jarcode.auth.entity.Message;

public class MessageDAO implements IMessageDAO {

	private Connection con;

	public MessageDAO(Connection c) {
		this.con = c;
	}

	@Override
	public Message getMessage(int id) {
		PreparedStatement ps;
		ResultSet rs;
		Message msg = null;
		try {
			ps = con.prepareStatement("SELECT * from message WHERE id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			msg = new Message(rs.getInt(1), rs.getInt(2), rs.getString(3));
		} catch (SQLException e) {
			// TODO: Close connection and ps
			e.printStackTrace();
		}

		return msg;

	}

	@Override
	public List<Message> getAllMessages() {
		List<Message> mList = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from messages");

			while(rs.next()){
				mList.add(new Message(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Close all
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public void insertMessage(int uId, String text) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into messages(from, message) values (?, ?)");
			ps.setInt(1, uId);
			ps.setString(2, text);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
