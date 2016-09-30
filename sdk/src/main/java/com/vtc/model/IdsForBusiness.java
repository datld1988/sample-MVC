package com.vtc.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class IdsForBusiness {
	@JsonProperty("data")
	private List<FbData> data;
	
	public List<FbData> getData() {
		return data;
	}

	public void setData(List<FbData> data) {
		this.data = data;
	}

	
}
