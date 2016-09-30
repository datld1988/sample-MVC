package com.vtc.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppleReceiptData {
	@JsonProperty("in_app")
	private List<AppleReceiptInApp> inApp;

	public List<AppleReceiptInApp> getInApp() {
		return inApp;
	}

	public void setInApp(List<AppleReceiptInApp> inApp) {
		this.inApp = inApp;
	}

	
}
