package com.vtc.business.impl;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.CollectionUtils;

import com.vtc.aspect.Loggable;
import com.vtc.business.CommonUtils;
import com.vtc.business.ServiceUtils;
import com.vtc.config.ISysConfig;
import com.vtc.config.RedisTokenStore;
import com.vtc.dataconstant.DataConstants;
import com.vtc.model.AppleReceiptInApp;
import com.vtc.model.AppleReceiptResponse;
import com.vtc.model.GoogleVerifyResponse;
import com.vtc.mongocore.Accounts;
import com.vtc.mongocore.PackagesData;
import com.vtc.mongorepository.AccountRepository;
import com.vtc.request.GamePaymentRequest;
import com.vtc.request.Request;
import com.vtc.util.MathUtil;
import com.vtc.ws.v2.model.ResponseData;
import com.vtc.ws.v2.service.BillingService;


public class ServiceUtilsImpl implements ServiceUtils{
	private static Logger log = Logger.getLogger(ServiceUtilsImpl.class);
	
	@Autowired
	private RedisTokenStore tokenStore;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ISysConfig sysConfig;

	@Loggable
	@Override
	public boolean validateToken(String accountName, String tokenKey) {
		if (accountName == null) {
			log.error("user_name is null");
			return false;
		}
		if (tokenKey == null) {
			log.error("token_key is null");
			return false;
		}
		Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByUserName(accountName);

		if (tokens == null || tokens.size() == 0) {
			log.error("Not exist token.");
			return false;
		}

		boolean valid = false;
		for (OAuth2AccessToken token : tokens) {
			if (token.getValue().equals(tokenKey)) {
				valid = true;
			}
		}
		return valid;
	}
	
	public RedisTokenStore getTokenStore() {
		return tokenStore;
	}

	@Loggable
	@Override
	public Request modifyRequest(Request request) {
		if(request == null || StringUtils.isEmpty(request.getUtm())){
			return request;
		}
		HashMap<String, String> mapping = commonUtils.utmLinkToMap(request.getUtm());
		if(request.getCampaign() == null || request.getCampaign().isEmpty()){
			request.setCampaign(mapping.get(DataConstants.UtmParams.Utm_Campaign));
		}
		request.getTrackingModel().setCampaignName(request.getCampaign());
		
		if(request.getSource() == null || request.getSource().isEmpty()){
			request.setSource(mapping.get(DataConstants.UtmParams.Utm_Source));
		}
		request.getTrackingModel().setCampaignSource(request.getSource());
		
		if(request.getMedium() == null || request.getMedium().isEmpty()){
			request.setMedium(mapping.get(DataConstants.UtmParams.Utm_Medium));
		}
		request.getTrackingModel().setCampaignMedium(request.getMedium());
		
		return request;
	}

	public CommonUtils getCommonUtils() {
		return commonUtils;
	}

	public void setCommonUtils(CommonUtils commonUtils) {
		this.commonUtils = commonUtils;
	}

	@Override
	public ResponseData checkBillingAccessToken(Integer serviceId, String accountName, String billingAccessToken) throws RemoteException, ServiceException {
		return billingService.checkBillingAccessToken(serviceId, accountName, billingAccessToken);
	}

	@Loggable
	@Override
	public String getBillingAccessToken(Integer accountId, String accountName) throws RemoteException, ServiceException {
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(accountId, accountName);
		
		if(CollectionUtils.isEmpty(accounts)){
			log.error("[ERROR] Account not found");
			return "";
		}
		String billingAccessToken = accounts.stream().findFirst().get().getBillingAccessToken();
		if(StringUtils.isEmpty(billingAccessToken)){
			log.error("[ERROR] Billing Access Token not found in DB");
			return "";
		}
		ResponseData checkBillingData = billingService.checkBillingAccessToken(MathUtil.parseInt(sysConfig.getBillingServiceId()), accountName, billingAccessToken);
		if(checkBillingData == null || checkBillingData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
			return "";
		}
		
		return billingAccessToken;
//		StringBuffer sb = new StringBuffer(accountName).append(billingAccessToken).append("880717").append(keySign).append(sysConfig.getBillingServiceKey()).append(sysConfig.getBillingServiceId());
//		reauthenData = billingService.reauthen(billingAccessToken, accountName, fromIp,
//				deviceType, authenType, MathUtil.parseInt("880717"), sysConfig.getBillingServiceKey(),
//				MathUtil.parseInt(sysConfig.getBillingServiceId()), commonUtils.hashMD5(sb.toString()));
//		if(StringUtils.isEmpty(billingAccessToken)){
//			reauthenData = billingService.reauthen(billingAccessToken, accountName, fromIp,
//					deviceType, authenType, MathUtil.parseInt("880717"), sysConfig.getBillingServiceKey(),
//					MathUtil.parseInt(sysConfig.getBillingServiceId()), commonUtils.hashMD5(sb.toString()));
//			if(reauthenData == null || reauthenData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
//				log.error(new StringBuffer().append("[ERROR] reauthen Failed!!!").append(" Code:").append(reauthenData.getResponseCode()).append(" , Description:").append(reauthenData.getDescription()));
//				return "";
//			}
//			
//			return reauthenData.getAccessToken();
//		} else{
//			ResponseData checkBillingData = billingService.checkBillingAccessToken(MathUtil.parseInt(sysConfig.getBillingServiceId()), accountName, billingAccessToken);
//			if(checkBillingData == null || checkBillingData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
//				reauthenData = billingService.reauthen(billingAccessToken, accountName, fromIp,
//						deviceType, authenType, MathUtil.parseInt("880717"), sysConfig.getBillingServiceKey(),
//						MathUtil.parseInt(sysConfig.getBillingServiceId()), commonUtils.hashMD5(sb.toString()));
//				if(reauthenData == null || reauthenData.getResponseCode().compareTo(DataConstants.Zero) <= 0){
//					log.error(new StringBuffer().append("[ERROR] reauthen Failed!!!").append(" Code:").append(reauthenData.getResponseCode()).append(" , Description:").append(reauthenData.getDescription()));
//					return "";
//				}
//			}
//			return billingAccessToken;
//		}
	}

	@Loggable
	@Override
	public GamePaymentRequest checkVerifyIAP(GamePaymentRequest request, PackagesData packageData) {
		GamePaymentRequest verifyResponse = new GamePaymentRequest();
		if (request.getTypeIAP().compareTo(DataConstants.TypeInAppPurchase.Apple) == 0) {
			AppleReceiptResponse appleReceiptResponse = commonUtils.verifyPayment_Apple(request.getReceiptData());
			if(appleReceiptResponse == null || appleReceiptResponse.getReceipt() == null
					|| CollectionUtils.isEmpty(appleReceiptResponse.getReceipt().getInApp())
					|| appleReceiptResponse.getStatus().compareTo(DataConstants.Zero) != 0){
				log.error(new StringBuffer("[ERROR] Verify IAP Apple is failed."));
				return null;
			}
			
			AppleReceiptInApp data = appleReceiptResponse.getReceipt().getInApp().stream().findFirst().get();
			
			// TODO: Check mapping server and response verify from APPLE
			if(!data.getProductId().equals(packageData.getMappingKeyApple())){
				log.error(new StringBuffer("[ERROR] Mapping productId is failed.")
						.append(" ProductId-Apple:").append(data.getProductId())
						.append(" , ProductId-DB:").append(packageData.getMappingKeyApple()));
				
				return null;
			}
			
			verifyResponse.setProductId(data.getProductId());
			verifyResponse.setRelatedTransactionId(data.getTransactionId());
			verifyResponse.setPurchaseDate(data.getPurchaseDateMs());
			
		} else if (request.getTypeIAP().compareTo(DataConstants.TypeInAppPurchase.Google) == 0){
			GoogleVerifyResponse googleVerifyResponse = commonUtils.verifyPayment_Google(request.getPackageName(), request.getProductId(), request.getReceiptData());
			if(googleVerifyResponse == null 
					|| googleVerifyResponse.getPurchaseState().compareTo(DataConstants.GooglePurchaseState.Purchased) != 0
					|| googleVerifyResponse.getConsumptionState().compareTo(DataConstants.GoogleConsumptionState.Consumed) != 0
					|| !googleVerifyResponse.getPurchaseTime().equals(request.getPurchaseDate())){
				log.error(new StringBuffer("[ERROR] Verify IAP GOOGLE is failed."));
				
				return null;
			}
			
			// TODO: Check Mapping server and response verify from Google
			if(!request.getProductId().equals(packageData.getMappingKeyGoogle())){
				log.error(new StringBuffer("[ERROR] Mapping productId is failed.")
						.append(" ProductId-Google:").append(request.getProductId())
						.append(" , ProductId-DB:").append(packageData.getMappingKeyGoogle()));
				
				return null;
			}
			
			verifyResponse.setProductId(request.getProductId());
			verifyResponse.setRelatedTransactionId(request.getRelatedTransactionId());
			verifyResponse.setPurchaseDate(request.getPurchaseDate());
		}
		
		return verifyResponse;
	}

	@Override
	public Map<String, String> generateMapClientIdForGame(String gameCode) {
		Map<String, String> result = new HashMap<>();
		String data = new StringBuffer(gameCode).append(sysConfig.getGamePaymentSignPartnerCode()).append(sysConfig.getSdkKeySign()).toString();
		String key = commonUtils.hashMD5(data);
		String value = commonUtils.hashMD5(commonUtils.base64(data));
		result.put(key, value);
		
		return result;
	}
}
