package com.vtc.mongocore;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

public class LoginData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer serviceId;
	private String serviceKey;
	private String accountName;
	private String secureCode;
	private Integer secureType;
	private Integer deviceType;
	private String clientIP;
	private Integer authenType;

	private Integer authenSocial;
	private Integer oAuthSystemId;
	private String oAuthAccount;
	private String fbEmail;
	private String fbBussinessIds;
	private Integer isAutoCreate;
	private Integer isDisableCheckSecure;
	private String signDisableSecure; 
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getSecureCode() {
		return secureCode;
	}
	public void setSecureCode(String secureCode) {
		this.secureCode = secureCode;
	}
	public Integer getSecureType() {
		return secureType;
	}
	public void setSecureType(Integer secureType) {
		this.secureType = secureType;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getClientIP() {
		return clientIP;
	}
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	public Integer getAuthenType() {
		return authenType;
	}
	public void setAuthenType(Integer authenType) {
		this.authenType = authenType;
	}
	public Integer getAuthenSocial() {
		return authenSocial;
	}
	public void setAuthenSocial(Integer authenSocial) {
		this.authenSocial = authenSocial;
	}
	public Integer getoAuthSystemId() {
		return oAuthSystemId;
	}
	public void setoAuthSystemId(Integer oAuthSystemId) {
		this.oAuthSystemId = oAuthSystemId;
	}
	public String getoAuthAccount() {
		return oAuthAccount;
	}
	public void setoAuthAccount(String oAuthAccount) {
		this.oAuthAccount = oAuthAccount;
	}
	public String getFbEmail() {
		return fbEmail;
	}
	public void setFbEmail(String fbEmail) {
		this.fbEmail = fbEmail;
	}
	public String getFbBussinessIds() {
		return fbBussinessIds;
	}
	public void setFbBussinessIds(String fbBussinessIds) {
		this.fbBussinessIds = fbBussinessIds;
	}
	public Integer getIsAutoCreate() {
		return isAutoCreate;
	}
	public void setIsAutoCreate(Integer isAutoCreate) {
		this.isAutoCreate = isAutoCreate;
	}
	public Integer getIsDisableCheckSecure() {
		return isDisableCheckSecure;
	}
	public void setIsDisableCheckSecure(Integer isDisableCheckSecure) {
		this.isDisableCheckSecure = isDisableCheckSecure;
	}
	public String getSignDisableSecure() {
		return signDisableSecure;
	}
	public void setSignDisableSecure(String signDisableSecure) {
		this.signDisableSecure = signDisableSecure;
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
