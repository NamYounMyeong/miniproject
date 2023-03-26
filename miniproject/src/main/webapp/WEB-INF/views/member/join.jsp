<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/join.css">
<body>
<div class="container-500">
	<form action="join" method="post" class="join-form">
		<div class="row">
			<input class="join-input w-100" type="text" name="mbrId" placeholder ="아이디">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div class="row">
			<div>
				<input class="join-input w-100" type="password" name="mbrPw" placeholder ="비밀번호">
				<div>
					<span class="confirm-text"></span>
				</div>
			</div>
			<div class="row">
				<input class="join-input w-100" type="password" id="mbrPwConfirm" placeholder ="비밀번호 확인">
				<div>
					<span class="confirm-text"></span>
				</div>
			</div>
		</div>
		<div class="row">
			<input class="join-input w-100" type="text" name="mbrNm" placeholder ="이름">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div class="row">
			<input class="join-input w-100" type="text" name="mbrMblTelno" placeholder ="휴대폰번호">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div class="row">
			<input class="join-input w-100" type="text" name="mbrHomeAddr" placeholder ="주소">
			<div>
				<span class="confirm-text"></span>
			</div>
			<input class="join-input w-100" type="text" name="mbrHomeDaddr" placeholder ="상세주소">
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
		<div class="row">
			<label for="mbrBrdt">생년월일</label>
			<input class="join-input w-100" id="mbrBrdt" type="date" name="mbrBrdt">
<%-- 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
		</div>
		<div class="join-btn-box">
			<button class="w-100" id="submit-btn" type="submit">가입하기</button>
			<div>
				<span class="confirm-text"></span>
			</div>
		</div>
	</form>
</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
	var root = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/resources/js/join.js"></script>
</body>
</html>