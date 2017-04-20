package com.jarcode.auth.dto;

public class MessageDTO {
	private int id;
	private String fromName;
	private String color;
	private String text;
	private String time;
	private int block;

	public MessageDTO() {
	}

	public MessageDTO(int id, String fromName, String color, String text, String time, int block) {
		super();
		this.id = id;
		this.fromName = fromName;
		this.color = color;
		this.text = text;
		this.time = time;
		this.block = block;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", fromName=" + fromName + ", color=" + color + ", text=" + text + ", time="
				+ time + ", block=" + block + "]";
	};

}
