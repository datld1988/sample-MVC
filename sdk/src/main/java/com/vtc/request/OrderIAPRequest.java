package com.vtc.request;

public class OrderIAPRequest extends Request {
	private String packageId;
	private String clientIp;
	private String receiptData;
	private String billingAccessToken;
	private Integer authenType;
	
	public Integer getAuthenType() {
		return authenType;
	}
	public void setAuthenType(Integer authenType) {
		this.authenType = authenType;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
		
	}
	public String getReceiptData() {
		return receiptData;
	}
	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
		
	}
	public String getBillingAccessToken() {
		return billingAccessToken;
	}
	public void setBillingAccessToken(String billingAccessToken) {
		this.billingAccessToken = billingAccessToken;
		
	}
}
