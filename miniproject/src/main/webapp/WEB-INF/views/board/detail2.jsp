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
	
	.detail-top-area {
		top: 0;
		display: flex;
		justify-content: flex-end;
	}
	
	.detail-middle-area {
	}
	
	.detail-bottom-area {
		bottom: 0;
	}
	
	.context-box {
		min-height: 600px;
	}
	.title-box {
		display: flex;
		justify-content: space-between;
	}
	.title-box>div:nth-child(2) {
		display: flex;
	}
	
	.title-box > div:nth-child(2) > div {
		margin-right: 10px;
	}
	
	/* 댓글 CSS */
	.reply-area {
		width: 1000px;
		border: 1px solid #e6e6e6;
		padding: 10px;
		margin: 0 auto;
	}
	
	.reply-box {
		display: flex;
		flex-direction: column;
		border: 1px solid #e6e6e6;
		margin-top: 5px;
	}
	
</style>
<body>
	<h1>게시글 상세페이지</h1>
	<div class="detail-view">
		<div class="detail-top-area">
			<a href="detail">목록으로</a>
		</div>
		<div class="detail-middle-area">
			<div class="title-box">
				<div>
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
				게시글 내용
				<div>${boardDetail.boardDto.pstgWrtCn}</div>
			</div>
		</div>
		<div class="detail-bottom-area">
			<div>
				<div>
					첨부파일 목록
				</div>
				<div>
					<span>작성시간</span>
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
			<textarea name="cmntWrtCn" rows="5" cols="100"></textarea>
			<input name="cmntWrtNm" value="${sessionScope.loginId}" type="hidden"/>
			<input name="cmntPstgNo" value="${boardDetail.boardDto.pstgNo}" type="hidden"/>
			<button type="button" class="reply-write-btn">작성</button>
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
					<span class="reply-date">${replyList.cmntWrtYmd}</span>
				</div>
				<div>
					<input value="${replyList.cmntNo}" type="hidden"/>
					<button class="reply-update-btn">수정</button>
					<button class="reply-delete-btn">삭제</button>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script type="text/javascript">
	$(function(){
		var cmntPstgNo = $("[name=cmntPstgNo]").val();
		
		//댓글 폼 전송
		$(".reply-write-btn").click(function(){
			var cmntWrtCn = $("[name=cmntWrtCn]").val();
			var cmntWrtNm = $("[name=cmntWrtNm]").val();
			
			var data = {
					"cmntWrtCn" : cmntWrtCn,
					"cmntWrtNm" : cmntWrtNm,
					"cmntPstgNo" : cmntPstgNo
			};
			$.ajax({
				url: '${pageContext.request.contextPath}/rest/board/reply-write',
				method: 'POST',
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function() {
					$(".cmntWrtCn").val("");
// 					var a = $(".reply-box>div:nth-child(1)>span").text(cmntWrtNm);
// 					$(".reply-area").append(a);
					$.ajax({
						url: '${pageContext.request.contextPath}/rest/board/reply-list',
						method: 'GET',
						data: {pstgNo:cmntPstgNo},
						success: function(resp) {
							var replyBox = $('<div>').addClass("reply-box");
							
							/* 댓글 내용 */
							var replyContent = $("<span>").text(resp[resp.length-1].cmntWrtCn);
							/* 작성한 사람 */
							var replyId = $("<span>").text(resp[resp.length-1].cmntWrtNm);
							/* 작성일 */
							var date = moment(resp[resp.length-1].cmntWrtYmd).format("YYYY-MM-DD");
							var replyDate = $("<span>").text(date);
							var replyUpdateBtn = $("<button>").text("수정").addClass("reply-update-btn");
							var replyDeleteBtn = $("<button>").text("삭제").addClass("reply-delete-btn");
							
							/* 비동기 댓글 작성시 태그 추가 */
							var div = $('<div>').append(replyId);
							replyBox.append(div);
							var div2 = $('<div>').append(replyContent);
							replyBox.children("div").last().append(div2);
							var div3 = $('<div>').append(replyDate);
							replyBox.children("div").last().append(div3);
							var div4 = $('<div>').append(replyUpdateBtn).append(replyDeleteBtn);
							replyBox.children("div").last().append(div4);
							
							if(resp.length == 0) {
								$(".reply-box-container").prepend(replyBox);
							}
							else {
								$(".reply-box-container").children("div").last().after(replyBox);
							}
							
						}
					});//ajax end
					
				}
				
			});//ajax end
		});//reply-write-btn.click end
		
		$(".reply-delete-btn").click(function(){
			var cmntNo = $(this).parent().find("input").val();
			//console.log(cmntNo); //확인 완료
			$.ajax({
				url: "${pageContext.request.contextPath}/rest/board/reply-delete",
				method: "DELETE",
				data: {
						cmntNo:cmntNo,
						pstgNo:cmntPstgNo
						},
				success: function(resp){
					console.log(resp);
				}
			});//ajax end
		});//reply-delete-btn.click end
		
		
	});
</script>
</body>
</html>