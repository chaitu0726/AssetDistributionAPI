package com.profile.Springbootbackend.model;

public class AssetsDistribute {
	
	private String assetkey;
	private int count;
	
	public AssetsDistribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetsDistribute(String assetkey, int count) {
		super();
		this.assetkey = assetkey;
		this.count = count;
	}

	public String getAssetkey() {
		return assetkey;
	}

	public void setAssetkey(String assetkey) {
		this.assetkey = assetkey;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AssetsDistribute [assetkey=" + assetkey + ", count=" + count + "]";
	}
	
}
