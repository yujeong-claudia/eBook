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
									<a href="/review/review-detail-view?reviewId=${review.id}" class="text-danger font-weight-bold" data-toggle="modal" data-target="#modal">${review.subject}</a>
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
			<a href="/book/book-detail-view?bookName=${book.bookName}" class="btn btn-dark text-white">뒤로가기</a> 
			<a href="/bookSearch/bookSearch-view" class="btn btn-secondary text-white">검색목록</a> 
			<a href="/review/review-create-view?bookId=${book.id}" class="btn btn-dark text-white">리뷰작성</a>
		</div>
	</div>
</div>

<!-- Modal
<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  	<%-- 
  		modal-sm: 작은 모달창 
  		modal-dialog-centered: 수직 기준 가운데 위치
  	--%>
  	<div class="modal-dialog modal-sm modal-dialog-centered">
    	<div class="modal-content text-center">
    		<div class="py-3 border-bottom">
				<a href="/review/review-create-view?bookId=${book.id}" id="review">리뷰작성</a>      
    		</div>
    		<div class="py-3">
				<a href="location.reload()" data-dismiss="modal">취소하기</a>      
    		</div>
    	</div>
  	</div>
</div>
-->

<div class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">리뷰 스포일러</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>스포일러가 담긴 내용입니다.<br> 내용을 보시겠습니까?</p>
      </div>
      <div class="modal-footer d-flex">
        	<div class="py-3 border-bottom">
				<a href="/review/review-create-view?bookId=${book.id}" id="review">네</a>      
    		</div>
    		<div class="py-3">
				<a href="location.reload()" data-dismiss="modal">아니요</a>      
    		</div>
      </div>
    </div>
  </div>
</div>
