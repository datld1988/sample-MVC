package com.vtc.mongocore;

import java.io.Serializable;

public class TopupBankMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String accountName;
	private String bankCode;
	private Integer CPId;
	private String clientIp;
	private Long clientTime;
	private Integer createdUserId;
	private String createdUserName;
	private Integer deductServiceId;
	private String deductServiceKey;
	private String description;
	private Integer deviceType;
	private String notifyUrl;
	private String orderCode;
	private Integer productId;
	private String returnUrl;
	private Integer vcoin;
	
	public String getName() {
		return name;
	}
	public TopupBankMetadata setName(String name) {
		this.name = name;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public TopupBankMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public String getBankCode() {
		return bankCode;
	}
	public TopupBankMetadata setBankCode(String bankCode) {
		this.bankCode = bankCode;
		return this;
	}
	public Integer getCPId() {
		return CPId;
	}
	public TopupBankMetadata setCPId(Integer cPId) {
		CPId = cPId;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public TopupBankMetadata setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Long getClientTime() {
		return clientTime;
	}
	public TopupBankMetadata setClientTime(Long clientTime) {
		this.clientTime = clientTime;
		return this;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public TopupBankMetadata setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public TopupBankMetadata setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public Integer getDeductServiceId() {
		return deductServiceId;
	}
	public TopupBankMetadata setDeductServiceId(Integer deductServiceId) {
		this.deductServiceId = deductServiceId;
		return this;
	}
	public String getDeductServiceKey() {
		return deductServiceKey;
	}
	public TopupBankMetadata setDeductServiceKey(String deductServiceKey) {
		this.deductServiceKey = deductServiceKey;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public TopupBankMetadata setDescription(String description) {
		this.description = description;
		return this;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public TopupBankMetadata setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
		return this;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public TopupBankMetadata setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
		return this;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public TopupBankMetadata setOrderCode(String orderCode) {
		this.orderCode = orderCode;
		return this;
	}
	public Integer getProductId() {
		return productId;
	}
	public TopupBankMetadata setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public TopupBankMetadata setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}
	public Integer getVcoin() {
		return vcoin;
	}
	public TopupBankMetadata setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
		return this;
	}
	

}
