package com.iit.mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	//메인화면
	@GetMapping(path="home")
	public String home() {
		return "home";
	}
	
	//로그인 화면
		@GetMapping(path="login")
		public String login(){
			return "login";
		}
		
		//회원가입 화면
		@GetMapping(path="join")
		public String join(){
			return "join";
		}
}
