package com.ebook.like;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class likeRestController {
	
	@RequestMapping("/like/{bookId}")
	public Map<String, Object> likeToggle(
			@PathVariable(name = "bookId") int bookId,
			HttpSession session) {
		
		// 로그인 여부 확인 
		
		// BO 호출 -> likeToggle
		
		// 응답값
	}
}
