package com.vtc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.VtcOAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtc.business.AccountService;
import com.vtc.business.GameService;
import com.vtc.business.ServiceUtils;
import com.vtc.dataconstant.DataConstants;
import com.vtc.model.AccountInfoFullModel;
import com.vtc.model.AccountInfoModel;
import com.vtc.model.AutoLoginRequest;
import com.vtc.model.WapInfo;
import com.vtc.request.AccountInfoRequest;
import com.vtc.request.ActiveSMSPlusRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.request.ChangeMobileRequest;
import com.vtc.request.RegisterSMSPlusRequest;
import com.vtc.request.RegisterSecureRequest;
import com.vtc.request.Request;
import com.vtc.request.UpdateProfileRequest;
import com.vtc.request.VerifyMobileRequest;
import com.vtc.response.ResponseModel;
import com.vtc.util.MathUtil;
import com.vtc.util.PConstants;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.info.BalanceResponseData;
import com.vtc.ws.v2.model.plus.SMSPlusListResponseData;
import com.vtc.ws.v2.service.BillingService;

/**
 * for check balance, +/- money for account
 * 
 * @author xuanbach
 *
 */
@Controller
public class AccountController{
	private static final Logger log = Logger.getLogger(AccountController.class);

	@Autowired
	private BillingService billingService;

	@Autowired
	private HttpServletRequest httpRequest;
	
	@Autowired
	private ServiceUtils serviceUtils;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private GameService gameService;

//	@RequestMapping(value="/acc/authenLoginVTC", method = RequestMethod.POST, headers = "Accept=application/json")
//	@ResponseBody
//	public ResponseModel authenLoginVTC(@RequestBody AuthenticationRequest request){
//		long t1 = System.currentTimeMillis();
//		log.info(new StringBuffer("[START]AccountController.AuthenLoginVTC() ")
//				.append(", Campaign: ").append(request.getCampaign())
//				.append(", Medium: ").append(request.getMedium())
//				.append(", Source: ").append(request.getSource())
//				.append(", Agency: ").append(request.getAgency())
//				.append(", ClientId: ").append(request.getClientId())
//				.append(", AccountName: ").append(request.getAccountName())
//				.append(", ClientIp: ").append(request.getClientIp())
//				.append(", DeviceType: ").append(request.getDeviceType())
//				.append(", Password: ").append(request.getPassword())
//				.append(", SecureCode: ").append(request.getSecureCode())
//				.append(", SecureType: ").append(request.getSecureType())
//				.append(", ServiceId: ").append(request.getServiceId())
//				.append(", GaTrackingId: ").append(request.getGaTrackingId())
//				.append(", EventCategory: ").append(request.getEventCategory())
//				.append(", EventAction: ").append(request.getEventAction())
//				.append(", EventLabel: ").append(request.getEventLabel())
//				);
//		try {
//			ResponseModel response = new ResponseModel(); 
//			AuthenResponseData result = accountService.authenLoginVTC(request);
//
//			long t2 = System.currentTimeMillis();
//			log.info(new StringBuffer("[END]AccountController.authenLoginVTC(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
//			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
//			response.setInfo(result);
//			return response;// response;
//		} catch (Exception e) {
//			log.error("ERROR", e);
//			long t2 = System.currentTimeMillis();
//			log.error(new StringBuffer("[END]AccountController.authenLoginVTC(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
//			return null;
//		}
//	}
//
//	@RequestMapping(value="/acc/authenLoginBySocial", method = RequestMethod.POST, headers = "Accept=application/json")
//	@ResponseBody
//	public ResponseModel authenLoginBySocial(@RequestBody AuthenticationRequest request){
//		long t1 = System.currentTimeMillis();
//		log.info(new StringBuffer("[START]AccountController.AuthenLoginBySocial() ")
//				.append(", FbBussinessIds: ").append(request.getFbBussinessIds())
//				.append(", FbEmail: ").append(request.getFbEmail())
//				.append(", IsAutoCreate: ").append(request.getIsAutoCreate())
//				.append(", IsDisableCheckSecure: ").append(request.getIsDisableCheckSecure())
//				.append(", OAuthAccount: ").append(request.getoAuthAccount())
//				.append(", OAuthSystemId: ").append(request.getoAuthSystemId())
//				.append(", SignDisableSecure: ").append(request.getSignDisableSecure())
//				.append(", Campaign: ").append(request.getCampaign())
//				.append(", Medium: ").append(request.getMedium())
//				.append(", Source: ").append(request.getSource())
//				.append(", Agency: ").append(request.getAgency())
//				.append(", ClientId: ").append(request.getClientId())
//				.append(", ClientIp: ").append(request.getClientIp())
//				.append(", DeviceType: ").append(request.getDeviceType())
//				.append(", SecureCode: ").append(request.getSecureCode())
//				.append(", SecureType: ").append(request.getSecureType())
//				.append(", ServiceId: ").append(request.getServiceId())
//				.append(", GaTrackingId: ").append(request.getGaTrackingId())
//				.append(", GaClientId: ").append(request.getGaClientId())
//				.append(", EventCategory: ").append(request.getEventCategory())
//				.append(", EventAction: ").append(request.getEventAction())
//				.append(", EventLabel: ").append(request.getEventLabel())
//				);
//		try {
//			ResponseModel response = new ResponseModel(); 
//			OAuthResponseData result = accountService.authenLoginBySocial(request);
//
//			long t2 = System.currentTimeMillis();
//			log.info(new StringBuffer("[END]AccountController.authenLoginBySocial(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
//			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
//			response.setInfo(result);
//			
//			return response;// response;
//		} catch (Exception e) {
//			log.error("ERROR", e);
//			long t2 = System.currentTimeMillis();
//			log.error(new StringBuffer("[END]AccountController.authenLoginBySocial(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
//			return null;
//		}
//	}
	
	/**
	 * Get billing access token
	 * 
	 * @param userName
	 * @param clientIp
	 * @return
	 */
	@RequestMapping(value = "/account/reauthen", method = RequestMethod.POST)
	@ResponseBody
	public ResponseModel reauthen(@RequestBody AuthenticationRequest request){
//			@RequestParam(value = "userName", required = true, defaultValue = "0") String userName,
//			@RequestParam(value = "access_token", required = true, defaultValue = "0") String accessToken,
//			@RequestParam(value = "billing_token", required = true, defaultValue = "0") String billingToken,
//			@RequestParam(value = "deviceType", required = true, defaultValue = "0") Integer deviceType,
//			@RequestParam(value = "authenType", required = true, defaultValue = "0") Integer authenType,
//			@RequestParam(value = "serviceId", required = true, defaultValue = "0") Integer serviceId,
//			@RequestParam(value = "serviceKey", required = true, defaultValue = "0") String serviceKey,
//			@RequestParam(value = "serviceIdOld", required = true, defaultValue = "0") Integer serviceIdOld,
//			@RequestParam(value = "clientIp", required = true, defaultValue = "0") String clientIp) {
		ResponseModel response = new ResponseModel();
		long t1 = System.currentTimeMillis();
		try {
			log.info(new StringBuffer("[START]AccountController.reauthen() clientIp = ").append(request.getClientIp())
					.append(", access_token = ").append(request.getAccessToken()));

			boolean isValid = serviceUtils.validateToken(request.getAccountName(), request.getAccessToken());
			if (!isValid) {
//				log.error(new StringBuffer("INVALID TOKEN access_token = ").append(request.getAccess_token()).toString());
//				long t2 = System.currentTimeMillis();
//				log.error(new StringBuffer("[END]AccountController.reauthen(). TOTAL TIME: ")
//						.append(String.valueOf(t2 - t1)).toString());
//				return null;
				response.setError(PConstants.RESPONSE.CODE_ERROR);
				response.setInfo(new AuthenResponseData());
				return response;
			}

			AuthenResponseData data = accountService.reAuthen(request);
//			AuthenResponseData response = billingService.reauthen(billingToken, userName, clientIp, deviceType,
//					authenType, serviceId, serviceKey, serviceIdOld);
			long t2 = System.currentTimeMillis();
			log.info(new StringBuffer("[END]AccountController.reauthen(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
					.toString());
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(data);
			
		} catch (Exception e) {
			log.error("ERROR ", e);
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
//			long t2 = System.currentTimeMillis();
//			log.error(new StringBuffer("[END]AccountController.reauthen(). TOTAL TIME: ")
//					.append(String.valueOf(t2 - t1)).toString());
		}
		return response;
	}
	
	/**
	 * @api {GET} /account/detail?username={username}&access_token={access_token} Get Account Detail
	 * @apiName GetAccountDetail
	 * @apiGroup Account
	 * 
	 * @apiHeader {String} Authorization Mandatory authorization accessToken (Ex: Bearer 1bb3b5c6-5e80-4305-980d-c96385d99dcc)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
	 *		    "id": 117813858,
	 *		    "userName": "vtctest90",
	 *		    "password": "e10adc3949ba59abbe56e057f20f883e",
	 *		    "fullName": "PhongNV",
	 *		    "email": "",
	 *		    "birthday": 630979200000,
	 *		    "locationId": 10,
	 *		    "userPassport": null,
	 *		    "userStatus": 1,
	 *		    "mobile": "0979647609",
	 *		    "gender": 2,
	 *		    "address": "Tran cung - Ha Noi",
	 *		    "vcoinGame": 0,
	 *		    "vcoinPayment": 9980,
	 *		    "paygateId": 0,
	 *		    "timeStored": 1469785380520
	 *		  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/detail", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel getDetail(
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken) {
		ResponseModel response = new ResponseModel();
		long t1 = System.currentTimeMillis();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				response.setError(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue());
				response.setMessage(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
				return response;
			}
			AccountInfoFullModel accountFull = null;
//			String userJson = serviceUtils.getTokenStore().getAccountInfo(userName);
//			if (userJson == null) {
				accountFull = billingService.getAccountInfo(userName);
//				serviceUtils.getTokenStore().storeAccountInfo(accountFull);
//				AccountInfoModel info = new AccountInfoModel(accountFull);
//				long t2 = System.currentTimeMillis();
//				log.info(new StringBuffer("[END]AccountController.getInfo(). TOTAL TIME: ")
//						.append(String.valueOf(t2 - t1)).toString());
//				response.setError(PConstants.RESPONSE.CODE_SUCCESS);
//				response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
//				response.setInfo(info);
//				
//				return response;
//			}
//
//			AccountInfoFullModel accountInfoFull = AccountInfoFullModel.fromJson(userJson);
//
//			long current = System.currentTimeMillis();
//			Long storedTime = accountInfoFull.getTimeStored();
//			long dayTime = 24 * 60 * 60 * 1000;
//			if (storedTime == null || current - storedTime > dayTime) {
//				accountFull = billingService.getAccountInfo(userName);
//				serviceUtils.getTokenStore().storeAccountInfo(accountInfoFull);
//			}
//
//			long t2 = System.currentTimeMillis();
//			log.info(new StringBuffer("[END]AccountController.getInfo(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
			
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(accountFull);
		} catch (Exception e) {
			log.error("ERROR ", e);
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
//			long t2 = System.currentTimeMillis();
//			log.error(new StringBuffer("[END]AccountController.getInfo(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
//			return null;
		}
		
		return response;
	}

	/**
	 * @api {GET} /account/balancevcoin?username={username}&access_token={access_token} Get balance Vcoin of user
	 * @apiName balancevcoin
	 * @apiGroup Account
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
  	 *			"error": 200,
  	 *			"message": "Success",
  	 *			"info": {
     *				"description": null,
     *				"extend": null,
     *				"responseCode": 1,
     *				"accountID": 117815097,
     *				"accountName": "phongtest1807",
     *				"vcoin": 0,
     *				"vcoinFreeze": 0,
     *				"vcoinGame": 90
  	 *			}
  	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/balancevcoin", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel balanceVcoin(
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken){
		ResponseModel response = new ResponseModel();
		
		try{
//			String tokenKey = httpRequest.getParameter(OAuth2AccessToken.ACCESS_TOKEN);
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				response.setError(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue());
				response.setMessage(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
				return response;
			}
			BalanceResponseData data = accountService.getAllBalance(userName);
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, data);
		}catch(Exception e){
			log.error("ERROR ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/account/info", method = RequestMethod.GET)
	@ResponseBody
	public ResponseModel getInfo(
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken) {
		ResponseModel response = new ResponseModel();
		long t1 = System.currentTimeMillis();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				response.setError(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue());
				response.setMessage(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
				return response;
			}

			AccountInfoFullModel accountFull = null;
			String userJson = serviceUtils.getTokenStore().getAccountInfo(userName);
			if (userJson == null) {
				accountFull = billingService.getAccountInfo(userName);
				serviceUtils.getTokenStore().storeAccountInfo(accountFull);
				AccountInfoModel info = new AccountInfoModel(accountFull);
				long t2 = System.currentTimeMillis();
				log.info(new StringBuffer("[END]AccountController.getInfo(). TOTAL TIME: ")
						.append(String.valueOf(t2 - t1)).toString());
				
				response.setError(PConstants.RESPONSE.CODE_SUCCESS);
				response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
				response.setInfo(info);
				
				return response;
			}

			AccountInfoFullModel accountInfoFull = AccountInfoFullModel.fromJson(userJson);

			long current = System.currentTimeMillis();
			Long storedTime = accountInfoFull.getTimeStored();
			long dayTime = 24 * 60 * 60 * 1000;
			if (storedTime == null || current - storedTime > dayTime) {
				accountFull = billingService.getAccountInfo(userName);
				serviceUtils.getTokenStore().storeAccountInfo(accountInfoFull);
			}

			AccountInfoModel info = new AccountInfoModel(accountInfoFull);
			long t2 = System.currentTimeMillis();
			log.info(new StringBuffer("[END]AccountController.getInfo(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
					.toString());
			
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(info);
			
		} catch (Exception e) {
			log.error("ERROR ", e);
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
//			long t2 = System.currentTimeMillis();
//			log.error(new StringBuffer("[END]AccountController.getInfo(). TOTAL TIME: ").append(String.valueOf(t2 - t1))
//					.toString());
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /account/autologin?username={username}&access_token={access_token} Auto Login account
	 * @apiName AutoLogin
	 * @apiGroup Account
	 * 
	 * @apiParam {int} accountId	Mandatory your accountId
	 * @apiParam {String} clientId	Mandatory id mapping with server
	 * @apiParam {int} osType	Mandatory type of os (1:iOs    2:Android)
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id Mandatory client_id header
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
  	 *			"error": 200,
  	 *			"message": "Success",
  	 *			"info": {
     *				"accountId": "117815097",
     *				"accessToken": "",
     *				"billingAccessToken": "",
     *				"userName": "phongtest1807",
     *				"email": null,
     *				"userStatus": 1,
     *				"mobile": null,
     *				"avatarUrl": "",
     *				"gameVersion": "1"
  	 *			}
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/autologin", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel autoLogin(
			@RequestBody AutoLoginRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken) {
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}

			VtcOAuth2AccessToken result = accountService.autoLogin(request.getAccountId(), userName, accessToken);
			if(result == null || MathUtil.parseInt(result.getErrorCode()).compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : MathUtil.parseInt(result.getErrorCode()), result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getErrorMessage());
				return response;
			}
			
			result.setGameVersion(gameService.findEnvironmentByClientIdAndOS(request.getClientId(), request.getOsType()).getVersion());
			result.setAvatarUrl("");
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, result);
			
		} catch (Exception e) {
			log.error("ERROR ", e);
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/account/regisauthensecure", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel setupAuthenSecure(
			@RequestBody RegisterSecureRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try{
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
			}
			
			ResponseData result = accountService.setupAuthenSecure(request);
			if(result == null || result.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode(),
											 result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getDescription(),
											 result);
				
				return response;
			}
			
			response = new ResponseModel(result.getResponseCode(), result.getDescription(), result);
		} catch (Exception e){
			log.error("ERROR ", e);
			response.setError(PConstants.RESPONSE.CODE_ERROR);
			response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /account/updateprofile?username={username}&access_token={access_token} Update Profile
	 * @apiName UpdateProfile
	 * @apiGroup Account
	 * 
	 * @apiHeader {String} Authorization Mandatory Bearer + accessToken (Ex: Bearer 1bb3b5c6-5e80-4305-980d-c96385d99dcc)
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} clientId Mandatory clientId config with Server
     * @apiParam {String} deviceType Mandatory 1:Web, 2:Mobile
     * @apiParam {String} deviceToken Mandatory notification of device
     * @apiParam {String} manufacture Manufacture
     * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
     * @apiParam {String} accountName Mandatory your accountName
     * @apiParam {int} accountId Mandatory your accountId
     * @apiParam {String} mobile Mandatory your new mobile
     * @apiParam {String} fullName Mandatory your new fullname
     * @apiParam {String} address Mandatory your new address
     * @apiParam {String} birthday Mandatory your birthday YYYY/MM/dd (Ex: 1990/01/01)
     * @apiParam {int} districtId Mandatory your district
     * @apiParam {int} gender Mandatory your gender. 1-Female, 2-Male
     * @apiParam {int} locationId Mandatory your location
     * @apiParam {int} wardId Mandatory your wardId
     * @apiParam {String} clientIp Mandatory your clientIP
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": "Cập nhật thông tin tài khoản thành công",							
	 *			  "info": {
	 *				    "responseCode": 1,
	 *				    "extend": null,
	 *				    "description": "Cập nhật thông tin tài khoản thành công",
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/updateprofile", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel updateAccountProfile(
			@RequestBody UpdateProfileRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				response.setError(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue());
				response.setMessage(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
				return response;
			}
			if(StringUtils.isEmpty(request.getAccountName())){
				request.setAccountName(userName);
			}
			
			ResponseData result = accountService.updateAccountProfile(request);
			if(result == null || result.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode(),
											 result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getDescription(),
											 result);
				
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, result.getDescription(), result);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/account/registersmsplus", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel registerSmsPlus(
			@RequestBody RegisterSMSPlusRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
			}
			
			ResponseData result = accountService.registerSmsPlus(request);
			
			if(result == null || result.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode(),
											 result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getDescription(),
											 result);
				
				return response;
			}
			
			response = new ResponseModel(result.getResponseCode(), result.getDescription(), result);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
		
	}
	
	/**
	 * @api {POST} /account/verifymobile?username={username}&access_token={access_token} Verify Mobile
	 * @apiName VerifyMobile
	 * @apiGroup Account
	 * 
	 * @apiHeader {String} Authorization Mandatory Bearer + accessToken (Ex: Bearer 1bb3b5c6-5e80-4305-980d-c96385d99dcc)
	 * @apiHeader {String} client_id Mandatory client_id header
     * 
	 * @apiParam {String} clientId Mandatory clientId config with Server
     * @apiParam {String} deviceType Mandatory 1:Web, 2:Mobile
     * @apiParam {String} deviceToken Mandatory notification of device
     * @apiParam {String} manufacture Manufacture
     * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
     * @apiParam {String} accountName Mandatory your accountName
     * @apiParam {int} accountId Mandatory your accountId
     * @apiParam {String} mobile Mandatory your new mobile
     * @apiParam {String} clientIp Mandatory your clientIP
     * @apiParam {String} otp Mandatory your otp (truyen o buoc 2)
     * @apiParam {String} sign Mandatory your sign (lay ve tu buoc 1 va truyen vao buoc 2)
     * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": "Success",							
	 *			  "info": {
	 *				    "responseCode": 1,
	 *				    "extend": 636056669116047917.e9dc8cd7d64472ae59ffe796b8b117a9,
	 *				    "description": "thành công",
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/verifymobile", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel verifyMobile(
			@RequestBody VerifyMobileRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				response.setError(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue());
				response.setMessage(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
				return response;
			}
			
			ResponseData result = accountService.verifyMobile(request);
			
			if(result == null || result.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode(),
											 result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getDescription(),
											 result);
				
				return response;
			}
			
			response = new ResponseModel(result.getResponseCode(), result.getDescription(), result);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/account/activesmsplus", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel activeSmsPlus(
			@RequestBody ActiveSMSPlusRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				response.setError(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue());
				response.setMessage(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
				return response;
			}
			
			ResponseData result = accountService.activeSmsPlus(request);
			
			if(result == null || result.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode(),
											 result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getDescription(),
											 result);
				
				return response;
			}
			
			response = new ResponseModel(result.getResponseCode(), result.getDescription(), result);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
		
	}

	@RequestMapping(value = "/account/getlistsmsplus", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel getListSmsPlus(
			@RequestBody Request request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
			}
			
			SMSPlusListResponseData result = accountService.getListSmsPlus(request);
			
			if(result == null || result.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode(),
											 result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getDescription(),
											 result);
				
				return response;
			}
			
			response = new ResponseModel(result.getResponseCode(), result.getDescription(), result);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /account/changemobile?username={username}&access_token={access_token} Change Mobile
	 * @apiName Change Mobile
	 * @apiGroup Account
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {String} clientIp		Mandatory clientIp
	 * @apiParam {int} accountId	Mandatory Id of your account
	 * @apiParam {String} accountName Mandatory your accountName
	 * @apiParam {Object} requestData	Request object data for Change Password
	 * @apiParam {String} 	requestData.mobile	Mandatory your mobile
	 * @apiParam {String} 	requestData.newMobile	new mobile
	 * @apiParam {String} 	requestData.newOTP	new otp
	 * @apiParam {String} 	requestData.OTP	Mandatory your otp
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id 353b302c44574f565045687e534e7d6a
	 * 
	 * 
	 * @apiParamExample {json} Request-Example:
	 *		{
	 * 			"manufacture": "Iphone",
	 *			"modelName": "Iphone6",
	 *			"operatingSystem": "IOS 8.0",
	 *			"operatingSystemVersion": "8.0",
	 *		    "deviceType": 1,		
	 *			"deviceId": "abababba",
	 *			"clientIp": "192.1.1.1",
	 *			"accountId": 1234324,
	 *			"accountName": "vtctest01",
	 *		    "requestData":{					
	 *		        "mobile": "123456789",			
	 *		        "newMobile": "65432123232",						
	 *		        "newOTP": "123456",							
	 *		        "OTP": "123456"								
	 *		    }	
	 *		}
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    "responseCode": 1,
	 *				    "extend": null,
	 *				    "description": "Đổi mật khẩu thành công",
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/changemobile", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel changeMobile(
			@RequestBody ChangeMobileRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			
			ResponseData responseData = accountService.changeMobile(request);
			
			if(responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode(),
						responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription(),
								responseData);
				
				return response;
			}
			
			response = new ResponseModel(responseData.getResponseCode(), responseData.getDescription(), responseData);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /account/insertaccountinfo?username={username}&access_token={access_token} Insert Account Info
	 * @apiName InsertAccountInfo
	 * @apiGroup Account
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {String} clientId		Mandatory clientId
	 * @apiParam {int} accountId	Mandatory Id of your account
	 * @apiParam {String} accountName Mandatory your accountName
	 * @apiParam {String} address Mandatory your address 
	 * @apiParam {int} questionId Mandatory id of question
	 * @apiParam {String} answer Mandatory your answer
	 * @apiParam {String} birthday Mandatory your birthday (YYYY-MM-dd)
	 * @apiParam {String} clientIp Mandatory Ip of client
	 * @apiParam {int} districtId Mandatory district
	 * @apiParam {String} email Mandatory your email
	 * @apiParam {String} fullName Mandatory your full name
	 * @apiParam {int} gender Mandatory your gender. 1-Female, 2-Male
	 * @apiParam {int} locationId Mandatory location
	 * @apiParam {String} mobile Mandatory your mobile
	 * @apiParam {String} passport Mandatory your passport
	 * @apiParam {String} secureCode Mandatory your secureCode
	 * @apiParam {int} wardId Mandatory wardId
	 * @apiParam {String} sign (Step2) After step 1, you will receive sign and input here
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id 353b302c44574f565045687e534e7d6a
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    "responseCode": 1,
	 *				    "extend": null,
	 *				    "description": "",
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/insertaccountinfo", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel insertAccountInfo(
			@RequestBody AccountInfoRequest request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			
			ResponseData responseData = accountService.insertAccountInfo(request);
			
			if(responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode(),
						responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription(),
								responseData);
				
				return response;
			}
			
			response = new ResponseModel(responseData.getResponseCode(), responseData.getDescription(), responseData);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /account/wapinfo?username={username}&access_token={access_token} Get Wap Info
	 * @apiName GetWapInfo
	 * @apiGroup Account
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {String} clientId		Mandatory clientId
	 * @apiParam {int} accountId	Mandatory Id of your account
	 * @apiParam {String} accountName Mandatory your accountName
	 * 
	 * @apiHeader {String} Authorization Bearer + accessToken (ex: Bearer 92afc063-3d63-47a2-9ec2-009eb90e0140)
	 * @apiHeader {String} client_id 353b302c44574f565045687e534e7d6a
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				   	"description": null,
     *					"extend": null,
     *					"responseCode": 1,
     *					"wapUrl": "http://117.103.207.67/wapsdk/",
     *					"accountName": "vtctest90",
	 *				    "accountId": 117813858,
	 *				    "vcoin": 9872,
	 *				    "vcoinFreeze": 0,
	 *				    "vcoinGame": 0
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/account/wapinfo", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel wapInfo(
			@RequestBody Request request,
			@RequestParam(value = DataConstants.RequestParams.UserName, required = true, defaultValue = "0") String userName,
			@RequestParam(value = DataConstants.RequestParams.AccessToken, required = true, defaultValue = "0") String accessToken
			){
		ResponseModel response = new ResponseModel();
		try {
			boolean isValid = serviceUtils.validateToken(userName, accessToken);
			if (!isValid) {
				return new ResponseModel(DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getValue(), DataConstants.ResponseCode.INVALID_TOKEN_OR_USERNAME.getDisplay());
			}
			
			request.setAccountName(userName);
			WapInfo responseData = accountService.getWapInfo(request);
			
			if(responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(responseData == null ? PConstants.RESPONSE.CODE_ERROR : responseData.getResponseCode(),
						responseData == null ? PConstants.RESPONSE.MESS_SYSTEM : responseData.getDescription(),
								responseData);
				
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	public BillingService getBillingService() {
		return billingService;
	}

	public void setBillingService(BillingService billingService) {
		this.billingService = billingService;
	}
}
