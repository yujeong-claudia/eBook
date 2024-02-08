<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<div class="my-2"><a href="#"><b>1 </b>살인자의 쇼핑몰</a></div>
				<div class="my-2"><a href="#"><b>2 </b>나는 메트로폴리탄 미술관의 경비원입니다</a></div>
				<div class="my-2"><a href="#"><b>3 </b>처음부터 시작하는 주식투자 단타전략</a></div>
				<div class="my-2"><a href="#"><b>4 </b>도둑맞은 집중력</a></div>
				<div class="my-2"><a href="#"><b>5 </b>살인자의 쇼핑몰2</a></div>
			</div>
			<!-- 오른쪽 -->
			<div>
				<div class="my-2"><a href="#"><b>6 </b>아주 희미한 빛으로도</a></div>
				<div class="my-2"><a href="#"><b>7 </b>마흔에 읽는 쇼펜하우어</a></div>
				<div class="my-2"><a href="#"><b>8 </b>유목민의 투자의 정석</a></div>
				<div class="my-2"><a href="#"><b>9 </b>고구려7</a></div>
				<div class="my-2"><a href="#"><b>10 </b>인생은 순간이다</a></div>
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
		// 이미지 3초 간격으로 변하기
		let bannerImg = ["/static/img/banner1.jpg", "/static/img/banner2.jpg", "/static/img/banner3.jpg"];
        let currentIndex = 0;
        setInterval(function() {
            $('#img').attr('src', bannerImg[currentIndex]);
            currentIndex++;

            if (currentIndex > bannerImg.length) { // 인덱스 값이 배열의 크기를 넘으면 0으로(처음 이미지) 세팅
                currentIndex = 0;
            }
        }, 2000);

	}); 

</script>