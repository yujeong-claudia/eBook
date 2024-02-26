package com.ebook.review.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.review.domain.Review;
import com.ebook.review.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;

	public List<Review> getReviewListByBookId(int bookId){
		return reviewMapper.selectReviewListByBookId(bookId);
	}
	
	//input:bookId, subject, content 	output: x
	public void addReview(int userId, int bookId, String subject, String content) {
		reviewMapper.insertReview(userId, bookId, subject, content);
	}
	
	public Review getReviewByReviewId(int reviewId) {
		return reviewMapper.getReviewByReviewId(reviewId);
	}
}
