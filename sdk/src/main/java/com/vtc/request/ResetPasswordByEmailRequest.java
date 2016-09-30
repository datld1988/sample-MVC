package com.vtc.request;

public class ResetPasswordByEmailRequest extends Request{

    private java.lang.String clientIp;

    private java.lang.String email;

    private java.lang.String password;
    
    private String sign;

	public java.lang.String getClientIp() {
		return clientIp;
	}

	public void setClientIp(java.lang.String clientIp) {
		this.clientIp = clientIp;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
		
	}
    
}
