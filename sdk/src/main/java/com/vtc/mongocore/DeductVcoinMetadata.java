package com.vtc.mongocore;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class DeductVcoinMetadata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountId;
    private String accountName;
    private Integer cpId;
    private String clientIp;
    private Long clientTime;
    private Integer createdUserId;
    private String createdUserName;
    private Integer deviceType;
    private String description;
    private Long relatedTransactionId;
    private Integer serviceId;
    private String serviceKey;
    private Integer vcoin;
    private String sign;
    private Integer relatedAccountId;
    
	public Integer getAccountId() {
		return accountId;
	}
	public DeductVcoinMetadata setAccountId(Integer accountId) {
		this.accountId = accountId;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public DeductVcoinMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public Integer getCpId() {
		return cpId;
	}
	public DeductVcoinMetadata setCpId(Integer cpId) {
		this.cpId = cpId;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public DeductVcoinMetadata setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Long getClientTime() {
		return clientTime;
	}
	public DeductVcoinMetadata setClientTime(Long clientTime) {
		this.clientTime = clientTime;
		return this;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public DeductVcoinMetadata setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
		return this;
	}
	public String getCreatedUserName() {
		return createdUserName;
	}
	public DeductVcoinMetadata setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public DeductVcoinMetadata setDescription(String description) {
		this.description = description;
		return this;
	}
	public Long getRelatedTransactionId() {
		return relatedTransactionId;
	}
	public DeductVcoinMetadata setRelatedTransactionId(Long relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
		return this;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public DeductVcoinMetadata setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public DeductVcoinMetadata setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}
	public Integer getVcoin() {
		return vcoin;
	}
	public DeductVcoinMetadata setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
		return this;
	}
	public String getSign() {
		return sign;
	}
	public DeductVcoinMetadata setSign(String sign) {
		this.sign = sign;
		return this;
	}
	public Integer getRelatedAccountId() {
		return relatedAccountId;
	}
	public DeductVcoinMetadata setRelatedAccountId(Integer relatedAccountId) {
		this.relatedAccountId = relatedAccountId;
		return this;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public DeductVcoinMetadata setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
		return this;
	}
	
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();//.writer().withDefaultPrettyPrinter();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
