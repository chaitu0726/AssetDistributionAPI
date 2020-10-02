package com.profile.Springbootbackend.repository;

import java.util.List;



import com.profile.Springbootbackend.model.Assets;
import com.profile.Springbootbackend.model.AssetsKeys;
import com.profile.Springbootbackend.model.Login;
import com.profile.Springbootbackend.model.UserDetail;
import com.profile.Springbootbackend.model.UserShortDetails;

public interface TaskRepository {

	
	public int updateUser(int userId);
	public int deleteUser();
	public UserDetail selectUser(int userId);
	public List<UserDetail> selectAllUsers();
	
	public String login(Login login);
	public List<UserShortDetails> getUserShortDetails(String role);
	
	//assets tables
	public List<Assets> getAssetsDetails();
	public int updateAssetsDetails(List<Assets> assetsList);
	
	public int leaveAssets();
	public List<AssetsKeys> getAssetTypesDropDown();
	public int addNewAsset(Assets asset);
	public int addAssetKey(AssetsKeys assetKey);
	public int getAssetCountForType(String type);
	public List<String> getUserRoleDropDown();
	public List<Integer> getAvailableAsset(String key);
	public int updateAvailableAsset(String key,Integer available,Integer total);
}
