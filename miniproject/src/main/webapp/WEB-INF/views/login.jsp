<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="login" method="post">
		<div>
			<input name="mbrId" type="text" placeholder="아이디 입력">
		</div>
		<div>
			<input name="mbrPw" type="password" placeholder="비밀번호 입력">
		</div>
		<button type="submit">로그인</button>
	</form>
	<c:if test="${param.error != null}">
		<div class="">
			<div class="">아이디 혹은 비밀번호가 일치하지 않습니다.</div>
		</div>
	</c:if>
	<a href="member/join">회원가입 하기</a>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
	$(function(){
		
	});
</script>
</body>
</html>