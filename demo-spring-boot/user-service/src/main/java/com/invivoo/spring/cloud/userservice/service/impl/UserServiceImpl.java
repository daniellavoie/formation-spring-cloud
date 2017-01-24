package com.invivoo.spring.cloud.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.invivoo.spring.cloud.userservice.repository.UserRepository;
import com.invivoo.spring.cloud.userservice.service.UserService;
import com.invivoo.spring.cloud.validationservice.UserValidation;
import com.invivoo.spring.cloud.validationservice.model.User;

@Service
public class UserServiceImpl implements UserService {
	private UserValidation userValidation;
	private UserRepository userRepository;

	public UserServiceImpl(UserValidation userValidation, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.userValidation = userValidation;
	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();

		userRepository.findAll().forEach(list::add);

		return list;
	}

	@Override
	public User save(User user) {
		userValidation.validateUser(user);
		
		return userRepository.save(user);
	}
}
