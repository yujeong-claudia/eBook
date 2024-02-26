<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="review-create-box">
		<h1 class="mb-3">리뷰 작성</h1>
		
		<input type="text" id="subject" class="form-control" placeholder="제목을 입력하세요">
		<textarea id="content" class="form-control" placeholder="불법적인 내용, 타인에게 불쾌감을 주는 논쟁을 유발하는 내용, 스포일러 등은 &#10;운영정책에 의해 사전고지 없이 처리될 수 있습니다." rows="10"></textarea>
	
		<div class="d-flex justify-content-between mt-4">
			<button type="button" id="reviewListBtn" class="form-control col-2 btn-dark">뒤로가기</button>		
			<button type="button" id="clearBtn"  class="form-control col-3 btn-secondary">모두지우기</button>		
			<button type="button" id="saveBtn"  class="form-control col-2 btn-dark mb-5" data-book-id="${bookId}">등록하기</button>		
		</div>
		
		<div class="spoiler-checkbox">
			<input type="checkbox" id="spoiler" name="spoiler" value="스포일러가 포함되어있을시 체크해주세요"> 스포일러가 포함되어있을시 체크해주세요
		</div>
	</div>
</div>	
<script>
	$(document).ready(function() {
		
		// 체크박스
		$("input:checkbox[id='spoiler']").prop("checked", true); // 체크박스 선택
		$("input:checkbox[id='spoiler']").prop("checked", false); // 체크박스 해제
		
		// 뒤로가기 버튼을 클릭 했을 때 => 리뷰 목록 페이지로 이동
		$("#reviewListBtn").on('click', function() {
			//alert("뒤로 가기");
			location.href = "/review/review-list-view?bookId=${bookId}"
		});
		// 모두 지우기 버튼을 클릭 했을 때
		$("#clearBtn").on('click', function(){
			//alert("모두 지우기");
			$("#subject").val("");
			$("#content").val("");
		});
		// 등록하기 버튼을 클릭 했을 때
		$("#saveBtn").on('click', function(){
			//alert("등록하기");
			let bookId =  $(this).data("book-id");
			let subject = $("#subject").val().trim();
			let content = $("#content").val();
			
			// validation check
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
						location.href="/review/review-list-view?bookId=" + bookId
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