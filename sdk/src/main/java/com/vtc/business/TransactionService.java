package com.vtc.business;

import java.io.IOException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import javax.xml.rpc.ServiceException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vtc.request.GamePaymentRequest;
import com.vtc.request.OrderIAPRequest;
import com.vtc.request.TransactionDeductVcoinRequest;
import com.vtc.request.TransactionTopupByBankRequest;
import com.vtc.request.TransactionTopupByCardRequest;
import com.vtc.request.TransactionTopupByIAPRequest;
import com.vtc.request.TransactionTopupByVtcPayRequest;
import com.vtc.response.GamePaymentResponseData;
import com.vtc.ws.v2.model.transaction.TopupByBankResponseData;
import com.vtc.ws.v2.model.transaction.TopupByCardResponseData;
import com.vtc.ws.v2.model.transaction.TopupByVTCPayResponseData;
import com.vtc.ws.v2.model.transaction.TopupIAPResponseData;
import com.vtc.ws.v2.model.transaction.TransactionOutputResponseData;

public interface TransactionService {
	TopupByCardResponseData topupCard(TransactionTopupByCardRequest request) throws JsonParseException, JsonMappingException, IOException;
	TopupByBankResponseData topupBank(TransactionTopupByBankRequest request) throws JsonParseException, JsonMappingException, IOException;
	TopupByVTCPayResponseData topupVtcpay(TransactionTopupByVtcPayRequest request) throws JsonParseException, JsonMappingException, IOException;
	TopupIAPResponseData topupIAP(TransactionTopupByIAPRequest request) throws JsonParseException, JsonMappingException, IOException;
	TransactionOutputResponseData deductVcoin(TransactionDeductVcoinRequest request) throws JsonParseException, JsonMappingException, IOException;
	
	GamePaymentResponseData gamePaymentVcoin(GamePaymentRequest request, String accessToken) throws IOException, NoSuchAlgorithmException, ServiceException;
	GamePaymentResponseData gamePaymentIAP(GamePaymentRequest request, String accessToken) throws IOException, NoSuchAlgorithmException, ServiceException;
	GamePaymentResponseData gamePaymentBank(GamePaymentRequest request, String accessToken) throws IOException, NoSuchAlgorithmException, ServiceException;
	GamePaymentResponseData gamePaymentVtcPay(GamePaymentRequest request, String accessToken) throws IOException, NoSuchAlgorithmException, ServiceException;
	GamePaymentResponseData gamePaymentCard(GamePaymentRequest request, String accessToken) throws IOException, NoSuchAlgorithmException, ServiceException;
	
	String initOrder(OrderIAPRequest request, String accessToken) throws RemoteException, ServiceException ;
}
