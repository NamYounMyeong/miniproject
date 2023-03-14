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
	.detail_view {
		display: none;
		overflow-y: scroll;
	}
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
	
</style>
<body style="height: 3000px">
	<h1>게시글 상세페이지</h1>
	<div>
		<p>페이지 전환</p>
		<a href="detail2?pstgNo=2"><button>상세보기</button></a>
		<a href="detail2?pstgNo=3"><button>상세보기</button></a>
		<a href="detail2?pstgNo=4"><button>상세보기</button></a>
		<a href="detail2?pstgNo=5"><button>상세보기</button></a>
		<a href="detail2?pstgNo=6"><button>상세보기</button></a>
	</div>
	<div>
		<p>div 형식</p>
		<button data-num="2" class="view_btn">상세보기</button>
		<button data-num="3" class="view_btn">상세보기</button>
		<button data-num="4" class="view_btn">상세보기</button>
		<button data-num="5" class="view_btn">상세보기</button>
		<button data-num="6" class="view_btn">상세보기</button>
	</div>
	
	<!-- detail_view div 시작 -->
	<div class="detail_view">
		<div class="detail_top_area">
			<button class="close_btn">닫기</button>
		</div>
		<div class="detail_middle_area">
			<div class="title_box">
				<div>
					<span>제목</span>
					<span id="title"></span>
				</div>
				<div>
					<div>
						<span>조회수</span>
						<span id="count"></span>
					</div>
					<div>
						<span>작성자</span>
						<span id="writer"></span>
					</div>
				</div>
			</div>
			<div class="context_box">
				게시글 내용
				<div id="content"></div>
			</div>
		</div>
		<div class="detail_bottom_area">
			<div>
				<div>
					첨부파일 목록
				</div>
				<div>
					<span>작성시간</span>
					<span id="write_time"></span>
				</div>
			</div>
		</div>
	</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
$(function(){
	//상세페이지 열기
	$(".view_btn").click(function(){
		var pstgNo = $(this).attr("data-num");
		$(".detail_view").addClass("on");
		
		$.ajax({
			url: "${pageContext.request.contextPath}/rest/board/detail",
			method: "POST",
			data: {pstgNo:pstgNo},
			success: function(resp){
				console.log(resp);
				$("#title").text(resp.pstgWrtTitle);
				$("#count").text(resp.pstgInqCnt);
				$("#writer").text(resp.pstgWrtId);
				$("#content").text(resp.pstgWrtCn);
				if(resp.pstgMdfcnYmd == null) {
					$("#write_time").text(resp.pstgWrtYmd);
				}
				else {
					$("#write_time").text(resp.pstgMdfcnYmd);
				}
			}
		});//ajax end
		
	});
	//상세페이지 닫기
	$(".close_btn").click(function() {
		$(".detail_view").removeClass("on");
	});
});
</script>
</body>
</html>