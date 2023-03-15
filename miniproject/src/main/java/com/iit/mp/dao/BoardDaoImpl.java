package com.iit.mp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iit.mp.dto.BoardDto;
import com.iit.mp.vo.BoardDetailVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시글 상세페이지
	@Override
	public BoardDto detailView(int pstgNo) {
		return sqlSession.selectOne("board.detail", pstgNo);
	}
	
	//댓글 리스트 조회
	@Override
	public BoardDetailVO boardDetail(int pstgNo) {
		return sqlSession.selectOne("board.boardDetail", pstgNo);
	}
}
