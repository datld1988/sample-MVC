package com.vtc.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtc.business.AccountService;
import com.vtc.business.AppActivityService;
import com.vtc.business.CommonUtils;
import com.vtc.business.UserService;
import com.vtc.dataconstant.DataConstants;
import com.vtc.request.AccountRegisterRequest;
import com.vtc.request.ChangePasswordRequest;
import com.vtc.request.ResetPasswordByEmailRequest;
import com.vtc.request.ResetPasswordBySecureCodeRequest;
import com.vtc.response.ResponseModel;
import com.vtc.util.PConstants;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.OAuthCreateResponseData;
import com.vtc.ws.v2.model.plus.AccountOAuth;
import com.vtc.ws.v2.model.register.RegisterResponseData;

@Controller
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AppActivityService appActivityService;
	
	@Autowired
	CommonUtils commonUtils;
	
	/**
	 * @api {POST} /user/registerVtc RegisterVTC account
	 * @apiName RegisterAccountVTC
	 * @apiGroup User
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} campaign	Name of campaign
	 * @apiParam {String} medium	Name of medium
	 * @apiParam {String} source	Name of source
	 * @apiParam {String} agency	Name of agency
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
	 * @apiParam {String} accountName	Mandatory Name of Account Register
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} deviceId		Mandatory Id of device
	 * @apiParam {String} password	Mandatory Password account
	 * @apiParam {String} email		Your email
	 * @apiParam {Object} trackingModel	Tracking information that your send GA , server only save data
	 * @apiParam {String} 	trackingModel.gaTrackingId		TrackingId send to Google Analytics
	 * @apiParam {String} 	trackingModel.gaClientId		ClientId of device/user send to Google Analytics
	 * @apiParam {String} 	[trackingModel.hitType="event"]	HitType send to GA default "event"
	 * @apiParam {String} 	trackingModel.category	Name of eventCategory
	 * @apiParam {String} 	trackingModel.action	Name of eventAction
	 * @apiParam {String} 	[trackingModel.label]	Optional Name of eventLabel
	 * @apiParam {int} registerType		Mandatory 1:thông thường;2: đk nhanh; 3: chơi ngay; 4: đk gắn kết Facebook; 5: đk gắn kết Google; 6: đk gắn kết Yahoo
	 * @apiParam {int} serviceId	Mandatory ServiceId mapping with Server
	 * @apiParam {String} mobile	Your mobile
	 * @apiParam {String} clientIp	your clientIP
	 * 
	 * @apiParamExample {json} Request-Example:
	 *		{
	 * 			"manufacture": "Iphone",
	 *			"modelName": "Iphone6",
	 *			"operatingSystem": "IOS 8.0",
	 *			"operatingSystemVersion": "8.0",
	 *			"utm": "democlpt://?utm_source=facebook&utm_campaign=demo&utm_medium=1706",
	 *		    "campaign": "TestCampaign1",          					
	 *		    "medium": "TestMedium1",							
	 *		    "source": "TestSource1",								
	 *		    "agency": "TestAgency1",								
	 *		    "clientId": "353b302c44574f565045687e534e7d6a",		
	 *		    "accountName": "testvtc20160711",	
	 *		    "deviceType": 1,		
	 *			"deviceId": "abababba",
	 *		    "password": "Vtctest@123",								
	 *		    "trackingModel":{			
	 *		        "gaTrackingId": "UA-59062861-18",			
	 *		        "gaClientId": "a1b2c3d4e5f6g7h8j9k10",		
	 *		        "hitType": "event",			
	 *		        "category": "TestCategory1",						
	 *		        "action": "TestAction1",							
	 *		        "label": "TestLabel1"								
	 *		    },
	 *		    "registerType": 2,		
	 *		    "serviceId": 100000,	
	 *		    "clientIp": "192.168.1.1"								
	 *		}
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    "description": "Đăng ký tài khoản thành công",
	 *				    "extend": null,
	 *				    "responseCode": 1,
	 *				    "accessToken": null,
	 *				    "accountID": 117815083,											
	 *				    "accountName": "testvtc20160711",				
	 *				    "balance": -- Balance vcoin
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/user/registerVtc", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel accountRegister(@RequestBody AccountRegisterRequest request){
		ResponseModel response = new ResponseModel(); 
		try {
			RegisterResponseData result = userService.accountRegister(request);
			
			if (result == null || result.getResponseCode().compareTo(new Integer(0)) <= 0) {
				response.setError(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode());
				response.setMessage(PConstants.RESPONSE.MESS_SYSTEM);
				response.setInfo(result);
				return response;
			}
			
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(result);
		} catch (IOException e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value="/user/registerBySocial", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel accountRegisterBySocial(@RequestBody AccountRegisterRequest request){
		ResponseModel response = new ResponseModel(); 
		try {
			OAuthCreateResponseData result = userService.registerBySocial(request);
			
			if (result == null || result.getResponseCode().compareTo(new Integer(0)) <= 0) {
				response.setError(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode());
				response.setInfo(result);
				return response;
			}
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, result);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value="/user/deleteAccountOAuth/{oAuthId}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel deleteAccountOAuth(@PathVariable String oAuthId){
		ResponseModel response = new ResponseModel(); 
		try {
			Integer oAuthIdInteger = Integer.parseInt(oAuthId);
			ResponseData data = userService.deleteAccountOAuth(oAuthIdInteger);
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, data);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value="/user/getAccountsOAuth/{accountName}/{oAuthSystemId}/{oAuthAccounts}", 
			method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel getAccountsOAuth(
			@PathVariable String accountName, 
			@PathVariable String oAuthSystemId,
			@PathVariable String oAuthAccounts
			){
		ResponseModel response = new ResponseModel(); 
		try {
			Integer oAuthSystemIdInteger = Integer.parseInt(oAuthSystemId);
			List<AccountOAuth> data = userService.getAccountsOAuth(accountName, oAuthSystemIdInteger, oAuthAccounts);
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, data);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value="/user/checkvtcaccount/{accountName}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel getAccountsOAuth(@PathVariable String accountName){
		ResponseModel response = new ResponseModel(); 
		try {
			ResponseData data = userService.checkVTCAccount(accountName);
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, data);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
//	@RequestMapping(value = "/user/changepassword1", method = RequestMethod.POST, headers = "Accept=application/json")
//	@ResponseBody
//	public ResponseModel changePassword(
//			@RequestBody ChangePasswordRequest request
//			){
//		ResponseModel response = new ResponseModel();
//		try {
//			ResponseData result = accountService.changePassword(request);
//			
//			if(result == null || result.getResponseCode().compareTo(DataConstants.Zero) <= 0){
//				response = new ResponseModel(result == null ? PConstants.RESPONSE.CODE_ERROR : result.getResponseCode(),
//											 result == null ? PConstants.RESPONSE.MESS_SYSTEM : result.getDescription(),
//											 result);
//				
//				return response;
//			}
//			
//			response = new ResponseModel(result.getResponseCode(), result.getDescription(), result);
//		} catch (Exception e) {
//			log.error("[ERROR] ", e);
//			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
//		}
//		
//		return response;
//	}
	
	/**
	 * @api {POST} /user/resetpassbyotp Reset Password By OTP
	 * @apiName ResetPasswordByOTP
	 * @apiGroup User
	 * 
	 * @apiHeader {String} client_id Users unique client_id
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} accountName		Mandatory account want to reset
	 * @apiParam {String} clientIp		Mandatory your clientIP
	 * @apiParam {String} secureCode	Mandatory your opt code
	 * @apiParam {int} 	secureType	Mandatory your opt type : 1 - OTP SMS , 2 - OTP App
	 * @apiParam {String} password	Mandatory new password
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    "description": "Thành công",
	 *				    "extend": null,
	 *				    "responseCode": 1,
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/resetpassbyotp", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel resetPasswordBySecureCode(
			@RequestBody ResetPasswordBySecureCodeRequest request
			){
		ResponseModel response = new ResponseModel();
		try {
			ResponseData responseData = userService.resetPasswordBySecureCode(request);
			if(responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(responseData == null ? DataConstants.ResponseCode.ERROR_SYSTEM.getValue() : responseData.getResponseCode(),
											responseData == null ? DataConstants.ResponseCode.ERROR_SYSTEM.getDisplay() : responseData.getDescription(),
											responseData);
				
				return response;
			}
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(DataConstants.ResponseCode.ERROR_SYSTEM.getValue(), DataConstants.ResponseCode.ERROR_SYSTEM.getDisplay());
		}
		
		return response;
	}
	
	
	/**
	 * @api {POST} /user/resetpassbyemail Reset Password By Email
	 * @apiName ResetPasswordByEmail
	 * @apiGroup User
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	utm link
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
	 * @apiParam {String} deviceToken		Mandatory token of device
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} accountName		Mandatory your accountName
	 * @apiParam {String} clientIp		Mandatory your clientIp
	 * @apiParam {String} email	Mandatory your email link with account
	 * @apiParam {String} password	Mandatory new password
	 * @apiParam {String} sign (Step2) After step 1, you will receive sign and input here
	 * 
	 * 
	 * @apiParamExample {json} Request-Example:
	 *		{
	 * 			"manufacture": "Iphone",
	 *			"modelName": "Iphone6",
	 *			"operatingSystem": "IOS 8.0",
	 *			"operatingSystemVersion": "8.0",
	 *			"utm": "democlpt://?utm_source=facebook&utm_campaign=demo&utm_medium=1706",								
	 *		    "clientId": "353b302c44574f565045687e534e7d6a",		
	 *			"deviceId": "abababba",
	 *		    "deviceType": 1,	
	 *			"accountName": "vtctest90",			
	 *		    "clientIp": "",		
	 *		    "email": "",			
	 *		    "password": "",
	 *			"sign": "",								
	 *		}
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    "description": "Thành công",
	 *				    "extend": null,
	 *				    "responseCode": 1,
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/resetpassbyemail", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel resetPasswordByEmail(
			@RequestBody ResetPasswordByEmailRequest request){
		ResponseModel response = new ResponseModel();
		try {
			ResponseData responseData = userService.resetPasswordByEmail(request);
			if(responseData == null || responseData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
				response = new ResponseModel(responseData == null ? DataConstants.ResponseCode.ERROR_SYSTEM.getValue() : responseData.getResponseCode(),
											responseData == null ? DataConstants.ResponseCode.ERROR_SYSTEM.getDisplay() : responseData.getDescription(),
											responseData);
				
				return response;
			}
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(DataConstants.ResponseCode.ERROR_SYSTEM.getValue(), DataConstants.ResponseCode.ERROR_SYSTEM.getDisplay());
		}
		
		return response;
	}
	
	/**
	 * @api {POST} /user/changepassword Change Password
	 * @apiName Change Password
	 * @apiGroup User
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} deviceToken		Mandatory Id of device
	 * @apiParam {String} clientId	Mandatory clientId mapping with server
	 * @apiParam {String} accountName	Mandatory your accountName
	 * @apiParam {String} clientIp		Mandatory ClientIp
	 * @apiParam {String} newPassword	Mandatory New password
	 * @apiParam {String} oldPassword	Mandatory Old password
	 * @apiParam {String} secureCode	Mandatory Secure code of OTP
	 * @apiParam {String} secureType	Mandatory OTP type (1:OTP SMS, 2:OTP APP)
	 * 
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
	 *		    "clientIP": "::0.0.1",	
	 *			"accountName": "vtctest90",	
	 *		    "newPassword": "123456789",			
	 *		    "oldPassword": "654321",						
	 *		    "secureCode": "1234",							
	 *		    "secureType": 1									
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
	@RequestMapping(value = "/user/changepassword", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel changePassword(
			@RequestBody ChangePasswordRequest request
			){
		ResponseModel response = new ResponseModel();
		try {
			ResponseData result = userService.changePassword(request);
			
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
	
	
	/**
	 * @api {POST} /login?{param} Login by VTC account
	 * @apiName LoginVTCAccount
	 * @apiGroup User
	 * 
	 * @apiParam {String} username	Mandatory
	 * @apiParam {String} password	Mandatory
	 * @apiParam {String} client_id	Mandatory ip client mapping with server
	 * @apiParam {String} client_secret	Mandatory
	 * @apiParam {String} grant_type Mandatory 	default = password
	 * @apiParam {String} authen_type Mandatory 	 0: thường; 1: facebook;2: google; 3: yahoo
	 * @apiParam {String} secure_code Mandatory  (step2: for OTP account)
	 * @apiParam {String} secure_type Mandatory // 1: OTP SMS; 2: OTP App   (step2: for OTP)
	 * @apiParam {String} client_ip Mandatory ip of client
	 * @apiParam {String} service_id Mandatory id service mapping with server billing
	 * @apiParam {String} manufacture Mandatory 
	 * @apiParam {String} model_name Mandatory 
	 * @apiParam {String} operating_system Mandatory 
	 * @apiParam {String} operating_system_version Mandatory 
	 * @apiParam {String} device_type Mandatory 	 1: web; 2: wap; 3: ios; 4: android; 5: winphone
	 * @apiParam {String} device_token Mandatory 
	 * @apiParam {String} campaign Mandatory 
	 * @apiParam {String} source Mandatory 
	 * @apiParam {String} medium Mandatory 
	 * @apiParam {String} hit_type Mandatory  (default = event)
	 * @apiParam {String} gatracking_id Mandatory 
	 * @apiParam {String} gaclient_id Mandatory 
	 * @apiParam {String} event_category Mandatory 
	 * @apiParam {String} event_action Mandatory 
	 * @apiParam {String} event_label Mandatory 
	 * @apiParam {String} os_type Mandatory  // 1:iOS;   2:Android
	 * 
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    "accountId": "117815097",
     *					"accessToken": "",
     *					"billingAccessToken": "",
     *					"userName": "phongtest1807",
     *					"email": null,
     *					"userStatus": 1,
     *					"mobile": null,
     *					"avatarUrl":"",
     *					"gameVersion": "1"
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	public void loginVTC(){}
	
	/**
	 * @api {POST} /login?{param} Register Social account
	 * @apiName RegisterSocialAccount
	 * @apiGroup User
	 * 
	 * @apiParam {String} client_id	Mandatory ip client mapping with server
	 * @apiParam {String} client_secret	Mandatory
	 * @apiParam {String} grant_type Mandatory default = password	
	 * @apiParam {String} authen_social Mandatory 0:thường;  1:Social	(for social default = 1)
	 * @apiParam {String} secure_code Mandatory  (step2: for OTP account)
	 * @apiParam {String} secure_type Mandatory // 1: OTP SMS; 2: OTP App   (step2: for OTP)
	 * @apiParam {String} client_ip Mandatory ip of client
	 * @apiParam {String} service_id Mandatory id service mapping with server billing
	 * @apiParam {String} manufacture Mandatory 
	 * @apiParam {String} model_name Mandatory 
	 * @apiParam {String} operating_system Mandatory 
	 * @apiParam {String} operating_system_version Mandatory 
	 * @apiParam {String} device_type Mandatory 	 1: web; 2: wap; 3: ios; 4: android; 5: winphone
	 * @apiParam {String} device_token Mandatory 
	 * @apiParam {String} campaign Mandatory 
	 * @apiParam {String} source Mandatory 
	 * @apiParam {String} medium Mandatory 
	 * @apiParam {String} hit_type Mandatory  (default = event)
	 * @apiParam {String} gatracking_id Mandatory 
	 * @apiParam {String} gaclient_id Mandatory 
	 * @apiParam {String} event_category Mandatory 
	 * @apiParam {String} event_action Mandatory 
	 * @apiParam {String} event_label Mandatory 
	 * @apiParam {String} auto_authen Mandatory // 0:khong tu dong dang nhap  1:tự động đăng nhập luôn ngay sau khi tạo
	 * @apiParam {String} username Mandatory
	 * @apiParam {String} access_token Mandatory
	 * @apiParam {String} os_type Mandatory  // 1:iOS;   2:Android
	 * 
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				   
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	public void registerSocial(){}
	
	/**
	 * @api {POST} /login?{param} Login by Social account
	 * @apiName LoginBySocialAccount
	 * @apiGroup User
	 * 
	 * @apiParam {String} client_id	Mandatory ip client mapping with server
	 * @apiParam {String} client_secret	Mandatory
	 * @apiParam {String} grant_type Mandatory default = password	
	 * @apiParam {String} authen_social Mandatory 0:thường;  1:Social	(for social = 1)
	 * @apiParam {String} secure_code Mandatory  (step2: for OTP account)
	 * @apiParam {String} secure_type Mandatory // 1: OTP SMS; 2: OTP App   (step2: for OTP)
	 * @apiParam {String} client_ip Mandatory ip of client
	 * @apiParam {String} service_id Mandatory id service mapping with server billing
	 * @apiParam {String} manufacture Mandatory 
	 * @apiParam {String} model_name Mandatory 
	 * @apiParam {String} operating_system Mandatory 
	 * @apiParam {String} operating_system_version Mandatory 
	 * @apiParam {String} device_type Mandatory 	 1: web; 2: wap; 3: ios; 4: android; 5: winphone
	 * @apiParam {String} device_token Mandatory 
	 * @apiParam {String} campaign Mandatory 
	 * @apiParam {String} source Mandatory 
	 * @apiParam {String} medium Mandatory 
	 * @apiParam {String} hit_type Mandatory  (default = event)
	 * @apiParam {String} gatracking_id Mandatory 
	 * @apiParam {String} gaclient_id Mandatory 
	 * @apiParam {String} event_category Mandatory 
	 * @apiParam {String} event_action Mandatory 
	 * @apiParam {String} event_label Mandatory 
	 * @apiParam {String} access_token Mandatory
	 * @apiParam {String} os_type Mandatory  // 1:iOS;   2:Android
	 * 
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    "accountId": "117815097",
     *					"accessToken": "",
     *					"billingAccessToken": "",
     *					"userName": "phongtest1807",
     *					"email": null,
     *					"userStatus": 1,
     *					"mobile": null,
     *					"avatarUrl":"",
     *					"gameVersion": "1"
	 *			  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	public void loginSocial(){}
}
