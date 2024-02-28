package com.ebook.like.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {

	// input:X   output:List<Map>
	public List<Map<String, Object>> selectLikeList();
	
	public void selectLikeByBookNameUserId(
			@Param("bookName") String bookName, 
			@Param("userId") int userId);
	
	public void deleteLikeByBookNameUserId(
			@Param("bookName") String bookName, 
			@Param("userId") int userId);
	
	public void insertLike(
			@Param("bookName") String bookName, 
			@Param("userId") int userId);
}
