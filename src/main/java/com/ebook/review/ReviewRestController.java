package com.ebook.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.review.bo.ReviewBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/review")
@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 리뷰 저장
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("bookId") int bookId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			HttpSession session) {
		
		// 글쓴이 번호 - session에 있는 userId를 보낸다
		int userId = (int)session.getAttribute("userId"); 
		
		// db insert
		//reviewBO.addReview(userId, bookId, subject, content);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
}
