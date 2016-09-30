package com.vtc.model;

import com.vtc.request.Request;

public class AutoLoginRequest extends Request {
	public Integer osType;

	public Integer getOsType() {
		return osType;
	}

	public void setOsType(Integer osType) {
		this.osType = osType;
	}
}
