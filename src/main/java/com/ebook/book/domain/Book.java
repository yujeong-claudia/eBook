package com.ebook.book.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data 
public class Book {
	private int id;
	private String bookCoverPath;
	private String bookName;
	private String author;
	private String genre;
	private int page;
	private String publisher;
	private String content;
	private Date createdAt;
	private Date updatedAt;
	
	// 로그인 된 사람이 좋아요를 누른지 여부
	private boolean filledLike;
}
