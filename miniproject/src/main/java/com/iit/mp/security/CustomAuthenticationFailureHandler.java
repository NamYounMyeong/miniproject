/*시큐리티 설정중 우선 제외*/
//package com.iit.mp.security;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import com.iit.mp.util.UserConectHistorySearchService;
//
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//	@Autowired
//	private UserConectHistorySearchService userConectHistorySearchService;
//	
//	private String loginId;
//	private String loginPw;
//	private String loginRedirectName;
//	private String exceptionMsgName;
//	private String defaultFailureUrl;
//	
//	@Override
//	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException exception) throws IOException, ServletException {
//		// Request 객체의 Attribute에 사용자가 실패시 입력했던 로그인 ID와 비밀번호를 저장해두어 로그인페이지에서 이를 접근하도록 한다.
//		String user_id = request.getParameter(loginId);
//		String pwd = request.getParameter(loginPw);
//		String loginRedirect = request.getParameter(loginRedirectName);
//		
//		request.setAttribute(loginId, user_id);
//		request.setAttribute(loginPw, pwd);
//		request.setAttribute(loginRedirectName, loginRedirect);
//
//		// Request 객체의 Attribute에 예외 메시지 저장
//		request.setAttribute(exceptionMsgName, exception.getMessage());
//		
//		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
//		
//	}
//
//	public String getLoginId() {
//		return loginId;
//	}
//
//	public void setLoginId(String loginId) {
//		this.loginId = loginId;
//	}
//
//	public String getLoginPw() {
//		return loginPw;
//	}
//
//	public void setLoginPw(String loginPw) {
//		this.loginPw = loginPw;
//	}
//
//	public String getLoginRedirectName() {
//		return loginRedirectName;
//	}
//
//	public void setLoginRedirectName(String loginRedirectName) {
//		this.loginRedirectName = loginRedirectName;
//	}
//
//	public String getExceptionMsgName() {
//		return exceptionMsgName;
//	}
//
//	public void setExceptionMsgName(String exceptionMsgName) {
//		this.exceptionMsgName = exceptionMsgName;
//	}
//
//	public String getDefaultFailureUrl() {
//		return defaultFailureUrl;
//	}
//
//	public void setDefaultFailureUrl(String defaultFailureUrl) {
//		this.defaultFailureUrl = defaultFailureUrl;
//	}
//	
//	
//	
//	
//}
