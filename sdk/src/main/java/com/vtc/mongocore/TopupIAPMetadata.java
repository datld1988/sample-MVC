package com.vtc.mongocore;

import java.io.Serializable;

public class TopupIAPMetadata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sign;
    private String accountName;
    private Integer cpId;
    private String clientIp;
    private Integer createdUserID;
    private String createdUserName;
    private String description;
//    private Integer deviceType;
    private String packetId;
    private Long purchaseDate;
    private Integer quantity;
    private String receiptBase;
    private String receiptBaseMd5;
    private String receiptData;
    private String relatedTransactionId;
    private Integer serviceId;
    private String serviceKey;
    private String uuid;
    private Integer deductServiceId;
    private String deductServiceKey;
    
	public String getSign() {
		return sign;
	}
	public TopupIAPMetadata setSign(String sign) {
		this.sign = sign;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public TopupIAPMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public Integer getCpId() {
		return cpId;
	}
	public TopupIAPMetadata setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public TopupIAPMetadata setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Integer getCreatedUserID() {
		return createdUserID;
	}
	public TopupIAPMetadata setCreatedUserID(Integer createdUserID) {
		this.createdUserID = createdUserID;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public TopupIAPMetadata setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public TopupIAPMetadata setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getPacketId() {
		return packetId;
	}
	public TopupIAPMetadata setPacketId(String packetId) {
		this.packetId = packetId;
		return this;
	}
	public Long getPurchaseDate() {
		return purchaseDate;
	}
	public TopupIAPMetadata setPurchaseDate(Long purchaseDate) {
		this.purchaseDate = purchaseDate;
		return this;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public TopupIAPMetadata setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}
	public String getReceiptBase() {
		return receiptBase;
	}
	public TopupIAPMetadata setReceiptBase(String receiptBase) {
		this.receiptBase = receiptBase;
		return this;
	}
	public String getReceiptBaseMd5() {
		return receiptBaseMd5;
	}
	public TopupIAPMetadata setReceiptBaseMd5(String receiptBaseMd5) {
		this.receiptBaseMd5 = receiptBaseMd5;
		return this;
	}
	public String getReceiptData() {
		return receiptData;
	}
	public TopupIAPMetadata setReceiptData(String receiptData) {
		this.receiptData = receiptData;
		return this;
	}
	public String getRelatedTransactionId() {
		return relatedTransactionId;
	}
	public TopupIAPMetadata setRelatedTransactionId(String relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
		return this;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public TopupIAPMetadata setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public TopupIAPMetadata setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}
	public String getUuid() {
		return uuid;
	}
	public TopupIAPMetadata setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}
	public Integer getDeductServiceId() {
		return deductServiceId;
	}
	public TopupIAPMetadata setDeductServiceId(Integer deductServiceId) {
		this.deductServiceId = deductServiceId;
		return this;
	}
	public String getDeductServiceKey() {
		return deductServiceKey;
	}
	public TopupIAPMetadata setDeductServiceKey(String deductServiceKey) {
		this.deductServiceKey = deductServiceKey;
		return this;
	}

}
