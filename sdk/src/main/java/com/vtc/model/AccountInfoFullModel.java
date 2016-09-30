package com.vtc.model;


import java.io.Serializable;
import java.util.Calendar;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.vtc.ws.v2.model.info.AccountFull;

public class AccountInfoFullModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private String userName;

	private String password;

	private String fullName;

	private String email;

	private Calendar birthday;
	
	private Integer locationId;
	
	private String userPassport;
	
	private Integer userStatus;

	private String mobile;

	private Integer gender;

	private String address;

	private Integer vcoinGame;

	private Integer vcoinPayment;

	private Integer paygateId;

	private Long timeStored;

	public AccountInfoFullModel() {
		
	}
	public AccountInfoFullModel(AccountFull user) {
		super();
		this.id = user.getAccountID();
		this.userName = user.getAccountName();
		this.password = user.getPassword();
		this.fullName = user.getFullName();
		this.email = user.getEmail();
		this.birthday = user.getBirthday();
		this.locationId = user.getLocationID();
		this.userPassport = user.getPassport();
		this.userStatus = user.getStatus();
		this.mobile = user.getMobile();
		this.gender = user.getGender() == null ? null : user.getGender().intValue();
		this.address = user.getAddress();
		this.vcoinGame = user.getVCoin();
		this.vcoinPayment = user.getVCoinPayment();
		this.paygateId = user.getPaygateID();
	}
	
	public static AccountInfoFullModel fromJson(String s) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			AccountInfoFullModel user = mapper.readValue(s, AccountInfoFullModel.class);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String toString() {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			return ow.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getVcoinGame() {
		return vcoinGame;
	}
	public void setVcoinGame(Integer vcoinGame) {
		this.vcoinGame = vcoinGame;
	}
	public Integer getVcoinPayment() {
		return vcoinPayment;
	}
	public void setVcoinPayment(Integer vcoinPayment) {
		this.vcoinPayment = vcoinPayment;
	}
	public Integer getPaygateId() {
		return paygateId;
	}
	public void setPaygateId(Integer paygateId) {
		this.paygateId = paygateId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public String getUserPassport() {
		return userPassport;
	}
	public void setUserPassport(String userPassport) {
		this.userPassport = userPassport;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getTimeStored() {
		return timeStored;
	}
	public void setTimeStored(Long timeStored) {
		this.timeStored = timeStored;
	}
}
