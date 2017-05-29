package com.invivoo.spring.cloud.userservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invivoo.spring.cloud.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(params = "email")
	public List<String> findAllEmails() {
		return userService.findAll().stream().map(user -> user.getEmail()).collect(Collectors.toList());
	}
}
