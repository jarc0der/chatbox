package com.jarcode.auth.entity;

public class Conversation {
	private int id;
	private String name;
	private int owner;
	private int friend;
	private int isActive;

	public Conversation(){}
	
	public Conversation(int id, String name, int owner, int friend, int isActive) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.friend = friend;
		this.isActive = isActive;
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

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getFriend() {
		return friend;
	}

	public void setFriend(int friend) {
		this.friend = friend;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Conversation [id=" + id + ", name=" + name + ", owner=" + owner + ", friend=" + friend + ", isActive="
				+ isActive + "]";
	}

}
