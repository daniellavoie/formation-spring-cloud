package com.invivoo.spring.cloud.userservice.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.invivoo.spring.cloud.userservice.UserServiceApplication;
import com.invivoo.spring.cloud.userservice.service.ApplicationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationServiceImplTest {
	@Autowired
	private ApplicationService applicationService;

	@Test
	public void testFindAll() {
		Assert.assertFalse(applicationService.findAll().isEmpty());
	}
}
