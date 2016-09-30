package com.vtc.mongocore;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

public class RegisterSMSPlusMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer accountId;
	
	private String accountName;
	
	private String smsPlusMobile;

	public Integer getAccountId() {
		return accountId;
	}

	public RegisterSMSPlusMetadata setAccountId(Integer accountId) {
		this.accountId = accountId;
		return this;
	}

	public String getAccountName() {
		return accountName;
	}

	public RegisterSMSPlusMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}

	public String getSmsPlusMobile() {
		return smsPlusMobile;
	}

	public RegisterSMSPlusMetadata setSmsPlusMobile(String smsPlusMobile) {
		this.smsPlusMobile = smsPlusMobile;
		return this;
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
