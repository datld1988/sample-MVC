package com.vtc.ws.v2.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.types.UnsignedByte;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtc.config.ISysConfig;
import com.vtc.model.AccountInfoFullModel;
import com.vtc.util.MathUtil;
import com.vtc.util.PConstants;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.AuthenRequestData;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.authen.OAuthCreateRequestData;
import com.vtc.ws.v2.model.authen.OAuthCreateResponseData;
import com.vtc.ws.v2.model.authen.OAuthRequestData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;
import com.vtc.ws.v2.model.authen.ReAuthenRequestData;
import com.vtc.ws.v2.model.info.AccountFull;
import com.vtc.ws.v2.model.info.BalanceResponseData;
import com.vtc.ws.v2.model.plus.AccountOAuth;
import com.vtc.ws.v2.model.plus.AuthenSecureRequestData;
import com.vtc.ws.v2.model.plus.SMSPlusListResponseData;
import com.vtc.ws.v2.model.register.RegisterRequestData;
import com.vtc.ws.v2.model.register.RegisterResponseData;
import com.vtc.ws.v2.model.update.AccountInfoRequestData;
import com.vtc.ws.v2.model.update.ChangeMobileRequestData;
import com.vtc.ws.v2.model.update.ChangePasswordRequestData;
import com.vtc.ws.v2.model.update.ProfileRequestData;
import com.vtc.ws.v2.model.update.ResetPasswordByEmailRequestData;
import com.vtc.ws.v2.model.update.ResetPasswordBySecureCodeRequestData;
import com.vtc.ws.v2.model.update.VerifyMobileRequestData;
import com.vtc.ws.v2.service.authen.AccountOAuthService;
import com.vtc.ws.v2.service.authen.AuthenService;
import com.vtc.ws.v2.service.info.AccountInfoService;
import com.vtc.ws.v2.service.plus.AccountPlusService;
import com.vtc.ws.v2.service.register.RegisterService;
import com.vtc.ws.v2.service.update.AccountUpdateService;
@Service
public class BillingService {
	private static final Logger log = Logger.getLogger(BillingService.class);

	@Autowired
	private ISysConfig sysConfig;

	@Autowired
	private AuthenService authenServiceLocator;

	@Autowired
	private AccountInfoService accountInfoServiceLocator;

	@Autowired
	private RegisterService registerServiceLocator;

	@Autowired
	private AccountOAuthService accountOAuthServiceLocator;
	
	@Autowired
	private AccountPlusService accountPlusService;
	
	@Autowired
	private AccountUpdateService accountUpdateService;

	public AuthenResponseData authen(String accountName, String clientIp, Integer deviceType, String password, String secureCode, Integer secureType, Integer serviceId, String serviceKey) {
		log.info(new StringBuffer("[START] authen  CALL BILLING username = ").append(accountName).append(", clientIp = ").append(clientIp).toString());
		AuthenRequestData requestData = new AuthenRequestData();
		requestData.setAccountName(accountName);
		UnsignedByte authen = new UnsignedByte(PConstants.BILLING.AUTHEN_TYPE_NORMAL);
		requestData.setAuthenType(authen);
		requestData.setClientIP(clientIp);
		requestData.setDeviceType(deviceType == null ? PConstants.BILLING.DEVICE_TYPE_WEB : deviceType);
		requestData.setPassword(password);
		requestData.setSecureCode(secureCode);
		requestData.setSecureType(secureType == null ? null : new UnsignedByte(secureType));
//		requestData.setServiceID(MathUtil.parseInt(sysConfig.getBillingServiceId()));
//		requestData.setServiceKey(sysConfig.getBillingServiceKey());
		requestData.setServiceID(serviceId);
		requestData.setServiceKey(serviceKey);
		AuthenResponseData response = null;
		long t1 = System.currentTimeMillis();
		try {
			response = authenServiceLocator.getBasicHttpBinding_IAuthenService().authentication(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] authen  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return response;
	}

	public AuthenResponseData reauthen(String accessToken, String accountName, String clientIp, Integer deviceType, Integer authenType, Integer serviceId, String serviceKey, Integer serviceIdOld, String sign) {
		log.info(new StringBuffer("[START] authen  CALL BILLING username = ").append(accountName).append(", clientIp = ").append(clientIp).toString());
		ReAuthenRequestData requestData = new ReAuthenRequestData();
		requestData.setAccessToken(accessToken);
		requestData.setAccountName(accountName);
		UnsignedByte authen = new UnsignedByte(authenType == null ? PConstants.BILLING.AUTHEN_TYPE_NORMAL : authenType);
		requestData.setAuthenType(authen);
		requestData.setClientIP(clientIp);
		requestData.setDeviceType(deviceType == null ? PConstants.BILLING.DEVICE_TYPE_WEB : deviceType);
		requestData.setServiceID(serviceId);
		requestData.setServiceKey(serviceKey);
		requestData.setServiceID_Old(serviceIdOld);
		requestData.setSign(sign);
		AuthenResponseData response = null;
		long t1 = System.currentTimeMillis();
		try {
			response = authenServiceLocator.getBasicHttpBinding_IAuthenService().reAuthen(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] authen  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return response;
	} 

	public OAuthCreateResponseData createBySocial(String accountName, String clientIP, Integer deviceType, String fbBussinessIDs, String fbEmail,
			Boolean isAutoAuthen, Boolean isDisableCheckSecure, String oAuthAccount, Integer oAuthSystemId, Integer serviceId, String serviceKey,
			String signDisableSecure) {
		log.info(new StringBuffer("[START] authen  CALL BILLING username = ").append(accountName).append(", clientIp = ").append(clientIP).toString());
		OAuthCreateRequestData requestData = new OAuthCreateRequestData();
		requestData.setAccountName(accountName);
		requestData.setClientIP(clientIP);
		requestData.setDeviceType(deviceType);
		requestData.setFbBussinessIDs(fbBussinessIDs);
		requestData.setFbEmail(fbEmail);
		requestData.setIsAutoAuthen(isAutoAuthen);
		requestData.setIsDisableCheckSecure(isDisableCheckSecure);
		requestData.setOAuthAccount(oAuthAccount);
		requestData.setOAuthSystemID(oAuthSystemId);
		requestData.setServiceID(serviceId);
		requestData.setServiceKey(serviceKey);
		requestData.setSignDisableSecure(signDisableSecure);
		
		OAuthCreateResponseData response = null;
		long t1 = System.currentTimeMillis();
		try {
			response = accountOAuthServiceLocator.getBasicHttpBinding_IAccountOAuthService().createAccountOAuth(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] authen  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return response;
	}

	public OAuthResponseData authenBySocial(String clientIP, Integer deviceType, String fbBussinessIds, String fbEmail, Integer isAutoCreate,
			Integer isDisableCheckSecure, String oAuthAccount, Integer oAuthSystemID, String secureCode, Integer secureType,
			Integer serviceID, String serviceKey, String signDisableSecure) {
		log.info(new StringBuffer("[START] authen  CALL BILLING fbBussinessIds = ").append(fbBussinessIds).append(", clientIp = ").append(clientIP).toString());
		OAuthRequestData requestData = new OAuthRequestData();
		requestData.setClientIP(clientIP);
		requestData.setDeviceType(deviceType);
		requestData.setFbBussinessIDs(fbBussinessIds);
		requestData.setFbEmail(fbEmail);
		Boolean isAutoCreateB = null;
		if (isAutoCreate != null) {
			if (isAutoCreate == 1) {
				isAutoCreateB = Boolean.TRUE;
			} else {
				isAutoCreateB = Boolean.FALSE;
			}
		}
		Boolean isDisableCheckSecureB = null;
		if (isDisableCheckSecure != null) {
			if (isDisableCheckSecure == 1) {
				isDisableCheckSecureB = Boolean.TRUE;
			} else {
				isDisableCheckSecureB = Boolean.FALSE;
			}
		}
		requestData.setIsAutoCreate(isAutoCreateB);
		requestData.setIsDisableCheckSecure(isDisableCheckSecureB);
		requestData.setOAuthAccount(oAuthAccount);
		requestData.setOAuthSystemID(oAuthSystemID);
		requestData.setSecureCode(secureCode);
		UnsignedByte securetypeUnsign = null;
		if (secureType != null) {
			securetypeUnsign = new UnsignedByte(secureType);
		}
		requestData.setSecureType(securetypeUnsign);
		requestData.setServiceID(serviceID);
		requestData.setServiceKey(serviceKey);
		requestData.setSignDisableSecure(signDisableSecure);
		
		OAuthResponseData response = null;
		long t1 = System.currentTimeMillis();
		try {
			response = accountOAuthServiceLocator.getBasicHttpBinding_IAccountOAuthService().OAuthentication(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] authen  CALL BILLING fbBussinessIds = ").append(fbBussinessIds).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return response;
	} 

	public RegisterResponseData register(String name, String password, String clientIp, Integer deviceType, Integer registerType, String email, String mobile) {
		try {
			log.info(new StringBuffer("[START] register CALL BILLING username = ").append(name)
					.append(", clientIp = ").append(clientIp)
					.append(", deviceType = ").append(deviceType)
					.append(", registerType = ").append(registerType)
					.append(", email = ").append(email)
					.append(", mobile = ").append(mobile)
					.toString());
			long t1 = System.currentTimeMillis();
			RegisterRequestData requestData = new RegisterRequestData();
			requestData.setAccountName(name);
			requestData.setClientIP(clientIp);
			//  1: web; 2: mobile
			requestData.setDeviceType(deviceType == null ? PConstants.BILLING.DEVICE_TYPE_WEB : deviceType);
			// //  1:thông thường;2: đk nhanh; 3: chơi ngay; 4: đk gắn kết Facebook; 5: đk gắn kết Google; 6: đk gắn kết Yahoo
			requestData.setRegisterType(registerType == null ? PConstants.BILLING.REGISTER_TYPE_FAST : registerType);
			requestData.setPassword(password);
			requestData.setEmail(email);
			requestData.setMobile(mobile);
			requestData.setServiceID(MathUtil.parseInt(sysConfig.getBillingServiceId()));
			requestData.setServiceKey(sysConfig.getBillingServiceKey());
			RegisterResponseData r = registerServiceLocator.getBasicHttpBinding_IRegisterService().accountRegister(requestData);
			System.out.println(r);
			long t2 = System.currentTimeMillis();
			log.info(new StringBuffer("[END] register  CALL BILLING. ").append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResponseData checkAccount(String accountName) {
		log.info(new StringBuffer("[START] checkAccount CALL BILLING accountName = ").append(accountName).toString());
		long t1 = System.currentTimeMillis();
		ResponseData response = null;
    	try {
    		response = accountInfoServiceLocator.getBasicHttpBinding_IAccountInfoService().checkVTCAccount(accountName);
		} catch (Exception e) {
			log.error("ERROR checkAccount", e);
		}
    	long t2 = System.currentTimeMillis();
    	log.info(new StringBuffer("[END] checkAccount  CALL BILLING. ").append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
    	return response;
    }

	public AccountInfoFullModel getAccountInfo(String accountName) {
		log.info(new StringBuffer("[START] getAccountInfo CALL BILLING accountName = ").append(accountName).toString());
		long t1 = System.currentTimeMillis();
		AccountFull accountFull = null;
		try {
			accountFull = accountInfoServiceLocator.getBasicHttpBinding_IAccountInfoService().getAccountFullByAccountName(accountName);
		} catch (Exception e) {
			log.error("ERROR getAccountInfo", e);
		}
		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] checkAccount  CALL BILLING. ").append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		if (accountFull == null)
			return null;
    	return new AccountInfoFullModel(accountFull);
	}
	
	public BalanceResponseData getAllBalance(Integer accountId, String accountName){
		log.info(new StringBuffer("[START] getAllBalance CALL BILLING accountName = ").append(accountName).toString());
		long t1 = System.currentTimeMillis();
		BalanceResponseData balanceResponse = null;
		try {
			balanceResponse = accountInfoServiceLocator.getBasicHttpBinding_IAccountInfoService().getAllBalance(accountId, accountName);
		} catch (Exception e) {
			log.error("ERROR getAccountInfo", e);
		}
		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] getAllBalance  CALL BILLING. ").append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
    	
		return balanceResponse;
	}
	
	public ResponseData deleteAccountOAuth(Integer oAuthId){
		ResponseData response = null;
		try {
			response = accountPlusService.getBasicHttpBinding_IAccountPlusService().deleteAccountOAuth(oAuthId);
		} catch (Exception e) {
			log.error("ERROR deleteAccountOAuth", e);
		} 
		
		return response;
	}
	
	public List<AccountOAuth> getAccountsOAuth(String accountName, Integer oAuthSystemId, String oAuthAccounts){
		List<AccountOAuth> response = new ArrayList<>();
		try {
			AccountOAuth[] data = accountPlusService.getBasicHttpBinding_IAccountPlusService().getAccountOAuth(accountName, oAuthSystemId, oAuthAccounts);
			if(data != null && data.length > 0){
				response = Arrays.asList(data);
			}
		} catch (Exception e) {
			log.error("ERROR deleteAccountOAuth", e);
//			e.printStackTrace();
		}
		
		return response;
	}
	
	public ResponseData setupAuthenSecure(AuthenSecureRequestData requestData){
		ResponseData response = new ResponseData();
		try {
			response = accountPlusService.getBasicHttpBinding_IAccountPlusService().setupAuthenSecure(requestData);
		} catch (RemoteException | ServiceException e) {
			log.error("ERROR deleteAccountOAuth ", e);
//			e.printStackTrace();
		}
		
		return response;
	}
	
	public ResponseData updateAccountProfile(ProfileRequestData requestData){
		ResponseData response = new ResponseData();
		try {
			response = accountUpdateService.getBasicHttpBinding_IAccountUpdateService().updateAccountProfile(requestData);
		} catch (RemoteException | ServiceException e) {
			log.error("ERROR updateAccountProfile ", e);
			//			e.printStackTrace();
		}
		
		return response;
	}
	
	public ResponseData registerSmsPlus(Integer accountId, String accountName, String smsPlusMobile) throws RemoteException, ServiceException{
		return accountPlusService.getBasicHttpBinding_IAccountPlusService().registerSmsPlus(accountId, accountName, smsPlusMobile);
	}
	
	public ResponseData changePassword(ChangePasswordRequestData requestData) throws RemoteException, ServiceException{
		return accountUpdateService.getBasicHttpBinding_IAccountUpdateService().changePassword(requestData);
	}
	
	public ResponseData activeSmsPlus(Integer accountId, String otp, String smsPlusMobile) throws RemoteException, ServiceException{
		return accountPlusService.getBasicHttpBinding_IAccountPlusService().activeSmsPlus(accountId, otp, smsPlusMobile);
	}
	
	public SMSPlusListResponseData getListSmsPlus(Integer accountId) throws RemoteException, ServiceException{
		return accountPlusService.getBasicHttpBinding_IAccountPlusService().getListSmsPlus(accountId);
	}
	
	public ResponseData resetPasswordBySecureCode(ResetPasswordBySecureCodeRequestData requestData) throws RemoteException, ServiceException{
		return accountUpdateService.getBasicHttpBinding_IAccountUpdateService().resetPasswordBySecureCode(requestData);
	}
	
	public ResponseData resetPasswordByEmail(ResetPasswordByEmailRequestData requestData) throws RemoteException, ServiceException{
		return accountUpdateService.getBasicHttpBinding_IAccountUpdateService().resetPasswordByEmail(requestData);
	}
	
	public ResponseData changeMobile(ChangeMobileRequestData requestData) throws RemoteException, ServiceException{
		return accountUpdateService.getBasicHttpBinding_IAccountUpdateService().changeMobile(requestData);
	}
	
	public ResponseData verifyMobile(VerifyMobileRequestData requestData) throws RemoteException, ServiceException{
		return accountUpdateService.getBasicHttpBinding_IAccountUpdateService().verifyMobile(requestData);
	}
	
	public ResponseData checkBillingAccessToken(Integer serviceId, String accountName, String billingAccessToken) throws RemoteException, ServiceException{
		return accountInfoServiceLocator.getBasicHttpBinding_IAccountInfoService().checkAccessToken(serviceId, accountName, billingAccessToken);
	}
	
	public ResponseData insertAccountInfo(AccountInfoRequestData requestData) throws RemoteException, ServiceException{
		return accountUpdateService.getBasicHttpBinding_IAccountUpdateService().insertAccountInfo(requestData);
	}
	
	public AuthenService getAuthenServiceLocator() {
		return authenServiceLocator;
	}
	public void setAuthenServiceLocator(AuthenService authenServiceLocator) {
		this.authenServiceLocator = authenServiceLocator;
	}
	public AccountInfoService getAccountInfoServiceLocator() {
		return accountInfoServiceLocator;
	}
	public void setAccountInfoServiceLocator(AccountInfoService accountInfoServiceLocator) {
		this.accountInfoServiceLocator = accountInfoServiceLocator;
	}
	public RegisterService getRegisterServiceLocator() {
		return registerServiceLocator;
	}
	public void setRegisterServiceLocator(RegisterService registerServiceLocator) {
		this.registerServiceLocator = registerServiceLocator;
	}

	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}

	public AccountOAuthService getAccountOAuthServiceLocator() {
		return accountOAuthServiceLocator;
	}

	public void setAccountOAuthServiceLocator(AccountOAuthService accountOAuthServiceLocator) {
		this.accountOAuthServiceLocator = accountOAuthServiceLocator;
	}

	public AccountPlusService getAccountPlusService() {
		return accountPlusService;
	}

	public void setAccountPlusService(AccountPlusService accountPlusService) {
		this.accountPlusService = accountPlusService;
	}

	public AccountUpdateService getAccountUpdateService() {
		return accountUpdateService;
	}

	public void setAccountUpdateService(AccountUpdateService accountUpdateService) {
		this.accountUpdateService = accountUpdateService;
	}
}
