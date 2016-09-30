package com.vtc.mongocore;

import java.io.Serializable;

public class PackagesData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private Integer packageType;
	private Integer packagePaymentType;
	private String mappingKeyGoogle;
	private String mappingKeyApple;
	private String name;
	private Integer priceGold;
	private Integer priceVcoin;
	private Double priceUsd;
	private Integer priceVnd;
	private Integer moneyScale;
	private String currency;
	private Integer promotionalPercent;
	private String imageUrl;
	private String description;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getPackageType() {
		return packageType;
	}
	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}
	public String getMappingKeyGoogle() {
		return mappingKeyGoogle;
	}
	public void setMappingKeyGoogle(String mappingKeyGoogle) {
		this.mappingKeyGoogle = mappingKeyGoogle;
	}
	public String getMappingKeyApple() {
		return mappingKeyApple;
	}
	public void setMappingKeyApple(String mappingKeyApple) {
		this.mappingKeyApple = mappingKeyApple;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPriceGold() {
		return priceGold;
	}
	public void setPriceGold(Integer priceGold) {
		this.priceGold = priceGold;
	}
	public Integer getPriceVcoin() {
		return priceVcoin;
	}
	public void setPriceVcoin(Integer priceVcoin) {
		this.priceVcoin = priceVcoin;
	}
	public Double getPriceUsd() {
		return priceUsd;
	}
	public void setPriceUsd(Double priceUsd) {
		this.priceUsd = priceUsd;
	}
	public Integer getPriceVnd() {
		return priceVnd;
	}
	public void setPriceVnd(Integer priceVnd) {
		this.priceVnd = priceVnd;
	}
	public Integer getPromotionalPercent() {
		return promotionalPercent;
	}
	public void setPromotionalPercent(Integer promotionalPercent) {
		this.promotionalPercent = promotionalPercent;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getMoneyScale() {
		return moneyScale;
	}
	public void setMoneyScale(Integer moneyScale) {
		this.moneyScale = moneyScale;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getPackagePaymentType() {
		return packagePaymentType;
	}
	public void setPackagePaymentType(Integer packagePaymentType) {
		this.packagePaymentType = packagePaymentType;
	}
	
}
