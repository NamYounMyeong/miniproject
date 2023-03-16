<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세페이지</h1>
	<div>
		<a href="/">홈으로</a>
	</div>
	<div>
		<p>페이지 전환</p>
		<a href="detail?pstgNo=2"><button>상세보기</button></a>
		<a href="detail?pstgNo=3"><button>상세보기</button></a>
		<a href="detail?pstgNo=4"><button>상세보기</button></a>
		<a href="detail?pstgNo=5"><button>상세보기</button></a>
		<a href="detail?pstgNo=6"><button>상세보기</button></a>
	</div>
	<div>
		<input type="file" class="file-input" accept=".jpg, .png, .gif, .txt, .pdf"/>
	</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
$(function(){
	// 파일업로드 비동기
    $(".file-input").change(function(){
        if(this.files.length > 0){
            var atchData = new FormData();

            atchData.append("attach", this.files[0]);

            $.ajax({
                url: "${pageContext.request.contextPath}/rest/atch/upload",
                method: "post",
                data: atchData,
                processData:false, // 일반 폼에서 전송되는 형식(key = value)
                contentType:false, //형태가 없음을 의미 => multipart
                success: function(resp) {
                	console.log(resp);
//                     $(".profileImage").attr("src", resp);
                    
//                     var attachmentNo = (resp.split("download/")[1]);
                    
//                     $.ajax({
//                         url: root+"/rest/profileImg?attachmentNo="+attachmentNo,
//                         method: "post",
//                         contentType: "application/json",
//                         data: JSON.stringify({attachmentNo:attachmentNo}),
//                         success: function(resp) {

//                         }
//                     });//inner ajax end
                    
                }
            });//ajax end

        }//if end
        else {
            $(".profileImage").attr("src","");
        }//else end

    });//.file-input change end
});
</script>
</body>
</html>