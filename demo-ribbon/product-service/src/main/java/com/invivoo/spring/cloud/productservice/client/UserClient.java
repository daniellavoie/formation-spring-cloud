package com.invivoo.spring.cloud.productservice.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
public interface UserClient {
	@RequestMapping(value = "/user?email=", method = RequestMethod.GET)
	List<String> findAllEmails();
}
