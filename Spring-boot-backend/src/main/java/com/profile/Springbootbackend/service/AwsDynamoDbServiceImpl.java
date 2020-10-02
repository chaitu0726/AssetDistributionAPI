package com.profile.Springbootbackend.service;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.document.Item;

import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profile.Springbootbackend.model.AssetRecord;
import com.profile.Springbootbackend.model.RecommendedAssets;
import com.profile.Springbootbackend.model.UserAssignAssets;

import com.profile.Springbootbackend.util.SessionHandling;

import static com.profile.Springbootbackend.util.ProfileConstants.DEPARTMENT;
import static com.profile.Springbootbackend.util.ProfileConstants.ASSETS;
import static com.profile.Springbootbackend.util.ProfileConstants.ID;
import static com.profile.Springbootbackend.util.ProfileConstants.OK;
import static com.profile.Springbootbackend.util.ProfileConstants.NEGATIVE;

@Component
public class AwsDynamoDbServiceImpl implements AwsDynamoDbService{
	
	private Table table;
	private Table table2;
	
	@Autowired
	SessionHandling sessionHandling;
	
	@Autowired
	public AwsDynamoDbServiceImpl(Table dynamoTable,Table  dynamoTable2) {
					this.table = dynamoTable;
					this.table2 = dynamoTable2;
	}
	
	@Override
	public boolean addInDynamo(List<UserAssignAssets> assignAssets,int userId) {
		//int userId = this.sessionHandling.getSessionUsername();
	try {
			
		if(null !=assignAssets)
		{
			Map<String,Integer> assetsToUser = new HashMap<String, Integer>();
			for(UserAssignAssets tempAsset : assignAssets)
				assetsToUser.put(tempAsset.getAssetKey(), tempAsset.getAssetCount());
			table.putItem(new Item().withPrimaryKey(ID,userId).withMap(ASSETS, assetsToUser));
			return true;
		}
		else
		 return false;
	}
	catch(AmazonDynamoDBException e)
	{	
		e.printStackTrace();
		return false;
	}
  }

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAssignAssets> getFromDynamo() {
		
	try
	{
		int userId = this.sessionHandling.getSessionUsername();
		Map<String,HashMap<String,Integer>> dhm = new HashMap<String, HashMap<String,Integer>>();
		GetItemSpec spec = new GetItemSpec().withPrimaryKey(ID,userId);
		Item outcome = this.table.getItem(spec);
		String assetInfo = outcome.toJSON().toString();
		//working on business logic
		Map<String,Integer> getAssetMap = new HashMap<String,Integer>();
		try {
				dhm  =  new ObjectMapper().readValue(assetInfo, Map.class);
				getAssetMap= dhm.get(ASSETS);
		} catch (JsonProcessingException e) {
				return null;
		}
		
		List<UserAssignAssets> userAssets = new ArrayList<UserAssignAssets>();
		Map<String,AssetRecord> assetRecord = sessionHandling.getAssetRecordsMap();
		
		for (Map.Entry<String,Integer> entry : getAssetMap.entrySet()) 
		{
			UserAssignAssets userAssetstemp = new UserAssignAssets();
			AssetRecord tempRecord = assetRecord.get(entry.getKey());
			userAssetstemp.setAssetName(tempRecord.getAssetInfo());
			userAssetstemp.setAssetCount(entry.getValue());
			userAssetstemp.setAssetKey(tempRecord.getAssetKey());
			userAssets.add(userAssetstemp);	
		}
		 
		return userAssets;
	}
	catch(AmazonDynamoDBException e)
	{	
		e.printStackTrace();
		return null;
	}
  }

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAssignAssets> getRecommandedAssets(String department) {
	try
	{
		Map<String,Integer> assetsDistribution = new HashMap<String, Integer>();
		Map<String,HashMap<String,Integer>> dhm = new HashMap<String, HashMap<String,Integer>>();
		GetItemSpec spec = new GetItemSpec().withPrimaryKey(DEPARTMENT,department);
		Item outcome = this.table2.getItem(spec);
		String assetsD = outcome.toJSON().toString();
		try {
			dhm = new ObjectMapper().readValue(assetsD,Map.class);
			assetsDistribution = dhm.get(ASSETS);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,AssetRecord> assetsRecords = this.sessionHandling.getAssetRecordsMap();
		List<UserAssignAssets> recommandedAssetList = new ArrayList<UserAssignAssets>();
		
		for (Map.Entry<String,Integer> entry : assetsDistribution.entrySet())
		{
			UserAssignAssets tempRec = new UserAssignAssets();
			AssetRecord tempAssetRecord = assetsRecords.get(entry.getKey());
			
			tempRec.setAssetName(tempAssetRecord.getAssetInfo());
			tempRec.setAssetCount(entry.getValue());
			tempRec.setAssetKey(entry.getKey());
			tempRec.setAssetType(tempAssetRecord.getAssetType());
			recommandedAssetList.add(tempRec);
		}
			
		return recommandedAssetList;
	}
	catch(AmazonDynamoDBException e)
	{	
		e.printStackTrace();
		return null;
	}
}

	@Override
	public int deleteFromDynamo() {
	try
	{
		int userId = this.sessionHandling.getSessionUsername();
		DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey(ID,userId);
		 table.deleteItem(deleteItemSpec);
		return OK;
	}
	catch(AmazonDynamoDBException e)
	{	
		e.printStackTrace();
		return NEGATIVE;
	}
   }

	@Override
	public int editRecommendedAssets(RecommendedAssets recommendedAssets) {
		try {
			if(null !=recommendedAssets.getUserAssignAssets())
			{
				Map<String,Integer> recommendedToRole = new HashMap<String, Integer>();
				for(UserAssignAssets tempAsset : recommendedAssets.getUserAssignAssets())
					recommendedToRole.put(tempAsset.getAssetKey(), tempAsset.getAssetCount());
				table2.putItem(new Item().withPrimaryKey(DEPARTMENT,recommendedAssets.getUserRole()).withMap(ASSETS, recommendedToRole));
				return OK;
			}
			else
			 return NEGATIVE;
			
		}catch(AmazonDynamoDBException e) {
			e.printStackTrace();
		return NEGATIVE;
		}
	}
}
