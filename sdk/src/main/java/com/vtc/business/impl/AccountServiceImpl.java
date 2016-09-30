package com.vtc.business.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.types.UnsignedByte;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.VtcOAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vtc.business.AccountService;
import com.vtc.business.CommonUtils;
import com.vtc.business.ModelUtils;
import com.vtc.business.ServiceUtils;
import com.vtc.config.ISysConfig;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.DataConstants.AccountType;
import com.vtc.model.AccountInfoFullModel;
import com.vtc.model.AccountInfoModel;
import com.vtc.model.UpdateProfileMetadata;
import com.vtc.model.WapInfo;
import com.vtc.mongocore.Accounts;
import com.vtc.mongocore.ActiveSMSPlusMetadata;
import com.vtc.mongocore.LoginData;
import com.vtc.mongocore.ReAuthenticationMetadata;
import com.vtc.mongocore.RegisterSMSPlusMetadata;
import com.vtc.mongocore.VerifyMobileMetadata;
import com.vtc.mongorepository.AccountRepository;
import com.vtc.mongorepository.EventsRepository;
import com.vtc.mongorepository.TrackingRepository;
import com.vtc.request.AccountInfoRequest;
import com.vtc.request.ActiveSMSPlusRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.request.ChangeMobileRequest;
import com.vtc.request.RegisterSMSPlusRequest;
import com.vtc.request.RegisterSecureRequest;
import com.vtc.request.Request;
import com.vtc.request.UpdateProfileRequest;
import com.vtc.request.VerifyMobileRequest;
import com.vtc.util.DateUtil;
import com.vtc.util.MathUtil;
import com.vtc.util.PConstants;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;
import com.vtc.ws.v2.model.info.BalanceResponseData;
import com.vtc.ws.v2.model.plus.SMSPlusListResponseData;
import com.vtc.ws.v2.model.update.AccountInfoRequestData;
import com.vtc.ws.v2.model.update.ProfileRequestData;
import com.vtc.ws.v2.model.update.VerifyMobileRequestData;
import com.vtc.ws.v2.service.BillingService;

@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger log = Logger.getLogger(AccountServiceImpl.class);

	@Autowired
	private BillingService billingService;
	// @Autowired
	// private GaTracking gaTracking;
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
	@Autowired
	private ISysConfig sysConfig;

	// public AccountBizImpl(BillingService billingService, GaTracking
	// gaTracking, CommonUtils commonUtils,
	// EventsRepository eventsRepository, ModelUtils modelUtils) {
	// this.billingService = billingService;
	// this.gaTracking = gaTracking;
	// this.commonUtils = commonUtils;
	// this.eventsRepository = eventsRepository;
	// this.modelUtils = modelUtils;
	// }

	@Override
	public AuthenResponseData authenLoginVTC(AuthenticationRequest request) throws ServiceException, IOException {
		log.info(new StringBuffer("[START] AccountServiceImpl.authenLoginVTC() "));
		AuthenResponseData response = new AuthenResponseData();
		try {
			request.setServiceKey(commonUtils.findServiceKeyById(request.getServiceId()));
		} catch (Exception e) {
			log.warn(new StringBuffer("[WARNING] ").append(", ServiceId: ").append(request.getServiceId())
					.append(" Not mapping"));
			request.setServiceKey("");
		}

		if (request.getServiceKey().trim().isEmpty()) {
			log.error(new StringBuffer("Can't not found Key by ServiceId: ").append(request.getServiceId()));
			return response;
		}

		log.info(new StringBuffer(" 1. Call Authentication of BillingService"));
		String passwordPlainText = request.getPassword();
		String passwordMd5 = commonUtils.hashMD5(passwordPlainText);
		request.setPassword(passwordMd5);
		response = billingService.authen(request.getAccountName(), request.getClientIp(), request.getDeviceType(),
				request.getPassword(), request.getSecureCode(), request.getSecureType(), request.getServiceId(),
				request.getServiceKey());

		if (response == null || response.getResponseCode().compareTo(new Integer(0)) <= 0) {
			log.error(new StringBuffer("[Error] LOGIN FAILED. AccountName: ").append(request.getAccountName())
					.append(" Password: ").append(request.getPassword()).append("ResponseCode: ")
					.append(response.getResponseCode()).append(" Desciprtion: ").append(response.getDescription()));
			return response;
		}

		log.info(new StringBuffer(" 2. Save Account to DB"));
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(request.getAccountId(), request.getAccountName());
//		OAuth2AccessToken token = serviceUtils.getTokenStore().findTokensByUserName(request.getAccountName()).stream().findFirst().get();
		String accessToken = "";
//		if(token != null){
//			accessToken = token.getValue();
//		}
		if (CollectionUtils.isEmpty(accounts)) {
			accountRepository.save((modelUtils.createAccount(DataConstants.AccountType.VTC.getDisplay(), response.getAccountID(), request.getAccountName(), 
					passwordPlainText, passwordMd5, accessToken, response.getAccessToken(), "", "", "", "", "", null, DataConstants.Zero, "",
					"", DataConstants.Zero, "", "", new BigDecimal(0), new BigDecimal(0), "", 1)));
		} else {
			Accounts account = accounts.get(0);
			account.setPasswordPlainText(passwordPlainText);
			account.setPasswordMd5(passwordMd5);
			account.setAccessToken(accessToken);
			account.setBillingAccessToken(response.getAccessToken());
			account.setVersion(account.getVersion() + 1);
			account.setUpdatedTime(new Date());
			accountRepository.save(account);
		}

		log.info(new StringBuffer(" 3. Save Tracking to DB"));
		// gaTracking.TrackEvent(request.getGaTrackingId(),
		// request.getClientId(), request.getEventCategory(),
		// request.getEventAction(), request.getEventLabel(), "");
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer(" 4. Save Event to DB"));
		LoginData loginData = modelUtils.createLoginData(request);
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.LoginByVTC, request, loginData));

		log.info(new StringBuffer("[END] AccountServiceImpl.authenLoginVTC() is successfully!!! "));
		return response;
	}

	@Override
	public OAuthResponseData authenLoginBySocial(AuthenticationRequest request) throws IOException {
		log.info(new StringBuffer("[START] AccountServiceImpl.authenLoginBySocial() "));
		OAuthResponseData response = new OAuthResponseData();
		try {
			request.setServiceKey(commonUtils.findServiceKeyById(request.getServiceId()));
		} catch (Exception e) {
			log.warn(new StringBuffer("[WARNING] ").append(", ServiceId: ").append(request.getServiceId())
					.append(" Not mapping"));
			request.setServiceKey("");
		}
		
		if (request.getServiceKey().trim().isEmpty()) {
			log.error(new StringBuffer("[ERROR] Can't not found Key by ServiceId: ").append(request.getServiceId()));
			return response;
		}

		String typeLogin = commonUtils.getTypeLoginByAuthSystemId(request.getoAuthSystemId());		

		log.info(new StringBuffer(" 1. Call authenBySocial of BillingService"));
		response = billingService.authenBySocial(request.getClientIp(), request.getDeviceType(),
				request.getFbBussinessIds(), request.getFbEmail(), request.getIsAutoCreate(),
				request.getIsDisableCheckSecure(), request.getoAuthAccount(), request.getoAuthSystemId(),
				request.getSecureCode(), request.getSecureType(), request.getServiceId(), request.getServiceKey(),
				request.getSignDisableSecure());

		if (response == null || response.getResponseCode().compareTo(new Integer(0)) <= 0) {
			log.error(new StringBuffer("[ERROR] AUTHEN LOGIN FAILED!!!. Authen Login: ").append(typeLogin)
					.append("  is fail").append(", AccountName: ").append(request.getAccountName())
					.append(", Password: ").append(request.getPassword()).append(", ResponseCode: ")
					.append(response.getResponseCode()).append(", Desciprtion: ").append(response.getDescription()));

			return response;
		}

		log.info(new StringBuffer(" 2. Save Account to DB"));
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(response.getAccountID(), response.getAccountName());
//		OAuth2AccessToken token = serviceUtils.getTokenStore().findTokensByUserName(request.getAccountName()).stream().findFirst().get();
		String accessToken = "";
//		if(token != null){
//			accessToken = token.getValue();
//		}
		if (CollectionUtils.isEmpty(accounts)) {
			String accountType = Arrays.stream(DataConstants.AccountType.values())
										.filter(item -> item.getValue().compareTo(request.getoAuthSystemId()) == 0)
										.findAny()
										.orElse(AccountType.OTHER)
										.getDisplay();
			accountRepository.save((modelUtils.createAccount(accountType, response.getAccountID(), response.getAccountName(), "", "", accessToken, response.getAccessToken(), "", "", "", "", "", null, DataConstants.Zero, "",
					"", DataConstants.Zero, "", "", new BigDecimal(0), new BigDecimal(0), "", 1)));
		} else {
			Accounts account = accounts.get(0);
			account.setAccessToken(accessToken);
			account.setBillingAccessToken(response.getAccessToken());
			account.setVersion(account.getVersion() + 1);
			account.setUpdatedTime(new Date());
			accountRepository.save(account);
		}

		log.debug(new StringBuffer(" 3. Save Tracking to DB"));
		// gaTracking.TrackEvent(request.getGaTrackingId(),
		// request.getClientId(), request.getEventCategory(),
		// request.getEventAction(), request.getEventLabel(), "");
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.debug(new StringBuffer(" 4. Save data to DB"));
		LoginData loginData = modelUtils.createLoginData(request);
		eventsRepository.save(modelUtils.createEvent(typeLogin, request, loginData));

		log.info(new StringBuffer("[END] AccountServiceImpl.authenLoginBySocial() is successfully!!! "));
		return response;
	}

	@Override
	public AuthenResponseData reAuthen(AuthenticationRequest request) throws IOException {
		AuthenResponseData response = new AuthenResponseData();
		log.info(new StringBuffer("[START] AccountServiceImpl.reAuthen() "));
		try {
			request.setServiceKey(commonUtils.findServiceKeyById(request.getServiceId()));
		} catch (Exception e) {
			log.warn(new StringBuffer("[WARNING] ").append(", ServiceId: ").append(request.getServiceId())
					.append(" Not mapping"));
			request.setServiceKey("");
		}

		log.info(new StringBuffer("1. Call reauthen service of BillingService"));
		String keySign = sysConfig.getBillingKeySign();
		StringBuffer sb = new StringBuffer(request.getAccountName()).append(request.getAccessToken()).append(request.getServiceId()).append(keySign).append(request.getServiceKey()).append(request.getServiceIdOld());
		response = billingService.reauthen(request.getAccessToken(), request.getAccountName(), request.getClientIp(),
				request.getDeviceType(), request.getAuthenType(), request.getServiceId(), request.getServiceKey(),
				request.getServiceIdOld(), commonUtils.hashMD5(sb.toString()));
		if (response == null || response.getResponseCode().compareTo(new Integer(0)) <= 0) {
			log.error(new StringBuffer("[ERROR] RE-AUTHEN IS FAILED!!!. ")
					.append(", AccountName: ").append(request.getAccountName())
					.append(", AccessToken: ").append(request.getAccessToken())
					.append(", BillingAccessToken: ").append(request.getBilling_token())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		log.info(new StringBuffer(" 2. Save Tracking to DB"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer(" 3. Save data to DB"));
		ReAuthenticationMetadata metadata = modelUtils.createReAuthenMetadata(request.getServiceId(), request.getServiceKey(),
												request.getServiceIdOld(), request.getAccessToken(), request.getAccountName(),
												request.getDeviceType(), request.getClientIp(), request.getAuthenType());
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.ReAuthen, request, metadata));


		log.info(new StringBuffer("[END] AccountServiceImpl.reAuthen() is successfully!!! "));
		return response;
	}

	@Override
	public BalanceResponseData getAllBalance(String accountName) {
		AccountInfoFullModel info = billingService.getAccountInfo(accountName);
		if(info == null){
			log.error(new StringBuffer("[ERROR] accountName = ").append(accountName));
			return new BalanceResponseData();
		}
		
		return billingService.getAllBalance(info.getId(), accountName);
	}

	@Override
	public ResponseData setupAuthenSecure(RegisterSecureRequest request) {
		ResponseData response = new ResponseData();
		if(request == null || request.getRequestData() == null){
			return response;
		}
		
		log.info(" Call BillingService.updateAccountProfile");
		response = billingService.setupAuthenSecure(request.getRequestData());
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			log.error(new StringBuffer("[ERROR] Register Authen secure IS FAILED!!!. ")
					.append(", AccountName: ").append(request.getRequestData().getAccountName())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		log.info(" Save EVENT to DB");
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.RegisterAuthenSecure, request, request.getRequestData()));
		
		return response;//billingService.setupAuthenSecure(request);
	}

	@Override
	public ResponseData updateAccountProfile(UpdateProfileRequest request) {
		ResponseData response = new ResponseData();
		if(request == null){
			return response;
		}
		
		log.info(" Call BillingService.updateAccountProfile");
		ProfileRequestData profileRequestData = new ProfileRequestData();
		profileRequestData.setAccountID(request.getAccountId());
		profileRequestData.setClientIP(request.getClientIp());
		profileRequestData.setAddress(request.getAddress());
		profileRequestData.setFullName(request.getFullName());
		profileRequestData.setMobile(request.getMobile());
		profileRequestData.setBirthday(DateUtil.toCalendar(request.getBirthday(), "YYYY/MM/dd"));
		profileRequestData.setDistrictID(request.getDistrictId());
		profileRequestData.setGender(new UnsignedByte(request.getGender()));
		profileRequestData.setLocationID(request.getLocationId());
		profileRequestData.setWardID(request.getWardId());
		
		response = billingService.updateAccountProfile(profileRequestData);
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			log.error(new StringBuffer("[ERROR] UPDATE PROFILE IS FAILED!!!. ")
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		log.info(" Save EVENT to DB");
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.UpdateProfile, 
													request, 
													new UpdateProfileMetadata().setAddress(request.getAddress())
																				.setBirthday(request.getBirthday())
																				.setClientIp(request.getClientId())
																				.setDistrictId(request.getDistrictId())
																				.setFullName(request.getFullName())
																				.setGender(request.getGender())
																				.setLocationId(request.getLocationId())
																				.setMobile(request.getMobile())
																				.setWardId(request.getWardId())));
		
		log.info(" Save ACCOUNT to DB");
		List<Accounts> accounts = accountRepository. findAllByAccountId(request.getAccountId());
		if (accounts == null || accounts.isEmpty()) {
			accountRepository.save((modelUtils.createAccount("", request.getAccountId(), 
					request.getAccountName(), "", "", "", "", "", "", request.getEmail(), "", request.getFullName(), 
					profileRequestData.getBirthday().getTime(), request.getLocationId(), "", "", request.getGender(), 
					request.getMobile(), request.getAddress(), new BigDecimal(0), new BigDecimal(0), "", 1)));
		} else {
			Accounts account = accounts.get(0);
			account.setFullName(request.getFullName());
			account.setBirthday(profileRequestData.getBirthday().getTime());
			account.setAddress(request.getAddress());
			account.setGender(request.getGender());
			account.setLocationId(request.getLocationId());
			account.setMobile(request.getMobile());
			account.setVersion(account.getVersion() + 1);
			account.setUpdatedTime(Calendar.getInstance().getTime());
			accountRepository.save(account);
		}
		
		return response;
	}

	@Override
	public ResponseData registerSmsPlus(RegisterSMSPlusRequest request) throws RemoteException, ServiceException {
		ResponseData response = new ResponseData();
		// Check valid Param
		if(request == null 
				|| request.getAccountId() == null 
				|| StringUtils.isEmpty(request.getAccountName()) 
				|| StringUtils.isEmpty(request.getSmsPlusMobile())){
			return new ResponseData(DataConstants.ResponseCode.MISSING_PARAMS.getDisplay(), null, DataConstants.ResponseCode.MISSING_PARAMS.getValue());
		}
		
		log.info(" Call BillingService.registerSmsPlus");
		response = billingService.registerSmsPlus(request.getAccountId(), request.getAccountName(), request.getSmsPlusMobile());
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			log.error(new StringBuffer("[ERROR] Register SMS Plus IS FAILED!!!. ")
					.append(", AccountId: ").append(request.getAccountId())
					.append(", AccountName: ").append(request.getAccountName())
					.append(", SmsMobile: ").append(request.getSmsPlusMobile())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		log.info(" Save EVENT to DB");
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.RegisterSmsPlus, 
															request, 
															new RegisterSMSPlusMetadata()
																.setAccountId(request.getAccountId())
																.setAccountName(request.getAccountName())
																.setSmsPlusMobile(request.getSmsPlusMobile())));
			
		log.info(" Save ACCOUNT to DB");
		List<Accounts> accounts = accountRepository. findAllByAccountId(request.getAccountId());
		if (accounts == null || accounts.isEmpty()) {
			accountRepository.save((modelUtils.createAccount("", request.getAccountId(), 
					request.getAccountName(), "", "", "", "", "", "", request.getEmail(), "", "", 
					null, null, "", "", DataConstants.Zero, 
					request.getSmsPlusMobile(), "", new BigDecimal(0), new BigDecimal(0), "", 1)));
		} else {
			Accounts account = accounts.get(0);
			account.setMobile(request.getSmsPlusMobile());
			account.setVersion(account.getVersion() + 1);
			account.setUpdatedTime(Calendar.getInstance().getTime());
			accountRepository.save(account);
		}
		
		return response;
	}

	public ResponseData activeSmsPlus(ActiveSMSPlusRequest request) throws RemoteException, ServiceException{
		ResponseData response = new ResponseData();
		
		if(request== null ){
			return new ResponseData(DataConstants.ResponseCode.MISSING_PARAMS.getDisplay(), null, DataConstants.ResponseCode.MISSING_PARAMS.getValue());
		}
		
		response = billingService.activeSmsPlus(request.getAccountId(), request.getOtp(), request.getSmsPlusMobile());
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			log.error(new StringBuffer("[ERROR] Active SMS Plus IS FAILED!!!. ")
					.append(", AccountId: ").append(request.getAccountId())
					.append(", AccountName: ").append(request.getAccountName())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.ActiveSmsPlus, 
														request, 
														new ActiveSMSPlusMetadata()
															.setAccountId(request.getAccountId())
															.setOtp(request.getOtp())
															.setSmsPlusMobile(request.getSmsPlusMobile())));
		
		return response;
	}

	@Override
	public SMSPlusListResponseData getListSmsPlus(Request request) throws RemoteException, ServiceException {
		SMSPlusListResponseData response = new SMSPlusListResponseData();
		if(request == null || request.getAccountId() == null){
			response.setResponseCode(DataConstants.ResponseCode.MISSING_PARAMS.getValue());
			response.setDescription(DataConstants.ResponseCode.MISSING_PARAMS.getDisplay());
			return response;
		}
		
		response = billingService.getListSmsPlus(request.getAccountId());
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			log.error(new StringBuffer("[ERROR] Get List SMS Plus IS FAILED!!!. ")
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		return response;
	}

	@Override
	public ResponseData changeMobile(ChangeMobileRequest request) throws RemoteException, ServiceException {
		ResponseData response = new ResponseData();
		if(request == null || request.getRequestData() == null){
			return response;
		}
		request.getRequestData().setClientIP(request.getClientIp());
		request.getRequestData().setAccountName(request.getAccountName());
		
		response = billingService.changeMobile(request.getRequestData());
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			log.error(new StringBuffer("[ERROR] Get change mobile IS FAILED!!!. ")
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}
		
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(request.getAccountId(), request.getAccountName());
		if (accounts == null || accounts.isEmpty()) {
			accountRepository.save((modelUtils.createAccount("", request.getAccountId(), 
					request.getAccountName(), "" , "", "", "", "", "", request.getEmail(), "", "", 
					null, null, "", "", DataConstants.Zero, 
					request.getRequestData().getNewMobile(), "", new BigDecimal(0), new BigDecimal(0), "", 1)));
		} else {
			Accounts account = accounts.get(0);
			account.setMobile(request.getRequestData().getNewMobile());
			account.setVersion(account.getVersion() + 1);
			account.setUpdatedTime(Calendar.getInstance().getTime());
			accountRepository.save(account);
		}
		
		return response;
	}

	@Override
	public ResponseData verifyMobile(VerifyMobileRequest request) throws RemoteException, ServiceException {
		ResponseData response = new ResponseData();
		VerifyMobileRequestData requestData = new VerifyMobileRequestData();
		requestData.setAccountName(request.getAccountName());
		requestData.setClientIP(request.getClientIp());
		requestData.setMobile(request.getMobile());
		requestData.setOTP(request.getOtp());
		requestData.setSign(request.getSign());
		response = billingService.verifyMobile(requestData);
		if(response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			return response;
		}
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.VerifyMobile, 
													request, 
													new VerifyMobileMetadata()
															.setAccountName(requestData.getAccountName())
															.setClientIp(requestData.getClientIP())
															.setMobile(requestData.getMobile())
															.setOtp(requestData.getOTP())
															.setSign(requestData.getSign())));
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(request.getAccountId(), request.getAccountName());
		if (accounts == null || accounts.isEmpty()) {
			accountRepository.save((modelUtils.createAccount("", request.getAccountId(), 
					request.getAccountName(), "", "", "", "", "", "", request.getEmail(), "", "", 
					null, null, "", "", DataConstants.Zero, 
					request.getMobile(), "", new BigDecimal(0), new BigDecimal(0), "", 1)));
		} else {
			Accounts account = accounts.get(0);
			account.setMobile(request.getMobile());
			account.setVersion(account.getVersion() + 1);
			account.setUpdatedTime(Calendar.getInstance().getTime());
			accountRepository.save(account);
		}
		
		
		return response;
	}

	@Deprecated
	@Override
	public Accounts getAccountByAccountIdOrAccountName(Integer accountId, String accountName) {
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(accountId, accountName);
		
		return new Accounts();
	}

	@Override
	public ResponseData insertAccountInfo(AccountInfoRequest request) throws RemoteException, ServiceException {
		AccountInfoRequestData requestData = modelUtils.createAccountInfoMetadata(request);
		ResponseData response = billingService.insertAccountInfo(requestData);
		
		return response;
	}

	@Override
	public VtcOAuth2AccessToken autoLogin(Integer accountId, String userName, String accessToken) throws RemoteException, ServiceException {
		VtcOAuth2AccessToken result = new VtcOAuth2AccessToken();
		AccountInfoModel info = new AccountInfoModel();
		AccountInfoFullModel accountFull = null;
		String userJson = serviceUtils.getTokenStore().getAccountInfo(userName);
		if (userJson == null) {
			accountFull = billingService.getAccountInfo(userName);
			serviceUtils.getTokenStore().storeAccountInfo(accountFull);
			info = new AccountInfoModel(accountFull);
		} else{
			AccountInfoFullModel accountInfoFull = AccountInfoFullModel.fromJson(userJson);
	
			long current = System.currentTimeMillis();
			Long storedTime = accountInfoFull.getTimeStored();
			long dayTime = 24 * 60 * 60 * 1000;
			if (storedTime == null || current - storedTime > dayTime) {
				accountFull = billingService.getAccountInfo(userName);
				serviceUtils.getTokenStore().storeAccountInfo(accountInfoFull);
			}
	
			info = new AccountInfoModel(accountInfoFull);
		}
		
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(accountId, userName);
		if(CollectionUtils.isEmpty(accounts)){
			result.setErrorCode(DataConstants.ResponseCode.ACCOUNT_NOT_FOUND.getValue().toString());
			result.setErrorMessage(DataConstants.ResponseCode.ACCOUNT_NOT_FOUND.getDisplay());
			return result;
		}
		
		Accounts account = accounts.stream().findFirst().get();
		ResponseData responseCheckBilling = serviceUtils.checkBillingAccessToken(
				MathUtil.parseInt(sysConfig.getBillingServiceId()), userName, account.getBillingAccessToken());
		if (responseCheckBilling == null || responseCheckBilling.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			result.setErrorCode(responseCheckBilling == null ? DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getValue().toString() : responseCheckBilling.getResponseCode().toString());
			result.setErrorMessage(responseCheckBilling == null ? DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getDisplay() : responseCheckBilling.getDescription());
			
			return result;
		}
		result.setAccessToken(accessToken);
		result.setAccountId(info.getId().toString());
		result.setAccountName(userName);
		result.setBillingAccessToken(account.getBillingAccessToken());
		result.setEmail(info.getEmail());
		result.setMobile(info.getMobile());
		result.setUserStatus(info.getUserStatus());
		result.setErrorCode(PConstants.RESPONSE.CODE_SUCCESS + "");
		
		return result;
	}

	@Override
	public WapInfo getWapInfo(Request request) {
		WapInfo wapInfo = new WapInfo();
		BalanceResponseData balanceData = billingService.getAllBalance(request.getAccountId(), request.getAccountName());
		if(balanceData == null || balanceData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			wapInfo.setResponseCode(balanceData == null ? PConstants.RESPONSE.CODE_ERROR : balanceData.getResponseCode());
			wapInfo.setDescription(balanceData == null ? PConstants.RESPONSE.MESS_SYSTEM : balanceData.getDescription());
			
			return wapInfo;
		}
		wapInfo.setWapUrl(sysConfig.getWapEndpoint())
				.setAccountId(request.getAccountId())
				.setAccountName(request.getAccountName())
				.setVcoin(balanceData.getVcoin())
				.setVcoinFreeze(balanceData.getVcoinFreeze())
				.setVcoinGame(balanceData.getVcoinGame());
		wapInfo.setResponseCode(balanceData.getResponseCode());
		wapInfo.setDescription(balanceData.getDescription());
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GetWapInfo, request, null));
		
		return wapInfo;
	}
}
