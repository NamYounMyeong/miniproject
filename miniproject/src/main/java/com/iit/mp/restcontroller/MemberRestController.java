package com.iit.mp.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iit.mp.dao.MemberDao;
import com.iit.mp.dto.MemberDto;

@RestController
@RequestMapping("/rest/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="check-id", method = RequestMethod.POST)
	public String checkId(@RequestParam String mbrId){
		MemberDto memberDto = memberDao.checkId(mbrId);
		if(memberDto != null){
			return "Y";			
		}
		else {
			return "N";
		}
	}
	
	@RequestMapping(value="check-telno", method= RequestMethod.POST)
	public String checkTelno(@RequestParam String mbrMblTelno){
		MemberDto memberDto = memberDao.checkTelno(mbrMblTelno);
		if(memberDto != null){
			return "Y";
		}
		else{
			return "N";
		}
	}
	
}
