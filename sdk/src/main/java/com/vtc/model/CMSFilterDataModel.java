package com.vtc.model;

import java.util.List;

public class CMSFilterDataModel {
	private List<String> campaigns;
	
	private List<String> sources;
	
	private List<String> mediums;

	public List<String> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<String> campaigns) {
		this.campaigns = campaigns;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public List<String> getMediums() {
		return mediums;
	}

	public void setMediums(List<String> mediums) {
		this.mediums = mediums;
	}
}
