package com.iit.mp.security;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.iit.mp.util.GetUserSession;
import com.iit.mp.util.UserConectHistorySearchService;
import com.iit.mp.vo.UserVO;

@Service
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private String targetUrlParameter;//
	private String defaultUrl;//성공후 보낼 주소
	private boolean useReferer;//요청한 주소
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	private UserConectHistorySearchService userConectHistorySearchService;
	
	public CustomAuthenticationSuccessHandler() {
		targetUrlParameter = "";
		defaultUrl = "/";
		useReferer = false;
	}
	
	public String getTargetUrlParameter() {
		return targetUrlParameter;
	}



	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}



	public String getDefaultUrl() {
		return defaultUrl;
	}



	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}



	public boolean isUseReferer() {
		return useReferer;
	}



	public void setUseReferer(boolean useReferer) {
		this.useReferer = useReferer;
	}



	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		request.getSession().setMaxInactiveInterval(3600); //3600sec = 1시간
		HttpSession session = request.getSession(false);
		
		/* 역할 알아보기 */
		Cookie cookie = new Cookie("logoutId",GetUserSession.getUserId());
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*7);  
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("logoutPlantcode",GetUserSession.getPlantcode());
		cookie2.setPath("/");
		cookie2.setMaxAge(60*60*24*7);  
		response.addCookie(cookie2);
		
		Cookie cookie3 = new Cookie("logoutIp",GetUserSession.getUserIp());
		cookie3.setPath("/");
		cookie3.setMaxAge(60*60*24*7);  
		response.addCookie(cookie3);
		
		UserVO userVO = (UserVO)authentication.getPrincipal();
		userVO.setMbrId(cookie.getValue());
		
		//ip 저장
		String ip = request.getRemoteAddr();
		
		int decideRedirectStrategy = decideRedirectStrategy(request, response);
		
		//세션 정보 삭제
		request.removeAttribute("userId");
		request.removeAttribute("pwd");
		request.removeAttribute("ip");
		request.removeAttribute("loginRedirect");
		
		Map<String, Object> map= new HashMap<>();
		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    map.put(name, request.getParameter(name));
		}
		
		if("eln".equals(map.get("loginGbn"))){
			setDefaultUrl("/main.do");
		}else{
			setDefaultUrl("/limsView/elnDesignView.do");
			//request.getSession().setAttribute("elnFormSeq", map.get("elnFormSeq"));
			
			for(Map.Entry<String, Object> entry : map.entrySet()){
				if(!"".equals(entry.getValue()) && !(entry.getValue() == null) ){
					request.getSession().setAttribute(entry.getKey(), entry.getValue());
				}
			}
		}
		
		request.getSession().removeAttribute("loginGbn");
		request.getSession().removeAttribute("ip");
		request.getSession().removeAttribute("loginRedirect");
		request.getSession().removeAttribute("userId");
		request.getSession().removeAttribute("pwd");
		
		switch(decideRedirectStrategy) {
			case 1:
				useTargetUrl(request, response);
				break;
			case 2:
//				useSessionUrl(request, response);
				break;
			case 3:
//				useRefererUrl(request, response);
				break;
			default:
				useDefaultUrl(request, response);
				break;
		}
		
		//로그인 이력 저장
		HashMap param = new HashMap<String, Object>();
		param.put("jntIo", 'I');
		param.put("jntIp", ip);
		userConectHistorySearchService.saveLog(param);
		
	}
	
	private void useDefaultUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		redirectStrategy.sendRedirect(request, response, defaultUrl);
	}
	
	private void useTargetUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		redirectStrategy.sendRedirect(request, response, targetUrlParameter);
	}
	
	private int decideRedirectStrategy(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		if(!"".equals(targetUrlParameter)) {
			String targetUrl = request.getParameter(targetUrlParameter);
			if(StringUtils.hasText(targetUrl)) {
				result = 1;
			} else {
				if(savedRequest != null) {
					result = 2;
				} else {
					String refererUrl = request.getHeader("REFERER");
					if(useReferer && StringUtils.hasText(refererUrl)) {
						result = 3;
					} else {
						result = 0;
					}
				}
			}
			
			return result;
		}
		
		String refererUrl = request.getHeader("REFERER");
		if(useReferer && StringUtils.hasText(refererUrl)) {
			result = 3;
		} else {
			result = 0;
		}
		
		return result;
	}
	
}
