package com.ebook.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.like.mapper.LikeMapper;

@Service
public class LikeBO {
	
	@Autowired
	private LikeMapper likeMapper;	
	
	// input:bookId, userId     output: X
	public void likeToggle(int bookId, int userId) {
		
		if(likeMapper.selectLikeCountByBookIdOrUserId(bookId, userId) > 0) { 
			// 있으면 삭제
			likeMapper.deleteLikeByBookIdUserId(bookId, userId);
		} else { 
			// 없으면 추가
			likeMapper.insertLike(bookId, userId);
		}
		return;
	}
	
}

