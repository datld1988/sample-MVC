package com.vtc.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FbError {
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("code")
	private Integer code;
	
	@JsonProperty("error_subcode")
	private Integer errorSubCode;
	
	@JsonProperty("fbtrace_id")
	private String fbTraceId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getErrorSubCode() {
		return errorSubCode;
	}

	public void setErrorSubCode(Integer errorSubCode) {
		this.errorSubCode = errorSubCode;
	}

	public String getFbTraceId() {
		return fbTraceId;
	}

	public void setFbTraceId(String fbTraceId) {
		this.fbTraceId = fbTraceId;
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
