package com.iit.mp.dao;

import com.iit.mp.dto.MemberDto;

public interface MemberDao {

	/* 아이디 중복 검사 */
	MemberDto checkId(String mbrId);
	
}
