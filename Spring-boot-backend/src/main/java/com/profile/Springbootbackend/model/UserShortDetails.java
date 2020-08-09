package com.profile.Springbootbackend.model;

public class UserShortDetails {

	private int userId;
	private String firstName;
	private String lastName;
	
	public UserShortDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserShortDetails(int userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
