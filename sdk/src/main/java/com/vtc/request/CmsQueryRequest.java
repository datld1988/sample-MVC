package com.vtc.request;

public class CmsQueryRequest extends Request{
	private String gaTrackingId;
	private String gaViewId;
	private String fromDate;
	private String toDate;
	private String osSystem;
	private String campaign;
	private String source;
	private String medium;
	private String filterChannel;
	
	public String getGaTrackingId() {
		return gaTrackingId;
	}
	public void setGaTrackingId(String gaTrackingId) {
		this.gaTrackingId = gaTrackingId;
	}
	public String getGaViewId() {
		return gaViewId;
	}
	public void setGaViewId(String gaViewId) {
		this.gaViewId = gaViewId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getOsSystem() {
		return osSystem;
	}
	public void setOsSystem(String osSystem) {
		this.osSystem = osSystem;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getFilterChannel() {
		return filterChannel;
	}
	public void setFilterChannel(String filterChannel) {
		this.filterChannel = filterChannel;
		
	}
	
}
