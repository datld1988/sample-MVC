package com.vtc.business.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.axis.types.UnsignedByte;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vtc.business.CommonUtils;
import com.vtc.business.ModelUtils;
import com.vtc.dataconstant.DataConstants;
import com.vtc.model.TrackingModel;
import com.vtc.mongocore.Accounts;
import com.vtc.mongocore.AppActivityMetadata;
import com.vtc.mongocore.DeductVcoinMetadata;
import com.vtc.mongocore.Events;
import com.vtc.mongocore.GaMetadata;
import com.vtc.mongocore.Game;
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
import com.vtc.mongorepository.GameRepository;
import com.vtc.request.AccountInfoRequest;
import com.vtc.request.AccountRegisterRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.request.GamePaymentRequest;
import com.vtc.request.Request;
import com.vtc.util.DateUtil;
import com.vtc.ws.v2.model.update.AccountInfoRequestData;

@Service
public class ModelUtilsImpl implements ModelUtils {

	@Autowired
	CommonUtils commonUtils;
	
	@Autowired
	GameRepository gameRepository;
	/**
	 * Create new tracking id object
	 * 
	 * @param gaTrackingId
	 * @param gaClientId
	 * @param category
	 * @param action
	 * @param label
	 * @param value
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
//	@Override
	public Tracking createTrackingObj(TrackingModel data, String clientId) throws JsonParseException, JsonMappingException, IOException{
		Timestamp timeNow = new Timestamp(System.currentTimeMillis());

		GaMetadata metadata = new GaMetadata();
		if(data.getCampaignName() != null){
			metadata.setCampaignName(data.getCampaignName());
		}
		if(data.getCampaignSource() != null){
			metadata.setCampaignSource(data.getCampaignSource());
		}
		if(data.getCampaignMedium() != null){
			metadata.setCampaignMedium(data.getCampaignMedium());
		}
		if(data.getCategory() != null){
			metadata.setEventCategory(data.getCategory());
		}
		if(data.getAction() != null){
			metadata.setEventAction(data.getAction());
		}
		if(data.getLabel() != null){
			metadata.setEventLabel(data.getLabel());
		}
		if(data.getValue() != null){
			metadata.setEventValue(data.getValue());
		}
		if(data.getTransactionId() != null){
			metadata.setTransactionId(data.getTransactionId());
		}
		if(data.getTransactionRevenue() != null){
			metadata.setTransactionRevenue(data.getTransactionRevenue());
		}

		String gaTrackingId = ""; 
		List<Game> games = gameRepository.findAllByClientId(clientId);
		if (!CollectionUtils.isEmpty(games)) {
			Game game = games.stream().findFirst().get();
			gaTrackingId = game == null ? "" : game.getGaTrackingId();
		}

		data.setGaTrackingId(gaTrackingId);
		
		Tracking tracking = new Tracking();
		tracking.setId(new ObjectId());
		tracking.setTrackingId(data.getGaTrackingId());
		tracking.setClientId(data.getGaClientId());
		tracking.setHitType(data.getHitType());
		tracking.setMetadata(metadata);
		tracking.setCreatedTime(timeNow);
		tracking.setUpdatedTime(timeNow);

		return tracking;
	}

//	@Override
	public <T> Events<T> createEvent(String type, Request data, T metadata) {
		Timestamp timeNow = new Timestamp(System.currentTimeMillis());
		
		Events<T> event = new Events<>();
		event.setType(type);
		event.setClientId(data.getClientId());
		event.setDeviceToken(data.getDeviceToken());
		event.setDeviceType(data.getDeviceType());
		event.setManufacture(data.getManufacture());
		event.setModelName(data.getModelName());
		event.setOperatingSystem(data.getOperatingSystem());
		event.setOperatingSystemVersion(data.getOperatingSystemVersion());
		event.setUtm(data.getUtm());
		event.setCampaign(data.getCampaign());
		event.setMedium(data.getMedium());
		event.setSource(data.getSource());
		event.setAgency(data.getAgency());
		event.setAccountId(data.getAccountId());
		event.setAccountName(data.getAccountName());
		event.setEmail(data.getEmail());
		event.setAdsId(data.getAdsId());
		event.setMetadata(metadata);
		event.setVersion(1);
		event.setCreatedTime(timeNow);
		event.setUpdatedTime(timeNow);
		
		return event;
	}

//	@Override
	public LoginData createLoginData(AuthenticationRequest data) {
		LoginData loginData = new LoginData();
		loginData.setServiceId(data.getServiceId());
		loginData.setServiceKey(data.getServiceKey());
		loginData.setAccountName(data.getAccountName());
		loginData.setSecureCode(data.getSecureCode());
		loginData.setSecureType(data.getSecureType());
		loginData.setDeviceType(data.getDeviceType());
		loginData.setClientIP(data.getClientIp());
		loginData.setAuthenType(data.getAuthenType());
		loginData.setAuthenSocial(data.getAuthenSocial());
		loginData.setoAuthSystemId(data.getoAuthSystemId());
		loginData.setoAuthAccount(data.getoAuthAccount());
		loginData.setFbEmail(data.getFbEmail());
		loginData.setFbBussinessIds(data.getFbBussinessIds());
		loginData.setIsAutoCreate(data.getIsAutoCreate());
		loginData.setIsDisableCheckSecure(data.getIsDisableCheckSecure());
		loginData.setSignDisableSecure(data.getSignDisableSecure());
		
		return loginData;
	}

//	@Override
	public RegisterData createRegisterData(AccountRegisterRequest data) {
		RegisterData registerData = new RegisterData();
		registerData.setAccountName(data.getAccountName());
		registerData.setClientIp(data.getClientIp());
		registerData.setDeviceType(data.getDeviceType());
		registerData.setEmail(data.getEmail());
		registerData.setMobile(data.getMobile());
		registerData.setRegisterType(data.getRegisterType());
		registerData.setServiceId(data.getServiceId());
		
		registerData.setFbBussinessIds(data.getFbBussinessIds());
		registerData.setFbEmail(data.getFbEmail());
		registerData.setIsAutoAuthen(data.getIsAutoAuthen());
		registerData.setIsDisableCheckSecure(data.getIsDisableCheckSecure());
		registerData.setoAuthAccount(data.getoAuthAccount());
		registerData.setoAuthSystemId(data.getoAuthSystemId());
		registerData.setSignDisableSecure(data.getSignDisableSecure());
		
		return registerData;
	}

	@Override
	public Accounts createAccount(String accountType, Integer accountId, String accountName, 
			String passwordPlainText, String passwordMd5, String accessToken, String billingAccessToken, String firstName, String lastName, String email, String avatar, 
			String fullName, Date birthday, Integer locationId, String userStatus, String userPassport, 
			Integer gender, String mobile, String address, BigDecimal vcoinGame, BigDecimal vcoinPayment, 
			String paygateId, Integer version) {
		Timestamp timeNow = new Timestamp(System.currentTimeMillis());
	    
		Accounts account = new Accounts();
		account.setId(new ObjectId());
		account.setAccountType(accountType);
		account.setAccountId(accountId);
		account.setAccountName(accountName);
		account.setPasswordPlainText(passwordPlainText);
		account.setAccessToken(accessToken);
		account.setBillingAccessToken(billingAccessToken);
		account.setPasswordMd5(passwordMd5);
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setFullName(fullName == null || fullName.isEmpty() ? new StringBuffer(firstName).append(" ").append(lastName).toString() : fullName);
		account.setBirthday(birthday);
		account.setLocationId(locationId);
		account.setUserStatus(userStatus);
		account.setUserPassport(userPassport);
		account.setGender(gender);
		account.setEmail(email);
		account.setMobile(mobile);
		account.setAddress(address);
		account.setVcoinGame(vcoinGame);
		account.setVcoinPayment(vcoinPayment);
		account.setPaygateId(paygateId);
		account.setAvatar(avatar);
		account.setVersion(version);
		account.setCreatedTime(timeNow);
		account.setUpdatedTime(timeNow);
		
		return account;
	}

	@Override
	public TopupBankMetadata createTopupBankMetadata(String name, String accountName, String bankCode, Integer CPId,
			String clientIp, Long clientTime, Integer createdUserId, String createdUserName, Integer deductServiceId,
			String deductServiceKey, String description, Integer deviceType, String notifyUrl, String orderCode,
			Integer productId, String returnUrl, Integer vcoin) {
		TopupBankMetadata data = new TopupBankMetadata()
											.setAccountName(accountName)
											.setBankCode(bankCode)
											.setClientIp(clientIp)
											.setClientTime(clientTime)
											.setCPId(CPId)
											.setCreatedUserId(createdUserId)
											.setCreatedUserName(createdUserName)
											.setDeductServiceId(deductServiceId)
											.setDeductServiceKey(deductServiceKey)
											.setDescription(description)
											.setDeviceType(deviceType)
											.setName(name)
											.setNotifyUrl(notifyUrl)
											.setOrderCode(orderCode)
											.setProductId(productId)
											.setReturnUrl(returnUrl)
											.setVcoin(vcoin);
		
		return data;
	}

	@Override
	public TopupCardMetadata createTopupCardMetadata(String name, String accountName, Integer cpId, String cardCode,
			String cardSeri, Integer cardType, String clientIp, Long clientTime, Integer createdUserId,
			String createdUserName, Integer deviceType, Long relatedTransactionId, Integer serviceId,
			String serviceKey) {
		TopupCardMetadata data = new TopupCardMetadata()
											.setAccountName(accountName)
											.setCardCode(cardCode)
											.setCardSeri(cardSeri)
											.setCardType(cardType)
											.setClientIp(clientIp)
											.setClientTime(clientTime)
											.setCpId(cpId)
											.setCreatedUserId(createdUserId)
											.setCreatedUserName(createdUserName)
											.setDeviceType(deviceType)
											.setName(name)
											.setRelatedTransactionId(relatedTransactionId)
											.setServiceId(serviceId)
											.setServiceKey(serviceKey);
		return data;
	}

	@Override
	public TopupVtcPayMetadata createTopupVtcPayMetadata(String name, String accountName, String bankCode, Integer cpId,
			String clientIp, Long clientTime, Integer createdUserId, String createdUserName, Integer deductServiceId,
			String deductServiceKey, String description, Integer deviceType, String notifyUrl, String orderCode,
			Integer productId, String returnUrl, String vtcPayAccount, Integer vcoin) {
		TopupVtcPayMetadata data = new TopupVtcPayMetadata()
											.setAccountName(accountName)
											.setBankCode(bankCode)
											.setClientIp(clientIp)
											.setClientTime(clientTime)
											.setCpId(cpId)
											.setCreatedUserId(createdUserId)
											.setCreatedUserName(createdUserName)
											.setDeductServiceId(deductServiceId)
											.setDeductServiceKey(deductServiceKey)
											.setDescription(description)
											.setDeviceType(deviceType)
											.setName(name)
											.setNotifyUrl(notifyUrl)
											.setOrderCode(orderCode)
											.setProductId(productId)
											.setReturnUrl(returnUrl)
											.setVcoin(vcoin)
											.setVtcPayAccount(vtcPayAccount);
				
		return data;
	}

	@Override
	public ReAuthenticationMetadata createReAuthenMetadata(Integer serviceId, String serviceKey, Integer serviceId_Old,
			String accessToken, String accountName, Integer deviceType, String clientIp, Integer authenType) {
		ReAuthenticationMetadata data = new ReAuthenticationMetadata()
													.setAccessToken(accessToken)
													.setAccountName(accountName)
													.setAuthenType(authenType)
													.setClientIp(clientIp)
													.setDeviceType(deviceType)
													.setServiceId(serviceId)
													.setServiceId_Old(serviceId_Old)
													.setServiceKey(serviceKey);
		return data;
	}

	@Override
	public TopupIAPMetadata createTopupIAPMetadata(String sign, String accountName, Integer cpId, String clientIp,
			Integer createdUserID, String createdUserName, String description, String packetId, Long purchaseDate,
			Integer quantity, String receiptBase, String receiptBaseMd5, String receiptData,
			String relatedTransactionId, Integer serviceId, String serviceKey, String uuid, Integer deductServiceId,
			String deductServiceKey) {
		TopupIAPMetadata metadata = new TopupIAPMetadata()
				.setAccountName(accountName)
				.setClientIp(clientIp)
				.setCpId(cpId)
				.setCreatedUserID(createdUserID)
				.setCreatedUserName(createdUserName)
				.setDeductServiceId(deductServiceId)
				.setDeductServiceKey(deductServiceKey)
				.setDescription(description)
				.setPacketId(packetId)
				.setPurchaseDate(purchaseDate)
				.setQuantity(quantity)
				.setReceiptBase(receiptBaseMd5)
				.setReceiptBaseMd5(receiptBaseMd5)
				.setReceiptData(receiptData)
				.setRelatedTransactionId(relatedTransactionId)
				.setServiceId(serviceId)
				.setServiceKey(serviceKey)
				.setSign(sign)
				.setUuid(uuid);
		
		return metadata;
	}

	@Override
	public DeductVcoinMetadata createDeductVcoinMetadata(Integer serviceId, String serviceKey, Integer createdUserId,
			String createdUserName, Integer accountId, String accountName, Long relatedTransactionId, Integer deviceType,
			String clientIp, Long clientTime, Integer cpId, Integer vcoin, String description, String sign,
			Integer relatedAccountId) {
		DeductVcoinMetadata metadata = new DeductVcoinMetadata()
				.setAccountId(accountId)
				.setAccountName(accountName)
				.setClientIp(clientIp)
				.setClientTime(clientTime)
				.setCpId(cpId)
				.setCreatedUserId(createdUserId)
				.setCreatedUserName(createdUserName)
				.setDescription(description)
				.setRelatedAccountId(relatedAccountId)
				.setRelatedTransactionId(relatedTransactionId)
				.setServiceId(serviceId)
				.setServiceKey(serviceKey)
				.setSign(sign)
				.setVcoin(vcoin)
				.setDeviceType(deviceType);
				
		return metadata;
	}

	public CommonUtils getCommonUtils() {
		return commonUtils;
	}

	public void setCommonUtils(CommonUtils commonUtils) {
		this.commonUtils = commonUtils;
	}

	@Override
	public AppActivityMetadata createActivityMetadata(String trackingId, GaMetadata gaMetadata) {
		AppActivityMetadata metadata = new AppActivityMetadata()
				.setTrackingId(trackingId);
		if(gaMetadata != null){
			metadata.setCampaignName(gaMetadata.getCampaignName())
					.setCampaignSource(gaMetadata.getCampaignSource())
					.setCampaignMedium(gaMetadata.getCampaignMedium())
					.setEventAction(gaMetadata.getEventAction())
					.setEventCategory(gaMetadata.getEventCategory())
					.setEventLabel(gaMetadata.getEventLabel())
					.setEventValue(gaMetadata.getEventValue())
					.setTransactionId(gaMetadata.getTransactionId())
					.setTransactionRevenue(gaMetadata.getTransactionRevenue());
		}
				
		return metadata;
	}

	@Override
	public GamePaymentMetadata createGamePaymentMetadata(GamePaymentRequest data) {
		if(data == null){
			return new GamePaymentMetadata();
		}
		
		GamePaymentMetadata metaData = new GamePaymentMetadata()
				.setAccountName(data.getAccountName())
				.setAccountId(data.getAccountId())
				.setToAccountName(data.getToAccountName())
				.setPartnerCode(data.getPartnerCode())
				.setAmount(data.getAmount())
				.setPartnerAmount(data.getPartnerAmount())
				.setServerGame(data.getServerGame())
				.setFromIp(data.getFromIp())
				.setGameCode(data.getGameCode())
				.setPaymentType(data.getPaymentType())
				.setAccessToken(data.getBillingAccessToken())
				.setFunctionName(data.getFunctionName())
				.setPaymentFrom(data.getPaymentFrom())
				.setCardCode(data.getCardCode())
				.setCardSerial(data.getCardSerial())
				.setBankCode(data.getBankCode())
				.setVtcPayAccount(data.getVtcPayAccount())
				.setDescription(data.getDescription())
				.setUuid(data.getUuid())
				.setReceiptBase(data.getReceiptBase())
				.setReceiptData(data.getReceiptData())
				.setQuantity(data.getQuantity())
				.setProductId(data.getProductId())
				.setRelatedTransactionId(data.getRelatedTransactionId())
				.setPurchaseDate(data.getPurchaseDate())
				.setReceiptBaseMd5(data.getReceiptBaseMd5())
				.setOrderNo(data.getOrderNo());
		
		return metaData;
	}

	@Override
	public AccountInfoRequestData createAccountInfoMetadata(AccountInfoRequest data) {
		AccountInfoRequestData requestData = new AccountInfoRequestData();
		requestData.setAccountName(data.getAccountName());
		requestData.setAddress(data.getAddress());
		requestData.setAnswer(data.getAnswer());
		requestData.setBirthday(DateUtil.toCalendar(data.getBirthday(), DateUtil.PATTERN_YYYYMMDD_HYPHEN));
		requestData.setClientIP(data.getClientIp());
		requestData.setDistrictID(data.getDistrictId());
		requestData.setEmail(data.getEmail());
		requestData.setFullName(data.getFullName());
		requestData.setGender(new UnsignedByte(data.getGender()));
		requestData.setLocationID(data.getLocationId());
		requestData.setMobile(data.getMobile());
		requestData.setPassport(data.getPassport());
		requestData.setQuestionID(data.getQuestionId());
		requestData.setSecureCode(data.getSecureCode());
		requestData.setWardID(data.getWardId());
		if(!StringUtils.isEmpty(data.getSign())){
			requestData.setSign(data.getSign());
		}
		
		return requestData;
	}

	@Override
	public Monitor createMonitorData(GamePaymentRequest request, PackagesData packageData, String error) {
		Monitor monitor = new Monitor();
		
		monitor.setPackageIdSdk(request.getPackageId());
		monitor.setPackageIdBilling("unknown");
		monitor.setServerGame(request.getServerGame());
		monitor.setGameCode(request.getGameCode());
		monitor.setFromIp(request.getFromIp());
		monitor.setVcoin(packageData.getPriceVcoin());
		monitor.setPromotionalPercent(packageData.getPromotionalPercent());
		monitor.setScale(packageData.getMoneyScale());
		monitor.setPriceVnd(packageData.getPriceVnd());
		monitor.setPriceGold(packageData.getPriceGold());
		monitor.setPromotionGold(packageData.getPriceGold()*packageData.getPromotionalPercent()/100);
		monitor.setTotalGold(packageData.getPriceGold() + monitor.getPromotionGold());
		monitor.setAmount(request.getAmount());
		monitor.setPartnerAmount(request.getPartnerAmount());
		monitor.setPackageType(Arrays.asList(DataConstants.PackageType.values()).stream().filter(item -> item.getValue().compareTo(packageData.getPackageType()) == 0).findAny().get().getDisplay());
		monitor.setPaymentType(request.getPaymentType());
		monitor.setExtend(new StringBuffer().append(commonUtils.toJsonString(request)).append(" --------- ").append(commonUtils.toJsonString(packageData)).toString());
		monitor.setDescription(error);
		monitor.setCreatedDate(new Date());
		
		return monitor;
	}
}
