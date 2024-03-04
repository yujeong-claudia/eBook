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
import com.ebook.book.domain.BookView;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/book")
@Controller
public class BookController {
	
	@Autowired
	private BookBO bookBO;
	
	/**
	 * 책 상세화면
	 * @param bookName
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/book-detail-view")
	public String bookDetailView(
			@RequestParam("bookName") String bookName,
			Model model, HttpSession session) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		List<BookView> bookViewList = bookBO.generateBookViewList(bookName, userId);
		
		model.addAttribute("bookViewList", bookViewList);
		model.addAttribute("viewName", "book/bookDetail");
		return "template/layout";
	}
	
	/**
	 * 책 내용 화면
	 * @param bookId
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/book-content-view")
	public String bookContentView(
			@RequestParam("bookId") int bookId,
			Model model,
			HttpSession session) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
	
		// db - select
		Book book = bookBO.getBookById(bookId);
		
		model.addAttribute("book", book);
		model.addAttribute("viewName", "book/bookContent");
		return "template/layout";
	}
}
