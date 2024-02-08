package com.ebook.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/review")
@Controller
public class ReviewController {
	
	// 리뷰목록
	@GetMapping("/review-list-view")
	public String reviewListView(Model model, HttpSession session) {
		
		// db - 리뷰 목록 조회하기
		
		
		model.addAttribute("viewName", "review/reviewList");
		return "template/layout";
	}
}
