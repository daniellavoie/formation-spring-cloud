package com.invivoo.spring.cloud.hystrixtester.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invivoo.spring.cloud.unreliableservice.model.UserPurchaseHistory;

@FeignClient("unreliable-service")
public interface UserPurchaseHistoryClient {
	@RequestMapping(value = "/user-purchase-history", method = RequestMethod.GET)
	List<UserPurchaseHistory> findAll();

	@RequestMapping(value = "/user-purchase-history?toggle-reliable=", method = RequestMethod.GET)
	void toggleReliable();
}
