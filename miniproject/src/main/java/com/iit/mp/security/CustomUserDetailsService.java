package com.iit.mp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iit.mp.dao.MemberDao;
import com.iit.mp.vo.UserVO;

//임시로 걸어 놓았지만 해결 방법 알아야함. 어노테이션 없앨 경우 서버 실행 시 에러 발생, 안 없앨 경우 서버 실행은 되지만 로그인 안됨.
//@Primary
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
		System.out.println("유저디테일서비스");
		return user;
	}
	
}
