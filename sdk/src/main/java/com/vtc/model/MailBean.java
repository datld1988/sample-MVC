package com.vtc.model;

import java.io.Serializable;

public class MailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String message;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
