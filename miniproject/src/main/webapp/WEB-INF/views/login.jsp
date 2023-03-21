<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/reset.css">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container-300 screen-center">
	<div>
	<form action="#" method="post">
		<div class="row">
			<input class="w-100 login-input" name="mbrId" type="text" placeholder="아이디 입력">
		</div>
		<div class="row">
			<input class="w-100 login-input" name="mbrPw" type="password" placeholder="비밀번호 입력">
		</div>
		<div>
			<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
		    <input name="remember-me" type="checkbox" />자동 로그인
		</div>
		<div class="row login-btn-box">
			<button class="w-100" type="submit">로그인</button>
		</div>
	</form>
	<c:if test="${param.error != null}">
		<div class="">
			<div class="">아이디 혹은 비밀번호가 일치하지 않습니다.</div>
		</div>
	</c:if>
	</div>
	<div>
    	<a class="move-join-btn w-100" href="member/join">회원가입 하기</a>
    </div>
</div>
</body>
</html>