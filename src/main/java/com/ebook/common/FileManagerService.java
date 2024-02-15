package com.ebook.common;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component	//spring bean
public class FileManagerService {
	
	// 실제 업로드 된 이미지가 저장될 경로(서버)
	// 집용, 노트북용
	public static final String FILE_UPLOAD_PATH = "C:\\kimyujeong\\7.project\\workspace\\images/";
	// 학원용
	// public static final String FILE_UPLOAD_PATH = "C:\\kimyujeong\\7.project\\workspace\\images";
	
	// input: File 원본, 		output: 이미지 경로
	public String saveFile(MultipartFile file) {
		// 폴더(디렉토리) 생성
		String directoryName = "eBook_" + System.currentTimeMillis();
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 폴더 생성 실패 시 이미지 경로 null 리턴
			return null;
		}
		
		return null;
		
	}
}
