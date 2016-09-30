package com.vtc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppleReceiptInApp {
	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("product_id")
	private String productId;
	
	@JsonProperty("transaction_id")
	private String transactionId;
	
	@JsonProperty("original_transaction_id")
	private String originalTransactionId;
	
	@JsonProperty("purchase_date")
	private String purchaseDate;
	
	@JsonProperty("purchase_date_pst")
	private String purchaseDatePst;
	
	@JsonProperty("purchase_date_ms")
	private String purchaseDateMs;
	
	@JsonProperty("original_purchase_date")
	private String originalPurchaseDate;
	
	@JsonProperty("original_purchase_date_ms")
	private String originalPurchaseDateMs;
	
	@JsonProperty("original_purchase_date_pst")
	private String originalPurchaseDatePst;
	
	@JsonProperty("is_trial_period")
	private String isTrialPeriod;

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOriginalTransactionId() {
		return originalTransactionId;
	}

	public void setOriginalTransactionId(String originalTransactionId) {
		this.originalTransactionId = originalTransactionId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseDatePst() {
		return purchaseDatePst;
	}

	public void setPurchaseDatePst(String purchaseDatePst) {
		this.purchaseDatePst = purchaseDatePst;
	}

	public String getPurchaseDateMs() {
		return purchaseDateMs;
	}

	public void setPurchaseDateMs(String purchaseDateMs) {
		this.purchaseDateMs = purchaseDateMs;
	}

	public String getOriginalPurchaseDate() {
		return originalPurchaseDate;
	}

	public void setOriginalPurchaseDate(String originalPurchaseDate) {
		this.originalPurchaseDate = originalPurchaseDate;
	}

	public String getOriginalPurchaseDateMs() {
		return originalPurchaseDateMs;
	}

	public void setOriginalPurchaseDateMs(String originalPurchaseDateMs) {
		this.originalPurchaseDateMs = originalPurchaseDateMs;
	}

	public String getOriginalPurchaseDatePst() {
		return originalPurchaseDatePst;
	}

	public void setOriginalPurchaseDatePst(String originalPurchaseDatePst) {
		this.originalPurchaseDatePst = originalPurchaseDatePst;
	}

	public String getIsTrialPeriod() {
		return isTrialPeriod;
	}

	public void setIsTrialPeriod(String isTrialPeriod) {
		this.isTrialPeriod = isTrialPeriod;
	}
	
}
