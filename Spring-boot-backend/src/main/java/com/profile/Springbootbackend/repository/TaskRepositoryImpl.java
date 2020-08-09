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
				userDetail.setDepartment(rs.getString(7));
				userDetail.setIsAssetsAssign(rs.getString(8));
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
	public List<UserShortDetails> getUserShortDetails() {
		return this.jdbcTemlate.query(SHORT_USER_DETAILS_QUERY, new Object[] {NO,YES}, new ResultSetExtractor<List<UserShortDetails>>(){

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

	
}
