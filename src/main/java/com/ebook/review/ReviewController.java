package com.ebook.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebook.book.bo.BookBO;
import com.ebook.book.domain.Book;
import com.ebook.review.bo.ReviewBO;
import com.ebook.review.domain.Review;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/review")
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	@Autowired
	private BookBO bookBO;
	
	// 리뷰목록
	@GetMapping("/review-list-view")
	public String reviewListView(
			@RequestParam("bookId") int bookId, 
			Model model, 
			HttpSession session) {
		
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
		
		
		// db - 리뷰 목록 조회하기
		List<Review> reviewList = reviewBO.getReviewListByBookId(bookId);
		Book book = bookBO.getBookById(bookId);
		
		model.addAttribute("book", book);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("viewName", "review/reviewList");
		return "template/layout";
	}
	
	// 리뷰 상세
	@GetMapping("/review-detail-view")
	public String reviewDetailView(
			@RequestParam("reviewId") int reviewId, 
			Model model, 
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
		
		// db조회 - select
		Review review = reviewBO.getReviewByReviewId(reviewId);
		
		model.addAttribute("review", review);
		model.addAttribute("viewName", "review/reviewDetail");
		return "template/layout";
	}
	
	// 리뷰 쓰기
	@GetMapping("/review-create-view")
	public String reviewCreateView(
			@RequestParam("bookId") int bookId,
			Model model, HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
		
		model.addAttribute("bookId", bookId);
		model.addAttribute("viewName", "review/reviewCreate");
		return "template/layout";
	}
}
