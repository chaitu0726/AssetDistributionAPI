package com.profile.Springbootbackend.model;

public class AssetsKeys {
	
	private int assetKeyId;
	private String assetType;
	private String assetKey;
	
	public AssetsKeys(int assetKeyId, String assetType, String assetKey) {
		super();
		this.assetKeyId = assetKeyId;
		this.assetType = assetType;
		this.assetKey = assetKey;
	}

	public AssetsKeys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAssetKeyId() {
		return assetKeyId;
	}

	public void setAssetKeyId(int assetKeyId) {
		this.assetKeyId = assetKeyId;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetKey() {
		return assetKey;
	}

	public void setAssetKey(String assetKey) {
		this.assetKey = assetKey;
	}
	
}
	
