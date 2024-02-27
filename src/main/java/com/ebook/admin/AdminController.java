package com.ebook.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	/**
	 * 관리자 책 등록화면
	 * @return
	 */
	@GetMapping("/admin-create-view")
	public String adminCreateView() {
		return "book/bookCreate";
	}
}
