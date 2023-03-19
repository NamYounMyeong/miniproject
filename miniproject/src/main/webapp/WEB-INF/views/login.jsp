<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>로그인 페이지</h1>
<div class="wrapper fadeInDown" style="margin-top:150px;">
	<div id="formContent">
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
	</div>
	<div id="formFooter">
      <a class="underlineHover" href="member/join">회원가입 하기</a>
    </div>
	<a href="member/join">회원가입 하기</a>
</div>
</body>
</html>