package com.ebook.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
@Controller
public class BookController {
	
	@GetMapping("/book-detail-view")
	public String bookDetailView(Model model) {
		
		model.addAttribute("viewName", "book/bookDetail");
		return "template/layout";
	}
	
	@GetMapping("/book-content-view")
	public String bookContentView(Model model) {
		
		model.addAttribute("viewName", "book/bookContent");
		return "template/layout";
	}
}
