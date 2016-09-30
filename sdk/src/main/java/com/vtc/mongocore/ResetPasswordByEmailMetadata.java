package com.vtc.mongocore;

public class ResetPasswordByEmailMetadata {

	private String accountName;
	private java.lang.String clientIp;

	private java.lang.String email;

	private java.lang.String password;

	public String getAccountName() {
		return accountName;
	}

	public ResetPasswordByEmailMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}

	public java.lang.String getClientIp() {
		return clientIp;
	}

	public ResetPasswordByEmailMetadata setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
		return this;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public ResetPasswordByEmailMetadata setEmail(java.lang.String email) {
		this.email = email;
		return this;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public ResetPasswordByEmailMetadata setPassword(java.lang.String password) {
		this.password = password;
		return this;
	}
}
