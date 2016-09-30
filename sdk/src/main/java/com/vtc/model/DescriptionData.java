package com.vtc.model;

public class DescriptionData {
	private String description;
	private String gameToken;
	private String packageType;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGameToken() {
		return gameToken;
	}
	public void setGameToken(String gameToken) {
		this.gameToken = gameToken;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	
	public String toDataString(){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\\\"description\\\":").append("\\\"").append(this.getDescription()).append("\\\"");
		sb.append(",\\\"gameToken\\\":").append("\\\"").append(this.getGameToken()).append("\\\"");
		sb.append(",\\\"packageType\\\":").append("\\\"").append(this.getPackageType()).append("\\\"");
		sb.append("}");

		return sb.toString();
	}
}
