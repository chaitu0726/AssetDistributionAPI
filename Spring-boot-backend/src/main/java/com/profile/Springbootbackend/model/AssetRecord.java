package com.profile.Springbootbackend.model;

public class AssetRecord {

	private String assetKey;
	private String assetType;
	private String assetInfo;
	
	public AssetRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetRecord(String assetKey, String assetType, String assetInfo) {
		super();
		this.assetKey = assetKey;
		this.assetType = assetType;
		this.assetInfo = assetInfo;
	}

	public String getAssetKey() {
		return assetKey;
	}

	public void setAssetKey(String assetKey) {
		this.assetKey = assetKey;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetInfo() {
		return assetInfo;
	}

	public void setAssetInfo(String assetInfo) {
		this.assetInfo = assetInfo;
	}
	
}
