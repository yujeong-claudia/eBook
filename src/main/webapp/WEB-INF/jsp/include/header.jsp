<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<div class="d-flex justify-content-between align-items-center h-100">
	<%-- logo --%>
	<div class="d-flex justiyif-content-center">
		<img src="/static/img/eBook.jpg" alt="logo" width="330" height="100">
	</div>
	
	<%-- 로그인 정보 --%>
	<div class="d-flex mr-5">
		<%-- 로그인시 --%>
		<span class="text-white">000님 안녕하세요!</span>
		<a href="/user/sign-out" class="ml-5 text-white font-weight-bold">로그아웃</a>
		
		<%-- 비로그인시 
		<c:if test="">
			
		</c:if>--%>
	</div>
</div>