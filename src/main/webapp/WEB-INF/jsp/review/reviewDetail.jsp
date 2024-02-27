<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="review-detail-box">
		
		<input type="text" id="subject" class="form-control" placeholder="제목을 입력하세요" value="${review.subject}">
		<textarea id="content" class="form-control" placeholder="불법적인 내용, 타인에게 불쾌감을 주는 논쟁을 유발하는 내용, 스포일러 등은 &#10;운영정책에 의해 사전고지 없이 처리될 수 있습니다." rows="10">${review.content}</textarea>
	
		<div class="d-flex justify-content-between mt-4">
			<button type="button" id="reviewListBtn" class="form-control col-2 btn-dark">뒤로가기</button>		
			
			<%-- 로그인 된 사람과 글쓴이 정보가 일치할 때 노출 --%>
			<%-- <c:if test="${userId eq review.userId}">--%>
			<button type="button" id="saveBtn" class="btn btn-secondary" data-review-id="${review.id}">수정</button>
			<button type="button" id="deleteBtn" class="btn btn-dark" data-review-id="${review.id}">삭제</button>
			<%--</c:if>--%>
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
		
		// 리뷰 수정 버튼
		$("#saveBtn").on('click', function() {
			//alert("수정하기");
			let reviewId = $(this).data("review-id");
			let subject = $("#subject").val().trim();
			let content = $("#content").val();
			
			// validation
			if (!subject) {
				alert("제목을 입력하세요.");
				return;
			}
			
			if (!content) {
				alert("내용을 입력하세요.");
				return;
			}
			
			$.ajax({
				//request
				type:"PUT"
				, url:"/review/update"
				, data: {"reviewId":reviewId, "subject":subject, "content":content}
				
				//response - CALL BACK 함수
				, success:function(data){
					if(data.code == 200) {
						alert("리뷰가 수정되었습니다.");
						location.reload();
					} else {
						alert(data.error_message);
					}
				}
				, error:function(request, status, error) {
					alert("리뷰를 수정하는데 실패했습니다.")
				}
			});
			
		});
	});
</script>