package com.nuey.spring_security.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nuey.spring_security.entity.User;
import com.nuey.spring_security.mapper.UserMapper;
import com.nuey.spring_security.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void signUp(User user) {

		//TODO db에 회원이 존재하는 지 검증. existByUsername 메서드 필요

		User data = new User();
		data.setUsername(user.getUsername());
		data.setPassword(passwordEncoder.encode(user.getPassword()));
		data.setRole(user.getRole() != null ? user.getRole() : "USER");

		userMapper.insertUser(data);
	}

}
