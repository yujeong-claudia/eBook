package com.ebook.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.user.bo.UserBO;
import com.ebook.user.entity.UserEntity;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
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
}
