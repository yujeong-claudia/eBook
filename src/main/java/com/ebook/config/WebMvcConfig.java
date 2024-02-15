package com.ebook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ebook.common.FileManagerService;

@Configuration //설정을 위한 spring bean
public class WebMvcConfig implements WebMvcConfigurer {
	
	// 웹 이미지 path와 서버에 업로드 된 실제 이미지와 매핑 설정
	// 이게 없으면 무조건 404
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/images/**") // web path: http://localhost/images/eBook_1708009311838/살인자의 쇼핑몰.jpg
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH); // 실제 이미지파일 위치
	}
}
