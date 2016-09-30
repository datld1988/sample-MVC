package com.vtc.business;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vtc.model.TrackingModel;
import com.vtc.mongocore.Accounts;
import com.vtc.mongocore.AppActivityMetadata;
import com.vtc.mongocore.DeductVcoinMetadata;
import com.vtc.mongocore.Events;
import com.vtc.mongocore.GaMetadata;
import com.vtc.mongocore.GamePaymentMetadata;
import com.vtc.mongocore.LoginData;
import com.vtc.mongocore.Monitor;
import com.vtc.mongocore.PackagesData;
import com.vtc.mongocore.ReAuthenticationMetadata;
import com.vtc.mongocore.RegisterData;
import com.vtc.mongocore.TopupBankMetadata;
import com.vtc.mongocore.TopupCardMetadata;
import com.vtc.mongocore.TopupIAPMetadata;
import com.vtc.mongocore.TopupVtcPayMetadata;
import com.vtc.mongocore.Tracking;
import com.vtc.request.AccountInfoRequest;
import com.vtc.request.AccountRegisterRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.request.GamePaymentRequest;
import com.vtc.request.Request;
import com.vtc.ws.v2.model.update.AccountInfoRequestData;

public interface ModelUtils {
	Accounts createAccount(String accountType, Integer accountId, String accountName, String passwordPlainText, 
			String accessToken, String billingAccessToken, String passwordMd5, String firstName, String lastName, String email, String avatar, 
			String fullName, Date birthday, Integer locationId, String userStatus, String userPassport, 
			Integer gender, String mobile, String address, BigDecimal vcoinGame, BigDecimal vcoinPayment, 
			String paygateId, Integer version);
	Tracking createTrackingObj(TrackingModel data, String clientId)  throws JsonParseException, JsonMappingException, IOException ;

	LoginData createLoginData(AuthenticationRequest data);
	<T> Events<T> createEvent(String type, Request data, T metadata);
	
	RegisterData createRegisterData(AccountRegisterRequest data);
	
	AppActivityMetadata createActivityMetadata(String trackingId, GaMetadata gaMetadata);
	
	TopupBankMetadata createTopupBankMetadata(String name, String accountName, String bankCode, Integer CPId, 
			String clientIp, Long clientTime, Integer createdUserId, String createdUserName, 
			Integer deductServiceId, String deductServiceKey, String description, Integer deviceType,
			String notifyUrl, String orderCode, Integer productId, String returnUrl, Integer vcoin);
	
	TopupCardMetadata createTopupCardMetadata(String name, String accountName, Integer cpId, String cardCode,
			String cardSeri,Integer cardType, String clientIp, Long clientTime, Integer createdUserId, 
			String createdUserName, Integer deviceType, Long relatedTransactionId, Integer serviceId, String serviceKey);
	
	TopupVtcPayMetadata createTopupVtcPayMetadata(String name, String accountName, String bankCode, Integer cpId,
			String clientIp, Long clientTime, Integer createdUserId, String createdUserName, Integer deductServiceId,
			String deductServiceKey, String description, Integer deviceType, String notifyUrl, String orderCode,
			Integer productId, String returnUrl, String vtcPayAccount, Integer vcoin);
	
	TopupIAPMetadata createTopupIAPMetadata(String sign, String accountName, Integer cpId,String clientIp,
			Integer createdUserID, String createdUserName, String description, String packetId, Long purchaseDate,
			Integer quantity, String receiptBase, String receiptBaseMd5, String receiptData, String relatedTransactionId,
			Integer serviceId, String serviceKey, String uuid, Integer deductServiceId, String deductServiceKey);
	
	DeductVcoinMetadata createDeductVcoinMetadata(Integer serviceId, String serviceKey, Integer createdUserId, 
			String createdUserName, Integer accountId, String accountName, Long reatedTransactionid, Integer deviceType,
			String clientIp, Long clientTime, Integer cpId, Integer vcoin, String description, String sign, Integer relatedAccountId);
	
	ReAuthenticationMetadata createReAuthenMetadata(Integer serviceId, String serviceKey, Integer serviceId_Old,
			String accessToken, String accountName, Integer deviceType, String clientIp, Integer authenType);
	
	GamePaymentMetadata createGamePaymentMetadata(GamePaymentRequest data);
	
	AccountInfoRequestData createAccountInfoMetadata(AccountInfoRequest data);
	
	Monitor createMonitorData(GamePaymentRequest request, PackagesData packageData, String error);
}
