package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class AccountRegisterRequest extends AuthenSocialRequest {
	// ----- Billing data request ----///
	private String password;
	private String mobile;
	private Integer registerType;
	private String clientIp;
	private Integer serviceId;
	private String serviceKey;
	
	private Integer isAutoAuthen;
	private Integer isDisableCheckSecure;
	private String signDisableSecure;
	
	public String getPassword() {
		return password;
	}
	public AccountRegisterRequest setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public AccountRegisterRequest setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public Integer getRegisterType() {
		return registerType;
	}
	public AccountRegisterRequest setRegisterType(Integer registerType) {
		this.registerType = registerType;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public AccountRegisterRequest setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public Integer getIsAutoAuthen() {
		return isAutoAuthen;
	}
	public AccountRegisterRequest setIsAutoAuthen(Integer isAutoAuthen) {
		this.isAutoAuthen = isAutoAuthen;
		return this;
	}
	public Integer getIsDisableCheckSecure() {
		return isDisableCheckSecure;
	}
	public AccountRegisterRequest setIsDisableCheckSecure(Integer isDisableCheckSecure) {
		this.isDisableCheckSecure = isDisableCheckSecure;
		return this;
	}
	public String getSignDisableSecure() {
		return signDisableSecure;
	}
	public AccountRegisterRequest setSignDisableSecure(String signDisableSecure) {
		this.signDisableSecure = signDisableSecure;
		return this;
	}
		
	public Integer getServiceId() {
		return serviceId;
	}
	public AccountRegisterRequest setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
		return this;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public AccountRegisterRequest setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
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
