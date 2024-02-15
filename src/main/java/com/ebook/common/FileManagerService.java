package com.ebook.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component	//spring bean
public class FileManagerService {
	
	// 실제 업로드 된 이미지가 저장될 경로(서버)
	// 집용, 노트북용
	public static final String FILE_UPLOAD_PATH = "C:\\kimyujeong\\7.project\\workspace\\images/";
	// 학원용
	//public static final String FILE_UPLOAD_PATH = "D:\\KIMYUJEONG\\7_project\\ebook\\workspace\\images/";
	
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
		
		// 파일 업로드: byte 단위로 업로드
		try {
			byte[] bytes = file.getBytes();
			
			//파일명 암호화, 한글 이름 이미지 가능
			String origName = new String(file.getOriginalFilename().getBytes("8859_1"),"UTF-8");
			String ext = origName.substring(origName.lastIndexOf(".")); // 확장자
			String saveFileName = getUuid() + ext;

			Path path = Paths.get(filePath + "/" + saveFileName);
			Files.write(path, bytes); // 실제 파일 업로드
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
 		
		// 파일업로드가 성공했으면 웹 이미지 url path를 리턴
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
		
	}
	 // uuid 생성
		public static String getUuid() {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}
}
