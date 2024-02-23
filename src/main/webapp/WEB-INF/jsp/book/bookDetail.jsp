<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<div class="d-flex justify-content-center">    
	<div class="book-detail-box mt-5">
		<c:forEach items="${bookList}" var="book">
		<div class="d-flex border border-success">
			<%-- 책 표지 --%>
			<div class="mr-3 mt-3 mb-3 ml-3">
				<img src="${book.bookCoverPath}">
			</div>
			
			<%-- 세부 내용 --%>
			<div class="mt-3">
				<div class="d-flex justify-content-center">
					<div class="title font-weight-bold mr-3">${book.bookName}</div>
					<a href="#" class="like-btn mt-2 mr-3">
						<img src="https://www.iconninja.com/files/214/518/441/heart-icon.png" width="30" height="30" alt="empty heart">
					</a>
				</div>
				<div class="font-weight-bold text-success mt-2">${book.author}</div>
				<div class="d-flex mt-3 mb-3 text-secondary">
					<div class="text-dark">
						장르 <br> 페이지수 <br> 출판사
					</div>
					<div class="ml-4">
						${book.genre} <br>
						${book.page}p <br> 
						${book.publisher}
					</div>
				</div>
			</div>
		</div>
		<div>
			<a href="/book/book-content-view?bookId=${book.id}" class="readBtn btn btn-dark w-100 mt-3">전자책 보기</a>
		</div>
		<a href="/review/review-list-view?bookId=${book.id}" class="readReview btn btn-secondary w-100 mt-2">리뷰 보러가기</a>
		</c:forEach>
	</div>
</div>
<script>
	$(document).ready(function() {
		// 좋아요 토글
		$(".like-btn").on('click', function(e) {
			e.preventDefault();
			alert("좋아요");
		}
	}
</script>