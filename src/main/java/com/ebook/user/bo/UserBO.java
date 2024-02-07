package com.ebook.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.user.entity.UserEntity;
import com.ebook.user.repository.UserRepository;

@Service
public class UserBO {

	@Autowired
	private UserRepository userRepository;

	// input: loginId output: UserEntity(중복된 게 있거나 없거나)
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}

	// input: 파라미터 4개 output: Integer id(pk)
	public Integer addUser(String loginId, String password, String name, String email) {
		UserEntity userEntity = userRepository.save(
					UserEntity.builder()
					.loginId(loginId)
					.password(password)
					.name(name)
					.email(email)
					.build()
				);
		return userEntity == null ? null : userEntity.getId();
	};

}
