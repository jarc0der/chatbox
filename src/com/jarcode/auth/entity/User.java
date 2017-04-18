package com.jarcode.auth.entity;

public class User {
	
	private int id;
	private String login;
	private String pass;
	private String email;
	private String color;
	private int roleId;
	private int ban;
	
	public User() {}
	
	public User(int id, String login, String pass, String email, String color, int roleId, int ban) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.email = email;
		this.color = color;
		this.roleId = roleId;
		this.ban = ban;
	}
	
	public User(int id, String login, String pass, String email){
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.email = email;
		this.color = "#ffffff";
		this.roleId = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	
	public boolean isBanned(){
		return this.ban > 0;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", pass=" + pass + ", email=" + email + ", color=" + color
				+ ", roleId=" + roleId + ", ban=" + ban + "]";
	}


	
	
}
