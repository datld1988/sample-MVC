package com.vtc.entity.authen;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.vtc.model.AccountInfoFullModel;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;

@Entity
public class UserAuthen implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AccountID")
	private Integer id;
	
	@Column(name = "AccountName")
	private String userName;

	@Column(name = "Password")
	private String password;

	@Column(name = "FullName")
	private String fullName;

	@Column(name = "Email")
	private String email;

	@Column(name = "Birthday")
	private String birthday;
	
	@Column(name = "LocationID")
	private Integer locationId;
	
	@Column(name = "Passport")
	private String userPassport;
	
	@Column(name = "Status")
	private Integer userStatus;

	@Column(name = "Mobile")
	private String mobile;

	@Column(name = "Gender")
	private Integer gender;

	@Column(name = "Address")
	private String address;

	@Column(name = "VCoin")
	private Integer vcoinGame;

	@Column(name = "VcoinPayment")
	private Integer vcoinPayment;

	@Column(name = "PaygateID")
	private Integer paygateId;

	@Transient
	private Boolean isCheckOtp;

	@Transient
	private Long timeStored;

	@Transient
	private String billingAccessToken;

	@Transient
	private Integer serviceId;

	@Transient
	private String serviceKey;

	public UserAuthen() {
		
	}
	public UserAuthen(UserAuthen user) {
		super();
		this.id = user.getId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.birthday = user.birthday;
		this.userStatus = user.getUserStatus();
		this.mobile = user.getMobile();
		this.gender = user.getGender();
		this.address = user.getAddress();
		this.vcoinGame = user.getVcoinGame();
		this.vcoinPayment = user.getVcoinPayment();
		this.paygateId = user.getPaygateId();
		this.isCheckOtp = user.getIsCheckOtp();
		this.billingAccessToken = user.getBillingAccessToken();
	}

	public UserAuthen(AuthenResponseData user) {
		super();
		this.id = user.getAccountID();
		this.userName = user.getAccountName();
		this.vcoinGame = user.getBalance();
		this.vcoinPayment = user.getBalance();
		this.billingAccessToken = user.getAccessToken();
	}

	public UserAuthen(OAuthResponseData user) {
		super();
		this.id = user.getAccountID();
		this.userName = user.getAccountName();
		this.vcoinGame = user.getBalance();
		this.vcoinPayment = user.getBalance();
		this.billingAccessToken = user.getAccessToken();
		this.billingAccessToken = user.getAccessToken();
	}

	public UserAuthen(AccountInfoFullModel user) {
		super();
		this.id = user.getId();
		this.userName = user.getUserName();
		this.vcoinGame = user.getVcoinGame();
		this.vcoinPayment = user.getVcoinPayment();
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

	public Boolean getIsCheckOtp() {
		return isCheckOtp;
	}
	public void setIsCheckOtp(Boolean isCheckOtp) {
		this.isCheckOtp = isCheckOtp;
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

	public static UserAuthen fromJson(String s) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			UserAuthen user = mapper.readValue(s, UserAuthen.class);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Long getTimeStored() {
		return timeStored;
	}
	public void setTimeStored(Long timeStored) {
		this.timeStored = timeStored;
	}
	public String getBillingAccessToken() {
		return billingAccessToken;
	}
	public void setBillingAccessToken(String billingAccessToken) {
		this.billingAccessToken = billingAccessToken;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
}
