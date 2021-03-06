package com.profile.Springbootbackend.util;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import com.profile.Springbootbackend.model.AssetRecord;
import com.profile.Springbootbackend.model.Assets;

import static com.profile.Springbootbackend.util.ProfileConstants.SESSION_TIMEOUT;
import static com.profile.Springbootbackend.util.ProfileConstants.ID;
import static com.profile.Springbootbackend.util.ProfileConstants.ASSETS_RECORD_MAP;
import static com.profile.Springbootbackend.util.ProfileConstants.ASSETS_STATITICS_MAP;
import static com.profile.Springbootbackend.util.ProfileConstants.ASSETS_STATITICS_LIST;

import java.util.List;
import java.util.Map;
@Service
@SessionScope
public class SessionHandling {
	
	
	private static  HttpSession session;
	
	public void setSession(String username, HttpSession session1)
	{
		session = session1;
		session.setAttribute(ID,username);
		session.setMaxInactiveInterval(3600);
		System.out.println("hi iam here..");
	}
	public String getSession()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpSession session = sra.getRequest().getSession();
		if(null != session && null != session.getAttribute(ID))
			return session.getAttribute(ID).toString();
		
		if(session != null)
			System.out.println("heyyyyyyy");
		
		System.out.println(SESSION_TIMEOUT);
			return SESSION_TIMEOUT;
	}
	
	public void logout()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		///HttpSession session = sra.getRequest().getSession();
		if(null != session)
			session.invalidate();
	}
	
	public int getSessionUsername()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpSession session = sra.getRequest().getSession();
		if(null != session && null != session.getAttribute(ID))
			return Integer.parseInt(session.getAttribute(ID).toString());
		else
			return -1;
	}
	
	public void setAssetMap(Map<String,Assets> assetDetail)
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpSession session = sra.getRequest().getSession();
		if(null != session)
			session.setAttribute(ASSETS_STATITICS_MAP, assetDetail);
	}

	@SuppressWarnings("unchecked")
	public Map<String,Assets> getAssetMap()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		///HttpSession session = sra.getRequest().getSession();
		if(null != session)
			return (Map<String, Assets>) session.getAttribute(ASSETS_STATITICS_MAP);
		 return null;
	}
	
	public void setAssetRecordsMap(Map<String,AssetRecord> assetsRecords)
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpSession session = sra.getRequest().getSession();
		if(null != session)
			session.setAttribute(ASSETS_RECORD_MAP, assetsRecords);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,AssetRecord> getAssetRecordsMap()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpSession session = sra.getRequest().getSession();
		if(null != session) {
			return (Map<String, AssetRecord>) session.getAttribute(ASSETS_RECORD_MAP);
		}
		return null;
	
	}
	
	public void setAssetsList(List<Assets> assets)
	{
		if(null != session)
			session.setAttribute(ASSETS_STATITICS_LIST, assets);
	}
	
	@SuppressWarnings("unchecked")
	public List<Assets> getAssetsList()
	{
		if(null != session)
			return (List<Assets>)session.getAttribute(ASSETS_STATITICS_LIST);
		return null;
	}
	
}








