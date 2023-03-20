package com.iit.mp.restcontroller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iit.mp.dao.BoardDao;
import com.iit.mp.dto.BoardDto;
import com.iit.mp.dto.ReplyDto;

@RestController
@RequestMapping("/rest/board")
public class BoardRestController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private SqlSession sqlSession;
	
//	@RequestMapping(value = "detail", method = RequestMethod.POST)
//	public BoardDto detail(@RequestParam String pstgNo) {
//		return boardDao.detailView(Integer.parseInt(pstgNo));
//	}
	
	//게시글 상세페이지
	@RequestMapping(value = "reply-write", method = RequestMethod.POST)
	public void replyWrite(@RequestBody ReplyDto replyDto) {
		boardDao.replyWrite(replyDto);
	}
	
	//댓글 리스트 업데이트
	@RequestMapping(value = "reply-list", method = RequestMethod.GET)
	public List<ReplyDto> replyList(@RequestParam int pstgNo) {
		return boardDao.replyList(pstgNo);
	}
	
	//댓글 삭제
	@RequestMapping(value = "reply-delete", method = RequestMethod.GET)
	public boolean deleteReply(@RequestParam int cmntNo) {
		// 다시 댓글 리스트를 보여줘야 하므로 댓글 번호와 글 번호 모두 받아와야한다.
		return boardDao.deleteReply(cmntNo);
	}
	
	//댓글 수정
	@RequestMapping(value = "reply-update", method = RequestMethod.POST)
	public boolean updateReply(@RequestBody ReplyDto replyDto) {
		return boardDao.updateReply(replyDto);
	}
	
	
}
