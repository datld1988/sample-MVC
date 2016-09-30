package com.vtc.mongocore;

import java.io.Serializable;

public class TopupVtcPayMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String accountName;
	private String bankCode;
	private Integer cpId;
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
	private String vtcPayAccount;
	private Integer vcoin;
	
	public String getName() {
		return name;
	}
	public TopupVtcPayMetadata setName(String name) {
		this.name = name;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public TopupVtcPayMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public String getBankCode() {
		return bankCode;
	}
	public TopupVtcPayMetadata setBankCode(String bankCode) {
		this.bankCode = bankCode;
		return this;
	}
	public Integer getCpId() {
		return cpId;
	}
	public TopupVtcPayMetadata setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public TopupVtcPayMetadata setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Long getClientTime() {
		return clientTime;
	}
	public TopupVtcPayMetadata setClientTime(Long clientTime) {
		this.clientTime = clientTime;
		return this;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public TopupVtcPayMetadata setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public TopupVtcPayMetadata setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public Integer getDeductServiceId() {
		return deductServiceId;
	}
	public TopupVtcPayMetadata setDeductServiceId(Integer deductServiceId) {
		this.deductServiceId = deductServiceId;
		return this;
	}
	public String getDeductServiceKey() {
		return deductServiceKey;
	}
	public TopupVtcPayMetadata setDeductServiceKey(String deductServiceKey) {
		this.deductServiceKey = deductServiceKey;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public TopupVtcPayMetadata setDescription(String description) {
		this.description = description;
		return this;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public TopupVtcPayMetadata setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
		return this;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public TopupVtcPayMetadata setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
		return this;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public TopupVtcPayMetadata setOrderCode(String orderCode) {
		this.orderCode = orderCode;
		return this;
	}
	public Integer getProductId() {
		return productId;
	}
	public TopupVtcPayMetadata setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public TopupVtcPayMetadata setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}
	public String getVtcPayAccount() {
		return vtcPayAccount;
	}
	public TopupVtcPayMetadata setVtcPayAccount(String vtcPayAccount) {
		this.vtcPayAccount = vtcPayAccount;
		return this;
	}
	public Integer getVcoin() {
		return vcoin;
	}
	public TopupVtcPayMetadata setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
		return this;
	}
}
