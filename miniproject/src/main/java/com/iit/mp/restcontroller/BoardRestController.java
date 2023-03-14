package com.iit.mp.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iit.mp.dao.BoardDao;
import com.iit.mp.dto.BoardDto;

@RestController
@RequestMapping("/rest/board")
public class BoardRestController {
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping(value = "detail", method = RequestMethod.POST)
	public BoardDto detail(@RequestParam String pstgNo) {
		return boardDao.detailView(Integer.parseInt(pstgNo));
	}
	
}
