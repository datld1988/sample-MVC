package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;

public class ChangePasswordRequest extends Request {
    private java.lang.String clientIp;

    private java.lang.String newPassword;

    private java.lang.String oldPassword;

    private java.lang.String secureCode;

    private Integer secureType;
    
	public java.lang.String getClientIp() {
		return clientIp;
	}

	public void setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
	}

	public java.lang.String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(java.lang.String newPassword) {
		this.newPassword = newPassword;
	}

	public java.lang.String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(java.lang.String oldPassword) {
		this.oldPassword = oldPassword;
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
