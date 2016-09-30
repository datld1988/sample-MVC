package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class AppActivityRequest extends Request {
//	private String campaign;
//	private String medium;
//	private String source;
//	private String agency;
//	private String clientId;
//	private String accountName;
//	private String clientIp;
//	private Integer deviceType;
//	
//	private String gaTrackingId;
//	private String gaClientId;
//	private String eventCategory;
//	private String eventAction;
//	private String eventLabel;
	private Integer activityType; //1:FirstOpen, 2:CloseApp, 3:Crash, 4: Click

	public Integer getActivityType() {
		return activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

	@Override
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
