package com.iit.mp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.iit.mp.vo.UserVO;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("authentication: "+ authentication);
		
		String loginUserName = String.valueOf(authentication.getPrincipal());
		String loginPassword = String.valueOf(authentication.getCredentials());
		System.out.println("로그인 아이디: "+loginUserName);
		System.out.println("로그인 비밀번호: "+loginPassword);
		
		UserVO user = (UserVO)userDetailsService.loadUserByUsername(loginUserName);
		/* 이력한 비밀번호와 조회한 비밀번호 일치 여부 조회 */
		if(!matchPassword(loginPassword, user.getPassword())) {

			System.out.println();

			throw new BadCredentialsException(loginUserName);
		}
		
		if(!user.isEnabled()) {
			throw new BadCredentialsException(loginUserName);
		}


		return new UsernamePasswordAuthenticationToken(loginUserName, loginPassword, user.getAuthorities());
	}
	
		@Override
		public boolean supports(Class<?> authentication) {
			return true;
		}
	
		private boolean matchPassword(String loginPassword, String password) {
	
			return loginPassword.equals(password);
	
		}
	
}
