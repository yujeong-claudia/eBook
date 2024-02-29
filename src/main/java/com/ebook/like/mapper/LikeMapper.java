package com.ebook.like.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {
	
	public int selectLikeCountByBookIdOrUserId(
			@Param("bookId") int bookId,
			@Param("userId") Integer userId);
	
	public void deleteLikeByBookIdUserId(
			@Param("bookId") int bookId,
			@Param("userId") int userId);
	
	public void insertLike(
			@Param("bookId") int bookId,
			@Param("userId") int userId);
	
	public void deleteLikeByBookId(int bookId);

}
