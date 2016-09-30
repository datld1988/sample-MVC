package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;

public class RegisterSMSPlusRequest extends Request {
	private String smsPlusMobile;

	public String getSmsPlusMobile() {
		return smsPlusMobile;
	}

	public void setSmsPlusMobile(String smsPlusMobile) {
		this.smsPlusMobile = smsPlusMobile;
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
