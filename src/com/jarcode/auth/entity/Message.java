package com.jarcode.auth.entity;

public class Message {
	
	private int id;
	private User user;
	private String text;
	
	public Message(int id, User user, String text) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", text=" + text + "]";
	}
	
	
}
