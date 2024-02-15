<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 화면</title>

<%-- bootstrap --%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<%-- 내가 만든 스타일시트 --%>
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<body>
	<div id="wrap">
		<header>
			<div class="d-flex justiyif-content-center">
				<img src="/static/img/eBook.jpg" alt="logo" width="330" height="100">
			</div>
		</header>
		<section class="d-flex justify-content-center">
			<div class="book-content-box my-5">
				<h1>책 등록</h1>
	
				<input type="text" id="bookName" class="form-control mt-4" placeholder="책 제목"> 
				<input type="text" id="author" class="form-control" placeholder="저자"> 
				<input type="text" id="publisher" class="form-control" placeholder="출판사">
				<div class="d-flex">
					<input type="text" id="genre" class="form-control col-6" placeholder="장르"> 
					<input type="text" id="page" class="form-control col-6" placeholder="페이지 수 (숫자만 입력가능)">
				</div>
				<textarea id="content" class="form-control" placeholder="책 내용" rows="20"></textarea>
	
				<div class="d-flex justify-content-between mt-3">
					<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
					<div>
						<button type="button" id="clearBtn" class="btn btn-secondary">모두 지우기</button>
						<button type="button" id="saveBtn" class="btn btn-dark">등록</button>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script>
		$(document).ready(function(){
			// 모두 지우기 버튼을 클릭했을 때
			$("#clearBtn").on('click', function(){
				//alert("모두 지우기");
				$("#bookName").val("");
				$("#author").val("");
				$("#publisher").val("");
				$("#genre").val("");
				$("#page").val("");
				$("#content").val("");
			});
			// 등록 버튼을 클릭 했을 때
			$("#saveBtn").on('click', function(){
				//alert("등록");
				let bookName = $("#bookName").val();
				let author = $("#author").val();
				let publisher = $("#publisher").val();
				let genre = $("#genre").val();
				let page = $("#page").val().trim();
				let content = $("#content").val();
				let fileName = $("#file").val();
				//alert(fileName); //C:\fakepath\book_1.jpg
				
				// validation check
				if (!bookName) {
					alert("책 제목을 입력해주세요");
					return;
				}
				if (!author) {
					alert("저자를 입력해주세요");
					return;
				}
				if (!publisher) {
					alert("출판사를 입력해주세요");
					return;
				}
				if (!genre) {
					alert("장르를 입력해주세요");
					return;
				}
				if (!page) {
					alert("페이지수를 입력해주세요");
					return;
				}
				if (isNaN(page)) { // 숫자가 아닐 때 참
					alert("페이지수는 숫자만 입력가능합니다.");
					return;
				}
				if (!content) {
					alert("책 내용을 입력해주세요");
					return;
				}
				// 파일 역시 필수값이다.
				if (!fileName) {
					alert("책 표지를 등록해주세요");
					return;
				}
				// 확장자만 뽑은 후 소문자로 변경해서 검사한다.
				if (fileName) {
					let extension = fileName.split(".").pop().toLowerCase();
					//alert(extension);
				
					if ($.inArray(extension, ['jpg', 'png', 'gif', 'jpeg']) == -1) {
						alert("이미지 파일만 업로드 할 수 있습니다.");
						$("#file").val(""); // 파일을 비운다.
						return;
					}
				}
				
				// form 태그를 js를 만든다.
				// 이미지를 업로드 할 때는 반드시 frm 태그가 있어야 한다.
				let formData = new FormData();
				formData.append("bookName", bookName); // key는 name속성, Request parameter
				formData.append("author", author);
				formData.append("publisher", publisher);
				formData.append("genre", genre);
				formData.append("page", page);
				formData.append("content", content);
				formData.append("file", $("#file")[0].files[0]);
				
				// AJAX
				$.ajax({
					//request
					type:"post"
					, url:"/admin/create"
					, data:formData
					, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
					, processData:false // 파일 업로드를 위한 필수 설정
					, contentType:false // 파일 업로드를 위한 필수 설정
					
					//response
					, success:function(data) {
						if(data.code == 200) {
							alert("책이 등록되었습니다.");
							location.reload();
						} else {
							alert(data.error_message);
						}
					}
					, error: function(request, status, error) {
						alert("책을 등록하는데 실패했습니다.");
					}
				});
			});
		});
	</script>
</body>
</html>