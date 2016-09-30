package com.vtc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:config/server.properties")
public class SysConfig implements ISysConfig{
	@Value("${mail.smtp.host}")
	private String mailHost;

	@Value("${mail.smtp.port}")
	private String mailPort;

	@Value("${mail.smtp.auth}")
	private String mailAuth;

	@Value("${mail.smtp.starttls.enable}")
	private String mailEnable;

	@Value("${mail.server.account}")
	private String mailAccount;

	@Value("${mail.server.password}")
	private String mailPassword;

	@Value("${billing2.service.id}")
	private String billingServiceId;

	@Value("${billing2.service.key}")
	private String billingServiceKey;
	
	//@Value("${server.backup}")
	private String status;

	@Value("${authen.service.id}")
	private String serviceId;

	@Value("${authen.service.salt}")
	private String salt;

	@Value("${authen.sys.partner.key}")
	private String sysPartnerKey;

	@Value("${biling2.authen.service.url}")
	private String billingAuthenAddress;
	
	@Value("${biling2.register.service.url}")
	private String billingRegisterAddress;

	@Value("${biling2.account.info.service.url}")
	private String billingInfoAddress;

	@Value("${biling2.account.oauth.service.url}")
	private String billingOauthAddress;

	@Value("${biling2.transaction.topup.card.service.url}")
	private String topupCardAddress;

	@Value("${biling2.transaction.topup.bank.service.url}")
	private String topupBankAddress;

	@Value("${biling2.transaction.topup.vtcpay.service.url}")
	private String topupVtcpayAddress;
	
	private String topupIAPAddress;
	
	@Value("${vtcservice.key_value}")
	private String serviceKeyValue;
	
	@Value("${facebook.appid}")
	private String facebookAppId;
	
	@Value("${facebook.appsecret}")
	private String facebookAppSecret;
	
	@Value("${facebook.permissions}")
	private String facebookPermissions;
	
	@Value("${googleplus.clientid}")
	private String googleClientId;
	
	@Value("${googleplus.clientsecret}")
	private String googleClientSecret;
	
	@Value("${googleplus.scopeid}")
	private String googleScope;

	@Value("${biling2.transaction.deduct.service.url}")
	private String deductVcoinAddress;
	
	@Value("${billing2.gamepayment.endpoint}")
	private String gamePaymentEndPoint;

	@Value("${billing2.gamepayment.sign.secretkey}")
	private String gamePaymentSignSecretKey;
	
	@Value("${billing2.gamepayment.sign.partnercode}")
	private String gamePaymentSignPartnerCode;
	
	@Value("${billing2.keysign}")
	private String billingKeySign;
	
	@Value("${mobile.wap.endpoint}")
	private String wapEndpoint;
	
	@Value("${sdk2.keysign}")
	private String sdkKeySign;
	
	public SysConfig() {
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public String getBillingServiceId() {
		return billingServiceId;
	}

	public void setBillingServiceId(String billingServiceId) {
		this.billingServiceId = billingServiceId;
	}

	public String getBillingServiceKey() {
		return billingServiceKey;
	}

	public void setBillingServiceKey(String billingServiceKey) {
		this.billingServiceKey = billingServiceKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSysPartnerKey() {
		return sysPartnerKey;
	}

	public void setSysPartnerKey(String sysPartnerKey) {
		this.sysPartnerKey = sysPartnerKey;
	}

	public String getBillingAuthenAddress() {
		return billingAuthenAddress;
	}

	public void setBillingAuthenAddress(String billingAuthenAddress) {
		this.billingAuthenAddress = billingAuthenAddress;
	}

	public String getBillingRegisterAddress() {
		return billingRegisterAddress;
	}

	public void setBillingRegisterAddress(String billingRegisterAddress) {
		this.billingRegisterAddress = billingRegisterAddress;
	}

	public String getBillingInfoAddress() {
		return billingInfoAddress;
	}

	public void setBillingInfoAddress(String billingInfoAddress) {
		this.billingInfoAddress = billingInfoAddress;
	}

	public String getBillingOauthAddress() {
		return billingOauthAddress;
	}

	public void setBillingOauthAddress(String billingOauthAddress) {
		this.billingOauthAddress = billingOauthAddress;
	}

	public String getTopupCardAddress() {
		return topupCardAddress;
	}

	public void setTopupCardAddress(String topupCardAddress) {
		this.topupCardAddress = topupCardAddress;
	}

	public String getTopupBankAddress() {
		return topupBankAddress;
	}

	public void setTopupBankAddress(String topupBankAddress) {
		this.topupBankAddress = topupBankAddress;
	}

	public String getTopupVtcpayAddress() {
		return topupVtcpayAddress;
	}

	public void setTopupVtcpayAddress(String topupVtcpayAddress) {
		this.topupVtcpayAddress = topupVtcpayAddress;
	}

	public String getMailHost() {
		return mailHost;
	}

	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	public String getMailPort() {
		return mailPort;
	}

	public void setMailPort(String mailPort) {
		this.mailPort = mailPort;
	}

	public String getMailAuth() {
		return mailAuth;
	}

	public void setMailAuth(String mailAuth) {
		this.mailAuth = mailAuth;
	}

	public String getMailEnable() {
		return mailEnable;
	}

	public void setMailEnable(String mailEnable) {
		this.mailEnable = mailEnable;
	}

	public String getMailAccount() {
		return mailAccount;
	}

	public void setMailAccount(String mailAccount) {
		this.mailAccount = mailAccount;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getServiceKeyValue() {
		return serviceKeyValue;
	}

	public void setServiceKeyValue(String serviceKeyValue) {
		this.serviceKeyValue = serviceKeyValue;
	}

	public String getTopupIAPAddress() {
		return topupIAPAddress;
	}

	public void setTopupIAPAddress(String topupIAPAddress) {
		this.topupIAPAddress = topupIAPAddress;
	}

	public String getFacebookAppId() {
		return facebookAppId;
	}

	public void setFacebookAppId(String facebookAppId) {
		this.facebookAppId = facebookAppId;
	}

	public String getFacebookAppSecret() {
		return facebookAppSecret;
	}

	public void setFacebookAppSecret(String facebookAppSecret) {
		this.facebookAppSecret = facebookAppSecret;
	}

	public String getFacebookPermissions() {
		return facebookPermissions;
	}

	public void setFacebookPermissions(String facebookPermissions) {
		this.facebookPermissions = facebookPermissions;
	}

	public String getGoogleClientId() {
		return googleClientId;
	}

	public void setGoogleClientId(String googleClientId) {
		this.googleClientId = googleClientId;
	}

	public String getGoogleClientSecret() {
		return googleClientSecret;
	}

	public void setGoogleClientSecret(String googleClientSecret) {
		this.googleClientSecret = googleClientSecret;
	}

	public String getGoogleScope() {
		return googleScope;
	}

	public void setGoogleScope(String googleScope) {
		this.googleScope = googleScope;
	}

	public String getDeductVcoinAddress() {
		return deductVcoinAddress;
	}

	public void setDeductVcoinAddress(String deductVcoinAddress) {
		this.deductVcoinAddress = deductVcoinAddress;
	}

	public String getGamePaymentEndPoint() {
		return gamePaymentEndPoint;
	}

	public void setGamePaymentEndPoint(String gamePaymentEndPoint) {
		this.gamePaymentEndPoint = gamePaymentEndPoint;
	}

	public String getGamePaymentSignSecretKey() {
		return gamePaymentSignSecretKey;
	}

	public void setGamePaymentSignSecretKey(String gamePaymentSignSecretKey) {
		this.gamePaymentSignSecretKey = gamePaymentSignSecretKey;
	}

	public String getGamePaymentSignPartnerCode() {
		return gamePaymentSignPartnerCode;
	}

	public void setGamePaymentSignPartnerCode(String gamePaymentSignPartnerCode) {
		this.gamePaymentSignPartnerCode = gamePaymentSignPartnerCode;
	}

	public String getBillingKeySign() {
		return billingKeySign;
	}

	public void setBillingKeySign(String billingKeySign) {
		this.billingKeySign = billingKeySign;
	}

	public String getWapEndpoint() {
		return wapEndpoint;
	}

	public void setWapEndpoint(String wapEndpoint) {
		this.wapEndpoint = wapEndpoint;
	}

	public String getSdkKeySign() {
		return sdkKeySign;
	}

	public void setSdkKeySign(String sdkKeySign) {
		this.sdkKeySign = sdkKeySign;
	}
}
