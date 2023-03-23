package com.iit.mp.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	
	private String mbrId, mbrPw, mbrNm, mbrAuthrity, plantcode;
	private boolean mbrEnabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(mbrAuthrity));
		return auth;
	}
	
	@Override
	public String getPassword() {
		return mbrPw;
	}
	
	@Override
	public String getUsername() {
		return mbrId;
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
		return mbrEnabled;
	}
	

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getMbrPw() {
		return mbrPw;
	}

	public void setMbrPw(String mbrPw) {
		this.mbrPw = mbrPw;
	}

	public String getMbrNm() {
		return mbrNm;
	}

	public void setMbrNm(String mbrNm) {
		this.mbrNm = mbrNm;
	}

	public String getMbrAuthrity() {
		return mbrAuthrity;
	}

	public void setMbrAuthrity(String mbrAuthrity) {
		this.mbrAuthrity = mbrAuthrity;
	}

	public boolean isMbrEnabled() {
		return mbrEnabled;
	}

	public void setMbrEnabled(boolean mbrEnabled) {
		this.mbrEnabled = mbrEnabled;
	}

	public String getPlantcode() {
		return plantcode;
	}

	public void setPlantcode(String plantcode) {
		this.plantcode = plantcode;
	}


	

}
