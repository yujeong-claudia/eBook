package com.ebook.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ebook.review.domain.Review;

@Mapper
public interface ReviewMapper {
	public List<Review> selectReviewList();
}
