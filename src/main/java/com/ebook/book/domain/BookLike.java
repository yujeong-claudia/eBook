package com.ebook.book.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BookLike {
	// 로그인 된 사람이 좋아요를 누른지 여부
	private boolean filledLike;
}
