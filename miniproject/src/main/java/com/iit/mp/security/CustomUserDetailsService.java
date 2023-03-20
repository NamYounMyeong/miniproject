package com.iit.mp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iit.mp.dao.MemberDao;
import com.iit.mp.vo.UserVO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String mbrId) throws UsernameNotFoundException {
//		MemberDto user = memberDao.loginMember(mbrId);
		UserVO user = memberDao.loginMember(mbrId);
		if(user == null) {
			throw new UsernameNotFoundException(mbrId);
		}
		return user;
	}
	
}
