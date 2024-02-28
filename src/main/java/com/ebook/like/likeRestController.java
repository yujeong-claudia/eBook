package com.ebook.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.like.bo.LikeBO;

import jakarta.servlet.http.HttpSession;

@RestController
public class likeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
	@RequestMapping("/like/{bookId}")
	public Map<String, Object> likeToggle(
			@PathVariable(name = "bookId") int bookId,
			HttpSession session) {
		
		// 로그인 여부 확인 
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인을 해주세요.");
			return result;
		}
		
		// 여기까지 내려오면 로그인이 되어있다.
		// BO 호출 -> likeToggle
		likeBO.likeToggle(bookId, userId);
		// 응답값
		result.put("code", 200);
		result.put("result", "성공");
		return result;		
	}
}
