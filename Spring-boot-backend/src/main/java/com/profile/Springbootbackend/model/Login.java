package com.profile.Springbootbackend.model;

public class Login {

	private int loginId;
	private String username;
	private String password;
	private String role;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int loginId, String username, String password, String role) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
