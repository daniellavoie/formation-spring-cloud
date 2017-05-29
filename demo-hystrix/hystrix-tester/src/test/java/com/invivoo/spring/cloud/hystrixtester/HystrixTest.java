package com.invivoo.spring.cloud.hystrixtester;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.invivoo.spring.cloud.hystrixtester.client.UserPurchaseHistoryClient;
import com.invivoo.spring.cloud.hystrixtester.service.UserPurchaseHistoryService;
import com.netflix.hystrix.exception.HystrixRuntimeException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HystrixTesterApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class HystrixTest {
	@Autowired
	private UserPurchaseHistoryClient userPurchaseHistoryClient;

	@Autowired
	private UserPurchaseHistoryService userPurchaseHistoryService;

	@Before
	public void init() {
		try {
			userPurchaseHistoryClient.findAll();
		} catch (HystrixRuntimeException hystrixRuntimeEx) {
			if (hystrixRuntimeEx.getCause() != null && hystrixRuntimeEx.getCause().getMessage() != null
					&& hystrixRuntimeEx.getCause().getMessage().startsWith("status 500"))
				userPurchaseHistoryClient.toggleReliable();
			else
				throw hystrixRuntimeEx;
		}
	}

	@Test
	public void test() {
		Assert.assertFalse(userPurchaseHistoryClient.findAll().isEmpty());
		Assert.assertFalse(userPurchaseHistoryService.findAll().isEmpty());

		userPurchaseHistoryClient.toggleReliable();

		try {
			userPurchaseHistoryClient.findAll();

			Assert.fail("Should have caused an exception.");
		} catch (Exception ex) {
		}

		Assert.assertTrue(userPurchaseHistoryService.findAll().isEmpty());

		userPurchaseHistoryClient.toggleReliable();

		Assert.assertFalse(userPurchaseHistoryService.findAll().isEmpty());

	}
}
