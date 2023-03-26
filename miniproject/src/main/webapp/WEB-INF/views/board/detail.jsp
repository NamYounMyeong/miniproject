<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세페이지</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board_detail.css">
<body>
	<div class="detail-view container-1000">
		<div class="detail-top-area">
			<!-- <a href="list">목록으로</a> -->
			<input type="button" id="boardList_button" value="목록보기" style="height:25px" />
			<input type="button" id="update_button" value="편집" style="height:25px" />
		    <input type="button" id="delete_button" value="삭제" style="height:25px" />
		    <input type="button" id="reply_button" value="답글쓰기" style="height:25px" />
		</div>
		<div class="detail-middle-area">
			<div class="title-box">
				<div class="board-title">
					<span>제목</span>
					<span>${boardDetail.boardDto.pstgWrtTitle}</span>
				</div>
				<div>
					<div>
						<span>조회수</span>
						<span>${boardDetail.boardDto.pstgInqCnt}</span>
					</div>
					<div>
						<span>작성자</span>
						<span>${boardDetail.boardDto.pstgWrtId}</span>
					</div>
				</div>
			</div>
			<div class="context-box">
				<div>${boardDetail.boardDto.pstgWrtCn}</div>
			</div>
		</div>
		<div class="detail-bottom-area">
			<div>
				<div>
					첨부파일 목록
					<c:forEach var="atchList" items="${boardDetail.atchList}">
						<button>${atchList.atchFileNm}</button>
					</c:forEach>
				</div>
				<div class="write-time">
					<c:choose>
						<c:when test="${boardDetail.boardDto.pstgMdfcnYmd == null}">
							<span>작성일: ${boardDetail.boardDto.pstgWrtYmd}</span>
						</c:when>
						<c:otherwise>
							<span>작성일: ${boardDetail.boardDto.pstgMdfcnYmd} (수정됨)</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<div class="reply-area">
	
		<div class="reply-write">
			<c:choose>
			<c:when test="${sessionScope.loginId == null}">
				<textarea name="cmntWrtCn" rows="5" cols="100" readonly="readonly" placeholder="로그인 후 작성이 가능합니다."></textarea>
			</c:when>
			<c:otherwise>
				<textarea name="cmntWrtCn" rows="5" cols="100"></textarea>
				<input name="cmntWrtNm" value="${sessionScope.loginId}" type="hidden"/>
				<input name="cmntPstgNo" value="${boardDetail.boardDto.pstgNo}" type="hidden"/>
				<button type="button" class="reply-write-btn">작성</button>
			</c:otherwise>
			</c:choose>
		</div>
		댓글목록
		<div class="reply-box-container">
		<c:forEach var="replyList" items="${boardDetail.replyList}">
			<div class="reply-box">
				<div>
					<span class="reply-id">${replyList.cmntWrtNm}</span>
				</div>
				<div>
					<span class="reply-content">${replyList.cmntWrtCn}</span>
				</div>
				<div>
					<c:choose>
						<c:when test="${replyList.cmntMdfcnYmd == null}">
							<span class="reply-date">${replyList.cmntWrtYmd}</span>
						</c:when>
						<c:otherwise>
							<span class="reply-date">${replyList.cmntMdfcnYmd} (수정됨)</span>
						</c:otherwise>
					</c:choose>
					<input value="${replyList.cmntNo}" type="hidden"/>
				</div>
				<c:if test="${sessionScope.loginId == replyList.cmntWrtNm}">
				<div class="reply-btn-container">
					<button class="reply-update-btn">수정</button>
					<button class="reply-delete-btn">삭제</button>
				</div>
				</c:if>
			</div>
		</c:forEach>
		</div>
	</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script type="text/javascript">
	var root = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/resources/js/board_detail.js"></script>
<script type="text/javascript">
	$(function() {
		$('#boardList_button').on('click', function(event) {
			location.href = 'board';
		});
		
		$('#delete_button').on('click', function(event) {
		    const ok = confirm("${boardDetail.boardDto.pstgNo}번 글을 삭제할까요?");
		    if (!ok) return; 
		    location.href = 'boardDelete?pstgNo=${boardDetail.boardDto.pstgNo}';
		});
		
		$('#reply_button').on('click', function(event) {
		    const ok = confirm("${boardDetail.boardDto.pstgNo}번 답글을 작성 하시겠습니까?");
		    if (!ok) return; 
		    location.href = 'replyWrite?pstgNo=${boardDetail.boardDto.pstgNo}';
		});

		
		$('#update_button').on('click', function(event) {
			const ok = confirm("수정 하시겠습니까?");
			if (!ok) return; 
			location.href = 'edit?pstgNo=${boardDetail.boardDto.pstgNo}';
		});
	});
	</script>
</body>
</html>