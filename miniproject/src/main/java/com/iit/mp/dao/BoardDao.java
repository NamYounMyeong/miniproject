package com.iit.mp.dao;

import com.iit.mp.dto.BoardDto;
import com.iit.mp.vo.BoardDetailVO;

public interface BoardDao {
	//게시글 상세페이지
	BoardDto detailView(int pstgNo);
	//댓글 리스트 조회
	BoardDetailVO boardDetail(int pstgNo);
}
