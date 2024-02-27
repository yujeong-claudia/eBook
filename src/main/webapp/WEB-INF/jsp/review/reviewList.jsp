<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex justify-content-center">
	<div class="review-list-box">
		<table class="table text-center mt-5">
				<%-- 리뷰영역 --%>
			<c:if test="${empty reviewList}">
				<div class="text-center text-secondary">
					아직 작성된 리뷰가 없습니다.<br>다른 분들께 도움이 될 수 있도록<br>리뷰를 남겨주세요.
				</div>
			</c:if>
			<c:if test="${not empty reviewList}">
			<thead>
				<tr>
					<th>No.</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${reviewList}" var="review">
						<tr>
							<td><a
								href="/review/review-detail-view?reviewId=${review.id}">${review.id}</a></td>
							<td><a
								href="/review/review-detail-view?reviewId=${review.id}">${review.subject}</a></td>
						</tr>
					</c:forEach>
			</tbody>
			</c:if>
		</table>
		<div class="d-flex justify-content-between mt-5">
			<a href="/book/book-detail-view?bookName=${book.bookName}"
				class="btn btn-dark text-white">뒤로가기</a> <a
				href="/bookSearch/bookSearch-view"
				class="btn btn-secondary text-white">검색목록</a> <a
				href="/review/review-create-view?bookId=${book.id}"
				class="btn btn-dark text-white">리뷰작성</a>
		</div>
	</div>
</div>