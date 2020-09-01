package com.profile.Springbootbackend.model;

import java.util.List;

public class RecommendedAssets {

	private String userRole;
	private List<UserAssignAssets> userAssignAssets;
	
	public RecommendedAssets() {
		// TODO Auto-generated constructor stub
	}

	public RecommendedAssets(String userRole, List<UserAssignAssets> userAssignAssets) {
		super();
		this.userRole = userRole;
		this.userAssignAssets = userAssignAssets;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<UserAssignAssets> getUserAssignAssets() {
		return userAssignAssets;
	}

	public void setUserAssignAssets(List<UserAssignAssets> userAssignAssets) {
		this.userAssignAssets = userAssignAssets;
	}

	
}
