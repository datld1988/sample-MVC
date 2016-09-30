package com.vtc.mongocore;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vtc.dataconstant.Collections;

@Document(collection=Collections.ORDER)
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
	private String orderNo;
	private String accessToken;
	private String billingAccessToken;
	private String clientIp;
    private String serverGame;
    private String gameCode;
    private String packageId;
    private Integer status;
    private String description;
    private Integer version;
    private Date createdTime;
    private Date updatedTime;
    
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public Order setOrderNo(String orderNo) {
		this.orderNo = orderNo;
		return this;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public Order setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}
	public String getBillingAccessToken() {
		return billingAccessToken;
	}
	public Order setBillingAccessToken(String billingAccessToken) {
		this.billingAccessToken = billingAccessToken;
		return this;
	}
	public String getClientIp() {
		return clientIp;
	}
	public Order setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}
	public String getServerGame() {
		return serverGame;
	}
	public Order setServerGame(String serverGame) {
		this.serverGame = serverGame;
		return this;
	}
	public String getGameCode() {
		return gameCode;
	}
	public Order setGameCode(String gameCode) {
		this.gameCode = gameCode;
		return this;
	}
	public String getPackageId() {
		return packageId;
	}
	public Order setPackageId(String packageId) {
		this.packageId = packageId;
		return this;
	}
	public Integer getStatus() {
		return status;
	}
	public Order setStatus(Integer status) {
		this.status = status;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Order setDescription(String description) {
		this.description = description;
		return this;
	}
	public Integer getVersion() {
		return version;
	}
	public Order setVersion(Integer version) {
		this.version = version;
		return this;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public Order setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public Order setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
		return this;
	}
}
