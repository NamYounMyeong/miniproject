<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
   <link href="${path}/resources/css/login.css" rel="stylesheet" type="text/css">
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>로그인</title>

</head>
<body>
	<div class="wrapper fadeInDown" style="margin-top:150px;">
	
  <div id="formContent">

    <!-- Login Form -->
    <form>
    <h1>로그인</h1>
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="아이디">
      <input type="password" id="password" class="fadeIn third" name="login" placeholder="비밀번호">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="join">회원가입</a>
    </div>

  </div>
</div>
</body>
</html>