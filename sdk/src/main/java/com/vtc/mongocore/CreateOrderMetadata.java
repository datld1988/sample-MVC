package com.vtc.mongocore;

public class CreateOrderMetadata {
	private String orderId;
	private String orderNo;
	private String accountName;
	private String packageId;
	private String accessToken;
	private String billingAccessToken;
	
	public String getOrderId() {
		return orderId;
	}
	public CreateOrderMetadata setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public CreateOrderMetadata setOrderNo(String orderNo) {
		this.orderNo = orderNo;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public CreateOrderMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public String getPackageId() {
		return packageId;
	}
	public CreateOrderMetadata setPackageId(String packageId) {
		this.packageId = packageId;
		return this;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public CreateOrderMetadata setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}
	public String getBillingAccessToken() {
		return billingAccessToken;
	}
	public CreateOrderMetadata setBillingAccessToken(String billingAccessToken) {
		this.billingAccessToken = billingAccessToken;
		return this;
	}
}
