<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>인터페이스 정보기술</title>
    <style>
        #header{            
            width:100%;
            height:50px;
            background-color: #f8f8f8;
        }
        #left{
            float:left;
            width:10%; 
        }
        #body{
            float:left;
            width:90%;
        }
       /*  #footer{
            width: 100%;
            height: 50px;            
            text-align: center;
            background-color: orange;
            clear:both;
        } */
         #left, #body{ 
               min-height: 600px;
         } 
    </style>
    
</head>
<body>
    <div style="width:100%; height:100%;position:fixed;">
    <div id="header"><tiles:insertAttribute name="header" /></div>
    <div id="left"><tiles:insertAttribute name="left" /></div>
    <div id="body"><tiles:insertAttribute name="body" /></div>    
    <%-- <div id="footer"><tiles:insertAttribute name="footer" /></div> --%>
    </div>
</body>
</html>