<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="w-50">
		<h1>리뷰 작성</h1>
		
		<input type="text" id="subject" class="form-control mt-4" placeholder="제목을 입력하세요">
		<textarea id="content" class="form-control" placeholder="내용을 입력하세요" rows="10"></textarea>
	
		<div class="d-flex justify-content-between mt-4">
			<button type="button" class="form-control reviewListBtn btn-dark">뒤로가기</button>		
			<button type="button" class="form-control clearBtn btn-secondary">모두지우기</button>		
			<button type="button" class="form-control saveBtn btn-dark">저장하기</button>		
		</div>
	</div>
</div>	