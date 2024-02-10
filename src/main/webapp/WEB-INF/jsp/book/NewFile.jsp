<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 화면</title>

<%-- bootstrap --%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>

<%-- 내가 만든 스타일시트 --%>
<link rel="stylesheet" type="text/css" href="/static/css/style.css">


</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
</head>
<body>
	<div class="d-flex justify-content-center">
		<div class="w-50">
			<h1>관리자 화면</h1>

			<input type="text" id="bookName" class="form-control mt-4"
				placeholder="책 제목"> <input type="text" id="author"
				class="form-control" placeholder="저자"> <input type="text"
				id="publisher" class="form-control" placeholder="출판사">
			<div class="d-flex">
				<input type="text" id="genre" class="form-control col-6"
					placeholder="장르"> <input type="text" id="page"
					class="form-control col-6" placeholder="페이지 수">
			</div>
			<textarea id="content" class="form-control" placeholder="책 내용"
				rows="30"></textarea>

			<div class="d-flex justify-content-between mt-4">
				<button type="button" id="file"
					class="form-control col-2 reviewListBtn btn-dark text-white">파일</button>
				<button type="button"
					class="form-control col-2 clearBtn btn-secondary text-white">모두지우기</button>
				<button type="button"
					class="form-control col-2 saveBtn btn-dark text-white">저장하기</button>
			</div>
		</div>
	</div>
</body>
</html>