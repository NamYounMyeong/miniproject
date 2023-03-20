package com.iit.mp.dao;

import java.util.List;

import com.iit.mp.dto.BoardDto;
import com.iit.mp.dto.ReplyDto;
import com.iit.mp.vo.BoardDetailVO;

public interface BoardDao {
	//게시글 상세페이지
	BoardDetailVO boardDetail(int pstgNo);
	//댓글 등록
	void replyWrite(ReplyDto replyDto);
	//댓글 리스트 업데이트
	List<ReplyDto> replyList(int pstgNo);
	//댓글 삭제
	boolean deleteReply(int cmntNo);
	//댓글 수정
	boolean updateReply(ReplyDto replyDto);
	//조회수 증가
	
}
