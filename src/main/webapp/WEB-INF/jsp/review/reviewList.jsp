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
					<th>리뷰 목록</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${reviewList}" var="review">
						<tr>
							<td>
							<c:choose>
								<%-- 제목이 스포일러라면 빨간색으로 처리한다 --%>
								<c:when test="${review.subject eq '[스포일러]'}">
									<a href="/review/review-detail-view?reviewId=${review.id}" class="text-danger font-weight-bold">${review.subject}</a>
								</c:when>
								<%-- 조건이 없다면 그냥 나오게 한다 --%>
								<c:otherwise>
									<a href="/review/review-detail-view?reviewId=${review.id}">${review.subject}</a>
								</c:otherwise>
								
							</c:choose>
							</td>
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