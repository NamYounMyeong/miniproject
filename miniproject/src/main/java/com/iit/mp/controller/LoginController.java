package com.iit.mp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iit.mp.dao.MemberDao;
import com.iit.mp.security.CustomUserDetailsService;

@Controller
public class LoginController {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	/* 로그인 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	//로그인
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String login(HttpSession session, @ModelAttribute MemberDto inputDto) {
////		MemberDto findDto = memberDao.loginMember(inputDto.getMbrId());
//		MemberDto findDto = memberDao.loginMember(inputDto.getMbrId());
//		customUserDetailService.loadUserByUsername(findDto.getMbrId());
//		
//		if(findDto == null) {
//			return "redirect:login?error";
//		}
//		boolean checkPw = passwordEncoder.matches(inputDto.getMbrPw(), findDto.getMbrPw());
//		
//		if(checkPw) {
//			session.setAttribute("loginId", inputDto.getMbrId());
//			return "redirect:/";
//		}
//		else {
//			return "redirect:login?error";
//		}//if ~else end
//		
//	} //로그인 end
	
//	//로그인
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(){
//		return "redirect:/";
//	}//로그인 end
//	
//	
//	//로그아웃
//	@RequestMapping(value="logout", method=RequestMethod.GET)
//	public String logout(HttpSession session) {
//		session.removeAttribute("loginId");
//		return "redirect:/";
//	}
	
	
}
