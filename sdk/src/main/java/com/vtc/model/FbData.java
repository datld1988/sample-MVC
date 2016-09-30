package com.vtc.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FbData{
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("app")
	private FbApp app;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FbApp getApp() {
		return app;
	}

	public void setApp(FbApp app) {
		this.app = app;
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
