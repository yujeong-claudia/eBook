<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex justify-content-center">
	<!-- 검색 영역 -->
	<div class="col-5">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="제목, 저자 검색">
			<div class="input-group-append">
				<button class="btn btn-light" type="button">검색</button>
			</div>
		</div>
		<div class="mt-5">
			<h3 class="font-weight-bold">인기순위</h3>
		</div>
		<div class="d-flex justify-content-between">
			<!-- 왼쪽 -->
			<div>			
			<c:forEach items="${bookList}" var="book" begin="0" end="4">
				<div class="my-2"><a href="/book/book-detail-view?bookName=${book.bookName}"><b>${book.id} </b>${book.bookName}</a></div>
			</c:forEach>
			</div>
			<!-- 오른쪽 -->
			<div>
			<c:forEach items="${bookList}" var="book" begin="5" end="10">
				<div class="my-2"><a href="/book/book-detail-view?bookName=${book.bookName}"><b>${book.id} </b>${book.bookName}</a></div>
			</c:forEach>
			</div>
		</div>
		<!-- 배너 -->
		<div class="d-flex justiyif-content-center mt-5">
			<img id="img" src="/static/img/banner1.jpg" alt="banner1" class="w-100">
		</div>
	</div>
</div>
<script> 
	$(document).ready(function() {
		
		// 검색하기
		
		
		// 이미지 3초 간격으로 변하기
		let bannerImg = ["/static/img/banner1.jpg", "/static/img/banner2.jpg", "/static/img/banner3.jpg"];
        let currentIndex = 0;
        setInterval(function() {
            $('#img').attr('src', bannerImg[currentIndex]);
            currentIndex++;

            if (currentIndex > bannerImg.length) { // 인덱스 값이 배열의 크기를 넘으면 0으로(처음 이미지) 세팅
                currentIndex = 0;
            }
        }, 3000);

	}); 

</script>