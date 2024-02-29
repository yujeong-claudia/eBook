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
		if (likeMapper.selectLikeCountByBookIdOrUserId(bookId, userId) > 0) {
			// 있으면 삭제
			likeMapper.deleteLikeByBookIdUserId(bookId, userId);
		} else {
			// 없으면 추가
			likeMapper.insertLike(bookId, userId);
		}
	}
	
	public int getLikeCountByBookId(int bookId) {
		return likeMapper.selectLikeCountByBookIdOrUserId(bookId, null);
	}
	
	public int getLikeCountByBookIdUserId(int bookId, int userId) {
		return likeMapper.selectLikeCountByBookIdOrUserId(bookId, userId);
	}
	
	// input:bookId, userId(null or)    output:boolean
	public boolean getLikeCountByBookIdUserId(int bookId, Integer userId) {
		// 비로그인이면 무조건 빈하트 => false
		if (userId == null) {
			return false;
		}
		
		// 로그인 - 0보다 크면(1이면) 채운다, 그렇지않으면 false
		return likeMapper.selectLikeCountByBookIdOrUserId(bookId, userId) > 0;
	}
	
	public void deleteLikeByBookId(int bookId) {
		likeMapper.deleteLikeByBookId(bookId);
	}
	
}

