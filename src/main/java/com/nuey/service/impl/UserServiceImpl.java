package com.nuey.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nuey.dto.SignupReq;
import com.nuey.mapper.UserMapper;
import com.nuey.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void signUp(SignupReq signupReq) {

		//db에 회원이 존재하는 지 검증. existByUsername 메서드 필요

		SignupReq data = new SignupReq();
		data.setUsername(signupReq.getUsername());
		data.setPassword(passwordEncoder.encode(signupReq.getPassword()));
		data.setRole(signupReq.getRole() != null ? signupReq.getRole() : "USER");

		userMapper.insertUser(data);
	}

}
