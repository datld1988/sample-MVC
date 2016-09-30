package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class AuthenSocialRequest extends Request {
	private Integer oAuthSystemId;
	private String oAuthAccount;
	private String fbEmail;
	private String fbBussinessIds;
	private String accessToken;
	
	public Integer getoAuthSystemId() {
		return oAuthSystemId;
	}
	public void setoAuthSystemId(Integer oAuthSystemId) {
		this.oAuthSystemId = oAuthSystemId;
	}
	public String getoAuthAccount() {
		return oAuthAccount;
	}
	public void setoAuthAccount(String oAuthAccount) {
		this.oAuthAccount = oAuthAccount;
	}
	public String getFbEmail() {
		return fbEmail;
	}
	public void setFbEmail(String fbEmail) {
		this.fbEmail = fbEmail;
	}
	public String getFbBussinessIds() {
		return fbBussinessIds;
	}
	public void setFbBussinessIds(String fbBussinessIds) {
		this.fbBussinessIds = fbBussinessIds;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
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
