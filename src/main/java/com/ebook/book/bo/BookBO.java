package com.ebook.book.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.domain.Book;
import com.ebook.book.domain.BookView;
import com.ebook.book.mapper.BookMapper;
import com.ebook.user.bo.UserBO;

@Service
public class BookBO { //getReviewListByBookId
	
	@Autowired
	private BookMapper bookMapper;
	
	// input:x    output: List<BookView>
//	public List<BookView> generateBookViewList() {
//		
//		// 글 목록을 가져온다. List<Book>
//		List<BookView> bookList = bookMapper.selectBookList(bookName);
//		
//		// 글 목록 반복문 순회
//		// book => bookView     => bookViewList에 넣기
//		for (Book book : bookList) {
//			ㅠㅐㅐ
//			// book 하나에 대응되는 하나의 카드를 만든다.
//			BookView bookView = new BookView();
//			
//			// 글 1개가 들어갔다.
//			bookView.setBook(book);
//			
//			// 좋아요 개수
//			
//			// ★★★★★마지막에 bookView를 list에 넣는다.
//			bookViewList.add(bookView);
////			
////		}
//		return ;
//	}
	
	// 아래 코드들 필요한지 확인 -> 북서치에 필요
	public List<Book> getBookList() {
		return bookMapper.selectBookList();
	} 
	// 아래 코드들 필요한지 확인 -> 북 디테일에 필요함
	public List<BookView> getBookListByBookName(String bookName) {
		return bookMapper.selectBookListByBookName(bookName);
	}
	
	public Book getBookById(int id) {
		return bookMapper.selectBookById(id);
	}
}
