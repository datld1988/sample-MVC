package com.vtc.model;


import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class BillingTokenModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private String userName;

	private String password;

	private Integer serviceId;

	private String serviceKey;

	private String billingAccessToken;


	public BillingTokenModel() {
		
	}
	
	public static BillingTokenModel fromJson(String s) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			BillingTokenModel user = mapper.readValue(s, BillingTokenModel.class);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceKey() {
		return serviceKey;
	}

	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}

	public String getBillingAccessToken() {
		return billingAccessToken;
	}

	public void setBillingAccessToken(String billingAccessToken) {
		this.billingAccessToken = billingAccessToken;
	}
	
}
