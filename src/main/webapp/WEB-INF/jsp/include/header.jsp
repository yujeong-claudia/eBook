<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<div class="d-flex justify-content-between align-items-center h-100">
	<%-- logo --%>
	<div class="d-flex">
		<h1>eBook</h1>
		<img src="/static/img/eBook.jpg" alt="logo" width="50" height="50">
	</div>
	
	<%-- 정보 --%>
	<div>
		<%-- 로그인시 --%>
		<c:if test="">
			<span>000님 안녕하세요!</span>
			<a>로그아웃</a>
		</c:if>
		
		<%-- 비로그인시 --%>
		<c:if test="">
			
		</c:if>
	</div>
</div>