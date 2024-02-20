package com.ebook.book.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.domain.Book;
import com.ebook.book.mapper.BookMapper;

@Service
public class BookBO { //getReviewListByBookId
	
	@Autowired
	private BookMapper bookMapper;
	
	public List<Book> getBookList() {
		return bookMapper.selectBookList();
	}
	
	public List<Book> getBookListByBookName(String bookName) {
		return bookMapper.selectBookListByBookName(bookName);
	}
}
