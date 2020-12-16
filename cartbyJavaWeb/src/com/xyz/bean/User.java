package com.xyz.bean;

public class User {
	private String username;
	private String password;
	private String sex;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User(String username, String password, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
	}
	public User() {
		super();
	}
	
	
}
