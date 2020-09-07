package com.profile.Springbootbackend.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import static com.profile.Springbootbackend.util.ProfileConstants.*;

import com.profile.Springbootbackend.model.Assets;
import com.profile.Springbootbackend.model.AssetsKeys;
import com.profile.Springbootbackend.model.Login;
import com.profile.Springbootbackend.model.UserDetail;
import com.profile.Springbootbackend.model.UserShortDetails;
import com.profile.Springbootbackend.util.SessionHandling;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemlate;
	
	@Autowired
	private SessionHandling sessionHandling;

	@Override
	public int addUser(UserDetail userDetail) {
	
	try {
		return this.jdbcTemlate.update(INSERT_QUERY, new Object[]{
			 		userDetail.getFirstName(),
			 		userDetail.getLastName(),
			 		userDetail.getEmailId(),
			 		YES
					}
				);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return NEGATIVE;
	}
		
 }

	@Override
	public int updateUser(int userId) {
		try
		{
			return this.jdbcTemlate.update(UPDATE_QUERY, new Object[] {
					YES,
					userId
				});
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return NEGATIVE;
		}	
	}

	@Override
	public int deleteUser() {
	try
	{
		int userId = this.sessionHandling.getSessionUsername();
		if(userId != -1)
		return this.jdbcTemlate.update(DELETE_QUERY, new Object[] {
						NO,
						userId
					});
		return NEGATIVE;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return NEGATIVE;
	}
		
	}

	@Override
	public UserDetail selectUser(int userId) {
	try
	{
		return this.jdbcTemlate.queryForObject(SELECT_QUERY, new Object[] {userId}, new RowMapper<UserDetail>() {

			@Override
			public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDetail userDetail = new UserDetail();
				userDetail.setUserId(rs.getInt(1));
				userDetail.setFirstName(rs.getString(2));
				userDetail.setLastName(rs.getString(3));
				userDetail.setEmailId(rs.getString(4));
				userDetail.setMobileNo(rs.getString(5));
				userDetail.setDateOfJoining(rs.getString(6));
				userDetail.setUserRole(rs.getString(7));
				userDetail.setIsAssetsAssign(rs.getString(8));
				userDetail.setDepartment(rs.getString(10));
				userDetail.setService(rs.getString(11));
				return userDetail;
			}
			
		});
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return null;
	}
		
	}

	@Override
	public List<UserDetail> selectAllUsers() {
		return this.jdbcTemlate.query(SELECT_ALL_QUERY, new Object[]{YES}, new ResultSetExtractor<List<UserDetail>>() {

			@Override
			public List<UserDetail> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserDetail> userDetailList = new ArrayList<UserDetail>();
				while(rs.next())
				{
					UserDetail userDetail = new UserDetail();
					userDetail.setUserId(rs.getInt(1));
					userDetail.setFirstName(rs.getString(2));
					userDetail.setLastName(rs.getString(3));
					userDetail.setEmailId(rs.getString(4));
					userDetailList.add(userDetail);
				}
				return userDetailList;
				
			}
			
		});
	}

	@Override
	public boolean createTable() {
		
		this.jdbcTemlate.execute(CREATE_USER_TABLE);
		return true;
	}

	@Override
	public String login(Login login) {
		try {
		return this.jdbcTemlate.queryForObject(LOGIN_QUERY,new Object[] {login.getUsername(),login.getUsername()}, String.class);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}	
	}

	@Override
	public List<UserShortDetails> getUserShortDetails(String role) {
		if(role.equals("DG_CSO"))
			role = DG_CSO;
		else if(role.equals("DG_CST"))
			role = DG_CST;
		else if(role.equals("IN_CSO"))
			role = IN_CSO;
		else if(role.equals("IN_CST"))
			role = IN_CST;
		
		return this.jdbcTemlate.query(SHORT_USER_DETAILS_QUERY+role, new Object[] {NO,YES}, new ResultSetExtractor<List<UserShortDetails>>(){

			@Override
			public List<UserShortDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserShortDetails> userShortList = new ArrayList<UserShortDetails>();
				while(rs.next())
				{
					UserShortDetails userDetail = new UserShortDetails();
					userDetail.setUserId(rs.getInt(1));
					userDetail.setFirstName(rs.getString(2));
					userDetail.setLastName(rs.getString(3));
					userShortList.add(userDetail);
				}
				return userShortList;
			}
			
		});
	
	}

	@Override
	public List<Assets> getAssetsDetails() {
	
		try {
		return this.jdbcTemlate.query(SELECT_ALL_ASSETS_INFO,new ResultSetExtractor<List<Assets>>() {

			@Override
			public List<Assets> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<Assets> assetsList = new ArrayList<Assets>();
				while(rs.next())
				{
					Assets asset  = new Assets();
					asset.setAssetsid(rs.getInt(1));
					asset.setAssetkey(rs.getString(2));
					asset.setAssignedAssets(rs.getInt(3));
					asset.setAvailableAssets(rs.getInt(4));
					asset.setTotalAssets(rs.getInt(5));
					asset.setAssetType(rs.getString(6));
					assetsList.add(asset);
				}
				
				return assetsList;
			}
			
		});
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
			
	}

	@Override
	//@Transactional
	public int updateAssetsDetails(List<Assets> assetsList) {
	try
	{
		for(Assets asset :assetsList)
		{
			this.jdbcTemlate.update(UPDATE_ASSETS_TABLE, new Object[] {
					asset.getAssignedAssets(),
					asset.getAvailableAssets(),
					asset.getAssetsid()
			});
				
		}
		return OK;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return NEGATIVE;
	}
	
}

	
	@Override
	public int leaveAssets() {
		
		int userId = this.sessionHandling.getSessionUsername();
		if(userId != -1)
			return this.jdbcTemlate.update(LEAVE_ASSETS_QUERY, new Object[] {
					ASSETS_LEFT,userId
			});
		
		return NEGATIVE;
	}

	@Override
	public List<AssetsKeys> getAssetTypesDropDown() {
		
		try
		{
			return this.jdbcTemlate.query(ASSET_KEY_QUERY,new ResultSetExtractor<List<AssetsKeys>>()
					{

						@Override
						public List<AssetsKeys> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AssetsKeys> assetKeyLsit = new ArrayList<AssetsKeys>();
							
							while(rs.next())
							{
								AssetsKeys assetKey = new AssetsKeys();
								assetKey.setAssetKeyId(rs.getInt(1));
								assetKey.setAssetType(rs.getString(2));
								assetKey.setAssetKey(rs.getString(3));
								
								assetKeyLsit.add(assetKey);
							}
							
							return assetKeyLsit;
						}
				
					});
			
		}catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public int addNewAsset(Assets asset) {
		try
		{
			return this.jdbcTemlate.update(ASSETS_INSERT_QUERY,new Object[] {
					asset.getAssetkey(),
					asset.getAssignedAssets(),
					asset.getAvailableAssets(),
					asset.getTotalAssets(),
					asset.getAssetType()
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int addAssetKey(AssetsKeys assetKey) {
		try
		{
			return this.jdbcTemlate.update(ASSET_KEY_INSERT_QUERY,new Object[] {
					assetKey.getAssetType(),
					assetKey.getAssetKey()
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getAssetCountForType(String type) {
		
		try {
			return this.jdbcTemlate.queryForObject(ASSET_TYPE_COUNT_QUERY,new Object[] {type},Integer.class);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return 0;
			}	
	}

	@Override
	public List<String> getUserRoleDropDown() {
		try {
			return this.jdbcTemlate.query(USER_ROLE_DROPDOWN_QUERY, new ResultSetExtractor<List<String>>() {

				@Override
				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<String> userRoleDropdown = new ArrayList<String>();
						while(rs.next())
						{
							String role = rs.getString(1);
							userRoleDropdown.add(role);
						}
						return userRoleDropdown;
				}
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
}
