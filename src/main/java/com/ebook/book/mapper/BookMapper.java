package com.ebook.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ebook.book.domain.Book;
import com.ebook.book.domain.BookView;

@Mapper
public interface BookMapper {
	public List<Book> selectBookList();

	public List<BookView> selectBookListByBookName(String bookName);
	
	public Book selectBookById(int id);
}
