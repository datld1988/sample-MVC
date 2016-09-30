package com.vtc.mongocore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.bson.types.ObjectId;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.vtc.dataconstant.Collections;

@Document(collection=Collections.ACCOUNTS)
public class Accounts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
	private String accountType;
	private Integer accountId;
	private String accountName;
	private String passwordPlainText;
	private String passwordMd5;
	private String accessToken;
	private String billingAccessToken;
    private String firstName;
    private String lastName;
    private String fullName;
    private Date birthday;
    private Integer locationId;
    private String userStatus;
    private String userPassport;
    private Integer gender;
    private String email;
    private String mobile;
    private String address;
    private BigDecimal vcoinGame;
    private BigDecimal vcoinPayment;
    private String paygateId;
    private String avatar;
    private Long timeStored;
    private Integer version;
    private Date createdTime;
    private Date updatedTime;
    
    public Accounts() {}
    public Accounts(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
	public ObjectId getId() {
		return id;
	}
	public Accounts setId(ObjectId id) {
		this.id = id;
		return this;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
		
	}
	public String getAccountName() {
		return accountName;
	}
	public Accounts setAccountName(String accountName) {
		this.accountName = accountName;
		return this;
	}
	public String getPasswordPlainText() {
		return passwordPlainText;
	}
	public void setPasswordPlainText(String passwordPlainText) {
		this.passwordPlainText = passwordPlainText;
		
	}
	public String getPasswordMd5() {
		return passwordMd5;
	}
	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public Accounts setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public Accounts setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Accounts setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getAvatar() {
		return avatar;
	}
	public Accounts setAvatar(String avatar) {
		this.avatar = avatar;
		return this;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public Accounts setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public Accounts setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
		return this;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public Accounts setAccountId(Integer accountId) {
		this.accountId = accountId;
		return this;
	}
	public Integer getGender() {
		return gender;
	}
	public Accounts setGender(Integer gender) {
		this.gender = gender;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Accounts setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getFullName() {
		return fullName;
	}
	public Accounts setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Accounts setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public Accounts setLocationId(Integer locationId) {
		this.locationId = locationId;
		return this;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public Accounts setUserStatus(String userStatus) {
		this.userStatus = userStatus;
		return this;
	}
	public String getUserPassport() {
		return userPassport;
	}
	public Accounts setUserPassport(String userPassport) {
		this.userPassport = userPassport;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public Accounts setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public BigDecimal getVcoinGame() {
		return vcoinGame;
	}
	public Accounts setVcoinGame(BigDecimal vcoinGame) {
		this.vcoinGame = vcoinGame;
		return this;
	}
	public BigDecimal getVcoinPayment() {
		return vcoinPayment;
	}
	public Accounts setVcoinPayment(BigDecimal vcoinPayment) {
		this.vcoinPayment = vcoinPayment;
		return this;
	}
	public String getPaygateId() {
		return paygateId;
	}
	public Accounts setPaygateId(String paygateId) {
		this.paygateId = paygateId;
		return this;
	}
	public Integer getVersion() {
		return version;
	}
	public Accounts setVersion(Integer version) {
		this.version = version;
		return this;
	}
	public Long getTimeStored() {
		return timeStored;
	}
	public void setTimeStored(Long timeStored) {
		this.timeStored = timeStored;
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
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();//.writer().withDefaultPrettyPrinter();
		try {
			return objectMapper.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
