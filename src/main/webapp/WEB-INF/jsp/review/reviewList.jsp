<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex justify-content-center">
	<div class="review-list-box">
		<h1>리뷰 목록</h1>
		<table class="table text-center mt-3">
			<thead>
				<tr>
					<th>No.</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<c:forEach items="${reviewList}" var="review">
					<td><a href="${review.id}">${review.id}</a></td>
					<td><a href="${review.subject}">${review.subject}</a></td>
				</c:forEach>
				</tr>
			</tbody>
		</table>
		<div class="d-flex justify-content-between mt-5">
			<a href="/book/book-detail-view?bookName=${book.bookName}" class="btn btn-dark text-white">뒤로가기</a>
			<a href="/bookSearch/bookSearch-view" class="btn btn-secondary text-white">검색목록</a>
			<a href="/review/review-create-view" class="btn btn-dark text-white">리뷰작성</a>
		</div>
	</div>
</div>