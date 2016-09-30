package com.vtc.request;

public class ResetPasswordBySecureCodeRequest extends Request {

	private java.lang.String clientIp;

	private java.lang.String password;

	private java.lang.String secureCode;

	private Integer secureType;
	
	public java.lang.String getClientIp() {
		return clientIp;
	}

	public void setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getSecureCode() {
		return secureCode;
	}

	public void setSecureCode(java.lang.String secureCode) {
		this.secureCode = secureCode;
	}

	public Integer getSecureType() {
		return secureType;
	}

	public void setSecureType(Integer secureType) {
		this.secureType = secureType;
	}
}
