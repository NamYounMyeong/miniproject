<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
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
		[ {
	        dataField : "id",		//데이터를 매핑해줄 때 사용할 이름. 예를 들어 {"id" : "test"} 라는 데이터를 받으면 test라는 데이터는 이 컬럼 안에 위치하게 됩니다.
	        headerText : "아이디",		//사용자에게 보여줄 이름
	        width : 140,			//컬럼의 너비
	        renderer : { // HTML 템플릿 렌더러 사용
				type : "TemplateRenderer"
			},						//a 태그같이 문자그대로가 아닌 html 코드로 인식 시켜야 할 때 필요한 설정
	        labelFunction : function (rowIndex, columnIndex, value, headerText, item ) { // HTML 템플릿 작성
				//순서대로 줄, 컬럼, (받은)값, 헤더문구.. 순서입니다.
                if(!value) return "";
				var template = '<div class="my_div">';
				/* template += '<a href="/board/boardView.do?seq=' + value + '">' + value + '</a>'; */
				template += '</div>';
				return template; // HTML 템플릿 반환..그대도 innerHTML 속성값으로 처리됨
	        },
	        dataType : "String"
		}, {
	        dataField : "String",
	        headerText : "제목",
	        dataType : "String"
	        
		},{
	        dataField : "date",
	        headerText : "작성일자",
	        width : 120
		},{
	        dataField : "date",
	        headerText : "날짜",
	        width : 120
		},{
	        dataField : "date",
	        headerText : "날짜",
	        width : 120
		},{
	        dataField : "name",
	        headerText : "이름",
	        width: 120
		}, {
	        dataField : "country",
	        headerText : "나라"
		}, {
	        dataField : "product",
	        headerText : "제품",
	        dataType : "String"
		}];
	//설정을 통해 컬럼의 포멧을 변환하는 등, 자세한 설정이 가능합니다. 해당 설정은 홈페이지를 참고합니다.
	
	
	//페이지가 로드 될 때 ajax 요청을 통해 데이터를 로드
	window.onload = function() {
           // 실제로 #grid_wrap 에 그리드 생성
           myGridID = AUIGrid.create("#grid_wrap", columnLayout);
           ajaxRequest();
	};
		
        
	function ajaxRequest() {	
		 // ajax 요청 전 그리드에 로더 표시
		AUIGrid.showAjaxLoader(myGridID);
 
		// ajax (XMLHttpRequest) 로 그리드 데이터 요청
		ajax( {
	           url : "${path}/resources/AUIGridJS/normal_100.json", //샘플데이터 요청
	           onSuccess : function(data) {
                     if(!data) {
                                return;
                     }
                     
                     //debug
                     console.log(data);
                     // 그리드 데이터
                     var gridData = data;
                     // 로더 제거
                     AUIGrid.removeAjaxLoader(myGridID);
                     // 그리드에 데이터 세팅
                     AUIGrid.setGridData(myGridID, gridData);
	           },
	           onError : function(status, e) {
                     alert("데이터 요청에 실패하였습니다.\r status : " + status);
	           }
		});
	}
	</script>
	
</head>
<body>
 
<div  id="" class="wrap">
	<div class="form-wrap">
		<div id="grid_wrap" style="width:1200px;height:480px;margin-top:150px;"></div>
		
		<br />
		
		<div>
			<a href="write"><button>글쓰기</button></a>
			<!-- <input type="button" id="excelDownload" value="EXCEL Download" onclick="exportToLocal()"/>
			<input type="button" id="pdflDownload" 	value="PDF Download"  onclick="exportPdfClick()"/> -->
		</div>
	</div>
</div>
 
<script type="text/javascript">
	// PDF 내보내
	function exportPdfClick() {
		// 완전한 HTML5 를 지원하는 브라우저에서만 PDF 저장 가능( IE=10부터 가능 )
		if(!AUIGrid.isAvailabePdf(myGridID)) {
			alert("PDF 저장은 HTML5를 지원하는 최신 브라우저에서 가능합니다.");
			return;
		}
		// 그리드가 작성한 엑셀, CSV 등의 데이터를 다운로드 처리할 서버 URL을 지시합니다.
		// 서버 사이드 스크립트가 JSP 이라면 ./export/export.jsp 로 변환해 주십시오.
		// 스프링 또는 MVC 프레임워크로 프로젝트가 구축된 경우 해당 폴더의 export.jsp 파일을 참고하여 작성하십시오.
		AUIGrid.setProperty(myGridID, "exportURL", "/auiPDF");
		// 내보내기 실행
		AUIGrid.exportToPdf(myGridID, {
		// 폰트 경로 지정 (필수)
			fontPath : "/resources/pdfkit/jejugothic-regular.ttf"
		});
	};
	
	// APACHE의 POI 라이브러리를 이용해서 다운로드 할 경우 추가합니다. 제 블로그를 참고하시면 방법이 나옵니다.
	function exportToExcelFromServer() {
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "Post");  //Post 방식
		form.setAttribute("action", "요청을 보낼 주소"); //요청 보낼 주소
		
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "page");
		hiddenField.setAttribute("value", "다운로드할 때 데이터 선정을 위해 필요한 데이터를 같이 보낼 수 있습니다.");
		form.appendChild(hiddenField);
		
		
		/* search KeyWord 등의 검색 조건을 필요로 하는 경우 추가한다. */
		/* hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "mEmail");
		hiddenField.setAttribute("value", mEmail);
		form.appendChild(hiddenField);  */
		
		
		document.body.appendChild(form);
		form.submit();
	}
	
	
	/* 구현하기 */
	function exportToLocal() {
		// 로컬 다운로드 가능 여부
		if(AUIGrid.isAvailableLocalDownload(myGridID)) {
			// 로컬에서 바로 내보내기 실행
			AUIGrid.exportToXlsx(myGridID);
		} else {
			// HTML5를 완전히 지원하지 않는 브라우저는 서버로 전송하여, 다운로드 처리
			//exportToServer();
			exportToServer();
		}
	};
	
	function exportToServer() {
		// 그리드가 작성한 엑셀, CSV 등의 데이터를 다운로드 처리할 서버 URL을 지시합니다.
		// 정품 및 평가판 압축 해제 후, export_server_samples 폴더 안에 PHP, JSP, ASP, ASP.NET 용 소스가 존재함
		AUIGrid.setProp(myGridID, "exportURL", "/auiEXCEL");
 
		// 내보내기 실행
		AUIGrid.exportToXlsx(myGridID, {
			// 지정된 exportURL (./server_script/export.php) 로 내보내기 합니다.
			// postToServer 를 true 설정하지 않은 경우, 기본적으로 로컬 다운로딩 처리됩니다.
			"postToServer" : true
		});
	}; 
</script>
 
	
</body>
</html>