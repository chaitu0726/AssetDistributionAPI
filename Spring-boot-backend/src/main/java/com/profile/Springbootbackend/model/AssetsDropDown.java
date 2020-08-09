package com.profile.Springbootbackend.model;

import java.util.List;

public class AssetsDropDown {
	
	private String assetName;
	private List<UserAssignAssets> assetTypes;
	
	public AssetsDropDown() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public AssetsDropDown(String assetName, List<UserAssignAssets> assetTypes) {
		super();
		this.assetName = assetName;
		this.assetTypes = assetTypes;
	}


	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public List<UserAssignAssets> getAssetTypes() {
		return assetTypes;
	}

	public void setAssetTypes(List<UserAssignAssets> assetTypes) {
		this.assetTypes = assetTypes;
	}


	@Override
	public String toString() {
		return "AssetsDropDown [assetName=" + assetName + ", assetTypes=" + assetTypes + "]";
	}
	
}
