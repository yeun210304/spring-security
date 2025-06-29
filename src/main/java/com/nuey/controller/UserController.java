package com.nuey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nuey.dto.SignupReq;
import com.nuey.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

    @GetMapping("/login")
    public String showLoginform() {
        return "loginForm";
    }

	@PostMapping("/login")
	public String login(Model model) {
		return "redirect:/";
	}

	@GetMapping("/signup")
	public String showSignUpForm() {
		return "signupForm";
	}

	@PostMapping("/signup")
	public String signup(SignupReq signupReq, Model model) {
		userService.signUp(signupReq);
		return "redirect:/login";
	}
    
}
