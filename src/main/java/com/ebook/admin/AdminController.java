package com.ebook.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@GetMapping("/admin-create-view")
	public String adminCreateView() {
		return "book/bookCreate";
	}
}
