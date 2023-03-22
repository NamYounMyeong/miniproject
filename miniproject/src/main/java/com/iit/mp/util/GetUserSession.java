package com.iit.mp.util;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.iit.mp.vo.UserVO;


public class GetUserSession {
	
public static String getUserId(){
		
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserVO user = (UserVO)authentication.getPrincipal();
			
			return user.getMbrId();	
		}
		catch(Exception e) {
			
			ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attr.getRequest();
			Cookie[] cookies = Optional.ofNullable(request.getCookies()).orElseGet(()-> new Cookie[0]);
			String userId = null;
			for (Cookie cookie:cookies) {   
				if(cookie.getName().equals("logoutId")){
					userId = cookie.getValue();
					cookie.setMaxAge(0);
				}
			}
			if(userId == null) userId = "null";
			
			return userId;
		}
	}
	
	public static String getUserNm(){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserVO user = (UserVO)authentication.getPrincipal();
		return user.getMbrNm();
	}
	
	public static String getPlantcode(){
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserVO user = (UserVO)authentication.getPrincipal();
			
			return user.getPlantcode();	
		}
		catch(Exception e) {
			
			ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attr.getRequest();
			Cookie[] cookies = Optional.ofNullable(request.getCookies()).orElseGet(()-> new Cookie[0]);
			String plantcode = null;
			for (Cookie cookie:cookies) {   
				if(cookie.getName().equals("logoutPlantcode")){
					plantcode = cookie.getValue();
					cookie.setMaxAge(0);
				}
			}
			if(plantcode == null) plantcode = "null";
			
			return plantcode;
		}
	}
	
	public static String getUserIp(){
		try {
			ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attr.getRequest();
			
			String userIp = request.getRemoteAddr();
			
			return userIp;
		}
		catch(Exception e) {
			return null;
		}
		
		
	}
	
}
