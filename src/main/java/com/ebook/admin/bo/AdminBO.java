package com.ebook.admin.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ebook.admin.mapper.AdminMapper;
import com.ebook.common.FileManagerService;

@Service
public class AdminBO {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	// input:제목, 내용, 등등	output:X
	public void addAdmin(
			String bookName, String author,
			String genre, int page,
			String publisher, String content,
			MultipartFile file) {
		
		String bookCoverPath = null;
		
		// 업로드할 이미지가 있을 때 업로드
		if (file != null) {
			bookCoverPath = fileManagerService.saveFile(file);
		}
		
		//SadminMapper.insertAdmin(bookName, author, genre, page, publisher, content, bookCoverPath);
	}
}
