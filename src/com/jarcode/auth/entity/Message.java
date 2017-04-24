package com.jarcode.auth.entity;

public class Message {
	
	private int id;
	private int userId;
	private String text;
	private String timestamp;
	private int convId;
	private int block;
	
	public Message(int id, int userId, String text, String timestamp, int convId, int block) {
		super();
		this.id = id;
		this.userId = userId;
		this.text = text;
		this.timestamp = timestamp;
		this.block = block;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}
	

	public int getConvId() {
		return convId;
	}

	public void setConvId(int convId) {
		this.convId = convId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", userId=" + userId + ", text=" + text + ", timestamp=" + timestamp + ", block="
				+ block + "]";
	}

	
	
}
