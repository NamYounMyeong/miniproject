package com.iit.mp.dao;

import java.util.List;

import com.iit.mp.dto.AttachmentDto;
import com.iit.mp.dto.BoardDto;
import com.iit.mp.dto.ReplyDto;
import com.iit.mp.vo.BoardDetailVO;

public interface BoardDao {
	
	//게시글 상세페이지
	BoardDetailVO boardDetail(int pstgNo);
	
	//댓글 번호 생성
	int replyNo();
	//댓글 등록
	void replyWrite(ReplyDto replyDto);
	
	//댓글 리스트 업데이트
	List<ReplyDto> replyList(int pstgNo);
	
	//댓글 삭제
	boolean deleteReply(int cmntNo);
	
	//댓글 수정
	boolean updateReply(ReplyDto replyDto);
	
	// 게시글쓰기
	void writeBoard(BoardDto boardDto, AttachmentDto attachmentDto);
	
	//게시글 수정
	void boardUpdate(BoardDto boardDto);
		
	// 게시글 삭제
	void deleteBoard(int pstgNo);

	// 조회수 증가
	void increaseViewCount(int pstgNo);
	
	//게시글 답변등록
	void insertReplyWrite(BoardDto boardDto);
	
	//게시글 답변조회
	List<BoardDto> selectReplyList(int pstgParent);
	
	//게시글 리스트 조회
	List<BoardDto> selectBoard();
	
	//게시글 첨부파일 리스트
	List<AttachmentDto> atchList(int pstgNo);


}
