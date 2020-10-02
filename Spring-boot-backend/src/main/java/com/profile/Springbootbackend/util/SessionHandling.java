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
import java.util.logging.Level;
import java.util.logging.Logger;
@Service
@SessionScope
public class SessionHandling {
	
	
	private static  HttpSession session;
	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public void setSession(String username, HttpSession session1)
	{
		session = session1;
		session.setAttribute(ID,username);
		session.setMaxInactiveInterval(3600);
		LOGGER.log(Level.INFO, "Session Created");
	}
	public String getSession()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpSession session = sra.getRequest().getSession();
		if(null != session && null != session.getAttribute(ID))
			return session.getAttribute(ID).toString();
		
		LOGGER.log(Level.WARNING, "Session Timeout");
			return SESSION_TIMEOUT;
	}
	
	public boolean logout()
	{
		//ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		///HttpSession session = sra.getRequest().getSession();
		if(null != session)
			session.invalidate();
		return true;
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








