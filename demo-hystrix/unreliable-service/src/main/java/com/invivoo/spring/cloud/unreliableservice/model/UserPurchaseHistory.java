package com.invivoo.spring.cloud.unreliableservice.model;

public class UserPurchaseHistory {
	private String product;
	private int quantity;

	public UserPurchaseHistory() {

	}

	public UserPurchaseHistory(String product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
