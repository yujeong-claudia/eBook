<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="review-detail-box">
		<h1 class="mb-3">리뷰</h1>
		
		<input type="text" id="subject" class="form-control" placeholder="제목을 입력하세요" value="${review.subject}">
		<textarea id="content" class="form-control" placeholder="불법적인 내용, 타인에게 불쾌감을 주는 논쟁을 유발하는 내용, 스포일러 등은 &#10;운영정책에 의해 사전고지 없이 처리될 수 있습니다." rows="10">${review.content}</textarea>
	
		<div class="d-flex justify-content-between mt-4">
			<button type="button" id="reviewListBtn" class="form-control col-2 btn-dark">뒤로가기</button>		
			<button type="button" id="saveBtn"  class="form-control col-2 btn-secondary">수정</button>		
			<button type="button" id="deleteBtn"  class="form-control col-2 btn-dark mb-5">삭제</button>		
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#reviewListBtn").on('click', function() {
			//alert("뒤로 가기");
			// 뒤로 가기를 눌렀을 때 => 리뷰목록 화면으로 이동
			location.href = "/review/review-list-view?bookId=${review.bookId}"
		});
	});
</script>