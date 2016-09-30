package com.vtc.mongocore;

public class ActiveSMSPlusMetadata {
	private Integer accountId;
	private String otp;
	private String smsPlusMobile;

	public Integer getAccountId() {
		return accountId;
	}
	public ActiveSMSPlusMetadata setAccountId(Integer accountId) {
		this.accountId = accountId;
		return this;
	}
	public String getOtp() {
		return otp;
	}
	public ActiveSMSPlusMetadata setOtp(String otp) {
		this.otp = otp;
		return this;
	}
	public String getSmsPlusMobile() {
		return smsPlusMobile;
	}
	public ActiveSMSPlusMetadata setSmsPlusMobile(String smsPlusMobile) {
		this.smsPlusMobile = smsPlusMobile;
		return this;
	}
}
