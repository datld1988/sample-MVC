package com.vtc.model;

public class TrackingModel {
	private String gaTrackingId;
	private String gaClientId;
	private String hitType;
	private String campaignName;
	private String campaignSource;
	private String campaignMedium;
	private String category;
	private String action;
	private String label;
	private String value;
	private String transactionId;
	private String transactionRevenue;
	
	public String getGaTrackingId() {
		return gaTrackingId;
	}
	public TrackingModel setGaTrackingId(String gaTrackingId) {
		this.gaTrackingId = gaTrackingId;
		return this;
	}
	public String getGaClientId() {
		return gaClientId;
	}
	public TrackingModel setGaClientId(String gaClientId) {
		this.gaClientId = gaClientId;
		return this;
	}
	public String getHitType() {
		return hitType;
	}
	public TrackingModel setHitType(String hitType) {
		this.hitType = hitType;
		return this;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public TrackingModel setCampaignName(String campaignName) {
		this.campaignName = campaignName;
		return this;
	}
	public String getCampaignSource() {
		return campaignSource;
	}
	public TrackingModel setCampaignSource(String campaignSource) {
		this.campaignSource = campaignSource;
		return this;
	}
	public String getCampaignMedium() {
		return campaignMedium;
	}
	public TrackingModel setCampaignMedium(String campaignMedium) {
		this.campaignMedium = campaignMedium;
		return this;
	}
	public String getCategory() {
		return category;
	}
	public TrackingModel setCategory(String category) {
		this.category = category;
		return this;
	}
	public String getAction() {
		return action;
	}
	public TrackingModel setAction(String action) {
		this.action = action;
		return this;
	}
	public String getLabel() {
		return label;
	}
	public TrackingModel setLabel(String label) {
		this.label = label;
		return this;
	}
	public String getValue() {
		return value;
	}
	public TrackingModel setValue(String value) {
		this.value = value;
		return this;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public TrackingModel setTransactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	public String getTransactionRevenue() {
		return transactionRevenue;
	}
	public TrackingModel setTransactionRevenue(String transactionRevenue) {
		this.transactionRevenue = transactionRevenue;
		return this;
	}
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer()
				.append(" GaTrackingId:").append(gaTrackingId)
				.append(", GaClientId:").append(gaClientId)
				.append(", HitType:").append(hitType);
		
		if(campaignName != null){
			str.append(", CampaignName:").append(campaignName);
		}
		if(campaignSource != null){
			str.append(", CampaignSource:").append(campaignSource);
		}
		if(campaignMedium != null){
			str.append(", CampaignMedium:").append(campaignMedium);
		}
		if(category != null){
			str.append(", Category").append(category);
		}
		if(category != null){
			str.append(", Action").append(action);
		}
		if(label != null){
			str.append("").append(label);
		}
		if(value != null ){
			str.append("").append(value);
		}
		
		return str.toString();
	}
}
