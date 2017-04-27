package com.jarcode.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jarcode.auth.entity.Message;
import com.jarcode.auth.utils.DateTimeUtils;

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
			msg = new Message(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
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

			while (rs.next()) {
				mList.add(new Message(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO Close all
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public void insertMessage(int uId, String text, String timestamp, int convId, int block) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `chatbox`.`messages` (`from`, `text`, `time`, `conv_id`, `block`) VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, uId);
			ps.setString(2, text);
			ps.setString(3, timestamp);
			ps.setInt(4, convId);
			ps.setInt(5, block);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void blockMessage(int id) {
		String sql = "UPDATE messages SET block = 1 WHERE id = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Exception message
			e.printStackTrace();
		}
	}

	@Override
	public List<Message> getMessagesByConvId(int id) {
		List<Message> msgList = new ArrayList<>();
		String sql = "Select * from messages where conv_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				msgList.add(new Message(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5),
						rs.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO Exception
			e.printStackTrace();
		}
		
		return msgList;

	}

}
