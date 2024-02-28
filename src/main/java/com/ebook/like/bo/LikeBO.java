package com.ebook.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.like.mapper.LikeMapper;

@Service
public class LikeBO {
	
	@Autowired
	private LikeMapper likeMapper;	
	
	// input:bookName, userId     output: X
//	public void likeToggle(String bookName, int userId) {
//		
//		if(likeMapper.selectLikeByBookNameUserId(bookName, userId)) { 
//			// 있으면 삭제
//			likeMapper.deleteLikeByBookNameUserId(bookName, userId);
//		} else { 
//			// 없으면 추가
//			likeMapper.insertLike(bookName, userId);
//		}
//		
//	}
//}
//	
//	 //input:bookName, userId(null or)    output:boolean
//	public boolean getLikeByBookNameUserId(String bookName, Integer userId) {
//		// 비로그인이면 무조건 빈하트 => false
//		if (userId == null) {
//			return false;
//		}
//		
//		// 로그인 - 0보다 크면(1이면) 채운다, 그렇지않으면 false
//		return likeMapper.deleteLikeByBookNameUserId(bookName, userId) > 0;
//	}
}
