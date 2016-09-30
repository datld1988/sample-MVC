package com.vtc.response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class ResponseModel {
	private Integer error;
	private String message;
	private Object info;
	public ResponseModel() {
		
	}
	public ResponseModel(Integer error, String message){
		super();
		this.error = error;
		this.message = message;
	}
	public ResponseModel(Integer error, String message, Object info) {
		super();
		this.error = error;
		this.message = message;
		this.info = info;
	}
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	
	public String toString() {
		return new StringBuffer(" Error:").append(this.getError())
				.append(" ,Message:").append(this.getMessage())
				.append(" ,Info: {").append(this.getInfo() != null ? this.getInfo().toString() : "")
				.append(" }")
				.toString();
	}

}
