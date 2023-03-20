package com.iit.mp.dao;

import com.iit.mp.dto.MemberDto;
import com.iit.mp.vo.UserVO;

public interface MemberDao {

	/* 아이디 중복 검사 */
	MemberDto checkId(String mbrId);
	/* 휴대폰번호 중복 검사 */
	MemberDto checkTelno(String mbrMblTelno);
	/* 회원가입 */
	void memberJoin(MemberDto memberDto);
	/* 로그인 */
//	MemberDto loginMember(String mbrId);
	UserVO loginMember(String mbrId);
	
}
