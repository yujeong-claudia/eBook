package com.ebook.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/review")
@RestController
public class ReviewRestController {
	
	// 리뷰 저장
	@PostMapping("/review-create-view")
	public Map<String, Object> reviewCreate(
			@RequestParam("bookId") int bookId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content) {
		
		// db insert
		
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
}
