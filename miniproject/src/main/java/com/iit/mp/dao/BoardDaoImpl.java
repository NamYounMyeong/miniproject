package com.iit.mp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iit.mp.dto.AttachmentDto;
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
	    BoardDetailVO board = sqlSession.selectOne("board.detail", pstgNo);
	    return board;
	}
	
	//댓글 번호 생성
	@Override
	public int replyNo() {
		return sqlSession.selectOne("board.replyNo");
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
	
	//게시글 쓰기
	@Override
	public void writeBoard(BoardDto boardDto, AttachmentDto attachmentDto) {
		//게시글 내용 insert
	    sqlSession.insert("board.writeBoard", boardDto);

	    //첨부파일 내용 insert
	    sqlSession.insert("insertAttachment", attachmentDto);

	    // 게시글 테이블과 첨부파일 연결 insert
	    Map<String, Object> map = new HashMap<>();
	    map.put("pstgNo", boardDto.getPstgNo());
	    map.put("atchNo", attachmentDto.getAtchNo());
	    sqlSession.insert("insertPstgImg", map);
	}
	
	// 게시판 리스트 조회
	@Override
	public List<BoardDto> selectBoard() {
		List<BoardDto> boards = sqlSession.selectList("board.selectAll");

		// DB에서 조회한 날짜 데이터를 Date 타입으로 변환하여 BoardDto 객체에 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (BoardDto board : boards) {
			try { // 예외처리
				Date pstgWrtYmd = dateFormat.parse(board.getPstgWrtYmd());
				board.setPstgWrtYmd(pstgWrtYmd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return boards;
	}
	
	// 게시글 수정
	@Override
	public void boardUpdate(BoardDto boardDto) {
		sqlSession.update("board.updateToBoard", boardDto);
	}

	// 게시글 삭제
	@Override
	public void deleteBoard(int pstgNo) {
		sqlSession.delete("board.boardToDelete", pstgNo);

	}

	// 조회수 증가
	public void increaseViewCount(int pstgNo) {
		sqlSession.update("board.viewCount", pstgNo);
	}
	
	// 게시글 답변등록
	@Override
	public void insertReplyWrite(BoardDto boardDto) {
		sqlSession.insert("board.insertReplyWrite", boardDto);
	}

	// 게시글 답변조회
	@Override
	public List<BoardDto> selectReplyList(int pstgParent) {
		return sqlSession.selectList("board.selectReplyListToBoard", pstgParent);
	}

	
}
