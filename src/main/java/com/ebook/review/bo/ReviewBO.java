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
	
	public List<Review> getReviewList(){
		return reviewMapper.selectReviewList();
	}
}
