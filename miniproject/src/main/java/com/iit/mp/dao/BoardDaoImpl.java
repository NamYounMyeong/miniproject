package com.iit.mp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iit.mp.dto.BoardDto;
import com.iit.mp.dto.ReplyDto;
import com.iit.mp.vo.BoardDetailVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시글 상세페이지
	@Override
	public BoardDetailVO boardDetail(int pstgNo) {
		return sqlSession.selectOne("board.detail", pstgNo);
	}
	
	//댓글 등록
	@Override
	public void replyWrite(ReplyDto replyDto) {
		sqlSession.insert("board.replyWrite", replyDto);
	}
	
	//댓글 리스트 업데이트
	@Override
	public List<ReplyDto> replyList(int pstgNo) {
		return sqlSession.selectList("board.selectReplyList", pstgNo);
	}
	
	//댓글 삭제
	@Override
	public boolean deleteReply(int cmntNo) {
		int result = sqlSession.delete("board.deleteReply", cmntNo);
		return result > 0;
	}
	
	//댓글 수정
	@Override
	public boolean updateReply(ReplyDto replyDto) {
		int result = sqlSession.update("board.updateReply", replyDto);
		return result > 0;
	}
	
}
