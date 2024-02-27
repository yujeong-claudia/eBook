package com.ebook.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/**
	 * 리뷰쓰기 API
	 * @param bookId
	 * @param subject
	 * @param content
	 * @param session
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("bookId") int bookId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			HttpSession session) {
		
		// 글쓴이 번호 - session에 있는 userId를 보낸다
		int userId = (int)session.getAttribute("userId"); 
		
		// db insert
		reviewBO.addReview(userId, bookId, subject, content);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	/**
	 * 리뷰수정 API
	 * @param reviewId
	 * @param subject
	 * @param content
	 * @return
	 */
	@PutMapping("/update")
	public Map<String, Object> update(
			@RequestParam("reviewId") int reviewId,
			@RequestParam("subject") String subject,
			@RequestParam("content") String content) {
		
		// db update
		reviewBO.updateReviewByReviewId(reviewId, subject, content);
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	/**
	 * 리뷰삭제 API
	 * @param reviewId
	 * @return
	 */
	@DeleteMapping("/delete")
	public Map<String, Object> delete(@RequestParam("reviewId") int reviewId){
		
		// db delete
		reviewBO.deleteReviewByReviewId(reviewId);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
