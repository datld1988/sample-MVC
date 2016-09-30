package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class TransactionDeductVcoinRequest extends Request {
    private Integer cpId;
    private String clientIp;
    private Long clientTime;
    private Integer createdUserId;
    private String createdUserName;
    private String description;
    private Long relatedTransactionId;
    private Integer serviceId;
    private String serviceKey;
    private Integer vcoin;
    private String sign;
    private Integer relatedAccountId;

	public Integer getCpId() {
		return cpId;
	}

	public TransactionDeductVcoinRequest setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}

	public String getClientIp() {
		return clientIp;
	}

	public TransactionDeductVcoinRequest setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}

	public Long getClientTime() {
		return clientTime;
	}

	public TransactionDeductVcoinRequest setClientTime(Long clientTime) {
		this.clientTime = clientTime;
		return this;
	}

	public Integer getCreatedUserId() {
		return createdUserId;
	}

	public TransactionDeductVcoinRequest setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
		return this;
	}

	public String getCreatedUserName() {
		return createdUserName;
	}

	public TransactionDeductVcoinRequest setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public TransactionDeductVcoinRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	public Long getRelatedTransactionId() {
		return relatedTransactionId;
	}

	public TransactionDeductVcoinRequest setRelatedTransactionId(Long relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
		return this;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public TransactionDeductVcoinRequest setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getServiceKey() {
		return serviceKey;
	}

	public TransactionDeductVcoinRequest setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}

	public Integer getVcoin() {
		return vcoin;
	}

	public TransactionDeductVcoinRequest setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
		return this;
	}
	
	public String getSign() {
		return sign;
	}

	public TransactionDeductVcoinRequest setSign(String sign) {
		this.sign = sign;
		return this;
	}

	public Integer getRelatedAccountId() {
		return relatedAccountId;
	}

	public TransactionDeductVcoinRequest setRelatedAccountId(Integer relatedAccountId) {
		this.relatedAccountId = relatedAccountId;
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
//				.append(" AccountId:").append(this.getAccountId())
//				.append(", AccountName:").append(this.getAccountName())
//				.append(", CpId:").append(this.getCpId())
//				.append(", ClientIp:").append(this.getClientIp())
//				.append(", ClientTime:").append(this.getClientTime())
//				.append(", CreatedUserId:").append(this.getCreatedUserId())
//				.append(", CreatedUserName:").append(this.getCreatedUserName())
//				.append(", Description:").append(this.getDescription())
//				.append(", RelatedTransactionId:").append(this.getRelatedTransactionId())
//				.append(", ServiceId:").append(this.getServiceId())
//				.append(", ServiceKey:").append(this.getServiceKey())
//				.append(", Vcoin:").append(this.getVcoin())
//				.append(", Sign:").append(this.getSign())
//				.append(", RelatedAccountId").append(this.getRelatedAccountId())
//				.append(", ").append(super.toString());
//				
//		
//		return sb.toString();
//	}
}
