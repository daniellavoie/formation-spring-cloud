package com.invivoo.spring.cloud.unreliableservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.invivoo.spring.cloud.unreliableservice.model.UserPurchaseHistory;

@RestController
@RequestMapping("/user-purchase-history")
public class UserPurchaseHistoryController {
	private List<UserPurchaseHistory> HISTORY = Arrays.asList(new UserPurchaseHistory("Frites", 1),
			new UserPurchaseHistory("Boulets", 2), new UserPurchaseHistory("Biere", 1));

	private boolean reliable;

	public UserPurchaseHistoryController() {
		reliable = true;
	}

	@GetMapping
	public List<UserPurchaseHistory> findAll() {
		if (reliable)
			return HISTORY;
		else
			throw new RuntimeException("Unreliable service");
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(params = "toggle-reliable")
	public void toggleReliable() {
		this.reliable = !reliable;
	}
}
