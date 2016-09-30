package com.vtc.request;

import org.codehaus.jackson.map.ObjectMapper;

import com.vtc.model.TrackingModel;

public class Request {
	private String clientId;
	private String clientSecret;
	private Integer deviceType;
	private String deviceToken;
	private String manufacture;
	private String modelName;
	private String operatingSystem;
	private String operatingSystemVersion;
	private String utm;
	private String campaign;
    private String medium;
    private String source;
    private String agency;
    private Integer accountId;
    private String accountName;
    private String email;
    private String adsId;
	private TrackingModel trackingModel;
	
	// Ad_Id
	// Token Notification
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getOperatingSystemVersion() {
		return operatingSystemVersion;
	}
	public void setOperatingSystemVersion(String operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}
	public String getUtm() {
		return utm;
	}
	public void setUtm(String utm) {
		this.utm = utm;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public TrackingModel getTrackingModel() {
		return trackingModel == null ? trackingModel = new TrackingModel() : trackingModel;
	}
	public void setTrackingModel(TrackingModel trackingModel) {
		this.trackingModel = trackingModel;
	}
	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdsId() {
		return adsId;
	}
	public void setAdsId(String adsId) {
		this.adsId = adsId;
	}
	//	@Override
//	public String toString(){
//		StringBuffer build = new StringBuffer()
//				.append(" ClientId: ").append(this.getClientId())
//				.append(", DeviceType: ").append(this.getDeviceType())
//				.append(", Manufacture: ").append(this.getManufacture())
//				.append(", ModelName: ").append(this.getModelName())
//				.append(", OperatingSystem: ").append(this.getOperatingSystem())
//				.append(", OperatingSystemVersion: ").append(this.getOperatingSystemVersion())
//				.append(", Campaign: ").append(this.getCampaign())
//				.append(", Medium: ").append(this.getMedium())
//				.append(", Source: ").append(this.getSource())
//				.append(", Agency: ").append(this.getAgency())
//				.append(", AppName: ").append(this.getAppName())
//				.append(", AppKey: ").append(this.getAppKey())
//				.append(", AdId: ").append(this.getAdId())
//				.append(", NotificationId: ").append(this.getNotificationId())
//				.append(", ").append(this.getTrackingModel().toString());
//		
//		return build.toString();
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
