package com.vtc.mongocore;

import java.io.Serializable;

public class TopupCardMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String accountName;
	private Integer cpId;
	private String cardCode;
	private String cardSeri;
	private Integer cardType;
	private String clientIp;
	private Long clientTime;
	private Integer createdUserId;
	private String createdUserName;
	private Integer deviceType;
	private Long relatedTransactionId;
	private Integer serviceId;
	private String serviceKey;
	
	public String getName() {
		return name;
	}
	public TopupCardMetadata setName(String name) {
		this.name = name;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public TopupCardMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public Integer getCpId() {
		return cpId;
	}
	public TopupCardMetadata setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}
	public String getCardCode() {
		return cardCode;
	}
	public TopupCardMetadata setCardCode(String cardCode) {
		this.cardCode = cardCode;
		return this;
	}
	public String getCardSeri() {
		return cardSeri;
	}
	public TopupCardMetadata setCardSeri(String cardSeri) {
		this.cardSeri = cardSeri;
		return this;
	}
	public Integer getCardType() {
		return cardType;
	}
	public TopupCardMetadata setCardType(Integer cardType) {
		this.cardType = cardType;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public TopupCardMetadata setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Long getClientTime() {
		return clientTime;
	}
	public TopupCardMetadata setClientTime(Long clientTime) {
		this.clientTime = clientTime;
		return this;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public TopupCardMetadata setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public TopupCardMetadata setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public TopupCardMetadata setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
		return this;
	}
	public Long getRelatedTransactionId() {
		return relatedTransactionId;
	}
	public TopupCardMetadata setRelatedTransactionId(Long relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
		return this;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public TopupCardMetadata setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public TopupCardMetadata setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}
	
	
	
}
