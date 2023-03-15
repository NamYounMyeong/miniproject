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
	
	//게시글 상세페이지
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String boardDetail(){
		
		return "board/detail";
	}
	
	//게시글 상세페이지2
	@RequestMapping(value="detail2", method = RequestMethod.GET)
	public String boardDetail2(@RequestParam int pstgNo, Model model){
		model.addAttribute("detail", boardDao.detailView(pstgNo));
//		System.out.println("No: "+pstgNo);
//		System.out.println("dao: "+boardDao.detailView(pstgNo));
		return "board/detail2";
	}
	
}
	

