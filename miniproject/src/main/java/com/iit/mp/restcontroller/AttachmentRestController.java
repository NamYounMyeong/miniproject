package com.iit.mp.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/atch")
public class AttachmentRestController {

	//파일 업로드
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload() {
		
	}
	
	//파일 다운로드
	
	
}
