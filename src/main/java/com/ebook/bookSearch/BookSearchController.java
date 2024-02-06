package com.ebook.bookSearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookSearchController {
	
	@GetMapping("/bookSearch/bookSearch-view")
	public String bookSearchView(Model model) {
		model.addAttribute("viewName", "bookSearch/bookSearch");
		return "template/layout";
	}
}
