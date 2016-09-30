package com.vtc.service.impl;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vtc.business.AccountService;
import com.vtc.business.CommonUtils;
import com.vtc.business.UserService;
import com.vtc.config.RedisTokenStore;
import com.vtc.entity.authen.UserRepositoryUserDetails;
import com.vtc.model.AccountInfoFullModel;
import com.vtc.model.BillingException;
import com.vtc.request.AuthenticationRequest;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.authen.OAuthCreateResponseData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;
import com.vtc.ws.v2.service.BillingService;

import facebook4j.FacebookException;

/**
 * user to override spring security
 * 
 * @author xuanbach
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	private static final Logger log = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private RedisTokenStore tokenStore;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private CommonUtils commonUtils;

	public AuthenResponseData authenBilling(AuthenticationRequest request) {
		log.info(new StringBuffer("[START] authenBilling CALL BILLING username = ").append(request.getAccountName())
							.append(", clientIp = ").append(request.getClientIp()).toString());
		AuthenResponseData response = null;
		long t1 = System.currentTimeMillis();
		try {
			response = accountService.authenLoginVTC(request);
			//response = billingService.authen(accountName, clientIp, deviceType, password, secureCode, secureType, serviceId, serviceKey);
		} catch (Exception e) {
			log.error("ERROR", e);
			long t2 = System.currentTimeMillis();
			log.info(new StringBuffer("[END] authenBilling CALL BILLING username = ").append(request.getAccountName()).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
//			e.printStackTrace();
		}
		
		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] authenBilling CALL BILLING username = ").append(request.getAccountName()).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return response;
	}

	public OAuthResponseData authenBySocial(AuthenticationRequest request) throws IOException, FacebookException, BillingException {
//		log.info(new StringBuffer("[START] authenBilling CALL BILLING fbBussinessIDs = ").append(fbBussinessIDs).append(", clientIp = ").append(clientIP).toString());
		OAuthResponseData response = null;
//		long t1 = System.currentTimeMillis();
//		try {
			OAuthCreateResponseData createResponse = null;
			if(!StringUtils.isEmpty(request.getAccountName())){
				createResponse = userService.registerBySocial(commonUtils.convertToAccountRegisterRequest(request));
				if(createResponse != null && createResponse.getResponseCode() < 0){
					log.error(new StringBuffer("[ERROR] CustomUserDetailsService.authenBySocial: ")
									.append(" ResponseCode=").append(createResponse.getResponseCode())
									.append(" Description=").append(createResponse.getDescription()));
					
					throw new BillingException(createResponse.getResponseCode(), createResponse.getDescription());
//					response = new OAuthResponseData();
//					response.setResponseCode(createResponse.getResponseCode());
//					response.setDescription(createResponse.getDescription());
//					
//					return response;
				}
				
				response = new OAuthResponseData();
				response.setAccessToken(createResponse.getAccessToken());
				response.setAccountID(createResponse.getAccountID());
				response.setAccountName(createResponse.getAccountName());
				response.setBalance(createResponse.getBalance());
				response.setDescription(createResponse.getDescription());
				response.setExtend(createResponse.getExtend());
				response.setLastLoginTime(createResponse.getLastLoginTime());
				response.setResponseCode(createResponse.getResponseCode());
				
				return response;
			}
			
			response = accountService.authenLoginBySocial(request);
			
//			response = billingService.authenBySocial(clientIP, deviceType, fbBussinessIDs, fbEmail, isAutoCreate, isDisableCheckSecure, oAuthAccount, oAuthSystemID, secureCode, secureType, serviceID, serviceKey, signDisableSecure);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error("ERROR", e);
//		}
		
//		long t2 = System.currentTimeMillis();
//		log.info(new StringBuffer("[END] authenBilling CALL BILLING fbBussinessIDs = ").append(fbBussinessIDs).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info(new StringBuffer("[START] CustomUserDetailsService.loadUserByUsername username = ").append(username).toString());
		AccountInfoFullModel response = null;
		UserDetails detail = null;
		long t1 = System.currentTimeMillis();
		try {
			response = billingService.getAccountInfo(username);
			detail = new UserRepositoryUserDetails(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] CustomUserDetailsService.loadUserByUsername username = ").append(username).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return detail;
	}

	public RedisTokenStore getTokenStore() {
		return tokenStore;
	}

	public void setTokenStore(RedisTokenStore tokenStore) {
		this.tokenStore = tokenStore;
	}
}
