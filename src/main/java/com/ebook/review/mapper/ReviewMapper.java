package com.ebook.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ebook.review.domain.Review;

@Mapper
public interface ReviewMapper {
	
	public List<Review> selectReviewListByBookId(int bookId);
	
	public void insertReview(
			@Param("userId") int userId, 
			@Param("bookId") int bookId, 
			@Param("subject") String subject, 
			@Param("content") String content);
	
	public Review selectReviewByReviewId(
			@Param("reviewId") int reviewId);
	
	public void updateReviewByReviewId(
			@Param("reviewId") int reviewId, 
			@Param("subject") String subject, 
			@Param("content") String content);
	
	public void deleteReviewByReviewId(@Param("reviewId") int reviewId);
}
