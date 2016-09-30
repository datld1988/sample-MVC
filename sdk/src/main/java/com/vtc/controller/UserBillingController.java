package com.vtc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.model.authen.OAuthCreateResponseData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;
import com.vtc.ws.v2.model.register.RegisterResponseData;
import com.vtc.ws.v2.service.BillingService;

@Controller
public class UserBillingController extends CommonController {
//	private static final Logger log = Logger.getLogger(UserBillingController.class);
//
//	@Autowired
//	private BillingService billingService;
//
//	@RequestMapping(value = "/user/check", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseData checkVTCAccount(
//			@RequestParam(value="name", required=true, defaultValue="") String name,
//			@RequestParam(value="clientIp", required=true, defaultValue="") String clientIp) {
//		log.info(new StringBuffer("[START] checkVTCAccount name = ").append(name).append(", clientIp").append(clientIp).toString());
//		long t1 = System.currentTimeMillis();
//		try {
//			ResponseData responseData = billingService.checkAccount(name);
//			long t2 = System.currentTimeMillis();
//			log.info("[END] checkVTCAccount TIME = " + (t2 - t1));
//			return responseData;
//		} catch (Exception e) {
//			log.error("ERROR", e);
//			return null;
//		}
//	}
//
//	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
//	@ResponseBody
//	public RegisterResponseData register(
//			@RequestParam(value="accountName", required=true, defaultValue="") String accountName,
//			@RequestParam(value="clientIp", required=true, defaultValue="") String clientIp,
//			@RequestParam(value="deviceType", required=true, defaultValue="") Integer deviceType,
//			@RequestParam(value="password", required=true, defaultValue="") String password,
//			@RequestParam(value="email", required=true, defaultValue="") String email,
//			@RequestParam(value="mobile", required=true, defaultValue="") String mobile,
//			@RequestParam(value="registerType", required=true, defaultValue="") Integer registerType
//			) {
//		log.info(new StringBuffer("[START] checkVTCAccount accountName = ").append(accountName)
//				.append(", clientIp").append(clientIp)
//				.append(", deviceType").append(deviceType)
//				.append(", password").append(password)
//				.append(",email").append(email)
//				.append(",mobile").append(mobile)
//				.append(",registerType").append(registerType).toString());
//		long t1 = System.currentTimeMillis();
//		try {
//			RegisterResponseData response = billingService.register(accountName, password, clientIp, deviceType, registerType, email, mobile);
//			long t2 = System.currentTimeMillis();
//			log.info("[END] checkVTCAccount TIME = " + (t2 - t1));
//			return response;
//		} catch (Exception e) {
//			log.error("ERROR", e);
//			return null;
//		}
//	}
//
//	@RequestMapping(value = "/register/social", method = RequestMethod.POST)
//	@ResponseBody
//	public OAuthCreateResponseData registerBySocial(
//			@RequestParam(value="accountName", required=true, defaultValue="") String accountName,
//			@RequestParam(value="clientIp", required=true, defaultValue="") String clientIp,
//			@RequestParam(value="deviceType", required=true, defaultValue="") Integer deviceType,
//			@RequestParam(value="fbBussinessIds", required=true, defaultValue="") String fbBussinessIds,
//			@RequestParam(value="fbEmail,", required=true, defaultValue="") String fbEmail,
//			@RequestParam(value="isAutoAuthen", required=true, defaultValue="") Integer isAutoAuthen,
//			@RequestParam(value="isDisableCheckSecure", required=true, defaultValue="") Integer isDisableCheckSecure,
//			@RequestParam(value="oAuthAccount", required=true, defaultValue="") String oAuthAccount,
//			@RequestParam(value="oAuthSystemId", required=true, defaultValue="") Integer oAuthSystemId,
//			@RequestParam(value="serviceId", required=true, defaultValue="") Integer serviceId,
//			@RequestParam(value="serviceKey,", required=true, defaultValue="") String serviceKey,
//			@RequestParam(value="signDisableSecure", required=true, defaultValue="") String signDisableSecure
//			) {
//		log.info(new StringBuffer("[START] loginBySocial fbBussinessIds = ").append(fbBussinessIds).append(", clientIp").append(clientIp).toString());
//		long t1 = System.currentTimeMillis();
//		try {
//			
//			Boolean isAutoAuthenB = Boolean.FALSE;
//			if (isAutoAuthen != null) {
//				if (isAutoAuthen == 1) {
//					isAutoAuthenB = Boolean.TRUE;
//				}
//			}
//			Boolean isDisableCheckSecureB = Boolean.FALSE;
//			if (isDisableCheckSecure != null) {
//				if (isDisableCheckSecure == 1) {
//					isDisableCheckSecureB = Boolean.TRUE;
//				}
//			}
//			OAuthCreateResponseData responseData = billingService.createBySocial(accountName, clientIp, deviceType, fbBussinessIds, fbEmail, isAutoAuthenB, isDisableCheckSecureB, oAuthAccount, oAuthSystemId, serviceId, serviceKey, signDisableSecure);
//			long t2 = System.currentTimeMillis();
//			log.info("[END] loginBySocial TIME = " + (t2 - t1));
//			return responseData;
//		} catch (Exception e) {
//			log.error("ERROR", e);
//			return null;
//		}
//	}
//	
//	public BillingService getBillingService() {
//		return billingService;
//	}
//
//	public void setBillingService(BillingService billingService) {
//		this.billingService = billingService;
//	}

}
