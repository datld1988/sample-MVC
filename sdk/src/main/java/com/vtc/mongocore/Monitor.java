package com.vtc.mongocore;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vtc.dataconstant.Collections;

@Document(collection=Collections.MONITOR)
public class Monitor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
	private String accountName;
	private String accountId;
	private String packageIdSdk;
	private String packageIdBilling;
	private String serverGame;
	private String fromIp;
	private String gameCode;
	private Integer vcoin;
	private Integer promotionalPercent;
	private Integer scale;
	private Integer priceVnd;
	private Integer priceGold;
	private Integer promotionGold;
	private Integer totalGold;
	private Integer amount;
	private Integer partnerAmount;
	private String packageType;
	private String paymentType;
	private String extend;
	private String description;
	private Date createdDate;
	
	public String getPackageIdSdk() {
		return packageIdSdk;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public void setPackageIdSdk(String packageIdSdk) {
		this.packageIdSdk = packageIdSdk;
	}
	public String getPackageIdBilling() {
		return packageIdBilling;
	}
	public void setPackageIdBilling(String packageIdBilling) {
		this.packageIdBilling = packageIdBilling;
	}
	public String getServerGame() {
		return serverGame;
	}
	public void setServerGame(String serverGame) {
		this.serverGame = serverGame;
	}
	public String getFromIp() {
		return fromIp;
	}
	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}
	public String getGameCode() {
		return gameCode;
	}
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	public Integer getVcoin() {
		return vcoin;
	}
	public void setVcoin(Integer vcoin) {
		this.vcoin = vcoin;
	}
	public Integer getPromotionalPercent() {
		return promotionalPercent;
	}
	public void setPromotionalPercent(Integer promotionalPercent) {
		this.promotionalPercent = promotionalPercent;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public Integer getPromotionGold() {
		return promotionGold;
	}
	public void setPromotionGold(Integer promotionGold) {
		this.promotionGold = promotionGold;
	}
	public Integer getTotalGold() {
		return totalGold;
	}
	public void setTotalGold(Integer totalGold) {
		this.totalGold = totalGold;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		
	}
	public Integer getPriceVnd() {
		return priceVnd;
	}
	public void setPriceVnd(Integer priceVnd) {
		this.priceVnd = priceVnd;
	}
	public Integer getPriceGold() {
		return priceGold;
	}
	public void setPriceGold(Integer priceGold) {
		this.priceGold = priceGold;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getPartnerAmount() {
		return partnerAmount;
	}
	public void setPartnerAmount(Integer partnerAmount) {
		this.partnerAmount = partnerAmount;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
}
