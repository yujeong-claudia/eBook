package com.ebook.book.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.domain.Book;
import com.ebook.book.domain.BookView;
import com.ebook.book.mapper.BookMapper;
import com.ebook.like.bo.LikeBO;
import com.ebook.user.bo.UserBO;

@Service
public class BookBO { 
	
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private LikeBO likeBO;
	
	// input:userId(비로그인:null, 로그인:userId)    output: List<BookView>
	public List<BookView> generateBookViewList(String bookName, Integer userId) {
		List<BookView> bookViewList = new ArrayList<>();
		
		// 글 목록을 가져온다. List<Book>
		List<Book> bookList = bookMapper.selectBookListByBookName(bookName);
		
		// 글 목록 반복문 순회
		// book => bookView     => bookViewList에 넣기
		for (Book book : bookList) {
			
			// book 하나에 대응되는 하나의 카드를 만든다.
			BookView bookView = new BookView();
			
			// 글 1개가 들어갔다.
			bookView.setBook(book);
			
			// 좋아요 개수
			int likeCount = likeBO.getLikeCountByBookId(book.getId());
			bookView.setLikeCount(likeCount);
			
			// 로그인된 사람이 좋아요를 했는지 여부(비로그인 사용자 고려)
			boolean filledLike = likeBO.getLikeCountByBookIdUserId(book.getId(), userId);
			bookView.setFilledLike(filledLike);
			
			// ★★★★★마지막에 bookView를 list에 넣는다.
			bookViewList.add(bookView);
			
		}
		return bookViewList;
	}
	
	// 북서치
	public List<Book> getBookList() {
		return bookMapper.selectBookList();
	} 
	
	// 북 컨텐트
	public Book getBookById(int id) { 
		return bookMapper.selectBookById(id);
	}
}
