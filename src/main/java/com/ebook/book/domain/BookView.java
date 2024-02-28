package com.ebook.book.domain;

import com.ebook.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BookView {
	
	// 글 1개
	private Book book;
	
	// 글쓴이 정보
	private UserEntity user;
	
	// 좋아요 개수
	private int likeCount;
		
	// 로그인 된 사람이 좋아요를 누른지 여부
	private boolean filledLike;
}
