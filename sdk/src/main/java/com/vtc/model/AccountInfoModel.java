package com.vtc.model;


import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.vtc.ws.v2.model.info.AccountFull;

public class AccountInfoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String userName;
	private String email;
	private Integer userStatus;
	private String mobile;

	public AccountInfoModel() {
		
	}

	public AccountInfoModel(AccountFull user) {
		super();
		this.id = user.getAccountID();
		this.userName = user.getAccountName();
		this.email = user.getEmail();
		this.userStatus = user.getStatus();
		this.mobile = user.getMobile();
	}

	public AccountInfoModel(AccountInfoFullModel user) {
		super();
		this.id = user.getId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
		this.userStatus = user.getUserStatus();
		this.mobile = user.getMobile();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String toString() {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			return ow.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
