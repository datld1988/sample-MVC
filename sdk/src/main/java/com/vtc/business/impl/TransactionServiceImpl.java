package com.vtc.business.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vtc.business.CommonUtils;
import com.vtc.business.GameService;
import com.vtc.business.ModelUtils;
import com.vtc.business.ServiceUtils;
import com.vtc.business.TransactionService;
import com.vtc.config.ISysConfig;
import com.vtc.dataconstant.DataConstants;
import com.vtc.model.DescriptionData;
import com.vtc.mongocore.CreateOrderMetadata;
import com.vtc.mongocore.DeductVcoinMetadata;
import com.vtc.mongocore.Game;
import com.vtc.mongocore.Order;
import com.vtc.mongocore.PackagesData;
import com.vtc.mongocore.TopupBankMetadata;
import com.vtc.mongocore.TopupCardMetadata;
import com.vtc.mongocore.TopupIAPMetadata;
import com.vtc.mongocore.TopupVtcPayMetadata;
import com.vtc.mongorepository.EventsRepository;
import com.vtc.mongorepository.MonitorRepository;
import com.vtc.mongorepository.OrderRepository;
import com.vtc.mongorepository.TrackingRepository;
import com.vtc.request.GamePaymentRequest;
import com.vtc.request.OrderIAPRequest;
import com.vtc.request.TransactionDeductVcoinRequest;
import com.vtc.request.TransactionTopupByBankRequest;
import com.vtc.request.TransactionTopupByCardRequest;
import com.vtc.request.TransactionTopupByIAPRequest;
import com.vtc.request.TransactionTopupByVtcPayRequest;
import com.vtc.response.GamePaymentResponseData;
import com.vtc.serviceproxy.GamePaymentService;
import com.vtc.util.DateUtil;
import com.vtc.ws.v2.model.transaction.TopupByBankResponseData;
import com.vtc.ws.v2.model.transaction.TopupByCardResponseData;
import com.vtc.ws.v2.model.transaction.TopupByVTCPayResponseData;
import com.vtc.ws.v2.model.transaction.TopupIAPResponseData;
import com.vtc.ws.v2.model.transaction.TransactionOutputResponseData;
import com.vtc.ws.v2.service.TransactionTopupService;

@Service
public class TransactionServiceImpl implements TransactionService {
	private static Logger log = Logger.getLogger(TransactionServiceImpl.class);

	@Autowired
	private TransactionTopupService transactionTopupService;

	@Autowired
	private EventsRepository eventsRepository;

	@Autowired
	private ModelUtils modelUtils;

	@Autowired
	private TrackingRepository trackingRepository;

	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private GamePaymentService gamePaymentService;
	
	@Autowired
	private ServiceUtils serviceUtils;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private ISysConfig sysConfig;
	
	@Autowired
	private MonitorRepository monitorRepository;
	
	@Override
	public TopupByCardResponseData topupCard(TransactionTopupByCardRequest request) throws JsonParseException, JsonMappingException, IOException {
		log.info(new StringBuffer("[START] TransactionServiceImpl.topupCard() "));
		TopupByCardResponseData response = new TopupByCardResponseData();
		try {
			request.setServiceKey(commonUtils.findServiceKeyById(request.getServiceId()));
		} catch (Exception e) {
			log.error(new StringBuffer("[ERROR] ").append(", ServiceId: ").append(request.getServiceId())
					.append(" Not mapping"));
			request.setServiceKey("");
			return response;
		}

		response = transactionTopupService.topupCard(request.getAccountName(), request.getCpId(), request.getCardCode(),
				request.getCardSeri(), request.getCardType(), request.getClientIp(), request.getClientTime(),
				request.getCreatedUserId(), request.getCreatedUserName(), request.getDeviceType(),
				request.getRelatedTransactionId(), request.getServiceId(), request.getServiceKey());

		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] TOPUP CARD FAILED. AccountName: ").append(request.getAccountName())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}

		// log.debug(new StringBuffer(" 2. Save Account to DB"));
		// List<Accounts> accounts =
		// accountRepository.findAllByAccountName(request.getAccountName());
		// if (accounts == null || accounts.isEmpty()) {
		// accountRepository.save((modelUtils.createAccount(request.getAccountName(),
		// "", "", "", "", "", null, "", "",
		// "", "", "", "", new BigDecimal(0), new BigDecimal(0), "", 1)));
		// } else {
		// Accounts account = accounts.get(0);
		// account.setVersion(account.getVersion() + 1);
		// accountRepository.save(account);
		// }

		log.info(new StringBuffer(" 3. Save Tracking to DB"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer(" 4. Save Event to DB"));
		TopupCardMetadata metadata = modelUtils.createTopupCardMetadata(request.getName(), request.getAccountName(),
				request.getCpId(), request.getCardCode(), request.getCardSeri(), request.getCardType(),
				request.getClientId(), request.getClientTime(), request.getCreatedUserId(),
				request.getCreatedUserName(), request.getDeviceType(), request.getRelatedTransactionId(),
				request.getServiceId(), request.getServiceKey());

		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.TopupByCard, request, metadata));

		log.info(new StringBuffer("[END] TransactionServiceImpl.topupCard() is successfully!!!"));
		return response;
	}

	@Override
	public TopupByBankResponseData topupBank(TransactionTopupByBankRequest request) throws JsonParseException, JsonMappingException, IOException {
		log.info(new StringBuffer("[START] TransactionServiceImpl.topupBank() "));
		TopupByBankResponseData response = new TopupByBankResponseData();

		response = transactionTopupService.topupBank(request.getAccountName(), request.getBankCode(), request.getCpId(),
				request.getClientIp(), request.getClientTime(), request.getCreatedUserId(),
				request.getCreatedUserName(), request.getDeductServiceId(), request.getDeductServiceKey(),
				request.getDescription(), request.getDeviceType(), request.getNotifyUrl(), request.getOrderCode(),
				request.getProductId(), request.getReturnUrl(), request.getVcoin());

		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] TOPUP BANK FAILED. AccountName: ").append(request.getAccountName())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}

		log.info(new StringBuffer(" 3. Save Tracking to DB"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer(" 4. Save Event to DB"));
		TopupBankMetadata metadata = modelUtils.createTopupBankMetadata(request.getName(), request.getAccountName(),
				request.getBankCode(), request.getCpId(), request.getClientIp(), request.getClientTime(),
				request.getCreatedUserId(), request.getCreatedUserName(), request.getDeductServiceId(),
				request.getDeductServiceKey(), request.getDescription(), request.getDeviceType(),
				request.getNotifyUrl(), request.getOrderCode(), request.getProductId(), request.getReturnUrl(),
				request.getVcoin());

		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.TopupByBank, request, metadata));

		log.info(new StringBuffer("[END] TransactionServiceImpl.topupBank() is successfully!!!"));
		return response;
	}

	@Override
	public TopupByVTCPayResponseData topupVtcpay(TransactionTopupByVtcPayRequest request) throws JsonParseException, JsonMappingException, IOException {
		log.info(new StringBuffer("[START] TransactionServiceImpl.topupVtcpay() "));
		TopupByVTCPayResponseData response = new TopupByVTCPayResponseData();

		response = transactionTopupService.topupVtcpay(request.getAccountName(), request.getBankCode(),
				request.getCpId(), request.getClientIp(), request.getClientTime(), request.getCreatedUserId(),
				request.getCreatedUserName(), request.getDeductServiceId(), request.getDeductServiceKey(),
				request.getDescription(), request.getDeviceType(), request.getNotifyUrl(), request.getOrderCode(),
				request.getProductId(), request.getReturnUrl(), request.getVtcPayAccount(), request.getVcoin());

		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] TOPUP VTCPAY FAILED. AccountName: ").append(request.getAccountName())
					.append(", Vcoin: ").append(request.getVcoin()).append(", VtcPayAccount: ")
					.append(request.getVtcPayAccount()).append(", ResponseCode: ")
					.append(response == null ? "" : response.getResponseCode()).append(", Desciprtion: ")
					.append(response == null ? "" : response.getDescription()));

			return response;
		}

		log.info(new StringBuffer(" 3. Save Tracking to DB"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer(" 4. Save Event to DB"));
		TopupVtcPayMetadata metadata = modelUtils.createTopupVtcPayMetadata(request.getName(), request.getAccountName(),
				request.getBankCode(), request.getCpId(), request.getClientIp(), request.getClientTime(),
				request.getCreatedUserId(), request.getCreatedUserName(), request.getDeductServiceId(),
				request.getDeductServiceKey(), request.getDescription(), request.getDeviceType(),
				request.getNotifyUrl(), request.getOrderCode(), request.getProductId(), request.getReturnUrl(),
				request.getVtcPayAccount(), request.getVcoin());

		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.TopupByVtcPay, request, metadata));

		log.info(new StringBuffer("[END] TransactionServiceImpl.topupVtcpay() is successfully!!!"));
		return response;
	}

	@Override
	public TopupIAPResponseData topupIAP(TransactionTopupByIAPRequest request) throws JsonParseException, JsonMappingException, IOException {
		log.info(new StringBuffer("[START] TransactionServiceImpl.topupIAP() "));
		TopupIAPResponseData response = new TopupIAPResponseData();
		try {
			request.setServiceKey(commonUtils.findServiceKeyById(request.getServiceId()));
		} catch (Exception e) {
			log.error(new StringBuffer("[ERROR] ").append(", ServiceId: ").append(request.getServiceId())
					.append(" Not mapping"));
			request.setServiceKey("");
			return response;
		}
		
		response = transactionTopupService.topupIAP(request.getUuid(), request.getReceiptBase(),
				request.getReceiptData(), request.getAccountName(), request.getQuantity(), request.getPacketId(),
				request.getRelatedTransactionId(), request.getPurchaseDate(), request.getReceiptBaseMd5(),
				request.getServiceId(), request.getServiceKey(), request.getCreatedUserID(),
				request.getCreatedUserName(), request.getDeviceType(), request.getDescription(), request.getCpId(),
				request.getClientIp(), request.getSign(), request.getDeductServiceId(), request.getDeductServiceKey());

		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] TOPUP INAPPPURCHASE FAILED. AccountName: ").append(request.getAccountName())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}

		log.info(new StringBuffer(" Save Tracking to DB"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer(" Save Event to DB"));
		TopupIAPMetadata metadata = modelUtils.createTopupIAPMetadata(request.getSign(), request.getAccountName(), 
				request.getCpId(), request.getClientIp(), request.getCreatedUserID(), request.getCreatedUserName(), 
				request.getDescription(), request.getPacketId(), request.getPurchaseDate(), request.getQuantity(), 
				request.getReceiptBase(), request.getReceiptBaseMd5(), request.getReceiptData(), 
				request.getRelatedTransactionId(), request.getServiceId(), request.getServiceKey(), request.getUuid(), 
				request.getDeductServiceId(), request.getDeductServiceKey());

		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.TopupByInAppPurchase, request, metadata));
		
		log.info(new StringBuffer("[END] TransactionServiceImpl.topupIAP() is successfully!!!"));
		return response;
	}

	@Override
	public TransactionOutputResponseData deductVcoin(TransactionDeductVcoinRequest request) throws JsonParseException, JsonMappingException, IOException {
		log.info(new StringBuffer("[START] TransactionServiceImpl.deductVcoint() "));
		TransactionOutputResponseData response = new TransactionOutputResponseData();
		try {
			request.setServiceKey(commonUtils.findServiceKeyById(request.getServiceId()));
		} catch (Exception e) {
			log.error(new StringBuffer("[ERROR] ").append(", ServiceId: ").append(request.getServiceId())
					.append(" Not mapping"));
			request.setServiceKey("");
			return response;
		}
		long t1 = System.currentTimeMillis();
		request.setClientTime(t1);
		response = transactionTopupService.deductVcoin(request.getServiceId(), request.getServiceKey(), 
						request.getCreatedUserId(), request.getCreatedUserName(), request.getAccountId(), 
						request.getAccountName(), request.getRelatedTransactionId(), request.getDeviceType(), 
						request.getClientIp(), request.getClientTime(), request.getCpId(), request.getVcoin(), 
						request.getDescription(), request.getSign(), request.getRelatedAccountId());
		
		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] TOPUP INAPPPURCHASE FAILED. AccountName: ").append(request.getAccountName())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			return response;
		}

		log.info(new StringBuffer(" Save Tracking to DB"));
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));

		log.info(new StringBuffer(" Save Event to DB"));
		DeductVcoinMetadata metadata = modelUtils.createDeductVcoinMetadata(request.getServiceId(), 
				request.getServiceKey(), request.getCreatedUserId(), request.getCreatedUserName(), 
				request.getAccountId(), request.getAccountName(), request.getRelatedTransactionId(), 
				request.getDeviceType(), request.getClientIp(), request.getClientTime(), request.getCpId(), 
				request.getVcoin(), request.getDescription(), request.getSign(), request.getRelatedAccountId());

		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.DeductVcoin, request, metadata));
		log.info(new StringBuffer("[END] TransactionServiceImpl.deductVcoint() is successfully!!!"));
		return response;
	}
	

	@Override
	public GamePaymentResponseData gamePaymentVcoin(GamePaymentRequest request, String accessToken) throws IOException, NoSuchAlgorithmException, ServiceException {
		GamePaymentResponseData response = new GamePaymentResponseData();
		if(request == null){
			return response;
		}
		
		// Find account to get BillingAccessToken
		String billingAccessToken = serviceUtils.getBillingAccessToken(request.getAccountId(), request.getAccountName());
		if(StringUtils.isEmpty(billingAccessToken)){
			response.setResponseCode(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getValue());
			response.setDescription(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getDisplay());
			return response;
		}
		
		request.setBillingAccessToken(billingAccessToken);
				
		// Modify UTM link
		request = (GamePaymentRequest) serviceUtils.modifyRequest(request);
		Game gameInfo = gameService.findGameInfoByClientId(request.getClientId());
		if(gameInfo == null || gameInfo.getStatus().compareTo(DataConstants.Status.Activated) < 0){
			return response;
		}
		
		// Find game info by clientId from client
		PackagesData packageData = gameService.findPackageByClientIdAndKey(request.getClientId(), 
							request.getPackageId(), request.getPackageType());
		if(packageData == null){
			return response;
		}
		
		request.setServerGame(StringUtils.isEmpty(request.getServerGame()) ? gameInfo.getServerGame() : request.getServerGame());
		request.setGameCode(gameInfo.getGameCode());
		request.setFunctionName(DataConstants.GamePaymentFunctionName.CREATE);
		request.setPaymentType(DataConstants.GamePaymentType.BUYVCOIN);
		request.setAmount(packageData.getPriceVcoin() * 1000);
		request.setPartnerAmount(packageData.getPriceVcoin() * (1000/packageData.getMoneyScale()));
		request.setPaymentFrom(DataConstants.PaymentFromVTC);
		request.setPartnerCode(sysConfig.getGamePaymentSignPartnerCode());
		String description = "Dich vu Nap Vcoin";
		DescriptionData descriptionData = new DescriptionData();
		descriptionData.setDescription(description);
		descriptionData.setGameToken(request.getExtendData());
		descriptionData.setPackageType(packageData.getPackageType().toString());
		request.setDescription(descriptionData.toDataString());
		
		// CREATE ORDER BILLING
		try{
			response = gamePaymentService.transactionPayment(request);
		}catch(Exception e){
			// Save Monitor
			monitorRepository.save(modelUtils.createMonitorData(request, packageData, e.toString()));
		}
		
		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] Game payment CREATE VCOIN is FAILED. AccountName: ").append(request.getAccountName())
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));
			// Save Monitor
			monitorRepository.save(modelUtils.createMonitorData(request, packageData, response == null ? "" : commonUtils.toJsonString(response)));
			return response;
		}
		
		// Save Monitor
		monitorRepository.save(modelUtils.createMonitorData(request, packageData, commonUtils.toJsonString(response)));
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentVcoinCreate, 
														request, 
														modelUtils.createGamePaymentMetadata(request)));
		
//		request.setFunctionName(DataConstants.GamePaymentFunctionName.UPDATE);
//		request.setVtcTransId(response.getResponseCode());
//		request.setDescription("Update nap VCOIN");
		
		// TODO: UPDATE ORDER BILLING
//		response = gamePaymentService.transactionPayment(request);
//		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
//			log.error(new StringBuffer("[Error] Game payment UPDATE VCOIN is FAILED. AccountName: ").append(request.getAccountName())
//					.append(", AccountId: ").append(request.getAccountId())
//					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
//					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));
//
//			return response;
//		}
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentVcoinUpdate, 
														request, 
														modelUtils.createGamePaymentMetadata(request)));
		
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));
		
		return response;
	}

	@Override
	public GamePaymentResponseData gamePaymentIAP(GamePaymentRequest request, String accessToken)
			throws IOException, NoSuchAlgorithmException, ServiceException {
		GamePaymentResponseData response = new GamePaymentResponseData();
		if(request == null){
			log.error("[ERROR] Request is null");
			return response;
		}
		
		// Find account to get BillingAccessToken
		String billingAccessToken = serviceUtils.getBillingAccessToken(request.getAccountId(), request.getAccountName());
		if(StringUtils.isEmpty(billingAccessToken)){
			response.setResponseCode(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getValue());
			response.setDescription(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getDisplay());
			return response;
		}
		
		request.setBillingAccessToken(billingAccessToken);
		
		// find Order by AccessToken and Status = Created
		List<Order> orders = orderRepository.findAllByAccessTokenAndBillingAccessTokenAndStatus(accessToken, request.getBillingAccessToken(), DataConstants.OrderStatus.Created);
		if(CollectionUtils.isEmpty(orders)){
			response.setResponseCode(DataConstants.ResponseCode.NOT_EXISTED_ORDER.getValue());
			response.setDescription(DataConstants.ResponseCode.NOT_EXISTED_ORDER.getDisplay());
			return response;
		}
		
		Order orderItem = orders.stream().findFirst().orElse(new Order());
				
		// Modify UTM link
		request = (GamePaymentRequest) serviceUtils.modifyRequest(request);
		
		// Find game info by clientId from client
		PackagesData packageData = gameService.findPackageByClientIdAndKey(request.getClientId(), 
							orderItem.getPackageId(), DataConstants.PackageType.NORMAL.getValue());
		if(packageData == null){
			
			return response;
		}
		
		GamePaymentRequest verifyResponse = serviceUtils.checkVerifyIAP(request, packageData);
		if(verifyResponse == null){
			response.setResponseCode(DataConstants.ResponseCode.INVALID_PAYMENT_IAP.getValue());
			response.setDescription(DataConstants.ResponseCode.INVALID_PAYMENT_IAP.getDisplay());
			
			return response;
		}
		String productId = verifyResponse.getProductId();
		String transactionId = verifyResponse.getRelatedTransactionId();
		String purchaseDate = verifyResponse.getPurchaseDate();
		
		// TODO: productId = com.vtc.mobile.idol.099 for TEST
		productId = "com.vtc.mobile.idol.099";
		
		request.setReceiptBase(request.getReceiptData());
		request.setReceiptBaseMd5(commonUtils.hashMD5(request.getReceiptBase()));
		
		request.setServerGame(StringUtils.isEmpty(request.getServerGame()) ? orderItem.getServerGame() : request.getServerGame());
		request.setGameCode(orderItem.getGameCode());
		request.setPartnerCode(sysConfig.getGamePaymentSignPartnerCode());
		request.setFunctionName(DataConstants.GamePaymentFunctionName.CREATE);
		request.setPaymentType(DataConstants.GamePaymentType.BUYIAP);
		request.setAmount(packageData.getPriceVnd());
		request.setPartnerAmount(packageData.getPriceGold());
		request.setUuid(request.getDeviceToken());
		request.setQuantity(DataConstants.One);
		request.setProductId(productId);
		request.setRelatedTransactionId(transactionId);
		request.setPurchaseDate(DateUtil.longToString(purchaseDate, DateUtil.PATTERN_YYYYMMDD_T_HHMMSS_Z)); //"2016-08-01T00:00:00Z");
		request.setPaymentFrom(DataConstants.PaymentFromVTC);
		String description = "Dich vu nap thong qua IAP";
		DescriptionData descriptionData = new DescriptionData();
		descriptionData.setDescription(description);
		descriptionData.setGameToken(request.getExtendData());
		descriptionData.setPackageType(packageData.getPackageType().toString());
		request.setDescription(descriptionData.toDataString());
		
		// Create Order Payment
		try{
			response = gamePaymentService.transactionPayment(request);
		}catch(Exception e){
			// Save Monitor
			monitorRepository.save(modelUtils.createMonitorData(request, packageData, e.toString()));
		}
		
		if (response == null || response.getResponseCode().compareTo(HttpURLConnection.HTTP_INTERNAL_ERROR) == 0 
				|| response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] Game payment CREATE IAP is FAILED. AccountName: ").append(request.getAccountName())
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));
			
			// Save Monitor
			monitorRepository.save(modelUtils.createMonitorData(request, packageData, response == null ? "" : commonUtils.toJsonString(response)));
			return response;
		}
		
		monitorRepository.save(modelUtils.createMonitorData(request, packageData, commonUtils.toJsonString(response)));
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentIAPCreate, 
														request, 
														modelUtils.createGamePaymentMetadata(request)));

		// UpdateOrder Payment
//		request.setFunctionName(DataConstants.GamePaymentFunctionName.UPDATE);
//		request.setVtcTransId(response.getResponseCode());
//		request.setDescription("Update nap IAP");
		
		// TODO: UPDATE ORDER
//		response = gamePaymentService.transactionPayment(request);
//		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
//			log.error(new StringBuffer("[Error] Game payment UPDATE IAP is FAILED. AccountName: ").append(request.getAccountName())
//					.append(", AccountId: ").append(request.getAccountId())
//					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
//					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));
//
//			return response;
//		}
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentIAPUpdate, 
														request, 
														modelUtils.createGamePaymentMetadata(request)));
		
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));
		
		// UPdate OrderNo
		orderItem.setStatus(DataConstants.OrderStatus.Finished);
		orderItem.setUpdatedTime(new Date());
		orderRepository.save(orderItem);
		
		return response;
	}

	@Override
	public String initOrder(OrderIAPRequest request, String accessToken) throws RemoteException, ServiceException {
		if(request == null 
				|| StringUtils.isEmpty(request.getClientId()) 
				|| StringUtils.isEmpty(request.getPackageId())
				|| StringUtils.isEmpty(accessToken)){
			return "";
		}
		
		// Find account to get BillingAccessToken
		String billingAccessToken = serviceUtils.getBillingAccessToken(request.getAccountId(), request.getAccountName());
		if(StringUtils.isEmpty(billingAccessToken)){
			return "";
		}
		
		request.setBillingAccessToken(billingAccessToken);
		
		Game gameInfo = gameService.findGameInfoByClientId(request.getClientId());
		if(gameInfo == null){
			return "";
		}
		
		// Find old OrderNo belong to accessToken having in db --> change to Delete
		List<Order> orders = orderRepository.findAllByAccessTokenAndBillingAccessToken(accessToken, request.getBillingAccessToken());
		if(!CollectionUtils.isEmpty(orders)){
			orders.stream().filter(item -> item.getStatus().compareTo(DataConstants.OrderStatus.Created) == 0)
							.forEach(item -> {
								item.setStatus(DataConstants.OrderStatus.Deleted);
								orderRepository.save(item);
							});
		}
		
		String orderNo = commonUtils.autoGenOrderNo(request.getClientId(), request.getAccountName(), request.getPackageId());
		Calendar calendar = Calendar.getInstance();
		Date dateNow = calendar.getTime();
		Order order = new Order().setOrderNo(orderNo)
								.setAccessToken(accessToken)
								.setBillingAccessToken(request.getBillingAccessToken())
								.setGameCode(gameInfo.getGameCode())
								.setServerGame(gameInfo.getServerGame())
								.setClientIp(request.getClientIp())
								.setPackageId(request.getPackageId())
								.setStatus(DataConstants.OrderStatus.Created)
								.setDescription("")
								.setVersion(DataConstants.One)
								.setCreatedTime(dateNow)
								.setUpdatedTime(dateNow);
		
		orderRepository.save(order);
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.CreateOrder, 
													request, 
													new CreateOrderMetadata().setAccountName(request.getAccountName())
																			 .setOrderId(order.getId().toString())
																			 .setOrderNo(orderNo)
																			 .setAccessToken(accessToken)
																			 .setBillingAccessToken(request.getBillingAccessToken())
																			 .setPackageId(request.getPackageId())));
		
		return orderNo;
	}

	@Override
	public GamePaymentResponseData gamePaymentBank(GamePaymentRequest request, String accessToken)
			throws IOException, NoSuchAlgorithmException, ServiceException {
		GamePaymentResponseData response = new GamePaymentResponseData();
		if(request == null){
			return response;
		}
		
		// Find account to get BillingAccessToken
		String billingAccessToken = serviceUtils.getBillingAccessToken(request.getAccountId(), request.getAccountName());
		if(StringUtils.isEmpty(billingAccessToken)){
			response.setResponseCode(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getValue());
			response.setDescription(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getDisplay());
			return response;
		}
		
		request.setBillingAccessToken(billingAccessToken);
				
		request = (GamePaymentRequest) serviceUtils.modifyRequest(request);
		
		Game gameInfo = gameService.findGameInfoByClientId(request.getClientId());
		if(gameInfo == null || gameInfo.getStatus().compareTo(DataConstants.Status.Activated) < 0){
			return response;
		}
		
		// Find game info by clientId from client
		PackagesData packageData = gameService.findPackageByClientIdAndKey(request.getClientId(),
				request.getPackageId(), request.getPackageType());
		if (packageData == null) {

			return response;
		}
		
		request.setServerGame(StringUtils.isEmpty(request.getServerGame()) ? gameInfo.getServerGame() : request.getServerGame());
		request.setGameCode(gameInfo.getGameCode());
		request.setPartnerCode(sysConfig.getGamePaymentSignPartnerCode());
		request.setAmount(packageData.getPriceVnd());
		request.setPartnerAmount(packageData.getPriceVnd()/ packageData.getMoneyScale());
		request.setFunctionName(DataConstants.GamePaymentFunctionName.CREATE);
		request.setPaymentType(DataConstants.GamePaymentType.BUYBANK);
		request.setPaymentFrom(DataConstants.PaymentFromVTC);
		String description = "Dich vu nap thong qua BANK";
		DescriptionData descriptionData = new DescriptionData();
		descriptionData.setDescription(description);
		descriptionData.setGameToken(request.getExtendData());
		descriptionData.setPackageType(packageData.getPackageType().toString());
		request.setDescription(descriptionData.toDataString());
		
		// CREATE ORDER BILLING
		try{
			response = gamePaymentService.transactionPayment(request);
		}catch(Exception e){
			monitorRepository.save(modelUtils.createMonitorData(request, packageData, e.toString()));
		}
		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] Game payment BANK CREATE is FAILED. AccountName: ").append(request.getAccountName())
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			monitorRepository.save(modelUtils.createMonitorData(request, packageData, response == null ? "" : commonUtils.toJsonString(response)));
			return response;
		}
		
		// Save Monitor
		monitorRepository.save(modelUtils.createMonitorData(request, packageData, commonUtils.toJsonString(response)));
				
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentBankCreate, 
														request, 
														modelUtils.createGamePaymentMetadata(request)));
		
		// TODO: Update after callback link
//		request.setFunctionName(DataConstants.GamePaymentFunctionName.UPDATE);
//		request.setVtcTransId(response.getResponseCode());
//		request.setDescription("Update nap BANK");
//		
//		// TODO: UPDATE ORDER BILLING
////		response = gamePaymentService.transactionPayment(request);
//		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
//			log.error(new StringBuffer("[Error] Game payment BANK UPDATE is FAILED. AccountName: ").append(request.getAccountName())
//					.append(", AccountId: ").append(request.getAccountId())
//					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
//					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));
//
//			return response;
//		}
//		
//		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentBankUpdate, 
//														request, 
//														modelUtils.createGamePaymentMetadata(request)));
		
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));
				
		return response;
	}

	@Override
	public GamePaymentResponseData gamePaymentVtcPay(GamePaymentRequest request, String accessToken)
			throws IOException, NoSuchAlgorithmException, ServiceException {
		GamePaymentResponseData response = new GamePaymentResponseData();
		if(request == null){
			return response;
		}
		
		// Find account to get BillingAccessToken
		String billingAccessToken = serviceUtils.getBillingAccessToken(request.getAccountId(), request.getAccountName());
		if(StringUtils.isEmpty(billingAccessToken)){
			response.setResponseCode(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getValue());
			response.setDescription(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getDisplay());
			return response;
		}
		
		request.setBillingAccessToken(billingAccessToken);
		
		// Modify UTM link
		request = (GamePaymentRequest) serviceUtils.modifyRequest(request);
		
		Game gameInfo = gameService.findGameInfoByClientId(request.getClientId());
		if(gameInfo == null || gameInfo.getStatus().compareTo(DataConstants.Status.Activated) < 0){
			return response;
		}
		
		// Find game info by clientId from client
		PackagesData packageData = gameService.findPackageByClientIdAndKey(request.getClientId(),
				request.getPackageId(), request.getPackageType());
		if (packageData == null) {

			return response;
		}
		
		request.setServerGame(StringUtils.isEmpty(request.getServerGame()) ? gameInfo.getServerGame() : request.getServerGame());
		request.setGameCode(gameInfo.getGameCode());
		request.setPartnerCode(sysConfig.getGamePaymentSignPartnerCode());
		request.setAmount(packageData.getPriceVnd());
		request.setPartnerAmount(packageData.getPriceVnd()/ packageData.getMoneyScale());
		request.setFunctionName(DataConstants.GamePaymentFunctionName.CREATE);
		request.setPaymentType(DataConstants.GamePaymentType.BUYVTCPAY);
		request.setPaymentFrom(DataConstants.PaymentFromVTC);
		request.setBankCode(DataConstants.BankCodeVTCPay);
		String description = "Dich vu nap thong qua VTCPAY";
		DescriptionData descriptionData = new DescriptionData();
		descriptionData.setDescription(description);
		descriptionData.setGameToken(request.getExtendData());
		descriptionData.setPackageType(packageData.getPackageType().toString());
		request.setDescription(descriptionData.toDataString());
		
		// CREATE ORDER BILLING
		try{
			response = gamePaymentService.transactionPayment(request);
		}catch(Exception e){
			monitorRepository.save(modelUtils.createMonitorData(request, packageData, e.toString()));
		}
		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] Game payment VTCPAY CREATE is FAILED. AccountName: ").append(request.getAccountName())
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			monitorRepository.save(modelUtils.createMonitorData(request, packageData, response == null ? "" : commonUtils.toJsonString(response)));
			return response;
		}
		
		monitorRepository.save(modelUtils.createMonitorData(request, packageData, response == null ? "" : commonUtils.toJsonString(response)));
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentVtcPayCreate, 
														request, 
														modelUtils.createGamePaymentMetadata(request)));
		// TODO: Call Update after callback link
//		request.setFunctionName(DataConstants.GamePaymentFunctionName.UPDATE);
//		request.setVtcTransId(response.getResponseCode());
//		request.setDescription("Update nap VTCPAY");
//		
//		// TODO: UPDATE ORDER BILLING
////		response = gamePaymentService.transactionPayment(request);
//		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
//			log.error(new StringBuffer("[Error] Game payment VTCPAY UPDATE is FAILED. AccountName: ").append(request.getAccountName())
//					.append(", AccountId: ").append(request.getAccountId())
//					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
//					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));
//
//			return response;
//		}
//		
//		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentVtcPayUpdate, 
//														request, 
//														modelUtils.createGamePaymentMetadata(request)));
		
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));
		
		return response;
	}
	
	public GameService getGameService() {
		return gameService;
	}
	
	public void setGameService(GameService gameService) {
		this.gameService = gameService;
		
	}

	@Override
	public GamePaymentResponseData gamePaymentCard(GamePaymentRequest request, String accessToken)
			throws IOException, NoSuchAlgorithmException, ServiceException {
		GamePaymentResponseData response = new GamePaymentResponseData();
		if(request == null){
			return response;
		}
		
		// Find account to get BillingAccessToken
		String billingAccessToken = serviceUtils.getBillingAccessToken(request.getAccountId(), request.getAccountName());
		if(StringUtils.isEmpty(billingAccessToken)){
			response.setResponseCode(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getValue());
			response.setDescription(DataConstants.ResponseCode.INVALID_BILLING_ACCESSTOKEN.getDisplay());
			return response;
		}
		
		request.setBillingAccessToken(billingAccessToken);
				
		request = (GamePaymentRequest) serviceUtils.modifyRequest(request);
		Game gameInfo = gameService.findGameInfoByClientId(request.getClientId());
		if(gameInfo == null || gameInfo.getStatus().compareTo(DataConstants.Status.Activated) < 0){
			return response;
		}
		
		// Find game info by clientId from client
		PackagesData packageData = gameService.findPackageByClientIdAndKey(request.getClientId(),
				request.getPackageId(), request.getPackageType());
		if (packageData == null) {
			return response;
		}
		
		request.setServerGame(StringUtils.isEmpty(request.getServerGame()) ? gameInfo.getServerGame() : request.getServerGame());
		request.setGameCode(gameInfo.getGameCode());
		request.setPartnerCode(sysConfig.getGamePaymentSignPartnerCode());
		request.setPartnerAmount(DataConstants.Zero);
		request.setAmount(packageData.getPackageType().compareTo(DataConstants.PackageType.MONTH_CARD.getValue()) == 0 ? packageData.getPriceVnd() : DataConstants.Zero);
		request.setFunctionName(DataConstants.GamePaymentFunctionName.CREATE);
		request.setPaymentFrom(DataConstants.PaymentFromVTC);
		String description = "Dich vu nap thong qua CARD";
		DescriptionData descriptionData = new DescriptionData();
		descriptionData.setDescription(description);
		descriptionData.setGameToken(request.getExtendData());
		descriptionData.setPackageType(packageData.getPackageType().toString());
		request.setDescription(descriptionData.toDataString());
		
		// CREATE ORDER BILLING
		response = gamePaymentService.transactionPayment(request);
		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
			log.error(new StringBuffer("[Error] Game payment CARD CREATE is FAILED. AccountName: ").append(request.getAccountName())
					.append(", AccountId: ").append(request.getAccountId())
					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));

			monitorRepository.save(modelUtils.createMonitorData(request, packageData, response == null ? "" : commonUtils.toJsonString(response)));
			return response;
		}
		
		monitorRepository.save(modelUtils.createMonitorData(request, packageData, response == null ? "" : commonUtils.toJsonString(response)));
		
		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentCardCreate, 
														request, 
														modelUtils.createGamePaymentMetadata(request)));
		
//		// TODO: Call Update after callback link
//		request.setFunctionName(DataConstants.GamePaymentFunctionName.UPDATE);
//		request.setVtcTransId(response.getResponseCode());
//		request.setDescription("Update nap CARD");
//		
//		// TODO: UPDATE ORDER BILLING
//		response = gamePaymentService.transactionPayment(request);
//		if (response == null || response.getResponseCode().compareTo(DataConstants.Zero) <= 0) {
//			log.error(new StringBuffer("[Error] Game payment CARD UPDATE is FAILED. AccountName: ").append(request.getAccountName())
//					.append(", AccountId: ").append(request.getAccountId())
//					.append(", ResponseCode: ").append(response == null ? "" : response.getResponseCode())
//					.append(", Desciprtion: ").append(response == null ? "" : response.getDescription()));
//
//			return response;
//		}
//		
//		eventsRepository.save(modelUtils.createEvent(DataConstants.EventTypes.GamePaymentCardUpdate, 
//														request, 
//														modelUtils.createGamePaymentMetadata(request)));
		
		trackingRepository.save(modelUtils.createTrackingObj(request.getTrackingModel(), request.getClientId()));
		
		return response;
	}

	public MonitorRepository getMonitorRepository() {
		return monitorRepository;
	}

	public void setMonitorRepository(MonitorRepository monitorRepository) {
		this.monitorRepository = monitorRepository;
	}

}
