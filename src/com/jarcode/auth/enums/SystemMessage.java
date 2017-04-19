package com.jarcode.auth.enums;

public class SystemMessage {
	// Add MsgType ENUM
	private String type;
	private String msg;
	
	public SystemMessage(String type, String msg) {
		super();
		this.type = type;
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "SystemMessage [type=" + type + ", msg=" + msg + "]";
	}
	
	
	
}
