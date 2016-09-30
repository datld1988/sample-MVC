package com.vtc.business;

import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.vtc.config.RedisTokenStore;
import com.vtc.mongocore.Monitor;
import com.vtc.mongocore.PackagesData;
import com.vtc.request.GamePaymentRequest;
import com.vtc.request.Request;
import com.vtc.ws.v2.model.ResponseData;

public interface ServiceUtils {
	boolean validateToken(String accountName, String tokenKey);
	RedisTokenStore getTokenStore();
	Request modifyRequest(Request request);
	
	ResponseData checkBillingAccessToken(Integer serviceId, String accountName, String billingAccessToken) throws RemoteException, ServiceException;
	
	String getBillingAccessToken(Integer accountId, String accountName) throws RemoteException, ServiceException;
	
	GamePaymentRequest checkVerifyIAP(GamePaymentRequest request, PackagesData packageData);
	
	Map<String, String> generateMapClientIdForGame(String gameCode);
}
