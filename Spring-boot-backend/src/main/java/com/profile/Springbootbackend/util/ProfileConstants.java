package com.profile.Springbootbackend.util;

public interface ProfileConstants {

	//SQL queries
	public static final String INSERT_QUERY = "INSERT INTO user(first_name,last_name,email_id,mobile_no,date_of_birth,profile_pic_url,flag)VALUES(?,?,?,?,?,?,?)";
	public static final String UPDATE_QUERY = "UPDATE USER SET is_assets_assign=? WHERE user_id =?";
	public static final String DELETE_QUERY = "UPDATE user SET is_user_present=? WHERE user_id=?";
	public static final String SELECT_QUERY = "SELECT * FROM USER WHERE user_id =?";
	public static final String SELECT_ALL_QUERY ="SELECT * FROM user WHERE flag =?";
	public static final String CREATE_USER_TABLE ="create table user\r\n" + 
			"(\r\n" + 
			"user_id int primary key auto_increment,\r\n" + 
			"first_name varchar(50),\r\n" + 
			"last_name varchar(50),\r\n" + 
			"email_id varchar(60),\r\n" + 
			"mobile_no varchar(40),\r\n" + 
			"date_of_birth varchar(40),\r\n" + 
			"profile_pic_url varchar(200),\r\n" + 
			"flag varchar(10)\r\n" + 
			")";
	
	public static final String LOGIN_QUERY = "select role from LOGIN where username=? AND password=?";
	public static final String SHORT_USER_DETAILS_QUERY ="select user_id,first_name,last_name from USER WHERE is_assets_assign=? AND is_user_present=?";
	
	//
	//Assets QUERIES
	public static final String SELECT_ALL_ASSETS_INFO = "select*from ASSETS";
	public static final String UPDATE_ASSETS_TABLE = "UPDATE ASSETS SET assigned=?,available=? WHERE assets_id =?";
	public static final String LEAVE_ASSETS_QUERY ="UPDATE USER SET is_assets_assign=? where user_id =?";
	//
	public static final String YES= "YES";
	public static final String NO ="NO";
	public static final int OK = 200;
	public static final int NOT_OK = 500;
	public static final int NEGATIVE = -1;
	public static final String SESSION_TIMEOUT="Session Timeout";
	public static final String INVALID_USER="Invalid";
	public static final String ADMIN_EMAIL="investmentdetails8@gmail.com";
	public static final String USER_EMAIL ="andimhatre@gmail.com";
	public static final String USER_EMAIL_ID="Chaitanya.Mhatre@in.tiaa.org";
	public static final String ASSETS_LEFT ="LEFT";
	public static final String CSV_FILE ="Assets.csv";
	public static final String ID = "id";
	public static final String ASSETS ="assets";
	public static final String DEPARTMENT="Department";
	public static final String ASSETS_STATITICS_MAP ="assetStatiticsMap";
	public static final String ASSETS_RECORD_MAP="assetsRecordsMap";
	public static final String ASSETS_STATITICS_LIST="assetStatiticsList";
	
}
