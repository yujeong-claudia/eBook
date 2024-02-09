package com.ebook.review.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data 
public class Review {
	private int id;
	private int userId;
	private int bookId;
	private String subject;
	private String content;
	private Date createdAt;
	private Date updatedAt;
}
