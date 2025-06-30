package com.nuey.spring_security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nuey.spring_security.entity.User;

@Mapper
public interface UserMapper {

	public void insertUser(User user);
	
}
