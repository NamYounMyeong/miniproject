<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<%-- 	<sec:authorize access="isAuthenticated()"> --%>
<%-- 	<form action="<c:url value='/logout'/>" method="post"> --%>
<%-- 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
<!-- 		<input type="submit" value="로그아웃"/> -->
<!-- 	</form> -->
<%-- 	</sec:authorize> --%>
</body>
</html>
