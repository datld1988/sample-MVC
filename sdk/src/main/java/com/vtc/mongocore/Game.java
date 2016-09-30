package com.vtc.mongocore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vtc.dataconstant.Collections;

@Document(collection=Collections.GAME)
public class Game implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
	private String clientId;
	private String secretId;
	private String gaTrackingId;
    private String serverGame;
    private String gameCode;
    private String gameName;
    private List<PackagesData> packages;
    private List<GameEnvironmentData> environments;
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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecretId() {
		return secretId;
	}
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
	public String getGaTrackingId() {
		return gaTrackingId;
	}
	public void setGaTrackingId(String gaTrackingId) {
		this.gaTrackingId = gaTrackingId;
	}
	public String getServerGame() {
		return serverGame;
	}
	public void setServerGame(String serverGame) {
		this.serverGame = serverGame;
	}
	public String getGameCode() {
		return gameCode;
	}
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public List<GameEnvironmentData> getEnvironments() {
		return environments;
	}
	public void setEnvironments(List<GameEnvironmentData> environments) {
		this.environments = environments;
		
	}
	public List<PackagesData> getPackages() {
		return packages;
	}
	public void setPackages(List<PackagesData> packages) {
		this.packages = packages;
		
	}

}
