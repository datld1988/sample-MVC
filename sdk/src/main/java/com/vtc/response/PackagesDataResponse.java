package com.vtc.response;

import com.vtc.mongocore.PackagesData;

public class PackagesDataResponse extends PackagesData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer totalGold;
	
	public PackagesDataResponse(){
	}
	
	public PackagesDataResponse(PackagesData packageData){
		this.setKey(packageData.getKey());
		this.setPackageType(packageData.getPackageType());
		this.setPackagePaymentType(packageData.getPackagePaymentType());
		this.setMappingKeyApple(packageData.getMappingKeyApple());
		this.setMappingKeyGoogle(packageData.getMappingKeyGoogle());
		this.setName(packageData.getName());
		this.setPriceGold(packageData.getPriceGold());
		this.setPriceVcoin(packageData.getPriceVcoin());
		this.setPriceUsd(packageData.getPriceUsd());
		this.setPriceVnd(packageData.getPriceVnd());
		this.setMoneyScale(packageData.getMoneyScale());
		this.setPromotionalPercent(packageData.getPromotionalPercent());
		this.setImageUrl(packageData.getImageUrl());
		this.setDescription(packageData.getDescription());
		this.setCurrency(packageData.getCurrency());
		this.setTotalGold(this.getPriceGold() + (this.getPriceGold()*this.getPromotionalPercent())/100);
	}
	
	public Integer getTotalGold() {
		return totalGold;
	}
	public PackagesDataResponse setTotalGold(Integer totalGold) {
		this.totalGold = totalGold;
		return this;
	}
}
