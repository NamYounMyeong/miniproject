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

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
//	private MemberDao memberDao;
	private MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String mbrId) throws UsernameNotFoundException {
		MemberDto user = memberDao.loginMember(mbrId);
		if(user != null) {
			return new PrincipalDetails(user);
		}
		return null;
	}
	
}
