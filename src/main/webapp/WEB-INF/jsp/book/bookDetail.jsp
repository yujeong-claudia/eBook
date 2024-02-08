<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">    
	<div class="book-detail-box">
		<h1 class="text-center">북 상세</h1>
		<%-- 책 표지 --%>
		<div class="mb-5">
			<span>책 표지</span>
		</div>
		<form>
			<%-- 책 제목 --%>
			<div>
				<input class="text form-control" name="bookName" placeholder="책 제목">
			</div>
			<div class="d-flex mt-3 justify-content-between">
				<input class="text col-5 form-control" name="bookName" placeholder="저자">
				<input class="text col-5 form-control" name="bookName" placeholder="출판사">
				<div class="col-1">
					하트
				</div>
			</div>
		</form>
		<button type="submit" class="btn btn-dark w-100 mt-3">전자책 보기</button>
	</div>
</div>