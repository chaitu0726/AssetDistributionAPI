package com.profile.Springbootbackend.model;

public class UserDetail {

	private int userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo; 
	private String dateOfJoining;
	private String department;
	private String role;
	private String isAssetsAssign;
	private String isDelete;
	
	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetail(int userId, String firstName, String lastName, String emailId, String mobileNo,
			String dateOfJoining, String department, String role, String isAssetsAssign, String isDelete) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.dateOfJoining = dateOfJoining;
		this.department = department;
		this.role = role;
		this.isAssetsAssign = isAssetsAssign;
		this.isDelete = isDelete;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIsAssetsAssign() {
		return isAssetsAssign;
	}

	public void setIsAssetsAssign(String isAssetsAssign) {
		this.isAssetsAssign = isAssetsAssign;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", dateOfJoining=" + dateOfJoining + ", department=" + department
				+ ", role=" + role + ", isAssetsAssign=" + isAssetsAssign + ", isDelete=" + isDelete + "]";
	}

}
