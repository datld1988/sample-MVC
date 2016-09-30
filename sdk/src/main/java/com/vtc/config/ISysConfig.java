package com.vtc.config;

public interface ISysConfig {
	public String getBillingServiceId();

	public String getBillingServiceKey();

	public String getStatus();

	public String getServiceId();

	public String getSalt();

	public String getSysPartnerKey();

	public String getBillingAuthenAddress();

	public String getBillingRegisterAddress();

	public String getBillingInfoAddress();

	public String getBillingOauthAddress();

	public String getTopupCardAddress();

	public String getTopupBankAddress();

	public String getTopupVtcpayAddress();

	public String getMailHost();

	public String getMailPort();

	public String getMailAuth();

	public String getMailEnable();

	public String getMailAccount();

	public String getMailPassword();

	public String getServiceKeyValue();

	public String getTopupIAPAddress();

	public String getFacebookAppId();

	public String getFacebookAppSecret();

	public String getFacebookPermissions();

	public String getGoogleClientId();

	public String getGoogleClientSecret();

	public String getGoogleScope();

	public String getDeductVcoinAddress();
	
	public String getGamePaymentEndPoint();

	public String getGamePaymentSignSecretKey();
	
	public String getGamePaymentSignPartnerCode();
	
	public String getBillingKeySign();
	
	public String getSdkKeySign();
	
	public String getWapEndpoint();
}
