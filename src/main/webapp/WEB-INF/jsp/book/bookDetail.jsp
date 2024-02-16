<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">    
	<div class="book-detail-box mt-5">
		<div class="d-flex border border-success">
			<%-- 책 표지 --%>
			<div class="mr-3 mt-3 mb-3 ml-3">
				<img src="/static/img/test.jpg" alt="책표지">
			</div>
			
			<%-- 세부 내용 --%>
			<div class="mt-3">
				<div class="d-flex justify-content-center">
					<div class="title font-weight-bold mr-3">구의 증명</div>
					<img src="https://www.iconninja.com/files/214/518/441/heart-icon.png" class="mt-2 mr-3" width="30" height="30" alt="empty heart">
				</div>
				<div class="font-weight-bold text-success mt-2">최진영</div>
				<div class="d-flex mt-3 mb-3 text-secondary">
					<div class="text-dark">
						장르 <br> 페이지수 <br> 출판사
					</div>
					<div class="ml-4">
						소설 <br>
						180p <br> 
						은행나무
					</div>
				</div>
			</div>
		</div>
		
		<a href="/book/book-content-view" class="readBtn btn btn-dark w-100 mt-3">전자책 보기</a>
		<a href="/review/review-list-view" class="readReview btn btn-secondary w-100 mt-2">리뷰 보러가기</a>
	</div>
</div>