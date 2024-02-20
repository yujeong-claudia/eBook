package com.ebook.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ebook.book.domain.Book;

@Mapper
public interface BookMapper {
	public List<Book> selectBookList();

	public List<Book> selectBookListByBookName(String bookName);
}
