package com.invivoo.spring.cloud.productservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invivoo.spring.cloud.productservice.client.UserClient;
import com.invivoo.spring.cloud.productservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserClient userClient;

	public UserServiceImpl(UserClient userClient) {
		this.userClient = userClient;
	}

	@Override
	public List<String> findAllEmails() {
		return userClient.findAllEmails();
	}

}
