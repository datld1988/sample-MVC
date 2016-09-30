package com.vtc.mongocore;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author PhongNV
 *
 */
public class RegisterData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer serviceId;
	private String serviceKey;
	private String accountName;
	private String email;
	private String mobile;
	private Integer registerType;
	private Integer deviceType;
	private String clientIp;
	
	//---- Register Social ---- //
	private String fbBussinessIds;
	private String fbEmail;
	private Integer isAutoAuthen;
	private Integer isDisableCheckSecure;
	private String oAuthAccount;
	private Integer oAuthSystemId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getRegisterType() {
		return registerType;
	}
	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
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
	public Integer getIsAutoAuthen() {
		return isAutoAuthen;
	}
	public void setIsAutoAuthen(Integer isAutoAuthen) {
		this.isAutoAuthen = isAutoAuthen;
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
