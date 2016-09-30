package com.vtc.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GamePaymentResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("ResponseCode")
	private Integer responseCode;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Amount")
	private Integer amount;
	
	@JsonProperty("VTCTransId")
	private Integer vtcTransId;
	
	@JsonProperty("PartnerTransId")
	private String partnerTransId;
	
	@JsonProperty("PaymentType")
	private String paymentType;
	
	@JsonProperty("TotalVcoinPayment")
	private Integer totalVcoinPayment;
	
	@JsonProperty("TotalVcoinGame")
	private Integer totalVcoinGame;

	@JsonProperty("Sign")
	private String sign;

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getVtcTransId() {
		return vtcTransId;
	}

	public void setVtcTransId(Integer vtcTransId) {
		this.vtcTransId = vtcTransId;
	}

	public String getPartnerTransId() {
		return partnerTransId;
	}

	public void setPartnerTransId(String partnerTransId) {
		this.partnerTransId = partnerTransId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getTotalVcoinPayment() {
		return totalVcoinPayment;
	}

	public void setTotalVcoinPayment(Integer totalVcoinPayment) {
		this.totalVcoinPayment = totalVcoinPayment;
	}

	public Integer getTotalVcoinGame() {
		return totalVcoinGame;
	}

	public void setTotalVcoinGame(Integer totalVcoinGame) {
		this.totalVcoinGame = totalVcoinGame;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
