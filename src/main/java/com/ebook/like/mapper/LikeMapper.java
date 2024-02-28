package com.ebook.like.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {

	// input:X   output:List<Map>
	public List<Map<String, Object>> selectLikeList();
	
	public int selectLikeCountByBookIdOrUserId(
			@Param("bookId") int bookId, 
			@Param("userId") Integer userId);
	
	public void deleteLikeByBookIdUserId(
			@Param("bookId") int bookId, 
			@Param("userId") int userId);
	
	public void insertLike(
			@Param("bookId") int bookId, 
			@Param("userId") int userId);

}
