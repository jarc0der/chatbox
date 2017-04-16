package com.jarcode.auth.dto;

public class MessageDTO {
	private int id;
	private String fromName;
	private String text;

	public MessageDTO(){};
	
	public MessageDTO(int id, String fromName, String text) {
		super();
		this.id = id;
		this.fromName = fromName;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", fromName=" + fromName + ", text=" + text + "]";
	}
	
	

}
