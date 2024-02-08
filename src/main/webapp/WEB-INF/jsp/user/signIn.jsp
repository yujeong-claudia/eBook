<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="sign-in-box">
		<h1 class="mb-4 font-weight-bold">로그인</h1>
		<form id="signInForm" method="post" action="/user/sign-in">
			<div class="input-group mb-3">
				<%-- input-group-prepend: input box 앞에 ID 부분을 회색으로 붙인다. --%>
				<div class="input-group-prepend">
					<span class="input-group-text">ID</span>
				</div>
				<input type="text" class="form-control" id="loginId" name="loginId">
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">PW</span>
				</div>
				<input type="password" class="form-control" id="password" name="password">
			</div>
			<%-- btn-block: 로그인 박스 영역에 버튼을 가득 채운다. --%>
			<input type="submit" id="loginBtn" class="btn btn-block btn-success" value="로그인">
			<a class="btn btn-block btn-dark" href="/user/sign-up-view">회원가입</a>
		</form>
	</div>
</div>
<script>
	$(document).ready(function() {
		
		$("#signInForm").on('submit', function(e) {
			e.preventDefault();
			
			//alert("로그인 버튼 클릭");
			
			//validation check
			let loginId = $("#loginId").val().trim(); 
			let password = $("#password").val().trim(); 
			
			if (!loginId) {
				alert("아이디를 입력해주세요.");
				return false;
			}
			if (!password) {
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			//AJAX: 화면 이동 되지 않음(콜백함수에서 이동) 응답값 JSON
			let url = $(this).attr('action');
			console.log(url); // 지금 보내는 주소
			let params = $(this).serialize(); // 폼태그에 있는 name 속성과 값으로 파라미터를 구성
			console.log(params);
			
			$.post(url, params) // request
			.done(function(data) { // response
				if (data.result == "성공") {
					location.href = "/bookSearch/bookSearch-view";
				} else {
					alert(data.error_message)
				}
			});
			
		});
	});
	
</script>