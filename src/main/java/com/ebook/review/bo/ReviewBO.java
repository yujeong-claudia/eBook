package com.ebook.review.bo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.review.domain.Review;
import com.ebook.review.mapper.ReviewMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;

	public List<Review> getReviewListByBookId(int bookId){
		return reviewMapper.selectReviewListByBookId(bookId);
	}
	
	// input:bookId, subject, content 	output:X
	public void addReview(int userId, int bookId, String subject, String content) {
		reviewMapper.insertReview(userId, bookId, subject, content);
	}
	
	// input:reviewId 	output:Review
	public Review getReviewByReviewId(int reviewId) {
		return reviewMapper.selectReviewByReviewId(reviewId);
	}
	
	// input:reviewId, subject, content    output:X
	public void updateReviewByReviewId(int reviewId, String subject, String content) {
		
		// 기존 글을 가져온다.
		Review review = reviewMapper.selectReviewByReviewId(reviewId);
		if (review == null) {
			log.info("[리뷰 수정] review is null. reviewId:{}, reviewId");
			return;
		}
		
		// db 업데이트
		reviewMapper.updateReviewByReviewId(reviewId, subject, content);
	}
	
	// input:reviewId    output:X
	public void deleteReviewByReviewId(int reviewId) {
		
		// 기존 글을 가져온다.
		Review review = reviewMapper.selectReviewByReviewId(reviewId);
		if (review == null) {
			log.info("[리뷰 삭제] review is null. reviewId:{}, reviewId");
			return;
		}
		
		// db 삭제
		reviewMapper.deleteReviewByReviewId(reviewId);
	}
}
