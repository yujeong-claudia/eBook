package com.ebook.user.bo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserBOTest {
	
	@Autowired
	UserBO userBO;
	
	@Transactional // rollback도 해줌
	//@Test
	void 유저추가테스트() {
		log.info("##### 유저추가테스트 시작");
	
		userBO.addUser("아이디테스트111", "비밀번호테스트222", "이름테스22트", "이메일테스33트");
	}

}
