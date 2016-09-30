package com.vtc.mongocore;

import java.io.Serializable;

public class ReAuthenticationMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer serviceId;
	private String serviceKey;
	private Integer serviceId_Old;
	private String accessToken;
	private String accountName;
	private Integer deviceType;
	private String clientIp;
	private Integer authenType;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public ReAuthenticationMetadata setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public ReAuthenticationMetadata setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}
	public Integer getServiceId_Old() {
		return serviceId_Old;
	}
	public ReAuthenticationMetadata setServiceId_Old(Integer serviceId_Old) {
		this.serviceId_Old = serviceId_Old;
		return this;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public ReAuthenticationMetadata setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}
	public String getAccountName() {
		return accountName;
	}
	public ReAuthenticationMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public ReAuthenticationMetadata setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public ReAuthenticationMetadata setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Integer getAuthenType() {
		return authenType;
	}
	public ReAuthenticationMetadata setAuthenType(Integer authenType) {
		this.authenType = authenType;
		return this;
	}
	

}
