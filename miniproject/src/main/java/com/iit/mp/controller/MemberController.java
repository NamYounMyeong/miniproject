package com.iit.mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iit.mp.dao.MemberDao;
import com.iit.mp.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	/* 회원가입 페이지 */
	@RequestMapping(value ="join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	/* 회원가입 */
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.memberJoin(memberDto);
		return "redirect:login";
	}
	/* 로그인 페이지 */
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(){
		return "member/login";
	}
	
}
