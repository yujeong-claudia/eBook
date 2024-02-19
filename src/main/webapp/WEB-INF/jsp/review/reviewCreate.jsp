<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="w-50">
		<h1>리뷰 작성</h1>
		
		<input type="text" id="bookId" class="form-control mt-4" placeholder="bookId를 입력하세요">		
		<input type="text" id="subject" class="form-control" placeholder="제목을 입력하세요">
		<textarea id="content" class="form-control" placeholder="내용을 입력하세요" rows="10"></textarea>
	
		<div class="d-flex justify-content-between mt-4">
			<button type="button" id="reviewListBtn" class="form-control col-2 btn-dark">뒤로가기</button>		
			<button type="button" id="clearBtn"  class="form-control col-2 btn-secondary">모두지우기</button>		
			<button type="button" id="saveBtn"  class="form-control col-2 btn-dark">등록하기</button>		
		</div>
	</div>
</div>	
<script>
	$(document).ready(function() {
		// 뒤로가기 버튼을 클릭 했을 때 => 리뷰 목록 페이지로 이동
		$("#reviewListBtn").on('click', function() {
			//alert("뒤로 가기");
			location.href = "/review/review-list-view";
		});
		// 모두 지우기 버튼을 클릭 했을 때
		$("#clearBtn").on('click', function(){
			//alert("모두 지우기");
			$("#bookId").val("");
			$("#subject").val("");
			$("#content").val("");
		});
		// 등록하기 버튼을 클릭 했을 때
		$("#saveBtn").on('click', function(){
			//alert("등록하기");
			let bookId = $("#bookId").val().trim();
			let subject = $("#subject").val().trim();
			let content = $("#content").val();
			
			// validation check
			if (!bookId) {
				alert("북아이디를 입력해주세요");
				return;
			}
			if (!subject) {
				alert("제목을 입력해주세요");
				return;
			}
			if (!content) {
				alert("내용을 입력해주세요");
				return;
			}
			
			$.ajax({
				//request
				type:"post"
				, url:"/review/create"
				, data: {"bookId":bookId, "subject":subject, "content":content}
				
				//response - CALL BACK 함수
				, success:function(data){
					if(data.code == 200) {
						alert("리뷰가 등록되었습니다.");
						location.href="/review/review-list-view"
					} else {
						alert(data.error_message);
					}
				}
				, error:function(request, status, error) {
					alert("리뷰를 등록하는데 실패했습니다.")
				}
			}); 
		});
	});
</script>