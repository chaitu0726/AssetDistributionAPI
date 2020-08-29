package com.profile.Springbootbackend.model;

public class UserDetail {

	private int userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo; 
	private String dateOfJoining;
	private String userRole;
	private String isAssetsAssign;
	private String isDelete;
	private String department;
	private String service;
	
	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	 public UserDetail(int userId, String firstName, String lastName, String emailId, String mobileNo,
			String dateOfJoining, String userRole, String isAssetsAssign, String isDelete, String department,
			String service) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.dateOfJoining = dateOfJoining;
		this.userRole = userRole;
		this.isAssetsAssign = isAssetsAssign;
		this.isDelete = isDelete;
		this.department = department;
		this.service = service;
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



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	public String getService() {
		return service;
	}



	public void setService(String service) {
		this.service = service;
	}

	

}
