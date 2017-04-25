package com.jarcode.auth.dto;

import java.util.List;

import com.jarcode.auth.entity.Message;
import com.jarcode.auth.entity.User;

public class ConversationDTO {
	private int id;
	private String name;
	private User owner;
	private User friend;
	private int state;
	private List<MessageDTO> msgs;
	
	public ConversationDTO(){}
	
	public ConversationDTO(int id, String name, User owner, User friend, int state, List<MessageDTO> msgs) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.friend = friend;
		this.state = state;
		this.msgs = msgs;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public User getFriend() {
		return friend;
	}
	public void setFriend(User friend) {
		this.friend = friend;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<MessageDTO> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<MessageDTO> msgs) {
		this.msgs = msgs;
	}

	@Override
	public String toString() {
		return "ConversationDTO [id=" + id + ", name=" + name + ", owner=" + owner + ", friend=" + friend + ", state="
				+ state + ", msgs=" + msgs + "]";
	}
	
	
	
}
