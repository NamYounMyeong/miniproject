<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iit.mp.dto.BoardDto" %>
<%@ page import="com.iit.mp.dao.BoardDao" %>


 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Home</title>
	
 
	<!-- AUI Grid 사용을 위해 필요한 소스를 불러옵니다.-->
	<script type="text/javascript" src="${path}/resources/AUIGrid/AUIGridLicense.js" ></script>
	<script type="text/javascript" src="${path}/resources/AUIGrid/AUIGrid.js" ></script>
	<script type="text/javascript" src="${path}/resources/AUIGridJS/ajax.js" ></script>
	<!-- AUIGrid PDF 다운로드를 위한 라이브러리 -->
	<script type="text/javascript" src="${path}/resources/pdfkit/AUIGrid.pdfkit.js"></script>
    <!-- 스타일 시트 로드 -->
	<link href="${path}/resources/AUIGrid/AUIGrid_style.css" rel="stylesheet"/>
	
	
	
	<script type="text/javascript">
	var columnLayout = 
		[{
			  dataField: "pstgWrtId",
			  headerText: "작성자",
			  dataType: "String",
			  width: 140
			},{
				  dataField: "pstgNo",
				  headerText: "게시글번호",
				  width: 140		      		
			},{
			  dataField: "pstgWrtTitle",
			  headerText: "제목",
			  dataType: "String",
			  renderer : { // HTML 템플릿 렌더러 사용
					type : "TemplateRenderer"
				},//a 태그같이 문자그대로가 아닌 html 코드로 인식 시켜야 할 때 필요한 설정
			  labelFunction : function (rowIndex, columnIndex, value, headerText, item ) { // HTML 템플릿 작성
					//순서대로 줄, 컬럼, (받은)값, 헤더문구.. 순서입니다.
	                if(!value) return "";
			  		
	                // 답글인 경우 제목 앞에 'Re:'를 붙임
	                var reply = item.pstgGroup > 0 ? "Re: " : "";
			  
					var template = '<div class="my_div">';
					template += '<a href="detail?pstgNo=' + item.pstgNo + '">' + reply + value + '</a>';
					template += '</div>';
					return template; // HTML 템플릿 반환..그대도 innerHTML 속성값으로 처리됨
			},
		},

		{  
	        dataField : "pstgWrtYmd",
	        headerText : "작성일자",
	        dataType : "String",
	        dateFormat: "yyyy-MM-dd", // 원하는 형식으로 설정
	        width : 120
		},
		{
	        dataField :  "pstgInqCnt",
	        headerText : "조회수",	
	        width : 140				
	        
		}];
	//설정을 통해 컬럼의 포멧을 변환하는 등, 자세한 설정이 가능합니다. 해당 설정은 홈페이지를 참고합니다.
	
	
	//페이지가 로드 될 때 ajax 요청을 통해 데이터를 로드
	window.onload = function() {
           // 실제로 #grid_wrap 에 그리드 생성
           myGridID = AUIGrid.create("#grid_wrap", columnLayout);
           
           var boards = ${boards};
           
/*            alert(JSON.stringify(boards)); */
        
        // 그리드에 데이터 세팅
           AUIGrid.setGridData(myGridID, boards)
	};
		
	</script>
	
</head>
<body>
 
<div  id="" class="wrap">
	<div class="form-wrap">
		<div id="grid_wrap" style="width:1200px;height:480px;margin-top:150px;"></div>
		
		<br />
		
		<div>
			<a href="write"><button>글쓰기</button></a>
		</div>
	</div>
</div>
	
</body>
</html>