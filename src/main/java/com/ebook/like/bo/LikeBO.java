package com.ebook.like.bo;

import org.springframework.stereotype.Service;

@Service
public class LikeBO {
	
	// input:bookId, userId     output: X
	public void likeToggle(int bookId, int userId) {
		
//		if(likeMapper.selectLikeByBookIdUserId(bookId, userId)) { 
//			// 있으면 삭제
//			likeMapper.deleteLikeByBookIdUserId(bookId, userId);
//		} else { 
//			// 없으면 추가
//			likeMapper.insertLike(bookId, userId);
//		}
		
	}
}
