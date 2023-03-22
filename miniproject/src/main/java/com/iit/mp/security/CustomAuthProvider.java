/*시큐리티 설정중 우선 제외*/
//package com.iit.mp.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//
//import com.iit.mp.dao.MemberDao;
//import com.iit.mp.vo.UserVO;
//
//public class CustomAuthProvider implements AuthenticationProvider {
//
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
//	
//	@Autowired
//	private MemberDao memberDao;
//	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String username = authentication.getName();
//		String password = (String)authentication.getCredentials();
//		UserVO userVO = null;
//		
//		userVO = memberDao.loginMember(username);
//		String id = null;
//		String plantcode = null;
//		
//		return null;
//	}
//	
//	@Override
//	public boolean supports(Class<?> authentication) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//}
