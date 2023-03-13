<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
   <link href="${path}/resources/css/join.css" rel="stylesheet" type="text/css">
    <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>로그인</title>

</head>
<body>
<div class="container" style="text-align: -webkit-center;">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h2 class="mb-3">회원가입</h2>
        <form class="validation-form" novalidate>
        
         <div class="row" style="display:block;">
            <div class="col-md-6 mb-3" style="float:none;">
              <label for="name" style="float:left;">이름</label>
              <input type="text" class="form-control" id="name" placeholder="" value="" required>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3"style="float:none;">
              <label for="" style="float:left;">아이디</label>
              <input type="text" class="form-control" id="name" placeholder="" value="" required>
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3" style="float:none;">
              <label for="name" style="float:left;">비밀번호</label>
              <input type="password" class="form-control" id="name" placeholder="" value="" required>
              <div class="invalid-feedback">
                비밀번호를 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3" style="float:none;">
              <label for="name" style="float:left;">비밀번호 확인</label>
              <input type="password" class="form-control" id="name" placeholder="" value="" required>
              <div class="invalid-feedback">
                비밀번호를 입력해주세요.
              </div>
            </div>
          <div class="col-md-6 mb-3" style="float:none;">
            <label for="email" style="float:left;">이메일</label>
            <input type="email" class="form-control" id="email" placeholder="you@example.com" required>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>

          <div class="col-md-6 mb-3" style="float:none;">
            <label for="address" style="float:left;">주소</label>
            <input type="text" class="form-control" id="address" placeholder="서울특별시 강남구" required>
            <div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>

          <div class="col-md-6 mb-3" style="float:none;">
            <label for="address2" style="float:left;">상세주소<span class="text-muted">&nbsp;(필수)</span></label>
            <input type="text" class="form-control" style="width:540px;" id="address2" placeholder="상세주소를 입력해주세요.">
          </div>
			</div>
          <hr class="mb-4" >
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit" style="width:300px;">가입 완료</button>
        </form>
      </div>
    </div>
  </div>
  <script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
</body>  
</html>