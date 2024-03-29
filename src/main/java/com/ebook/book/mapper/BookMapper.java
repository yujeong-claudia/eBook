package com.ebook.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ebook.book.domain.Book;
import com.ebook.book.domain.BookView;

@Mapper
public interface BookMapper {
	public List<Book> selectBookList();
	
	public List<Book> selectBookListByBookName(String bookName);
	
	public Book selectBookById(int id);
}
