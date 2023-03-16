<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>로그인 ID: ${sessionScope.loginId}</h1>
 <c:choose>
 	<c:when test="${sessionScope.loginId == null}">
		<a href="member/join">회원가입</a>
		<a href="/login">로그인</a>
 	</c:when>
 	<c:otherwise>
		<a href="/logout">로그아웃</a>
 	</c:otherwise>
 </c:choose>
<a href="board/list">디테일페이지</a>
</body>
</html>
