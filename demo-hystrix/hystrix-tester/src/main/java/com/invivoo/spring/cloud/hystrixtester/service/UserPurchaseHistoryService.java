package com.invivoo.spring.cloud.hystrixtester.service;

import java.util.List;

import com.invivoo.spring.cloud.unreliableservice.model.UserPurchaseHistory;

public interface UserPurchaseHistoryService {
	List<UserPurchaseHistory> findAll();
}
