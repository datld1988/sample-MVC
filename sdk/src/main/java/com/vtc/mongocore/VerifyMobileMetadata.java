package com.vtc.mongocore;

public class VerifyMobileMetadata {
	private java.lang.String accountName;

    private java.lang.String clientIp;

    private java.lang.String mobile;

    private java.lang.String otp;
    
    private String sign;

	public java.lang.String getAccountName() {
		return accountName;
	}

	public VerifyMobileMetadata setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
		return this;
	}

	public java.lang.String getClientIp() {
		return clientIp;
	}

	public VerifyMobileMetadata setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
		return this;
	}

	public java.lang.String getMobile() {
		return mobile;
	}

	public VerifyMobileMetadata setMobile(java.lang.String mobile) {
		this.mobile = mobile;
		return this;
	}

	public java.lang.String getOtp() {
		return otp;
	}

	public VerifyMobileMetadata setOtp(java.lang.String otp) {
		this.otp = otp;
		return this;
	}

	public String getSign() {
		return sign;
	}

	public VerifyMobileMetadata setSign(String sign) {
		this.sign = sign;
		return this;
	}
}
