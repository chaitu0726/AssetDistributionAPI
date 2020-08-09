package com.profile.Springbootbackend.model;

import java.util.List;

public class AssetsAssign {

	private List<UserAssignAssets> assetList;
	private int userId;
	
	public AssetsAssign(List<UserAssignAssets> assetList, int userId) {
		super();
		this.assetList = assetList;
		this.userId = userId;
	}

	public AssetsAssign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<UserAssignAssets> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<UserAssignAssets> assetList) {
		this.assetList = assetList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
