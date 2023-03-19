package com.iit.mp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.iit.mp.dao.MemberDao;
import com.iit.mp.dto.MemberDto;

@Service("CustomUserDetailsService")
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
//	private MemberDao memberDao;
	private MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String mbrId) throws UsernameNotFoundException {
		System.err.println("서비스 mbrId: "+mbrId);
		SecurityUserVO user = memberDao.loginMember(mbrId);
		System.err.println("서비스 user: "+user);
		if(user != null) {
			return user;
		}
		
		return null;
	}
	
}
