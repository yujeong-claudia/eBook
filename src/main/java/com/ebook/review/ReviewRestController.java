package com.ebook.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.review.bo.ReviewBO;

@RequestMapping("/review")
@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 리뷰 저장
	@PostMapping("/review-create-view")
	public Map<String, Object> reviewCreate(
			@RequestParam("userId") int userId,
			@RequestParam("bookId") int bookId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content) {
		
		// db insert
		reviewBO.addReview(userId, bookId, subject, content);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
}
