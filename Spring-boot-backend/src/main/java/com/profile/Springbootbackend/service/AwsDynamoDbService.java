package com.profile.Springbootbackend.service;

import java.util.List;


import com.profile.Springbootbackend.model.RecommendedAssets;
import com.profile.Springbootbackend.model.UserAssignAssets;

public interface AwsDynamoDbService {

	public boolean addInDynamo(List<UserAssignAssets> assignAssets,int userId);
	public List<UserAssignAssets> getFromDynamo();
	public List<UserAssignAssets> getRecommandedAssets(String department);
	public int deleteFromDynamo();
	public int editRecommendedAssets(RecommendedAssets recommendedAssets);
}
