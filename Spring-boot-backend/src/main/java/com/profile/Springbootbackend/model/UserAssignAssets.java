package com.profile.Springbootbackend.model;

public class UserAssignAssets {

	private String assetKey;
	private String assetName;
	private Integer assetCount;
	
	
	public UserAssignAssets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public Integer getAssetCount() {
		return assetCount;
	}
	public void setAssetCount(Integer assetCount) {
		this.assetCount = assetCount;
	}
	public String getAssetKey() {
		return assetKey;
	}
	public void setAssetKey(String assetKey) {
		this.assetKey = assetKey;
	}
	
	
	
}
