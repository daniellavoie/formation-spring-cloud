package com.invivoo.spring.cloud.userservice.service.impl;

import java.util.List;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.invivoo.spring.cloud.userservice.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	private DiscoveryClient discoveryClient;

	public ApplicationServiceImpl(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@Override
	public List<String> findAll() {
		return discoveryClient.getServices();
	}
}
