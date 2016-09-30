package com.vtc.business;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.vtc.request.AccountRegisterRequest;
import com.vtc.request.ChangePasswordRequest;
import com.vtc.request.ResetPasswordByEmailRequest;
import com.vtc.request.ResetPasswordBySecureCodeRequest;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.OAuthCreateResponseData;
import com.vtc.ws.v2.model.plus.AccountOAuth;
import com.vtc.ws.v2.model.register.RegisterResponseData;

import facebook4j.FacebookException;

public interface UserService {
	RegisterResponseData accountRegister(AccountRegisterRequest request) throws IOException ;
	
	OAuthCreateResponseData registerBySocial(AccountRegisterRequest request) throws IOException, FacebookException ;
	
	ResponseData deleteAccountOAuth(Integer oAuthId);
	
	List<AccountOAuth> getAccountsOAuth(String accountName, Integer oAuthSystemId, String oAuthAccounts);
	
	ResponseData checkVTCAccount(String accountName);
	
	ResponseData resetPasswordBySecureCode(ResetPasswordBySecureCodeRequest request) throws RemoteException, ServiceException;
	
	ResponseData resetPasswordByEmail(ResetPasswordByEmailRequest request) throws RemoteException, ServiceException;
	
	ResponseData changePassword(ChangePasswordRequest request) throws RemoteException, ServiceException;
}
