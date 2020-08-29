package com.profile.Springbootbackend.model;

public class Assets {
	
	private int assetsid;
	private String assetkey;
	private String assetName;
	private int assignedAssets;
	private int availableAssets;
	private int totalAssets;
	private String assetType;
	
	public Assets() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Assets(int assetsid, String assetkey, String assetName, int assignedAssets, int availableAssets,
			int totalAssets, String assetType) {
		super();
		this.assetsid = assetsid;
		this.assetkey = assetkey;
		this.assetName = assetName;
		this.assignedAssets = assignedAssets;
		this.availableAssets = availableAssets;
		this.totalAssets = totalAssets;
		this.assetType = assetType;
	}





	public int getAssetsid() {
		return assetsid;
	}


	public void setAssetsid(int assetsid) {
		this.assetsid = assetsid;
	}


	public String getAssetkey() {
		return assetkey;
	}


	public void setAssetkey(String assetkey) {
		this.assetkey = assetkey;
	}


	public int getAssignedAssets() {
		return assignedAssets;
	}


	public void setAssignedAssets(int assignedAssets) {
		this.assignedAssets = assignedAssets;
	}


	public int getAvailableAssets() {
		return availableAssets;
	}


	public void setAvailableAssets(int availableAssets) {
		this.availableAssets = availableAssets;
	}


	public int getTotalAssets() {
		return totalAssets;
	}


	public void setTotalAssets(int totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getAssetName() {
		return assetName;
	}


	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

}
