package com.iit.mp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iit.mp.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	/* 아이디 중복 검사 */
	@Override
	public MemberDto checkId(String mbrId) {
		return sqlSession.selectOne("member.checkId",mbrId);
	}
	
	/* 휴대폰번호 중복 검사 */
	@Override
	public MemberDto checkTelno(String mbrMblTelno) {
		return sqlSession.selectOne("member.checkTelno", mbrMblTelno);
	}
	
	/* 회원가입 */
	@Override
	public void memberJoin(MemberDto memberDto) {
		sqlSession.insert("member.memberJoin", memberDto);
	}
	
}
