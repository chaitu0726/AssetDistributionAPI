package com.profile.Springbootbackend.repository;

import java.util.List;

import com.profile.Springbootbackend.model.Assets;
import com.profile.Springbootbackend.model.Login;
import com.profile.Springbootbackend.model.UserDetail;
import com.profile.Springbootbackend.model.UserShortDetails;

public interface TaskRepository {

	public int addUser(UserDetail userDetail);
	public int updateUser(int userId);
	public int deleteUser();
	public UserDetail selectUser(int userId);
	public List<UserDetail> selectAllUsers();
	public boolean createTable();
	public String login(Login login);
	public List<UserShortDetails> getUserShortDetails();
	
	//assets tables
	public List<Assets> getAssetsDetails();
	public int updateAssetsDetails(List<Assets> assetsList);
	
	public int leaveAssets();
}
