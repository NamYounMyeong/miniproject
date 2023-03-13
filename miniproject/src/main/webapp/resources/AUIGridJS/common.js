// onload 
window.onload = function() {
	try{
		documentReady();
	} catch(e) {}
};

//데이터 요청
function requestData(url) {

	// ajax 요청 전 그리드에 로더 표시
	AUIGrid.showAjaxLoader(myGridID);
	
	// ajax (XMLHttpRequest) 로 그리드 데이터 요청
	ajax({
		url : url,
		onSuccess : function(data) {
			
			//console.log(data);
			
			// 그리드에 데이터 세팅
			// data 는 JSON 을 파싱한 Array-Object 입니다.
			AUIGrid.setGridData(myGridID, data);

			// 로더 제거
			AUIGrid.removeAjaxLoader(myGridID);
		},
		onError : function(status, e) {
			alert("데이터 요청에 실패하였습니다.\r\n status : " + status + "\r\nWAS 를 IIS 로 사용하는 경우 json 확장자가 web.config 의 handler 에 등록되었는지 확인하십시오.");
			// 로더 제거
			AUIGrid.removeAjaxLoader(myGridID);
		}
	});
};


function changeLocation(href) {
	location.href = href;
};