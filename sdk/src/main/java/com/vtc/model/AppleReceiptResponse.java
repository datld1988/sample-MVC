package com.vtc.model;

public class AppleReceiptResponse {
	private AppleReceiptData receipt;
	private String environment;
	private Integer status;
	
	public AppleReceiptData getReceipt() {
		return receipt;
	}
	public void setReceipt(AppleReceiptData receipt) {
		this.receipt = receipt;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
		
	}
}
