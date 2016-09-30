package com.vtc.mongocore;

public class ResetPasswordBySecureCodeMetadata {
	private java.lang.String accountName;

	private java.lang.String clientIp;

	private java.lang.String password;

	private java.lang.String secureCode;

	private Integer secureType;

	public java.lang.String getAccountName() {
		return accountName;
	}

	public ResetPasswordBySecureCodeMetadata setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
		return this;
	}

	public java.lang.String getClientIp() {
		return clientIp;
	}

	public ResetPasswordBySecureCodeMetadata setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
		return this;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public ResetPasswordBySecureCodeMetadata setPassword(java.lang.String password) {
		this.password = password;
		return this;
	}

	public java.lang.String getSecureCode() {
		return secureCode;
	}

	public ResetPasswordBySecureCodeMetadata setSecureCode(java.lang.String secureCode) {
		this.secureCode = secureCode;
		return this;
	}

	public Integer getSecureType() {
		return secureType;
	}

	public ResetPasswordBySecureCodeMetadata setSecureType(Integer secureType) {
		this.secureType = secureType;
		return this;
	}
}
