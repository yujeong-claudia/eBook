package com.ebook.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebook.book.bo.BookBO;
import com.ebook.book.domain.Book;

@RequestMapping("/book")
@Controller
public class BookController {
	
	@Autowired
	private BookBO bookBO;
	
	@GetMapping("/book-detail-view")
	public String bookDetailView(
			@RequestParam("bookName") String bookName,
			Model model) {
		
		// db - select
		List<Book> bookList = bookBO.getBookListByBookName(bookName);
		
		model.addAttribute("bookList", bookList);
		model.addAttribute("viewName", "book/bookDetail");
		return "template/layout";
	}
	
	@GetMapping("/book-content-view")
	public String bookContentView(
			@RequestParam("bookName") String bookName,
			Model model) {
		
		// db - select
		List<Book> bookList = bookBO.getBookListByBookName(bookName);
		
		model.addAttribute("bookList", bookList);
		model.addAttribute("viewName", "book/bookContent");
		return "template/layout";
	}
}
