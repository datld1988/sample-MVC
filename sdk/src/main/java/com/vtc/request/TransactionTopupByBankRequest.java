package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class TransactionTopupByBankRequest extends Request {

	private String name;
	private String bankCode;
	private Integer cpId;
	private String clientIp;
	private Long clientTime;
	private Integer createdUserId;
	private String createdUserName;
	private String description;
	private String notifyUrl;
	private String orderCode;
	private Integer productId;
	private String returnUrl;
	private Integer vcoin;
	
	// Service tru vcoin nap vao game
	private Integer deductServiceId;
	private String deductServiceKey;
	
	public String getName() {
		return name;
	}
	public TransactionTopupByBankRequest setName(String name) {
		this.name = name;
		return this;
	}
	public String getBankCode() {
		return bankCode;
	}
	public TransactionTopupByBankRequest setBankCode(String bankCode) {
		this.bankCode = bankCode;
		return this;
	}
	public Integer getCpId() {
		return cpId;
	}
	public TransactionTopupByBankRequest setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public TransactionTopupByBankRequest setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Long getClientTime() {
		return clientTime;
	}
	public TransactionTopupByBankRequest setClientTime(Long clientTime) {
		this.clientTime = clientTime;
		return this;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public TransactionTopupByBankRequest setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public TransactionTopupByBankRequest setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public Integer getDeductServiceId() {
		return deductServiceId;
	}
	public TransactionTopupByBankRequest setDeductServiceId(Integer deductServiceId) {
		this.deductServiceId = deductServiceId;
		return this;
	}
	public String getDeductServiceKey() {
		return deductServiceKey;
	}
	public TransactionTopupByBankRequest setDeductServiceKey(String deductServiceKey) {
		this.deductServiceKey = deductServiceKey;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public TransactionTopupByBankRequest setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public TransactionTopupByBankRequest setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
		return this;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public TransactionTopupByBankRequest setOrderCode(String orderCode) {
		this.orderCode = orderCode;
		return this;
	}
	public Integer getProductId() {
		return productId;
	}
	public TransactionTopupByBankRequest setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public TransactionTopupByBankRequest setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}
	public Integer getVcoin() {
		return vcoin;
	}
	public TransactionTopupByBankRequest setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
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
//				.append(", BankCode:").append(this.getBankCode())
//				.append(", CpId:").append(this.getCpId())
//				.append(", ClientIp:").append(this.getClientIp())
//				.append(", ClientTime:").append(this.getClientTime())
//				.append(", CreatedUserId:").append(this.getCreatedUserId())
//				.append(", CreatedUserName:").append(this.getCreatedUserName())
//				.append(", NotifyUrl:").append(this.getNotifyUrl())
//				.append(", OrderCode:").append(this.getOrderCode())
//				.append(", ProductId:").append(this.getProductId())
//				.append(", ReturnUrl:").append(this.getReturnUrl())
//				.append(", Vcoin:").append(this.getVcoin())
//				.append(", Description:").append(this.getDescription())
//				.append(", DeductServiceId:").append(this.getDeductServiceId())
//				.append(", DeductServiceKey:").append(this.getDeductServiceKey())
//				.append(", ").append(super.toString());
//		
//		return sb.toString();
//	}
}
