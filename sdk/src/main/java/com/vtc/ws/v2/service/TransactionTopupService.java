package com.vtc.ws.v2.service;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtc.ws.v2.model.transaction.TopupIAPRequestData;
import com.vtc.ws.v2.model.transaction.TopupByBankRequestData;
import com.vtc.ws.v2.model.transaction.TopupByBankResponseData;
import com.vtc.ws.v2.model.transaction.TopupByCardRequestData;
import com.vtc.ws.v2.model.transaction.TopupByCardResponseData;
import com.vtc.ws.v2.model.transaction.TopupByVTCPayRequestData;
import com.vtc.ws.v2.model.transaction.TopupByVTCPayResponseData;
import com.vtc.ws.v2.model.transaction.TopupIAPResponseData;
import com.vtc.ws.v2.model.transaction.TransactionOutputRequestData;
import com.vtc.ws.v2.model.transaction.TransactionOutputResponseData;
import com.vtc.ws.v2.service.transaction.TransactionInput_TopupByBankService;
import com.vtc.ws.v2.service.transaction.TransactionInput_TopupByCardService;
import com.vtc.ws.v2.service.transaction.TransactionInput_TopupByIAPService;
import com.vtc.ws.v2.service.transaction.TransactionInput_TopupByVTCPayService;
import com.vtc.ws.v2.service.transaction.TransactionOutput_DeductVcoinService;
@Service
public class TransactionTopupService {
	private static final Logger log = Logger.getLogger(TransactionTopupService.class);

	@Autowired
	private TransactionInput_TopupByCardService topupCardService;

	@Autowired
	private TransactionInput_TopupByBankService topupBankService;

	@Autowired
	private TransactionInput_TopupByVTCPayService topupVtcpayService;
	
	@Autowired
	private TransactionInput_TopupByIAPService topupIAPService;
	
	@Autowired
	private TransactionOutput_DeductVcoinService deductVcoinService;
	
	public TopupByCardResponseData topupCard(String accountName, Integer CPID, String cardCode, String cardSeri, Integer cardType, 
			String clientIP, Long clientTime, Integer createdUserID, String createdUserName, Integer deviceType, Long relatedTransactionID, 
			Integer serviceID, String serviceKey) {
		log.info(new StringBuffer("[START] topupCard  CALL BILLING  username = ").append(accountName).append(", clientIp = ").append(clientIP).toString());
		TopupByCardRequestData requestData = new TopupByCardRequestData();
		requestData.setAccountName(accountName);
		requestData.setCPID(CPID);
		requestData.setCardCode(cardCode);
		requestData.setCardSeri(cardSeri);
		requestData.setCardType(cardType);
		requestData.setClientIP(clientIP);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(clientTime);
		requestData.setClientTime(c);
		requestData.setCreatedUserName(createdUserName);
		requestData.setDeviceType(deviceType);
		requestData.setServiceID(serviceID);
		requestData.setServiceKey(serviceKey);

		TopupByCardResponseData topupResponse = null;
		long t1 = System.currentTimeMillis();
		try {
			topupResponse = getTopupCardService().getBasicHttpBinding_ITransactionInput_TopupByCardService().topupVcoinByCard(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] topupCard  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return topupResponse;
	}

	public TopupByBankResponseData topupBank(String accountName, String bankCode, Integer CPID, String clientIP, Long clientTime,
			Integer createdUserID, String createdUserName, Integer deductServiceID, String deductServiceKey, String description,
			Integer deviceType, String notifyUrl, String orderCode, Integer productID, String returnUrl, Integer vcoin) {
		log.info(new StringBuffer("[START] topupBank  CALL BILLING  username = ").append(accountName).append(", clientIp = ").append(clientIP).toString());
		TopupByBankRequestData requestData = new TopupByBankRequestData();
		requestData.setAccountName(accountName);
		requestData.setBankCode(bankCode);
		requestData.setCPID(CPID);
		requestData.setClientIP(clientIP);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(clientTime);
		requestData.setClientTime(c);
		requestData.setCreatedUserID(createdUserID);
		requestData.setCreatedUserName(createdUserName);
		requestData.setDeductServiceID(deductServiceID);
		requestData.setDeductServiceKey(deductServiceKey);
		requestData.setDescription(description);
		requestData.setDeviceType(deviceType);
		requestData.setNotifyUrl(notifyUrl);
		requestData.setOrderCode(orderCode);
		requestData.setProductID(productID);
		requestData.setReturnUrl(returnUrl);
		requestData.setVcoin(vcoin);
		
		TopupByBankResponseData topupResponse = null;
		long t1 = System.currentTimeMillis();
		try {
			topupResponse = topupBankService.getBasicHttpBinding_ITransactionInput_TopupByBankService().topupVcoinByBank(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] topupBank  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return topupResponse;
	}

	public TopupByVTCPayResponseData topupVtcpay(String accountName, String bankCode, Integer cpID, String clientIP, Long clientTime, 
			Integer createdUserID, String createdUserName, Integer deductServiceID, String deductServiceKey, String description, 
			Integer deviceType, String notifyUrl, String orderCode, Integer productID, String returnUrl, String vtcPayAccount, Integer vcoin) {
		log.info(new StringBuffer("[START] topupVtcpay  CALL BILLING  username = ").append(accountName).append(", clientIp = ").append(clientIP).toString());
		TopupByVTCPayRequestData requestData = new TopupByVTCPayRequestData();
		requestData.setAccountName(accountName);
		requestData.setBankCode(bankCode);
		requestData.setCPID(cpID);
		requestData.setClientIP(clientIP);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(clientTime);
		requestData.setClientTime(c);
		requestData.setCreatedUserID(createdUserID);
		requestData.setCreatedUserName(createdUserName);
		requestData.setDeductServiceID(deductServiceID);
		requestData.setDeductServiceKey(deductServiceKey);
		requestData.setDescription(description);
		requestData.setDeviceType(deviceType);
		requestData.setNotifyUrl(notifyUrl);
		requestData.setOrderCode(orderCode);
		requestData.setProductID(productID);
		requestData.setReturnUrl(returnUrl);
		requestData.setVTCPayAccount(vtcPayAccount);
		requestData.setVcoin(vcoin);

		TopupByVTCPayResponseData topupResponse = null;
		long t1 = System.currentTimeMillis();
		try {
			topupResponse = topupVtcpayService.getBasicHttpBinding_ITransactionInput_TopupByVTCPayService().topupVcoinByVTCPay(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] topupVtcpay  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return topupResponse;
	}

	public TopupIAPResponseData topupIAP(String uuid, String receiptBase, String receiptData, String accountName, 
			Integer quantity, String packetId, String relatedTransactionId, Long purchaseDate, String receiptBaseMd5,
			Integer serviceId, String serviceKey, Integer createdUserId, String createdUserName, Integer deviceType,
			String description, Integer cpId, String clientIp, String sign, Integer deductServiceId, String deductServiceKey){
		log.info(new StringBuffer("[START] topupInAppPurchase  CALL BILLING  username = ").append(accountName).append(", clientIp = ").append(clientIp).toString());
		TopupIAPRequestData requestData = new TopupIAPRequestData();
		requestData.setAccountName(accountName);
		requestData.setClientIP(clientIp);
		requestData.setCPID(cpId);
		requestData.setCreatedUserID(createdUserId);
		requestData.setCreatedUserName(createdUserName);
		requestData.setDeductServiceID(deductServiceId);
		requestData.setDeductServiceKey(deductServiceKey);
		requestData.setDescription(description);
		requestData.setDeviceType(deviceType);
		requestData.setPacketID(packetId);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(purchaseDate);
		requestData.setPurchaseDate(c);
		requestData.setQuantity(quantity);
		requestData.setReceiptBase(receiptBase);
		requestData.setReceiptBaseMD5(receiptBaseMd5);
		requestData.setReceiptData(receiptData);
		requestData.setRelatedTransactionID(relatedTransactionId);
		requestData.setServiceID(serviceId);
		requestData.setServiceKey(deductServiceKey);
		requestData.setSign(sign);
		requestData.setUuid(uuid);
		
		TopupIAPResponseData topupResponse = null;
		long t1 = System.currentTimeMillis();
		try {
			topupResponse = topupIAPService.getBasicHttpBinding_ITransactionInput_TopupByIAPService().topupInAppPurchase(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] topupInAppPurchase  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		return topupResponse;
	}
	
	public TransactionOutputResponseData deductVcoin(Integer serviceId, String serviceKey, Integer createdUserId, String createdUserName, 
			Integer accountId, String accountName, Long relatedTransactionId, Integer deviceType, String clientIp, Long clientTime,
			Integer cpId, Integer vcoin, String description, String sign, Integer relatedAccountId){
		log.info(new StringBuffer("[START] deductVcoin  CALL BILLING  username = ").append(accountName).append(", clientIp = ").append(clientIp).toString());
		TransactionOutputRequestData requestData = new TransactionOutputRequestData();
		requestData.setAccountID(accountId);
		requestData.setAccountName(accountName);
		requestData.setClientIP(clientIp);
		requestData.setCPID(cpId);
		requestData.setCreatedUserID(createdUserId);
		requestData.setCreatedUserName(createdUserName);
		requestData.setDescription(description);
		requestData.setDeviceType(deviceType);
		requestData.setRelatedTransactionID(relatedTransactionId);
		requestData.setServiceID(serviceId);
		requestData.setServiceKey(serviceKey);
		requestData.setSign(sign);
		requestData.setVcoin(vcoin);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(clientTime);
		requestData.setClientTime(c);
		
		TransactionOutputResponseData deductResponse = null;
		
		long t1 = System.currentTimeMillis();
		try {
			deductResponse = deductVcoinService.getBasicHttpBinding_ITransactionOutput_DeductVcoinService().transactionDeductVcoin(requestData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[END] deductVcoin  CALL BILLING username = ").append(accountName).append(" TIME = ").append(String.valueOf(t2 - t1)).toString());
		
		return deductResponse;
	}


	public TransactionInput_TopupByCardService getTopupCardService() {
		return topupCardService;
	}

	public void setTopupCardService(TransactionInput_TopupByCardService topupCardService) {
		this.topupCardService = topupCardService;
	}

	public TransactionInput_TopupByVTCPayService getTopupVtcpayService() {
		return topupVtcpayService;
	}

	public void setTopupVtcpayService(TransactionInput_TopupByVTCPayService topupVtcpayService) {
		this.topupVtcpayService = topupVtcpayService;
	}

	public TransactionInput_TopupByBankService getTopupBankService() {
		return topupBankService;
	}

	public void setTopupBankService(TransactionInput_TopupByBankService topupBankService) {
		this.topupBankService = topupBankService;
	}

	public TransactionInput_TopupByIAPService getTopupIAPService() {
		return topupIAPService;
	}

	public void setTopupIAPService(TransactionInput_TopupByIAPService topupIAPService) {
		this.topupIAPService = topupIAPService;
	}

	public TransactionOutput_DeductVcoinService getDeductVcoinService() {
		return deductVcoinService;
	}

	public void setDeductVcoinService(TransactionOutput_DeductVcoinService deductVcoinService) {
		this.deductVcoinService = deductVcoinService;
	} 

}
