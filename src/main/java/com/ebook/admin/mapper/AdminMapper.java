package com.ebook.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
	
	public void insertAdmin(
			@Param("bookName") String bookName, 
			@Param("author") String author,
			@Param("genre") String genre, 
			@Param("page") int page,
			@Param("publisher") String publisher, 
			@Param("content") String content,
			@Param("bookCoverPath") String bookCoverPath);
	
}
