package com.jarcode.auth.entity;

public class Message {
	
	private int id;
	private int userId;
	private String text;
	
	public Message(int id, int uId, String text) {
		super();
		this.id = id;
		this.userId = uId;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + userId + ", text=" + text + "]";
	}
	
	
}
