package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;

public class ActiveSMSPlusRequest extends Request {
	private String otp;
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

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
		
	}
}
