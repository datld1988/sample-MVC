package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class TransactionTopupByIAPRequest extends Request {

	 private String sign;
     private Integer cpId;
     private String clientIp;
     private Integer createdUserID;
     private String createdUserName;
     private String description;
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
     
     // Service tru vcoin nap vao game
     private Integer deductServiceId;
     private String deductServiceKey;
     
	public String getSign() {
		return sign;
	}
	public TransactionTopupByIAPRequest setSign(String sign) {
		this.sign = sign;
		return this;
	}
	public Integer getCpId() {
		return cpId;
	}
	public TransactionTopupByIAPRequest setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public TransactionTopupByIAPRequest setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Integer getCreatedUserID() {
		return createdUserID;
	}
	public TransactionTopupByIAPRequest setCreatedUserID(Integer createdUserID) {
		this.createdUserID = createdUserID;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public TransactionTopupByIAPRequest setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public TransactionTopupByIAPRequest setDescription(String description) {
		this.description = description;
		return this;
	}
//	public Integer getDeviceType() {
//		return deviceType;
//	}
//	public TransactionTopupByIAPRequest setDeviceType(Integer deviceType) {
//		this.deviceType = deviceType;
//		return this;
//	}
	public String getPacketId() {
		return packetId;
	}
	public TransactionTopupByIAPRequest setPacketId(String packetId) {
		this.packetId = packetId;
		return this;
	}
	public Long getPurchaseDate() {
		return purchaseDate;
	}
	public TransactionTopupByIAPRequest setPurchaseDate(Long purchaseDate) {
		this.purchaseDate = purchaseDate;
		return this;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public TransactionTopupByIAPRequest setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}
	public String getReceiptBase() {
		return receiptBase;
	}
	public TransactionTopupByIAPRequest setReceiptBase(String receiptBase) {
		this.receiptBase = receiptBase;
		return this;
	}
	public String getReceiptBaseMd5() {
		return receiptBaseMd5;
	}
	public TransactionTopupByIAPRequest setReceiptBaseMd5(String receiptBaseMd5) {
		this.receiptBaseMd5 = receiptBaseMd5;
		return this;
	}
	public String getReceiptData() {
		return receiptData;
	}
	public TransactionTopupByIAPRequest setReceiptData(String receiptData) {
		this.receiptData = receiptData;
		return this;
	}
	public String getRelatedTransactionId() {
		return relatedTransactionId;
	}
	public TransactionTopupByIAPRequest setRelatedTransactionId(String relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
		return this;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public TransactionTopupByIAPRequest setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public TransactionTopupByIAPRequest setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}
	public String getUuid() {
		return uuid;
	}
	public TransactionTopupByIAPRequest setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}
	public Integer getDeductServiceId() {
		return deductServiceId;
	}
	public TransactionTopupByIAPRequest setDeductServiceId(Integer deductServiceId) {
		this.deductServiceId = deductServiceId;
		return this;
	}
	public String getDeductServiceKey() {
		return deductServiceKey;
	}
	public TransactionTopupByIAPRequest setDeductServiceKey(String deductServiceKey) {
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
//				.append(" Sign:").append(this.getSign())
//				.append(", AccountName:").append(this.getAccountName())
//				.append(", CpId:").append(this.getCpId())
//				.append(", ClientIp:").append(this.getClientIp())
//				.append(", CreatedUserID:").append(this.getCreatedUserID())
//				.append(", CreatedUserName:").append(this.getCreatedUserName())
//				.append(", Description:").append(this.getDescription())
//				.append(", PacketId:").append(this.getPacketId())
//				.append(", PurchaseDate:").append(this.getPurchaseDate())
//				.append(", Quantity:").append(this.getQuantity())
//				.append(", ReceiptBase:").append(this.getReceiptBase())
//				.append(", ReceiptBaseMd5:").append(this.getReceiptBaseMd5())
//				.append(", ReceiptData:").append(this.getReceiptData())
//				.append(", RelatedTransactionId:").append(this.getRelatedTransactionId())
//				.append(", ServiceId:").append(this.getServiceId())
//				.append(", ServiceKey:").append(this.getServiceKey())
//				.append(", Uuid:").append(this.getUuid())
//				.append(", DeductServiceId:").append(this.getDeductServiceId())
//				.append(", DeductServiceKey:").append(this.getDeductServiceKey())
//				.append(", ").append(super.toString());
//		
//		return sb.toString();
//	}
}
