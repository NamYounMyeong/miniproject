package com.iit.mp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iit.mp.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {

	/* 회원가입 페이지 */
	@RequestMapping(value ="join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute MemberDto memberDto) {
		return "redirect:login";
	}
	/* 로그인 페이지 */
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(){
		return "member/login";
	}
	
}
