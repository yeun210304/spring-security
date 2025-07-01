package com.nuey.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nuey.spring_security.entity.User;
import com.nuey.spring_security.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/")
	public String main() {
		return "redirect:/login";
	}

    @GetMapping("/login")
    public String showLoginform() {
        return "loginForm";
    }

	@PostMapping("/login")
	public String login(Model model) {
		return "redirect:/";
	}

	@GetMapping("/signup")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signupForm";
	}

	@PostMapping("/signup")
	public String signup(User user, Model model) {
		userService.signUp(user);
		return "redirect:/login";
	}
    
}
