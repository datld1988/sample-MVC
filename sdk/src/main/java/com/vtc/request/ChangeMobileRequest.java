package com.vtc.request;

import com.vtc.ws.v2.model.update.ChangeMobileRequestData;

public class ChangeMobileRequest extends Request{
	private String clientIp;
	private ChangeMobileRequestData requestData;
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public ChangeMobileRequestData getRequestData() {
		return requestData;
	}
	public void setRequestData(ChangeMobileRequestData requestData) {
		this.requestData = requestData;
	}
}
