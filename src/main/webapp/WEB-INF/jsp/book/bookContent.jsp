<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex justify-content-center">    
	<div class="book-content-box mt-5">
		<div class="block">
			${bookContent.content}
		</div>
		<div class="d-flex justify-content-between mt-3">
			<a href="/book/book-detail-view?bookName=${book.bookName}" class="btn btn-dark">뒤로 가기</a>
			<a href="/review/review-list-view" class="btn btn-dark">리뷰</a>
		</div>
	</div>
</div>		    
