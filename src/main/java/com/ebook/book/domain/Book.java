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
	
}
