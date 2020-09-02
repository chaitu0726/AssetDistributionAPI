package com.profile.Springbootbackend.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.profile.Springbootbackend.model.Assets;
import com.profile.Springbootbackend.model.AssetsAssign;
import com.profile.Springbootbackend.model.AssetsDropDown;
import com.profile.Springbootbackend.model.AssetsKeys;
import com.profile.Springbootbackend.model.Login;
import com.profile.Springbootbackend.model.RecommendedAssets;
import com.profile.Springbootbackend.model.UserAssignAssets;
import com.profile.Springbootbackend.model.UserDetail;
import com.profile.Springbootbackend.model.UserShortDetails;
import com.profile.Springbootbackend.repository.TaskRepository;
import com.profile.Springbootbackend.service.AmazonS3Service;
import com.profile.Springbootbackend.service.AwsDynamoDbService;
import com.profile.Springbootbackend.service.TaskService;
import com.profile.Springbootbackend.util.SessionHandling;
import static com.profile.Springbootbackend.util.ProfileConstants.SESSION_TIMEOUT;


@RestController
@CrossOrigin(origins = {"*"})
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private AwsDynamoDbService awsDynamoService;
	
	@Autowired
	private SessionHandling sessionHandling;
	
	@Autowired
	private AmazonS3Service amazonS3Service;
    //login
    @PostMapping(value="/api/login")
    public Login login(@RequestBody Login login, HttpSession session)
    {
    	String role= this.taskService.login(login,session);
    	Login temp = new Login();
    	temp.setRole(role);
    	return temp;
    }
    
    //get names,ids
    @GetMapping(value="/api/getnames")
    public List<UserShortDetails> getUserShortDetails(@RequestParam String role)
    {
    	if(!this.sessionHandling.getSession().equalsIgnoreCase(SESSION_TIMEOUT))
    		return this.taskService.getUserShortDetails(role);
    	 return null;
    }
    
    //get userdetail by id
    @GetMapping(value="/api/getuserbyid")
    public UserDetail getUserById(@RequestParam String userId)
    {
    	int tempId= Integer.parseInt(userId);
    	return this.taskService.selectUser(tempId);
    }
    
    @GetMapping(value="/api/getuser")
    public UserDetail getUser()
    {
    	int userId = this.sessionHandling.getSessionUsername();
    	return this.taskService.selectUser(userId);
    }
    
    //getAssetsDetailsForUser
    @GetMapping("/api/getAssignAssets")
    public List<UserAssignAssets>getUserAssetsDynamo()
    {
    	return this.awsDynamoService.getFromDynamo();
    }
    
    //getAssetDetailsStatitics
    @GetMapping(value="/api/getAssetsDetails")
    public List<Assets> getAssetsDetails()
    {
    	return this.taskService.getAssetsDetails();
    }
    //asignAssetToUSer
    @PostMapping("/api/assetsAssign")
	public int updateUser(@RequestBody AssetsAssign assetsAssign)
	{
		return this.taskService.updateUser(assetsAssign);
	}
    
    @PostMapping("/api/leaveAssets")
    public int leaveAssets(@RequestBody List<UserAssignAssets> userAssignAsset)
    {
    	return this.taskService.leaveAssets(userAssignAsset);
    }

    
    @GetMapping(value="/api/getassets")
    public List<UserAssignAssets> getRecommandedAssets(@RequestParam String department)
    {
   
    	return this.awsDynamoService.getRecommandedAssets(department);
    }
    
    @GetMapping("/api/getAssetsDropDown")
    public List<AssetsDropDown> getAssetsDropDown()
    {
    	return this.taskService.getAssetsDropDown();
    }
    //logout
    @GetMapping(value="/api/logout")
    public boolean logout()
    {
    	this.sessionHandling.logout();
    	return true;
    }
 
    @GetMapping(value="/api/getAssetTypesDropDown")
    public List<AssetsKeys> getAssetTypesDropDown()
    {
    	return this.taskService.getAssetTypesDropDown();
    }
    
    @PostMapping("/api/addNewAsset")
    public boolean addNewAsset(@RequestBody Assets asset)
    {
    	this.taskService.addNewAsset(asset);
    	return false;
    }
    /*
    @PostMapping("/api/testFile")
    public int addNewAssetTest(@RequestBody Assets asset)
    {
    	this.amazonS3Service.updateCSVFile(asset);
    	return 0;
    }
    */
    
    @PostMapping("/api/setRecommendedAssets")
    public int editRecommendedAssets(@RequestBody RecommendedAssets recommendedAssets)
    {
    	this.awsDynamoService.editRecommendedAssets(recommendedAssets);
    	return 200;
    }
    
    @GetMapping("api/getRoleDropdown")
    public List<String> getUserRoleDropDown()
    {
    	return this.taskService.getUserRoleDropDown();
    }
}
