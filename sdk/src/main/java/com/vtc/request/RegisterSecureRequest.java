package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;

import com.vtc.ws.v2.model.plus.AuthenSecureRequestData;

public class RegisterSecureRequest extends Request {
	private AuthenSecureRequestData requestData;

	public AuthenSecureRequestData getRequestData() {
		return requestData;
	}

	public void setRequestData(AuthenSecureRequestData requestData) {
		this.requestData = requestData;
		
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
