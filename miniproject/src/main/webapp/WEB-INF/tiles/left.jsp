<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/resources/css/left-sidebar.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>로그인</title>

</head>
<body>
	
	<div class="row">
	<div class="side-menu">
	<nav class="navbar navbar-default" role="navigation">
    <div class="side-menu-container">
        <ul class="nav navbar-nav" style="width:100%;">
            <li class="panel panel-default" id="dropdown">
                <a data-toggle="collapse" href="#dropdown-lvl1">
                    <span class="glyphicon glyphicon-user"></span> 메뉴 <span class="caret"></span>
                </a>

            <!--     Dropdown level 1 -->
                <div id="dropdown-lvl1" class="panel-collapse collapse">
                    <div class="panel-body">
                        <ul class="nav navbar-nav">
                           <li><a href="login">로그인</a></li>
                           <li><a href="join">회원가입</a></li>

                            <!--     Dropdown level 2 -->
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl2">
                                    <span class="glyphicon glyphicon-off"></span> 게시판 <span class="caret"></span>
                                </a>
                                <div id="dropdown-lvl2" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="#">게시판</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </li>

        </ul>
    </div>
</nav>
</div>
    </div>
    
    <script>
    $(function () {
        $('.navbar-toggle').click(function () {
            $('.navbar-nav').toggleClass('slide-in');
            $('.side-body').toggleClass('body-slide-in');
            $('#search').removeClass('in').addClass('collapse').slideUp(200);
            
        });
       
       // Remove menu for searching
       $('#search-trigger').click(function () {
            $('.navbar-nav').removeClass('slide-in');
            $('.side-body').removeClass('body-slide-in');

        });
    });
    </script>
</body>
</html>