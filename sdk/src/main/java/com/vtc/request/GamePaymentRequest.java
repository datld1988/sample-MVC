package com.vtc.request;

import org.apache.commons.lang3.StringUtils;

import com.vtc.dataconstant.DataConstants;

public class GamePaymentRequest extends Request {
//	@JsonProperty("ToAccountName")
	private String toAccountName;
	
//	@JsonProperty("PartnerCode")
	private String partnerCode;
	
//	@JsonProperty("Amount")
	private Integer amount;
	
//	@JsonProperty("PartnerAmount")
	private Integer partnerAmount;
	
//	@JsonProperty("ServerGame")
	private String serverGame;
	
//	@JsonProperty("FromIP")
	private String fromIp;
	
//	@JsonProperty("GameCode")
	private String gameCode;
	
//	@JsonProperty("PaymentType")
	private String paymentType;
	
//	@JsonProperty("AccessToken")
	private String billingAccessToken;
	
//	@JsonProperty("FunctionName")
	private String functionName;
	
//	@JsonProperty("PaymentFrom")
	private String paymentFrom;
	
//	@JsonProperty("CardSerial")
	private String cardSerial;
	
//	@JsonProperty("CardCode")
	private String cardCode;
	
//	@JsonProperty("BankCode")
	private String bankCode;
	
//	@JsonProperty("VTCPayAccount")
	private String vtcPayAccount;
	
//	@JsonProperty("Description")
	private String description;
	
//	@JsonProperty("VTCTransId")
	private Integer vtcTransId;
	
	private String uuid; //Unique device Id cua tung may (trong TH nap IAP)
	
	private String receiptBase; // Hoa don Apple hoac GG gui ve dang ma base64 (trong TH nap IAP)
	
	private String receiptData; // Hoa don sau khi da giai ma (trong TH nap IAP)
	
	private Integer quantity; // So luong (trong TH nap IAP) default = 1
	
	private String productId; // Ten san phan tren store (trong TH nap IAP)
	
	private String relatedTransactionId; // Ma giao dich của Apple hoac GG (trong TH nap IAP)
	
	private String purchaseDate; // Ngay thanh toan của Apple hoac GG (trong TH nap IAP)
	
	private String receiptBaseMd5; 
	
	private String packageId;
	
	private Integer typeIAP;
	
	private String packageName; // Only for Payment IAP GOOGLE
	
	private String orderNo;
	
	private Integer authenType; //0: thông thường, 1: facebook, 2:Google, 3:Yahoo
	
	private String extendData;
	
	private Integer packageType;
	
	public String getToAccountName() {
		return toAccountName;
	}

	public GamePaymentRequest setToAccountName(String toAccountName) {
		this.toAccountName = toAccountName;
		return this;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public GamePaymentRequest setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
		return this;
	}

	public Integer getAmount() {
		return amount;
	}

	public GamePaymentRequest setAmount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public Integer getPartnerAmount() {
		return partnerAmount;
	}

	public GamePaymentRequest setPartnerAmount(Integer partnerAmount) {
		this.partnerAmount = partnerAmount;
		return this;
	}

	public String getServerGame() {
		return serverGame;
	}

	public GamePaymentRequest setServerGame(String serverGame) {
		this.serverGame = serverGame;
		return this;
	}

	public String getFromIp() {
		return fromIp;
	}

	public GamePaymentRequest setFromIp(String fromIp) {
		this.fromIp = fromIp;
		return this;
	}

	public String getGameCode() {
		return gameCode;
	}

	public GamePaymentRequest setGameCode(String gameCode) {
		this.gameCode = gameCode;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public GamePaymentRequest setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public String getBillingAccessToken() {
		return billingAccessToken;
	}

	public GamePaymentRequest setBillingAccessToken(String billingAccessToken) {
		this.billingAccessToken = billingAccessToken;
		return this;
	}

	public String getFunctionName() {
		return functionName;
	}

	public GamePaymentRequest setFunctionName(String functionName) {
		this.functionName = functionName;
		return this;
	}

	public String getPaymentFrom() {
		return paymentFrom;
	}

	public GamePaymentRequest setPaymentFrom(String paymentFrom) {
		this.paymentFrom = paymentFrom;
		return this;
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public GamePaymentRequest setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial;
		return this;
	}

	public String getCardCode() {
		return cardCode;
	}

	public GamePaymentRequest setCardCode(String cardCode) {
		this.cardCode = cardCode;
		return this;
	}

	public String getBankCode() {
		return bankCode;
	}

	public GamePaymentRequest setBankCode(String bankCode) {
		this.bankCode = bankCode;
		return this;
	}

	public String getVtcPayAccount() {
		return vtcPayAccount;
	}

	public GamePaymentRequest setVtcPayAccount(String vtcPayAccount) {
		this.vtcPayAccount = vtcPayAccount;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public GamePaymentRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getVtcTransId() {
		return vtcTransId;
	}

	public GamePaymentRequest setVtcTransId(Integer vtcTransId) {
		this.vtcTransId = vtcTransId;
		return this;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getReceiptBase() {
		return receiptBase;
	}

	public void setReceiptBase(String receiptBase) {
		this.receiptBase = receiptBase;
	}

	public String getReceiptData() {
		return receiptData;
	}

	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRelatedTransactionId() {
		return relatedTransactionId;
	}

	public void setRelatedTransactionId(String relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getReceiptBaseMd5() {
		return receiptBaseMd5;
	}

	public void setReceiptBaseMd5(String receiptBaseMd5) {
		this.receiptBaseMd5 = receiptBaseMd5;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
		
	}

	public Integer getTypeIAP() {
		return typeIAP;
	}

	public void setTypeIAP(Integer typeIAP) {
		this.typeIAP = typeIAP;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
		
	}

	public Integer getAuthenType() {
		return authenType;
	}

	public void setAuthenType(Integer authenType) {
		this.authenType = authenType;
	}

	public String getExtendData() {
		return extendData;
	}

	public void setExtendData(String extendData) {
		this.extendData = extendData;
	}

	public Integer getPackageType() {
		return packageType;
	}

	public void setPackageType(Integer packageType) {
		this.packageType = packageType;
	}

	public String toJsonCreateOrder(){
		StringBuffer sb = new StringBuffer()
				.append("{")
				.append("\"AccountName\":").append("\"").append(this.getAccountName()).append("\"")
				.append(",\"AccountID\":").append(this.getAccountId())
				.append(",\"ToAccountName\":").append("\"").append(this.getToAccountName()).append("\"")
				.append(",\"PartnerCode\":").append("\"").append(this.getPartnerCode()).append("\"");
		
		if(this.getAmount() != null){
			sb.append(",\"Amount\":").append(this.getAmount());
		}
		
		if(this.getPartnerAmount() != null){
			sb.append(",\"PartnerAmount\":").append(this.getPartnerAmount());
		}
		sb.append(",\"ServerGame\":").append("\"").append(this.getServerGame()).append("\"")
			.append(",\"FromIP\":").append("\"").append(this.getFromIp()).append("\"")
			.append(",\"GameCode\":").append("\"").append(this.getGameCode()).append("\"")
			.append(",\"PaymentType\":").append("\"").append(this.getPaymentType()).append("\"")
			.append(",\"AccessToken\":").append("\"").append(this.getBillingAccessToken()).append("\"")
			.append(",\"FunctionName\":").append("\"").append(this.getFunctionName()).append("\"");
				
		if(!StringUtils.isEmpty(this.getPaymentFrom())){
			sb.append(",\"PaymentFrom\":").append("\"").append(this.getPaymentFrom()).append("\"");	
		}
		
		if(this.getCardCode() != null){
			sb.append(",\"CardCode\":").append("\"").append(this.getCardCode()).append("\"");
		}
		
		if(this.getCardSerial() != null){
			sb.append(",\"CardSerial\":").append("\"").append(this.getCardSerial()).append("\"");
		}
		
		if(this.getBankCode() != null){
			sb.append(",\"BankCode\":").append("\"").append(this.getBankCode()).append("\"");
		}
		
		if(this.getVtcPayAccount() != null){
			sb.append(",\"VTCPayAccount\":").append("\"").append(this.getVtcPayAccount()).append("\"");
		}
		if(this.getDescription() != null){
			sb.append(",\"Description\":").append("\"").append(this.getDescription()).append("\"");
		}
		
		if(this.getPaymentType().equals(DataConstants.GamePaymentType.BUYIAP)){
			sb.append(",\"Uuid\":").append("\"").append(this.getUuid()).append("\"");
			sb.append(",\"ReceiptBase\":").append("\"").append(this.getReceiptBase()).append("\"");
			sb.append(",\"ReceiptData\":").append("\"").append(this.getReceiptData()).append("\"");
			sb.append(",\"Quantity\":").append(this.getQuantity());
			sb.append(",\"ProductID\":").append("\"").append(this.getProductId()).append("\"");
			sb.append(",\"RelatedTransactionID\":").append("\"").append(this.getRelatedTransactionId()).append("\"");
			sb.append(",\"PurchaseDate\":").append("\"").append(this.getPurchaseDate()).append("\"");
			sb.append(",\"ReceiptBaseMD5\":").append("\"").append(this.getReceiptBaseMd5()).append("\"");
		}
				
		sb.append("}");
		
		return sb.toString();
	}
	
	public String toJsonUpdateOrder(){
		StringBuffer sb = new StringBuffer()
				.append("{")
				.append("\"VTCTransID\":").append(this.getVtcTransId())
				.append(",\"GameCode\":").append("\"").append(this.getGameCode()).append("\"")
				.append(",\"FunctionName\":").append("\"").append(this.getFunctionName()).append("\"");
		
		if(this.getDescription() != null){
			sb.append(",\"Description\":").append("\"").append(this.getDescription()).append("\"");
		}
		
		sb.append(",\"PartnerCode\":").append("\"").append(this.getPartnerCode()).append("\"");
		sb.append("}");
		
		return sb.toString();
	}
}
