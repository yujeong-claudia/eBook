<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<div class="d-flex justify-content-center">    
	<div class="book-detail-box mt-5">
		<c:forEach items="${bookViewList}" var="bookView">
		<div class="d-flex border border-success">
			<%-- 책 표지 --%>
			<div class="mr-3 mt-3 mb-3 ml-3">
				<img src="${bookView.book.bookCoverPath}">
			</div>
			
			<%-- 세부 내용 --%>
			<div class="mt-3">
				<div class="d-flex justify-content-center">
					<div class="title font-weight-bold mr-3">${bookView.book.bookName}</div>
					<c:if test="${bookView.filledLike eq false}">
					<a href="#" class="like-btn mr-3" data-book-id="${bookView.book.id}">
						<img src="/static/img/empty.png" width="50" height="45" alt="empty heart">
					</a>
					</c:if>
					<c:if test="${bookView.filledLike eq true}">
					<a href="#" class="like-btn mr-3" data-book-id="${bookView.book.id}">
						<img src="/static/img/filled.png" width="50" height="45" alt="filled heart">
					</a>
					</c:if>
				</div>
				<div class="font-weight-bold text-success mt-2">${bookView.book.author}</div>
				<div class="d-flex mt-3 mb-3 text-secondary">
					<div class="text-dark">
						장르 <br> 페이지수 <br> 출판사
					</div>
					<div class="ml-4">
						${bookView.book.genre} <br>
						${bookView.book.page}p <br> 
						${bookView.book.publisher}
					</div>
				</div>
			</div>
		</div>
		<div>
			<a href="/book/book-content-view?bookId=${bookView.book.id}" class="readBtn btn btn-dark w-100 mt-3">전자책 보기</a>
		</div>
		<a href="/review/review-list-view?bookId=${bookView.book.id}" class="readReview btn btn-secondary w-100 mt-2">리뷰 보러가기</a>
		</c:forEach>
	</div>
</div>
<script>
	$(document).ready(function() {
		// 좋아요 토글
		$(".like-btn").on('click', function(e) {
			e.preventDefault();
			//alert("좋아요"); 
			
			let bookId = $(this).data("book-id");
			//alert(bookId)
			
			$.ajax({
				url:"/like/" + bookId
				, success:function(data) {
					if (data.code == 200) {
						// 성공
						//alert("좋아요!")
						location.reload(true); // 새로고침 => bookDetail화면
					} else if (data.code == 300) {
						// 비로그인 시 로그인 페이지로 이동
						alert(data.error_message);
						location.href = "/user/sign-in-view";
					}
				}
				, error:function(request, status, error) {
					alert("좋아요를 하는데 실패했습니다.");
				}				
			});
		});
	});
</script>