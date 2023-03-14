<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.on {
		display: flex;
		flex-direction: column;
		border: 1px solid #e6e6e6;
		width: 98%;
		background-color: white;
		position: fixed;
		top: 10px;
		bottom: 0;
	}
	
	.detail_top_area {
		top: 0;
		display: flex;
		justify-content: flex-end;
	}
	
	.detail_middle_area {
	}
	
	.detail_bottom_area {
		bottom: 0;
	}
	
	.context_box {
		min-height: 600px;
	}
	.title_box {
		display: flex;
		justify-content: space-between;
	}
	.title_box>div:nth-child(2) {
		display: flex;
	}
	
	.title_box > div:nth-child(2) > div {
		margin-right: 10px;
	}
	
	/* 댓글 CSS */
	.reply_area {
		background-color: red;
		width: 100%;
	}
</style>
<body>
	<h1>게시글 상세페이지</h1>
	<div class="detail_view">
		<div class="detail_top_area">
			<a href="detail">목록으로</a>
		</div>
		<div class="detail_middle_area">
			<div class="title_box">
				<div>
					<span>제목</span>
					<span>${detail.pstgWrtTitle}</span>
				</div>
				<div>
					<div>
						<span>조회수</span>
						<span>${detail.pstgInqCnt}</span>
					</div>
					<div>
						<span>작성자</span>
						<span>${detail.pstgWrtId}</span>
					</div>
				</div>
			</div>
			<div class="context_box">
				게시글 내용
				<div>${detail.pstgWrtCn}</div>
			</div>
		</div>
		<div class="detail_bottom_area">
			<div>
				<div>
					첨부파일 목록
				</div>
				<div>
					<span>작성시간</span>
					<c:choose>
					<c:when test="${detail.pstgMdfcnYmd == null}">
						<span>작성일: ${detail.pstgWrtYmd}</span>
					</c:when>
					<c:otherwise>
						<span>작성일: ${detail.pstgMdfcnYmd} (수정됨)</span>
					</c:otherwise>
				</c:choose>
				</div>
			</div>
		</div>
	</div>
	<div class="reply_area">
		<div>
			댓글목록
		</div>
	</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">

</script>
</body>
</html>