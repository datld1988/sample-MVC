package com.vtc.model;

public class GoogleVerifyResponse {
	// 0:Yet to be consumed         1:Consumed
	private Integer consumptionState;
	private String developerPayload;
	private String kind;
	//0:Purchased    1:Cancelled
	private Integer purchaseState;
	private String purchaseTime;
	
	public Integer getConsumptionState() {
		return consumptionState;
	}
	public void setConsumptionState(Integer consumptionState) {
		this.consumptionState = consumptionState;
	}
	public String getDeveloperPayload() {
		return developerPayload;
	}
	public void setDeveloperPayload(String developerPayload) {
		this.developerPayload = developerPayload;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getPurchaseState() {
		return purchaseState;
	}
	public void setPurchaseState(Integer purchaseState) {
		this.purchaseState = purchaseState;
	}
	public String getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	
}
