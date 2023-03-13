<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${path}/resources/css/board_write.css" rel="stylesheet"	type="text/css">


<script	src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
<title>게시판 글쓰기</title>
<script>
      tinymce.init({
        selector: '#mytextarea'
      });
    </script>
</head>
<body>
	<div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
			<div id="inputcontent">
				<div id="inputmain">
					<h1>게시글 쓰기</h1>
					<form method="post" action="write.action"
						enctype="multipart/form-data">
						<table>
							<tr>
								<th>제목</th>
								<td><input type="text" name="title"
									style="width: 580px; height: 25px;" /></td>
							</tr>
							<tr>
								<th>작성자</th>
								<td><input type="hidden" name="writer" value=""></td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td><input type="file" name="attach"
									style="width: 580px; height: 20px" /></td>
							</tr>
							<tr>
								<th>글내용</th>
								<td><textarea id="mytextarea" style="height: 400px;">Hello, World!</textarea></td>
							</tr>

						</table>

						<div class="buttons">
							<input type="submit" value="글쓰기" style="height: 25px" /> 
							<input type="button" value="취소" style="height: 25px" />
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>