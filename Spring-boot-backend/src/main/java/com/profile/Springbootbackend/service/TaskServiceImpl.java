package com.profile.Springbootbackend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.Springbootbackend.model.AssetRecord;
import com.profile.Springbootbackend.model.Assets;
import com.profile.Springbootbackend.model.AssetsAssign;
import com.profile.Springbootbackend.model.AssetsDropDown;
import com.profile.Springbootbackend.model.AssetsKeys;
import com.profile.Springbootbackend.model.Login;
import com.profile.Springbootbackend.model.UserAssignAssets;
import com.profile.Springbootbackend.model.UserDetail;
import com.profile.Springbootbackend.model.UserShortDetails;
import com.profile.Springbootbackend.repository.TaskRepository;
import com.profile.Springbootbackend.util.SessionHandling;

import static com.profile.Springbootbackend.util.ProfileConstants.INVALID_USER;
import static com.profile.Springbootbackend.util.ProfileConstants.NEGATIVE;
import static com.profile.Springbootbackend.util.ProfileConstants.OK;


@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskrepository;
	
	@Autowired 
	private SessionHandling sessionHandling;
	
	@Autowired
	AwsDynamoDbService awsDynamodbService;
	
	@Autowired
	AmazonS3Service amazonS3Service;
	
	@Autowired
	AwsSesService awsSesService;
	


	@Override //checks are remaining
	public int updateUser(AssetsAssign assetsAssign) {
		List<Assets> newAssetsList = this.updateAssetsDetails(assetsAssign.getAssetList());
		try {
				this.taskrepository.updateUser(assetsAssign.getUserId());
				this.awsDynamodbService.addInDynamo(assetsAssign.getAssetList(),assetsAssign.getUserId());
				this.taskrepository.updateAssetsDetails(newAssetsList);
				this.awsSesService.sendEmail(assetsAssign.getUserId());
			}
		catch(Exception e)
		{
			return NEGATIVE;
		}
		
		return OK;
	}

	@Override
	public int deleteUser() {
		if(this.taskrepository.deleteUser() == NEGATIVE)
			return NEGATIVE;
		return OK;
	}

	@Override
	public UserDetail selectUser(int userId) {
		
		return this.taskrepository.selectUser(userId);
	}

	@Override
	public List<UserDetail> selectAllUsers() {
		return this.taskrepository.selectAllUsers();
	}

	@Override
	public String login(Login login,HttpSession session) {
		
		String role = this.taskrepository.login(login);
		if(null != role)
		{
			this.sessionHandling.setSession(login.getUsername(), session);
			this.amazonS3Service.readFile();
			this.getAssetsDetails();
			return role;
		}
	
		return INVALID_USER;
	}

	@Override
	public List<UserShortDetails> getUserShortDetails(String role) {
		
		return this.taskrepository.getUserShortDetails(role);
	}

	@Override
	public List<Assets> getAssetsDetails() {
		List<Assets> assetList= this.taskrepository.getAssetsDetails();
		if(null != assetList)
		{
			Map<String,AssetRecord> assetRecord = this.sessionHandling.getAssetRecordsMap();
			for(Assets asset : assetList)
			{
				asset.setAssetName((assetRecord.get(asset.getAssetkey())).getAssetInfo());
			}
			Map<String,Assets> assetDetails = new HashMap<String, Assets>();
			for(Assets asset : assetList)
				assetDetails.put(asset.getAssetkey(), asset);
			this.sessionHandling.setAssetMap(assetDetails);
		//	this.sessionHandling.setAssetsList(assetList);
		}
		return assetList;
	}

	
	private List<Assets> updateAssetsDetails(List<UserAssignAssets> assetsList) {
		
		Map<String,Assets> assetDetails = this.sessionHandling.getAssetMap();
		List<Assets> modifiedList = new ArrayList<Assets>();
		for(UserAssignAssets asset : assetsList)
		{
			Assets assetNew  = new Assets();
			Assets assetOld = assetDetails.get(asset.getAssetKey());
			assetNew.setAssetkey(asset.getAssetKey());
			assetNew.setAssignedAssets(assetOld.getAssignedAssets() + asset.getAssetCount());
			assetNew.setAvailableAssets(assetOld.getAvailableAssets() - asset.getAssetCount());
			assetNew.setAssetsid(assetOld.getAssetsid());
			
			assetOld.setAssignedAssets(assetNew.getAssignedAssets());
			assetOld.setAvailableAssets(assetNew.getAvailableAssets());
			assetDetails.put(asset.getAssetKey(), assetOld);
			modifiedList.add(assetNew);
		}
		this.sessionHandling.setAssetMap(assetDetails);
		return modifiedList;
	}

	@Override
	public int leaveAssets(List<UserAssignAssets> userAssignAsset) {
		
		List<Assets> assetDetails = this.taskrepository.getAssetsDetails();
		List<Assets> modifiedList = new ArrayList<Assets>();
		
		for(Assets userAsset : assetDetails)
		{
			Assets assetTemp =  userAsset;
			for(UserAssignAssets asset : userAssignAsset)
			{
				if(userAsset.getAssetkey().equalsIgnoreCase(asset.getAssetKey()))
				{
					assetTemp.setAssignedAssets(userAsset.getAssignedAssets() - asset.getAssetCount());
					assetTemp.setAvailableAssets(userAsset.getAvailableAssets() + asset.getAssetCount());
					assetTemp.setAssetsid(userAsset.getAssetsid());
				}
			}
			modifiedList.add(assetTemp);
		}
		
		this.taskrepository.leaveAssets();
		this.awsDynamodbService.deleteFromDynamo();
		this.taskrepository.updateAssetsDetails(modifiedList);
		return 0;
	}

	@Override
	public List<AssetsDropDown> getAssetsDropDown() {
		List<AssetsDropDown> assetsDropDownList = new ArrayList<AssetsDropDown>();
		Map<String,AssetRecord> recordMap = this.sessionHandling.getAssetRecordsMap();
		 HashSet<String> tempSet=new HashSet<String>();  
		for (Entry<String, AssetRecord> entry : recordMap.entrySet()) 
		{
			tempSet.add(entry.getValue().getAssetType());
		}
		
		Iterator<String> i=tempSet.iterator();  
		 while(i.hasNext())  
		 {
			 List<UserAssignAssets> tempAssetInfo = new ArrayList<UserAssignAssets>();
			 String type = i.next();
			 	for (Entry<String, AssetRecord> entry : recordMap.entrySet()) 
				{
			 			if(entry.getValue().getAssetType().equalsIgnoreCase(type))
						{
								UserAssignAssets temp = new UserAssignAssets();
								temp.setAssetName(entry.getValue().getAssetInfo());
								temp.setAssetKey(entry.getValue().getAssetKey());
			 					tempAssetInfo.add(temp);	
						}
			 	}			
			 	AssetsDropDown tempDD = new AssetsDropDown(type,tempAssetInfo);
			 	assetsDropDownList.add(tempDD);
			 	
		 }
		return assetsDropDownList;
	}

	@Override
	public List<AssetsKeys> getAssetTypesDropDown() {

		return this.taskrepository.getAssetTypesDropDown();
	}

	@Override
	public boolean addNewAsset(Assets asset) {
		String key;
		if(asset.isNewType())
		{
			AssetsKeys assetKey = new AssetsKeys();
			assetKey.setAssetKey(asset.getAssetkey());
			assetKey.setAssetType(asset.getAssetType());
			key = asset.getAssetkey()+1;
			this.taskrepository.addAssetKey(assetKey);
		}
		else
		{
			int number = this.taskrepository.getAssetCountForType(asset.getAssetType()) + 1;
			key = asset.getAssetkey() + number;
		}
		asset.setAssetkey(key);
		asset.setAssignedAssets(0);
		asset.setTotalAssets(asset.getAvailableAssets());
		this.taskrepository.addNewAsset(asset);
		this.amazonS3Service.updateCSVFile(asset);
		return true;
	}

	@Override
	public List<String> getUserRoleDropDown() {
		
		return this.taskrepository.getUserRoleDropDown();
	}

	@Override
	public boolean updateAssetCount(String key, Integer count) {
		
		List<Integer> countDetails = this.taskrepository.getAvailableAsset(key);
		if(null != countDetails) {
			int num = this.taskrepository.updateAvailableAsset(key,countDetails.get(0)+count,countDetails.get(1)+count);
			if(num != NEGATIVE) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
