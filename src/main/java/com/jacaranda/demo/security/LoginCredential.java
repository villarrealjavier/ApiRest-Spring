package com.jacaranda.demo.security;

public class LoginCredential {
	private String username;
	private String password;
	
	public LoginCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	//GETTERS AND SETTERS
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
	
	
}
