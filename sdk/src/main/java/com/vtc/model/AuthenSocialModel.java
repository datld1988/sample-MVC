package com.vtc.model;


import java.io.Serializable;
import java.util.Calendar;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.vtc.ws.v2.model.info.AccountFull;

public class AuthenSocialModel implements Serializable {
	private String clientIp;
	private Integer deviceType;
	private String fbBussinessIds;
	private String fbEmail;
	private Integer isAutoCreate;
	private Integer isDisableCheckSecure;
	private String oAuthAccount;
	private Integer oAuthSystemId;
	private String secureCode;
	private Integer secureType;
	private Integer serviceId;
	private String serviceKey;
	private String signDisableSecure;
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getFbBussinessIds() {
		return fbBussinessIds;
	}
	public void setFbBussinessIds(String fbBussinessIds) {
		this.fbBussinessIds = fbBussinessIds;
	}
	public String getFbEmail() {
		return fbEmail;
	}
	public void setFbEmail(String fbEmail) {
		this.fbEmail = fbEmail;
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
	public String getoAuthAccount() {
		return oAuthAccount;
	}
	public void setoAuthAccount(String oAuthAccount) {
		this.oAuthAccount = oAuthAccount;
	}
	public Integer getoAuthSystemId() {
		return oAuthSystemId;
	}
	public void setoAuthSystemId(Integer oAuthSystemId) {
		this.oAuthSystemId = oAuthSystemId;
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
	public String getSignDisableSecure() {
		return signDisableSecure;
	}
	public void setSignDisableSecure(String signDisableSecure) {
		this.signDisableSecure = signDisableSecure;
	}
}
