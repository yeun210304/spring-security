package com.nuey.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupReq {
	private int idx;
	private String username;
	private String password;
	private String role; // USER or ADMIN
	private LocalDateTime createdAt;
}
