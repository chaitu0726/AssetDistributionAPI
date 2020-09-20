package com.profile.Springbootbackend.service;

import java.util.List;

import javax.servlet.http.HttpSession;


import com.profile.Springbootbackend.model.Assets;
import com.profile.Springbootbackend.model.AssetsAssign;
import com.profile.Springbootbackend.model.AssetsDropDown;
import com.profile.Springbootbackend.model.AssetsKeys;
import com.profile.Springbootbackend.model.Login;
import com.profile.Springbootbackend.model.MailSend;
import com.profile.Springbootbackend.model.UserAssignAssets;
import com.profile.Springbootbackend.model.UserDetail;
import com.profile.Springbootbackend.model.UserShortDetails;

public interface TaskService {

	public int addUser(UserDetail userDetail);
	public int updateUser(AssetsAssign assetsAssign);
	public int deleteUser();
	public UserDetail selectUser(int userId);
	public List<UserDetail> selectAllUsers();
	public String login(Login login,HttpSession session);
	public List<UserShortDetails> getUserShortDetails(String role);
	
	//Assets Table
	public List<Assets> getAssetsDetails();
	//public int updateAssetsDetails(List<Assets> assetsList);
	public int leaveAssets(List<UserAssignAssets> userAssignAsset);
	
	public List<AssetsDropDown> getAssetsDropDown();
	
	 public List<AssetsKeys> getAssetTypesDropDown();
	 public boolean addNewAsset(Assets asset);
	 public List<String> getUserRoleDropDown();
	 public boolean updateAssetCount(String key,Integer count);
	 
}
