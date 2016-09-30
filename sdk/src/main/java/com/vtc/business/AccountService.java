package com.vtc.business;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.springframework.security.oauth2.common.VtcOAuth2AccessToken;

import com.vtc.model.WapInfo;
import com.vtc.mongocore.Accounts;
import com.vtc.request.AccountInfoRequest;
import com.vtc.request.ActiveSMSPlusRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.request.ChangeMobileRequest;
import com.vtc.request.RegisterSMSPlusRequest;
import com.vtc.request.RegisterSecureRequest;
import com.vtc.request.Request;
import com.vtc.request.UpdateProfileRequest;
import com.vtc.request.VerifyMobileRequest;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;
import com.vtc.ws.v2.model.info.BalanceResponseData;
import com.vtc.ws.v2.model.plus.SMSPlusListResponseData;

public interface AccountService {
	AuthenResponseData authenLoginVTC(AuthenticationRequest request) throws IOException, ServiceException;
	
	OAuthResponseData authenLoginBySocial(AuthenticationRequest request) throws IOException ;
	
	AuthenResponseData reAuthen(AuthenticationRequest request) throws IOException;
	
	BalanceResponseData getAllBalance(String accountName);
	
	ResponseData setupAuthenSecure(RegisterSecureRequest request);
	
	ResponseData updateAccountProfile(UpdateProfileRequest request);
	
	ResponseData registerSmsPlus(RegisterSMSPlusRequest request) throws RemoteException, ServiceException;
	
	ResponseData activeSmsPlus(ActiveSMSPlusRequest request) throws RemoteException, ServiceException;
	
	SMSPlusListResponseData getListSmsPlus(Request request) throws RemoteException, ServiceException;
	
	ResponseData changeMobile(ChangeMobileRequest request) throws RemoteException, ServiceException;
	
	ResponseData verifyMobile(VerifyMobileRequest request)  throws RemoteException, ServiceException;
	
	Accounts getAccountByAccountIdOrAccountName(Integer accountId, String accountName);
	
	ResponseData insertAccountInfo(AccountInfoRequest request) throws RemoteException, ServiceException;
	
	VtcOAuth2AccessToken autoLogin(Integer accountId, String userName, String accessToken) throws RemoteException, ServiceException;
	
	WapInfo getWapInfo(Request request);
}
