package com.iit.mp.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iit.mp.dao.BoardDao;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	//게시판 페이지
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String board(){
		return "board";
	}
	//AUIGRID
	@RequestMapping(value = "/auiPDF", method = RequestMethod.POST)
	public String PDF(Locale locale, Model model) {
		
		return "export/export"; //export.jsp의 위치
	}
	
	@RequestMapping(value = "/auiEXCEL", method = RequestMethod.POST)
	public String EXCEL(Locale locale, Model model) {
		
		return "export/export"; //export.jsp의 위치
	}
	//게시판 글쓰기 페이지
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(){
		return "write";
	}
	
	//임시 게시판 리스트 페이지
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String boardList(){
		
		return "board/list";
	}
	
	//게시글 상세페이지
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String boardDetail2(@RequestParam int pstgNo, Model model){
		model.addAttribute("boardDetail", boardDao.boardDetail(pstgNo));
		return "board/detail";
	}
	
}
	

