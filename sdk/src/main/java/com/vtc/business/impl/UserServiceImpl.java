package com.vtc.business.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.types.UnsignedByte;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtc.business.CommonUtils;
import com.vtc.business.ModelUtils;
import com.vtc.business.ServiceUtils;
import com.vtc.business.UserService;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.DataConstants.AccountType;
import com.vtc.mongocore.ChangePasswordMetadata;
import com.vtc.mongocore.RegisterData;
import com.vtc.mongocore.ResetPasswordByEmailMetadata;
import com.vtc.mongocore.ResetPasswordBySecureCodeMetadata;
import com.vtc.mongorepository.AccountRepository;
import com.vtc.mongorepository.EventsRepository;
import com.vtc.mongorepository.TrackingRepository;
import com.vtc.request.AccountRegisterRequest;
import com.vtc.request.ChangePasswordRequest;
import com.vtc.request.ResetPasswordByEmailRequest;
import com.vtc.request.ResetPasswordBySecureCodeRequest;
import com.vtc.serviceproxy.GaTracking;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.OAuthCreateResponseData;
import com.vtc.ws.v2.model.plus.AccountOAuth;
import com.vtc.ws.v2.model.register.RegisterResponseData;
import com.vtc.ws.v2.model.update.ChangePasswordRequestData;
import com.vtc.ws.v2.model.update.ResetPasswordByEmailRequestData;
import com.vtc.ws.v2.model.update.ResetPasswordBySecureCodeRequestData;
import com.vtc.ws.v2.service.BillingService;

import facebook4j.FacebookException;

public class UserServiceImpl implements UserService {
	private static final Logger log = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private BillingService billingService;
	@Autowired
	private GaTracking gaTracking;
	@Autowired
	private CommonUtils commonUtils;
	@Autowired
	private EventsRepository eventsRepository;
	@Autowired
	private TrackingRepository trackingRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ModelUtils modelUtils;
	@Autowired
	private ServiceUtils serviceUtils;


	@Override
	public RegisterResponseData accountRegister(AccountRegisterRequest request) throws IOException {
		log.info(new StringBuffer("[START] com.vtc.business.impl.AccountServiceImpl.accountRegister()"));
		RegisterResponseData response = new RegisterResponseData();
		request = (AccountRegisterRequest) serviceUtils.modifyRequest(request);
		
		// Check account is existed
//		log.info(new StringBuffer("1. Check account is existed"));
//		ResponseData checkAccResponse = billingService.checkAccount(request.getAccountName());
//		if (checkAccResponse != null && checkAccResponse.getResponseCode().compareTo(new Integer(0)) > 0) {
//			log.error(new StringBuffer(
//					"[END] com.vtc.business.impl.AccountServiceImpl.accountRegister(): Account is existed!")
//							.append(", Data: ").append(checkAccResponse.toString()));
//
//			response.setResponseCode(-1);
//			response.setAccountID(checkAccResponse.getResponseCode());
//			response.setDescription(checkAccResponse.getDescription());
//			return response;
//		}

		// Call Billing
		log.info(new StringBuffer("1. Call BillingService to Register new account"));
		response = billingService.register(request.getAccountName(), request.getPassword(),
				request.getClientIp(), request.getDeviceType(), request.getRegisterType(), request.getEmail(),
				request.getMobile());

		if (response == null || response.getResponseCode().compareTo(new Integer(0)) <= 0) {
			log.error(new StringBuffer(
					"[END] com.vtc.business.impl.AccountServiceImpl.accountRegister(): Register is not success!")
							.append(", ResponseCode: ").append(response.getResponseCode()).append(", Description: ")
							.append(response.getDescription()));

			return response;
		}

		// TODO: Next version Send to GA
//		log.info(new StringBuffer("3. Send Tracking information to Google Analytic API"));
//		gaTracking.TrackEvent(request.getGaTrackingId(), request.getClientId(), request.getEventCategory(),
//				request.getEventAction(), request.getEventLabel(), request.getEventValue());

		// save Tracking
		log.info(new StringBuffer("2. Save to db Tracking Information have send to GA"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		// save event
		log.info(new StringBuffer("3. Save to db Event Register"));
		RegisterData registerData = modelUtils.createRegisterData(request);
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.RegisterByVTC, request, registerData));

		// save user
		log.info(new StringBuffer("4. Save to db Account Information"));
//		OAuth2AccessToken token = serviceUtils.getTokenStore().findTokensByUserName(request.getAccountName()).stream().findFirst().get();
		String accessToken = "";
//		if(token != null){
//			accessToken = token.getValue();
//		}
		accountRepository.save(modelUtils.createAccount(DataConstants.AccountType.VTC.getDisplay(), response.getAccountID(), request.getAccountName(), request.getPassword(), "",
				accessToken, response.getAccessToken(),"", "", request.getEmail(), "", "",
				null, DataConstants.Zero, "", "", DataConstants.Zero, "", "", new BigDecimal(0), new BigDecimal(0), "", 1));

		log.info(new StringBuffer("[END] com.vtc.business.impl.AccountServiceImpl.accountRegister(): Successfully"));

		return response;
	}

	@Override
	public OAuthCreateResponseData registerBySocial(AccountRegisterRequest request) throws IOException, FacebookException {
		log.info(new StringBuffer("[START] com.vtc.business.impl.AccountServiceImpl.registerBySocial()"));
		OAuthCreateResponseData responseData = new OAuthCreateResponseData();

		try {
			request.setServiceKey(commonUtils.findServiceKeyById(request.getServiceId()));
		} catch (Exception e) {
			log.error(new StringBuffer("[ERROR] ").append(", ServiceId: ").append(request.getServiceId())
					.append(" Not mapping"));
			request.setServiceKey("");
			return responseData;
		}
		
		request = (AccountRegisterRequest) serviceUtils.modifyRequest(request);

		Boolean isAutoAuthenB = Boolean.FALSE;
		if (request.getIsAutoAuthen() != null && request.getIsAutoAuthen() == 1) {
			isAutoAuthenB = Boolean.TRUE;
		}
		Boolean isDisableCheckSecureB = Boolean.FALSE;
		if (request.getIsDisableCheckSecure() != null && request.getIsDisableCheckSecure() == 1) {
			isDisableCheckSecureB = Boolean.TRUE;
		}
		
//		request = (AccountRegisterRequest) commonUtils.linkToSocial(request, request.getoAuthSystemId(), request.getAccessToken());

		log.info(new StringBuffer("1. Call Billing service to Create account by Social (FB, G+, Yahoo)"));
		responseData = billingService.createBySocial(request.getAccountName(), request.getClientIp(),
				request.getDeviceType(), request.getFbBussinessIds(), request.getFbEmail(), isAutoAuthenB,
				isDisableCheckSecureB, request.getoAuthAccount(), request.getoAuthSystemId(), request.getServiceId(),
				request.getServiceKey(), request.getSignDisableSecure());

		if (responseData == null || responseData.getResponseCode().compareTo(new Integer(0)) <= 0) {
			log.error(new StringBuffer(
					"[END] com.vtc.business.impl.AccountServiceImpl.accountRegister(): RegisterBySocial is not success!")
							.append(", ResponseCode: ").append(responseData.getResponseCode()).append(", Description: ")
							.append(responseData.getDescription()));

			return responseData;
		}

		
		String registerType = commonUtils.getTypeLoginByAuthSystemId(request.getoAuthSystemId());	
		// TODO: Next version Send to GA
//		log.info(new StringBuffer("3. Send Tracking information to Google Analytic API"));
//		gaTracking.TrackEvent(request.getGaTrackingId(), request.getClientId(), request.getEventCategory(),
//				request.getEventAction(), request.getEventLabel(), request.getEventValue());

		// save Tracking
		log.info(new StringBuffer("3. Save to db Tracking Information have send to GA"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		// save event
		log.info(new StringBuffer("4. Save to db Event Register"));
		RegisterData registerData = modelUtils.createRegisterData(request);
		eventsRepository.save(modelUtils.createEvent(registerType, request, registerData));
		
		Integer oAuthSystemId = request.getoAuthSystemId();
		// save user
		log.info(new StringBuffer("5. Save to db Account Information"));
//		OAuth2AccessToken token = serviceUtils.getTokenStore().findTokensByUserName(request.getAccountName()).stream().findFirst().get();
		String accessToken = "";
//		if(token != null){
//			accessToken = token.getValue();
//		}
		String accountType = Arrays.stream(DataConstants.AccountType.values())
									.filter(item -> item.getValue().compareTo(oAuthSystemId) == 0)
									.findAny()
									.orElse(AccountType.OTHER)
									.getDisplay();
		accountRepository.save(modelUtils.createAccount(accountType, responseData.getAccountID(), request.getAccountName(), "", "", accessToken, responseData.getAccessToken(), "", "", request.getEmail(), "", "",
				null, DataConstants.Zero, "", "", DataConstants.Zero, "", "", new BigDecimal(0), new BigDecimal(0), "", 1));

		log.info(new StringBuffer("[END] com.vtc.business.impl.AccountServiceImpl.registerBySocial(): Successfully"));

		return responseData;
	}

	@Override
	public ResponseData resetPasswordBySecureCode(ResetPasswordBySecureCodeRequest request) throws RemoteException, ServiceException {
		ResponseData response = new ResponseData();
		if(request == null){
			return response;
		}
		
		ResetPasswordBySecureCodeRequestData requestData = new ResetPasswordBySecureCodeRequestData();
		requestData.setAccountName(request.getAccountName());
		requestData.setClientIP(request.getClientIp());
		requestData.setPassword(request.getPassword());
		requestData.setSecureCode(request.getSecureCode());
		requestData.setSecureType(new UnsignedByte(request.getSecureType()));
		response = billingService.resetPasswordBySecureCode(requestData);
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.ResetPasswordBySecureCode, 
														request, 
														new ResetPasswordBySecureCodeMetadata().setAccountName(request.getAccountName())
																								.setClientIp(request.getClientIp())
																								.setPassword(request.getPassword())
																								.setSecureCode(request.getSecureCode())
																								.setSecureType(request.getSecureType())));
		
		return response;
	}
	
	@Override
	public ResponseData resetPasswordByEmail(ResetPasswordByEmailRequest request) throws RemoteException, ServiceException {
		ResponseData response = new ResponseData();
		if(request == null){
			return response;
		}
		ResetPasswordByEmailRequestData requestData = new ResetPasswordByEmailRequestData();
		requestData.setAccountName(request.getAccountName());
		requestData.setClientIP(request.getClientIp());
		requestData.setEmail(request.getEmail());
		requestData.setPassword(request.getPassword());
		if(!StringUtils.isEmpty(request.getSign())){
			requestData.setSign(request.getSign());
		}
		response =  billingService.resetPasswordByEmail(requestData);
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.ResetPasswordByEmail, 
														request, 
														new ResetPasswordByEmailMetadata().setAccountName(request.getAccountName())
																						.setClientIp(request.getClientIp())
																						.setEmail(request.getEmail())
																						.setPassword(request.getPassword())));
		
		return response;
	}
	
	@Override
	public ResponseData changePassword(ChangePasswordRequest request) throws RemoteException, ServiceException {
		ResponseData response = new ResponseData();
		// Check valid Param
		if (request == null) {
			return new ResponseData(DataConstants.ResponseCode.MISSING_PARAMS.getDisplay(), null, DataConstants.ResponseCode.MISSING_PARAMS.getValue());
		}
		
		ChangePasswordRequestData requestData = new ChangePasswordRequestData();
		requestData.setAccountName(request.getAccountName());
		requestData.setClientIP(request.getClientIp());
		requestData.setNewPassword(request.getNewPassword());
		requestData.setOldPassword(request.getOldPassword());
		requestData.setSecureCode(request.getSecureCode());
		requestData.setSecureType(new UnsignedByte(request.getSecureType()));
		
		log.info(" Call BillingService.changePassword");
		response = billingService.changePassword(requestData);
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			log.error(new StringBuffer("[ERROR] Register SMS Plus IS FAILED!!!. ")
					.append(", AccountId: ").append(request.getAccountId())
					.append(", AccountName: ").append(request.getAccountName())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		log.info(" Save EVENT to DB");
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.ChangePassword, 
															request, 
															new ChangePasswordMetadata().setAccountName(request.getAccountName())
																						.setClientIp(request.getClientIp())
																						.setNewPassword(request.getNewPassword())
																						.setOldPassword(request.getOldPassword())
																						.setSecureCode(request.getSecureCode())
																						.setSecureType(request.getSecureType())));
		
		return response;
	}
	
	@Override
	public ResponseData checkVTCAccount(String accountName) {
		return billingService.checkAccount(accountName);
	}
	
	@Override
	public ResponseData deleteAccountOAuth(Integer oAuthId) {
		return billingService.deleteAccountOAuth(oAuthId);
	}

	@Override
	public List<AccountOAuth> getAccountsOAuth(String accountName, Integer oAuthSystemId, String oAuthAccounts) {
		return billingService.getAccountsOAuth(accountName, oAuthSystemId, oAuthAccounts);
	}


}
