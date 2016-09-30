package com.vtc.mongocore;

public class ChangePasswordMetadata {
	private String accountName;
	
	private java.lang.String clientIp;

	private java.lang.String newPassword;

	private java.lang.String oldPassword;

	private java.lang.String secureCode;

	private Integer secureType;

	public String getAccountName() {
		return accountName;
	}

	public ChangePasswordMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	
	public java.lang.String getClientIp() {
		return clientIp;
	}

	public ChangePasswordMetadata setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
		return this;
	}

	public java.lang.String getNewPassword() {
		return newPassword;
	}

	public ChangePasswordMetadata setNewPassword(java.lang.String newPassword) {
		this.newPassword = newPassword;
		return this;
	}

	public java.lang.String getOldPassword() {
		return oldPassword;
	}

	public ChangePasswordMetadata setOldPassword(java.lang.String oldPassword) {
		this.oldPassword = oldPassword;
		return this;
	}

	public java.lang.String getSecureCode() {
		return secureCode;
	}

	public ChangePasswordMetadata setSecureCode(java.lang.String secureCode) {
		this.secureCode = secureCode;
		return this;
	}

	public Integer getSecureType() {
		return secureType;
	}

	public ChangePasswordMetadata setSecureType(Integer secureType) {
		this.secureType = secureType;
		return this;
	}
}
