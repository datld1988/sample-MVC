package com.vtc.mongocore;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

public class GaMetadata implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String campaignName;
	private String campaignSource;
	private String campaignMedium;
	private String eventCategory;
    private String eventAction;
    private String eventLabel;
    private String eventValue;
    private String transactionId;
    private String transactionRevenue;
    
	public String getCampaignName() {
		return campaignName;
	}
	public GaMetadata setCampaignName(String campaignName) {
		this.campaignName = campaignName;
		return this;
	}
	public String getCampaignSource() {
		return campaignSource;
	}
	public GaMetadata setCampaignSource(String campaignSource) {
		this.campaignSource = campaignSource;
		return this;
	}
	public String getCampaignMedium() {
		return campaignMedium;
	}
	public GaMetadata setCampaignMedium(String campaignMedium) {
		this.campaignMedium = campaignMedium;
		return this;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public GaMetadata setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
		return this;
	}
	public String getEventAction() {
		return eventAction;
	}
	public GaMetadata setEventAction(String eventAction) {
		this.eventAction = eventAction;
		return this;
	}
	public String getEventLabel() {
		return eventLabel;
	}
	public GaMetadata setEventLabel(String eventLabel) {
		this.eventLabel = eventLabel;
		return this;
	}
	public String getEventValue() {
		return eventValue;
	}
	public GaMetadata setEventValue(String eventValue) {
		this.eventValue = eventValue;
		return this;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public GaMetadata setTransactionId(String transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	public String getTransactionRevenue() {
		return transactionRevenue;
	}
	public GaMetadata setTransactionRevenue(String transactionRevenue) {
		this.transactionRevenue = transactionRevenue;
		return this;
	}
	@Override
//	public String toString(){
//	    StringBuffer sb = new StringBuffer();
//	    if(campaignName != null){
//	    	sb.append(" CampaignName:").append(this.getCampaignMedium());
//	    }
//	    if(campaignSource != null){
//	    	sb.append(", CampaignSource:").append(this.getCampaignSource());
//	    }
//	    if(campaignMedium != null){
//	    	sb.append(", CampaignMedium:").append(this.getCampaignMedium());
//	    }
//	    if(eventCategory != null){
//	    	sb.append(", Category:").append(this.getEventCategory());
//	    }
//	    if(eventAction != null){
//	    	sb.append(", Action:").append(this.getEventAction());
//	    }
//	    if(eventLabel != null){
//	    	sb.append(", Label:").append(this.getEventLabel());
//	    }
//	    if(eventValue != null){
//	    	sb.append(", Value:").append(this.getEventValue());
//	    }
//	    if(transactionId != null){
//	    	sb.append(", TransactionId:").append(this.getTransactionId());
//	    }
//	    if(transactionRevenue != null){
//	    	sb.append(", TransactionRevenue:").append(this.getTransactionRevenue());
//	    }
//	    
//	    return sb.toString();
//	}
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
