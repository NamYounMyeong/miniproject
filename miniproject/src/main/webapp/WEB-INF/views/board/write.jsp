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
					<h1>게시글 작성</h1>
					<!-- <form method="POST" action="insert" enctype="multipart/form-data"> -->
					<form method="POST" action="insert">
						<table>
							<tr>
								<th>제목</th>
								<td><input type="text" name="pstgWrtTitle"
									style="width: 580px; height: 25px;" required /></td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>
								${sessionScope.loginId}
								<input type="hidden" name="pstgWrtId" value="${sessionScope.loginId}" />
								</td>
							</tr>
							<!-- <tr>
								<th>첨부파일</th>
								<td><input type="file" name="attach"
									style="width: 580px; height: 20px" /></td>
							</tr>  -->
							<tr> 
								<th>글내용</th>
								<td><textarea id="mytextarea" name="pstgWrtCn" style="height: 400px;" placeholder="내용을 작성 해주세요."></textarea></td>
							</tr>
						</table>
							
						<div class="buttons">
							<input type="submit" value="글쓰기" style="height: 25px" /> 
							<input id="boardList_button" type="button" value="취소" style="height: 25px" />
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#boardList_button').on('click', function(event) {
			location.href = 'board';
		});
	});
	
		</script>
	
</body>
</html>