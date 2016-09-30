package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class TransactionTopupByCardRequest extends Request {
	
	private String name;
	private Integer cpId;
	private String cardCode;
	private String cardSeri;
	private Integer cardType;
	private String clientIp;
	private Long clientTime;
	private Integer createdUserId;
	private String createdUserName;
	private Long relatedTransactionId;
	private Integer serviceId;
	private String serviceKey;
	private String description;
	
	// Service tru vcoin nap vao game
	public Integer deductServiceId;
	public String deductServiceKey;
	
	public String getName() {
		return name;
	}
	public TransactionTopupByCardRequest setName(String name) {
		this.name = name;
		return this;
	}
	public Integer getCpId() {
		return cpId;
	}
	public TransactionTopupByCardRequest setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}
	public String getCardCode() {
		return cardCode;
	}
	public TransactionTopupByCardRequest setCardCode(String cardCode) {
		this.cardCode = cardCode;
		return this;
	}
	public String getCardSeri() {
		return cardSeri;
	}
	public TransactionTopupByCardRequest setCardSeri(String cardSeri) {
		this.cardSeri = cardSeri;
		return this;
	}
	public Integer getCardType() {
		return cardType;
	}
	public TransactionTopupByCardRequest setCardType(Integer cardType) {
		this.cardType = cardType;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public TransactionTopupByCardRequest setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Long getClientTime() {
		return clientTime;
	}
	public TransactionTopupByCardRequest setClientTime(Long clientTime) {
		this.clientTime = clientTime;
		return this;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public TransactionTopupByCardRequest setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public TransactionTopupByCardRequest setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public Long getRelatedTransactionId() {
		return relatedTransactionId;
	}
	public TransactionTopupByCardRequest setRelatedTransactionId(Long relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
		return this;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public TransactionTopupByCardRequest setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public TransactionTopupByCardRequest setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	public TransactionTopupByCardRequest setDescription(String description) {
		this.description = description;
		return this;
	}
	public Integer getDeductServiceId() {
		return deductServiceId;
	}
	public TransactionTopupByCardRequest setDeductServiceId(Integer deductServiceId) {
		this.deductServiceId = deductServiceId;
		return this;
	}
	public String getDeductServiceKey() {
		return deductServiceKey;
	}
	public TransactionTopupByCardRequest setDeductServiceKey(String deductServiceKey) {
		this.deductServiceKey = deductServiceKey;
		return this;
	}
	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();//.writer().withDefaultPrettyPrinter();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	public String toString(){
//		StringBuffer sb = new StringBuffer()
//				.append(" Name:").append(this.getName())
//				.append(", AccountName:").append(this.getAccountName())
//				.append(", CpId:").append(this.getCpId())
//				.append(", CardCode:").append(this.getCardCode())
//				.append(", CardSeri:").append(this.getCardSeri())
//				.append(", CardType:").append(this.getCardType())
//				.append(", ClientIp:").append(this.getClientIp())
//				.append(", ClientTime:").append(this.getClientTime())
//				.append(", CreatedUserId:").append(this.getCreatedUserId())
//				.append(", CreatedUserName:").append(this.getCreatedUserName())
//				.append(", RelatedTransactionId:").append(this.getRelatedTransactionId())
//				.append(", ServiceId:").append(this.getServiceId())
//				.append(", ServiceKey:").append(this.getServiceKey())
//				.append(", Description:").append(this.getDescription())
//				.append(", DeductServiceId:").append(this.getDeductServiceId())
//				.append(", DeductServiceKey:").append(this.getDeductServiceKey())
//				.append(", ").append(super.toString());
//		
//		return sb.toString();
//	}
}
