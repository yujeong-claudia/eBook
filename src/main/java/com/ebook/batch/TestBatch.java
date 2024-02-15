package com.ebook.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestBatch {
	
	// /가 들어가면 매일 1분마다 라는 뜻, 맨 앞은 초
	@Scheduled(cron = "0 */1 * * * *")
	public void task() {
		log.info("###### batch 수행");
	}
}
