package org.springframework.security.oauth2.common;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
@JsonSerialize(using = OAuth2AccessTokenSerializer.class)
@JsonDeserialize(using = OAuth2AccessTokenDeserializer.class)
public class VtcOAuth2AccessToken {
	private String accessToken;

	private String billingAccessToken;

	private String error;

	private String message;

	@JsonSerialize(using = OAuth2AccessTokenSerializer.class)
	private Date expiration;

	private String accountId;

	private String accountName;
	
	private String email;
	
	private String mobile;
	
	private Integer userStatus;
	
	private String avatarUrl;

	private String gameVersion;

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getErrorCode() {
		return error;
	}

	public void setErrorCode(String error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return message;
	}

	public void setErrorMessage(String message) {
		this.message = message;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getBillingAccessToken() {
		return billingAccessToken;
	}

	public void setBillingAccessToken(String billingAccessToken) {
		this.billingAccessToken = billingAccessToken;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getGameVersion() {
		return gameVersion;
	}

	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
		
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String toString() {
		return new StringBuffer(" [VtcOAuth2AccessToken] ")
				.append(" AccessToken:").append(this.getAccessToken())
				.append(" ,BillingAccessToken:").append(this.getBillingAccessToken())
				.append(" ,ErrorCode:").append(this.getErrorCode())
				.append(" ,ErrorMessage:").append(this.getErrorMessage())
				.append(" ,Expiration:").append(this.getExpiration())
				.append(" ,AccountId:").append(this.getAccountId())
				.append(" ,AccountName:").append(this.getAccountName())
				.toString();
	}

}
