package com.ebook.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebook.mapper.LikeMapper;
import com.ebook.mapper.UserMapper;

@Controller
public class TestController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private LikeMapper likeMapper;
	
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "Hello world!"; //html
	}
	
	@GetMapping("/test2")
	@ResponseBody
	public Map<String, Object> test2() {
		Map<String, Object> result = new HashMap<>();
		result.put("테스트1", 111);
		result.put("test2", 222);
		result.put("테스트3", 333);
		return result; //json
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "test/test"; //3 html
	}
	
	@GetMapping("test4")
	@ResponseBody
	public List<Map<String, Object>> test4() {
		return likeMapper.selectLikeList(); //4 jsp
	}
	
	@GetMapping("test5")
	@ResponseBody
	public List<Map<String, Object>> test5() {
		return userMapper.selectUserList(); //5 jsp 한글테스트
	}
}
