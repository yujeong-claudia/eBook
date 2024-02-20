package com.ebook.bookSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ebook.book.bo.BookBO;
import com.ebook.book.domain.Book;

@Controller
public class BookSearchController {
	
	@Autowired
	private BookBO bookBO;
	
	@GetMapping("/bookSearch/bookSearch-view")
	public String bookSearchView(Model model) {
		
		//db select
		List<Book> bookList = bookBO.getBookList();
		
		model.addAttribute("bookList", bookList);
		model.addAttribute("viewName", "bookSearch/bookSearch");
		return "template/layout";
	}
}
