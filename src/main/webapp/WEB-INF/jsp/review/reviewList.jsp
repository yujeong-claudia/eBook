<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex justify-content-center">
	<div class="w-50">
		<h1>리뷰 목록</h1>
		<table class="table text-center mt-3">
			<thead>
				<tr>
					<th>No.</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reviewList}" var="review">
				<tr>
					<td>${review.bookId}</td>
					<td>${review.subject}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="d-flex justify-content-between mt-5">
			<a href="/book/book-detail-view" class="btn btn-dark text-white">뒤로가기</a>
			<a href="/bookSearch/bookSearch-view" class="btn btn-secondary text-white">검색목록</a>
			<a href="/review/review-create-view" class="btn btn-dark text-white">리뷰작성</a>
		</div>
	</div>
</div>