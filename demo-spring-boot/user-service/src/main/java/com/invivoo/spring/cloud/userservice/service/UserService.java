package com.invivoo.spring.cloud.userservice.service;

import java.util.List;

import com.invivoo.spring.cloud.validationservice.model.User;

public interface UserService {
	List<User> findAll();

	User save(User user);
}
