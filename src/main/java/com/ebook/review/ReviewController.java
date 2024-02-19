package com.ebook.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.review.bo.ReviewBO;
import com.ebook.review.domain.Review;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/review")
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 리뷰목록
	@GetMapping("/review-list-view")
	public String reviewListView(int bookId, Model model, HttpSession session) {
		
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
		
		// db - 리뷰 목록 조회하기
		List<Review> reviewList = reviewBO.getReviewListByBookId(bookId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("viewName", "review/reviewList");
		return "template/layout";
	}
	
	// 리뷰 쓰기
	@GetMapping("/review-create-view")
	public String reviewCreateView(Model model) {
		// review 권한 검사 한번에 할 예정
		model.addAttribute("viewName", "review/reviewCreate");
		return "template/layout";
	}
}
