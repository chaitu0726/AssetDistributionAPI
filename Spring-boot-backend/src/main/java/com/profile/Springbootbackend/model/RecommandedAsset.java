package com.profile.Springbootbackend.model;

public class RecommandedAsset {

	private String assetInfo;
	private int count;
	
	public RecommandedAsset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecommandedAsset(String assetInfo, int count) {
		super();
		this.assetInfo = assetInfo;
		this.count = count;
	}

	public String getAssetInfo() {
		return assetInfo;
	}

	public void setAssetInfo(String assetInfo) {
		this.assetInfo = assetInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
