<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<style>
	.confirm-text {
		color: red;
	}
</style>
<body>
	<form action="join" method="post" class="join-form">
		<div>
			<input type="text" name="mbrId" placeholder ="아이디">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div>
			<div>
				<input type="password" name="mbrPw" placeholder ="비밀번호">
				<div>
					<span class="confirm-text"></span>
				</div>
			</div>
			<div>
				<input type="password" id="mbrPwConfirm" placeholder ="비밀번호 확인">
				<div>
					<span class="confirm-text"></span>
				</div>
			</div>
		</div>
		<div>
			<input type="text" name="mbrNm" placeholder ="이름">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div>
			<input type="text" name="mbrMblTelno" placeholder ="휴대폰번호">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div>
			<input type="text" name="mbrHomeAddr" placeholder ="주소">
			<div>
				<span class="confirm-text"></span>
			</div>
			<input type="text" name="mbrHomeDaddr" placeholder ="상세주소">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div>
			<input type="date" name="mbrBrdt">
		</div>
		<div>
			<button id="submit-btn" type="submit">가입하기</button>
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
	</form>
	
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
$(function(){
	var validChecking = {
			mbrIdValid: false,
			mbrPwValid: false,
			mbrPwConfirmValid: false,
			mbrNmValid: false,
			mbrMblTelnoValid: false,
			mbrHomeAddrValid: false,
			mbrHomeDaddrValid: false,
			mbrBrdtValid: false,
			mbrPwRegex: /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[a-zA-Z0-9!@#$]{8,20}$/,
            mbrMblTelnoRegex: /^010\d{8}$/,
			
			isAllValid: function () {
				return this.mbrIdValid && this.mbrPwValid && this.mbrPwConfirmValid && this.mbrNmValid && this.mbrMblTelnoValid
						&& this.mbrHomeAddrValid && this.mbrHomeDaddrValid && this.mbrBrdtValid;
			}
			
	};
	
	/* 아이디 중복 검사 */
	$("[name=mbrId]").on("blur",function(){
		var mbrId = $(this).val();
		//console.log(mbrId); //확인 완료
		$.ajax({
				url: "${pageContext.request.contextPath}/rest/member/check-id",
				method: "POST",
				data: {mbrId:mbrId},
				success: function(resp) {
					//console.log("결과: "+resp); //확인 완료
					if(resp == "Y") {
						$("[name=mbrId]").siblings("div").find(".confirm-text").text("이미 존재하는 아이디입니다.");
						validChecking.mbrIdValid = false;
					}
					else {
						$("[name=mbrId]").siblings("div").find(".confirm-text").text("");
						validChecking.mbrIdValid = true;
					}
					
				}
			});//ajax end
	});//아이디 중복검사 end
	
	
	/* 비밀번호 정규표현식 검사 */
	$("[name=mbrPw]").on("blur", function(){
		var mbrPw = $(this).val();
		var regex = validChecking.mbrPwRegex;
		if(regex.test(mbrPw)) {
			$(this).siblings("div").find(".confirm-text").text("사용가능한 비밀번호입니다").css("color","green");
			validChecking.mbrPwValid = true;
		}
		else {
			$(this).siblings("div").find(".confirm-text").text("영어+숫자+특수문자를 포함해 8~20자 내로 작성해주세요").css("color","red");
			validChecking.mbrPwValid = false;
		}
	}); //비밀번호 정규표현식 검사 end
	
	
	/* 비밀번호 화인 */
	$("#mbrPwConfirm").on("blur", function(){
		var mbrPwConfirm = $(this).val();
		var mbrPw = $("[name=mbrPw]").val();
		
		if(mbrPw == mbrPwConfirm) {
			$(this).siblings("div").find(".confirm-text").text("비밀번호가 일치합니다").css("color","green");
			validChecking.mbrPwConfirmValid = true;
		}
		else {
			$(this).siblings("div").find(".confirm-text").text("비밀번호가 일치하지 않습니다").css("color","red");
			validChecking.mbrPwConfirmValid = false;
		}
	});//비밀번호 확인 end
	
	
	/* 이름 입력 확인 */
	$("[name=mbrNm]").on("blur", function(){
		var mbrNm = $(this).val();
		if(mbrNm.length > 1) {
			$(this).siblings("div").find(".confirm-text").text("");
			validChecking.mbrNmValid = true;
		}
		else {
			$(this).siblings("div").find(".confirm-text").text("올바른 이름을 입력해주세요").css("color","red");
			validChecking.mbrNmValid = false;
		}
	});//이름 입력 확인 end
	
	
	/* 휴대폰번호 확인 */
	$("[name=mbrMblTelno]").on("blur", function(){
		var mbrMblTelno = $(this).val();
		var regex = validChecking.mbrMblTelnoRegex;
		if(regex.test(mbrMblTelno)) {
			$.ajax({
				url: "${pageContext.request.contextPath}/rest/member/check-telno",
				method: "POST",
				data: {mbrMblTelno:mbrMblTelno},
				success: function(resp) {
					if(resp == "Y"){
						$("[name=mbrMblTelno]").siblings("div").find(".confirm-text").text("이미 존재하는 휴대전화번호입니다.").css("color","red");
						validChecking.mbrMblTelnoValid = false;
					}
					else {
						$("[name=mbrMblTelno]").siblings("div").find(".confirm-text").text("");
						validChecking.mbrMblTelnoValid = true;
					}
				}
			});//ajax end
		}
	});
	
	
	/* 주소 입력 확인 */
	$("[name=mbrHomeAddr]").on("blur", function(){
		var mbrHomeAddr = $(this).val();
		if(mbrHomeAddr.length > 0){
			validChecking.mbrHomeAddrValid = true;
		}
		else {
			validChecking.mbrHomeAddrValid = false;
		}
	});//주소 입력 확인 end
	
	
	/* 상세주소 입력 확인 */
	$("[name=mbrHomeDaddr]").on("blur", function(){
		var mbrHomeDaddr = $(this).val();
		if(mbrHomeDaddr.length > 0){
			validChecking.mbrHomeDaddrValid = true;
		}
		else {
			validChecking.mbrHomeDaddrValid = false;
		}
	});// 상세주소 입력 확인 end
	
	
	/* 생년월일 입력 확인 */
	$("[name=mbrBrdt]").on("blur", function() {
		var mbrBrdt = $(this).val();
		if(mbrBrdt.length > 0){
			validChecking.mbrBrdtValid = true;
		}
		else{
			validChecking.mbrBrdtValid = false;
		}
	});//생년월일 입력 확인 end
	
	$(".join-form").submit(function(e) {
		e.preventDefault();
		
		if(validChecking.isAllValid()) {
			this.submit();
		}
		else{
			$("#submit-btn").siblings("div").find(".confirm-text").text("입력사항을 모두 입력해주세요.").css("color","red");
		}
		
	})//join-form submit end
	
	
})
</script>
</body>
</html>