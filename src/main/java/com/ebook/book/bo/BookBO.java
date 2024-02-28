package com.ebook.book.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.domain.Book;
import com.ebook.book.domain.BookView;
import com.ebook.book.mapper.BookMapper;

@Service
public class BookBO { //getReviewListByBookId
	
	@Autowired
	private BookMapper bookMapper;
	
	// input:userId(비로그인:null, 로그인:userId)    output: List<BookView>
	public List<BookView> generateBookViewList(Integer userId) {
		List<BookView> bookViewList = new ArrayList<>();
		
		
	}
	
	public List<Book> getBookList() {
		return bookMapper.selectBookList();
	}
	
	public List<Book> getBookListByBookName(String bookName) {
		return bookMapper.selectBookListByBookName(bookName);
	}
	
	public Book getBookById(int id) {
		return bookMapper.selectBookById(id);
	}
}
