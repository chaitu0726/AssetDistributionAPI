package com.profile.Springbootbackend.model;

public class AssetsFetch {
	
	private int id;
	private Assets assets;
	
	public AssetsFetch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetsFetch(int id, Assets assets) {
		super();
		this.id = id;
		this.assets = assets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "AssetsFetch [id=" + id + ", assets=" + assets + ", toString()=" + super.toString() + "]";
	}
	

}
