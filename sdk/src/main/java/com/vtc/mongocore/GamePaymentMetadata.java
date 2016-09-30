package com.vtc.mongocore;

import java.io.Serializable;
import java.util.Date;

public class GamePaymentMetadata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String accountName;
	
	private Integer accountId;
	
	private String toAccountName;
	
	private String partnerCode;
	
	private Integer amount;
	
	private Integer partnerAmount;
	
	private String serverGame;
	
	private String fromIp;
	
	private String gameCode;
	
	private String paymentType;
	
	private String accessToken;
	
	private String functionName;
	
	private String paymentFrom;
	
	private String cardSerial;
	
	private String cardCode;
	
	private String bankCode;
	
	private String vtcPayAccount;
	
	private String description;
	
	private String vtcTransId;
	
	private String uuid; //Unique device Id cua tung may (trong TH nap IAP)
	
	private String receiptBase; // Hoa don Apple hoac GG gui ve dang ma base64 (trong TH nap IAP)
	
	private String receiptData; // Hoa don sau khi da giai ma (trong TH nap IAP)
	
	private Integer quantity; // So luong (trong TH nap IAP) default = 1
	
	private String productId; // Ten san phan tren store (trong TH nap IAP)
	
	private String relatedTransactionId; // Ma giao dich của Apple hoac GG (trong TH nap IAP)
	
	private String purchaseDate; // Ngay thanh toan của Apple hoac GG (trong TH nap IAP)
	
	private String receiptBaseMd5;
	
	private String orderNo;

	public String getToAccountName() {
		return toAccountName;
	}

	public String getAccountName() {
		return accountName;
	}

	public GamePaymentMetadata setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public GamePaymentMetadata setAccountId(Integer accountId) {
		this.accountId = accountId;
		return this;
	}

	public GamePaymentMetadata setToAccountName(String toAccountName) {
		this.toAccountName = toAccountName;
		return this;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public GamePaymentMetadata setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
		return this;
	}

	public Integer getAmount() {
		return amount;
	}

	public GamePaymentMetadata setAmount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public Integer getPartnerAmount() {
		return partnerAmount;
	}

	public GamePaymentMetadata setPartnerAmount(Integer partnerAmount) {
		this.partnerAmount = partnerAmount;
		return this;
	}

	public String getServerGame() {
		return serverGame;
	}

	public GamePaymentMetadata setServerGame(String serverGame) {
		this.serverGame = serverGame;
		return this;
	}

	public String getFromIp() {
		return fromIp;
	}

	public GamePaymentMetadata setFromIp(String fromIp) {
		this.fromIp = fromIp;
		return this;
	}

	public String getGameCode() {
		return gameCode;
	}

	public GamePaymentMetadata setGameCode(String gameCode) {
		this.gameCode = gameCode;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public GamePaymentMetadata setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public GamePaymentMetadata setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public String getFunctionName() {
		return functionName;
	}

	public GamePaymentMetadata setFunctionName(String functionName) {
		this.functionName = functionName;
		return this;
	}

	public String getPaymentFrom() {
		return paymentFrom;
	}

	public GamePaymentMetadata setPaymentFrom(String paymentFrom) {
		this.paymentFrom = paymentFrom;
		return this;
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public GamePaymentMetadata setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial;
		return this;
	}

	public String getCardCode() {
		return cardCode;
	}

	public GamePaymentMetadata setCardCode(String cardCode) {
		this.cardCode = cardCode;
		return this;
	}

	public String getBankCode() {
		return bankCode;
	}

	public GamePaymentMetadata setBankCode(String bankCode) {
		this.bankCode = bankCode;
		return this;
	}

	public String getVtcPayAccount() {
		return vtcPayAccount;
	}

	public GamePaymentMetadata setVtcPayAccount(String vtcPayAccount) {
		this.vtcPayAccount = vtcPayAccount;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public GamePaymentMetadata setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getVtcTransId() {
		return vtcTransId;
	}

	public GamePaymentMetadata setVtcTransId(String vtcTransId) {
		this.vtcTransId = vtcTransId;
		return this;
	}

	public String getUuid() {
		return uuid;
	}

	public GamePaymentMetadata setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getReceiptBase() {
		return receiptBase;
	}

	public GamePaymentMetadata setReceiptBase(String receiptBase) {
		this.receiptBase = receiptBase;
		return this;
	}

	public String getReceiptData() {
		return receiptData;
	}

	public GamePaymentMetadata setReceiptData(String receiptData) {
		this.receiptData = receiptData;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public GamePaymentMetadata setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public String getProductId() {
		return productId;
	}

	public GamePaymentMetadata setProductId(String productId) {
		this.productId = productId;
		return this;
	}

	public String getRelatedTransactionId() {
		return relatedTransactionId;
	}

	public GamePaymentMetadata setRelatedTransactionId(String relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
		return this;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public GamePaymentMetadata setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
		return this;
	}

	public String getReceiptBaseMd5() {
		return receiptBaseMd5;
	}

	public GamePaymentMetadata setReceiptBaseMd5(String receiptBaseMd5) {
		this.receiptBaseMd5 = receiptBaseMd5;
		return this;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public GamePaymentMetadata setOrderNo(String orderNo) {
		this.orderNo = orderNo;
		return this;
	}
}
