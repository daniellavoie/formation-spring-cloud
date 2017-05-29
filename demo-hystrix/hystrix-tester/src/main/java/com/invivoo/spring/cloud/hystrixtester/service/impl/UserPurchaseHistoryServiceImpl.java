package com.invivoo.spring.cloud.hystrixtester.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.invivoo.spring.cloud.hystrixtester.client.UserPurchaseHistoryClient;
import com.invivoo.spring.cloud.hystrixtester.service.UserPurchaseHistoryService;
import com.invivoo.spring.cloud.unreliableservice.model.UserPurchaseHistory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserPurchaseHistoryServiceImpl implements UserPurchaseHistoryService {
	private UserPurchaseHistoryClient userPurchaseHistoryClient;

	public UserPurchaseHistoryServiceImpl(UserPurchaseHistoryClient userPurchaseHistoryClient) {
		this.userPurchaseHistoryClient = userPurchaseHistoryClient;
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallback")
	public List<UserPurchaseHistory> findAll() {
		return userPurchaseHistoryClient.findAll();
	}

	public List<UserPurchaseHistory> fallback() {
		return Arrays.asList();
	}
}
