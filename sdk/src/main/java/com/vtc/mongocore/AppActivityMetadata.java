package com.vtc.mongocore;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class AppActivityMetadata extends GaMetadata implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String trackingId;

	public String getTrackingId() {
		return trackingId;
	}

	public AppActivityMetadata setTrackingId(String trackingId) {
		this.trackingId = trackingId;
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
