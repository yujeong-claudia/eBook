package com.ebook.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebook.admin.bo.AdminBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/admin")
@RestController
public class AdminRestController {
	
	@Autowired
	private AdminBO adminBO;
	
	/**
	 * 관리자 책 등록 API
	 * @param bookName
	 * @param author
	 * @param genre
	 * @param page
	 * @param publisher
	 * @param content
	 * @param file
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("bookName") String bookName,
			@RequestParam("author") String author,
			@RequestParam("genre") String genre,
			@RequestParam("page") int page,
			@RequestParam("publisher") String publisher,
			@RequestParam("content") String content,
			@RequestParam("file") MultipartFile file) {
		
		// db insert
		adminBO.addAdmin(bookName, author, genre, page, publisher, content, file);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
				
		return result;
	}
}
