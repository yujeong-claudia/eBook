package com.ebook.admin.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.admin.mapper.AdminMapper;

@Service
public class AdminBO {
	
	@Autowired
	private AdminMapper adminMapper;
	
	// input:제목, 내용, 등등	output:X
	public void addAdmin(
			String bookName, String author,
			String genre, int page,
			String publisher, String content) {
		adminMapper.insertAdmin(bookName, author, genre, page, publisher, content, null);
	}
}
