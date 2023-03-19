package com.iit.mp.security;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.iit.mp.dto.MemberDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
public class PrincipalDetails implements UserDetails {

	private MemberDto memberDto;
	
	public PrincipalDetails(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return memberDto.getMbrGrd();
			}
		});
		return auth;
	}
	
	@Override
	public String getPassword() {
		return memberDto.getMbrPw();
	}
	
	@Override
	public String getUsername() {
		return memberDto.getMbrId();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	
}
