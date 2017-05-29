package com.invivoo.spring.cloud.productservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.invivoo.spring.cloud.productservice.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest {
	@Autowired
	private UserService userService;

	@Test
	public void testFindAllEmails() {
		for (int i = 0; i < 10; i++)
			Assert.assertNotNull(userService.findAllEmails());
	}
}
