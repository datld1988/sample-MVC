package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class AuthenticationRequest extends AuthenSocialRequest {
	private String password;
	private String secureCode;
	private Integer secureType;
	private String clientIp;
	private Integer authenType;
	private Integer serviceId;
	private String serviceKey;
	
	//----- FB ---------//
	private Integer authenSocial;
	private Integer isAutoCreate;
	private Integer isDisableCheckSecure;
	private String signDisableSecure;
	
	// ---- Reauthen ------//
	private String billing_token;
	private Integer serviceIdOld;
	private Integer isAutoAuthen;
	
	public String getClientIp() {
		return clientIp;
	}
	public AuthenticationRequest setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public AuthenticationRequest setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getSecureCode() {
		return secureCode;
	}
	public AuthenticationRequest setSecureCode(String secureCode) {
		this.secureCode = secureCode;
		return this;
	}
	public Integer getSecureType() {
		return secureType;
	}
	public AuthenticationRequest setSecureType(Integer secureType) {
		this.secureType = secureType;
		return this;
	}
	
	public Integer getAuthenSocial() {
		return authenSocial;
	}
	public AuthenticationRequest setAuthenSocial(Integer authenSocial) {
		this.authenSocial = authenSocial;
		return this;
	}
	public Integer getIsAutoCreate() {
		return isAutoCreate;
	}
	public AuthenticationRequest setIsAutoCreate(Integer isAutoCreate) {
		this.isAutoCreate = isAutoCreate;
		return this;
	}
	public Integer getIsDisableCheckSecure() {
		return isDisableCheckSecure;
	}
	public AuthenticationRequest setIsDisableCheckSecure(Integer isDisableCheckSecure) {
		this.isDisableCheckSecure = isDisableCheckSecure;
		return this;
	}
	public String getSignDisableSecure() {
		return signDisableSecure;
	}
	public AuthenticationRequest setSignDisableSecure(String signDisableSecure) {
		this.signDisableSecure = signDisableSecure;
		return this;
	}
	public Integer getAuthenType() {
		return authenType;
	}
	public AuthenticationRequest setAuthenType(Integer authenType) {
		this.authenType = authenType;
		return this;
	}
	public String getBilling_token() {
		return billing_token;
	}
	public AuthenticationRequest setBilling_token(String billing_token) {
		this.billing_token = billing_token;
		return this;
	}
	public Integer getServiceIdOld() {
		return serviceIdOld;
	}
	public AuthenticationRequest setServiceIdOld(Integer serviceIdOld) {
		this.serviceIdOld = serviceIdOld;
		return this;
	}
	
	public Integer getServiceId() {
		return serviceId;
	}
	public AuthenticationRequest setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public AuthenticationRequest setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
		return this;
	}
	public Integer getIsAutoAuthen() {
		return isAutoAuthen;
	}
	public void setIsAutoAuthen(Integer isAutoAuthen) {
		this.isAutoAuthen = isAutoAuthen;
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
