package com.ebook.book.domain;

import lombok.Data;
import lombok.ToString;

//View용 객체
//글 1개와 매핑됨
@ToString
@Data
public class BookView {
	
	// 글 1개
	private Book book;
	
	// 좋아요 개수
	private int likeCount;
		
	// 로그인 된 사람이 좋아요를 누른지 여부
	private boolean filledLike;
}
