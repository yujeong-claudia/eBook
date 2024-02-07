package com.ebook.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.EncryptUtils;
import com.ebook.user.bo.UserBO;
import com.ebook.user.entity.UserEntity;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	/**
	 * 아이디 중복확인 API
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		
		// DB 조회 - select
		UserEntity user = userBO.getUserEntityByLoginId(loginId);
		
		Map<String, Object> result = new HashMap<>();
		
		if (user != null) { // 유저가 이미 존재할 경우 , 중복
			result.put("code", 200);
			result.put("is_duplicated_id", true);
		} else { // 중복 아니다.
			result.put("code", 200);
			result.put("is_duplicated_id", false);
		}
		
		return result;
	}
	
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		// md5 알고리즘(비밀번호 해싱)
		// aaaa -> 74b8733745420d4d33f80c4663dc5e5
		String hashedPassword = EncryptUtils.md5(password);
		
		// DB 조회 - insert
		Integer userId = userBO.addUser(loginId, hashedPassword, name, email);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		
		if (userId != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "회원가입에 실패했습니다.");
		}
		
		return result;
	}
}
