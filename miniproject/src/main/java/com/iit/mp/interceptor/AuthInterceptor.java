package com.iit.mp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iit.mp.dto.MemberDto;

public class AuthInterceptor implements HandlerInterceptor {

	// 컨트롤러를 호출하기 전에 호출되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
	    String uri = req.getRequestURI();
	    HttpSession session = req.getSession();
	    MemberDto member = (MemberDto) session.getAttribute("loginuser");
	    if (member == null) {
	        if (uri.contains("/board/write") || uri.contains("/board/delete") || uri.contains("/board/edit") || uri.contains("/update")) {
	            resp.sendRedirect("/mp/login");
	            return false;
	        } else {
	            return true;
	        }
	    } else {
	        return true;
	   
	    }
	}

	
	// 컨트롤러 처리가 끝난 후에 호출되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}	
	// View 처리까지 끝난 후에 호출되는 메서드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}