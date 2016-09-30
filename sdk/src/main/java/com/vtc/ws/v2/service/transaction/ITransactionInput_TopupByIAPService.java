package com.vtc.ws.v2.service.transaction;

import com.vtc.ws.v2.model.transaction.TopupIAPRequestData;
import com.vtc.ws.v2.model.transaction.TopupIAPResponseData;

public interface ITransactionInput_TopupByIAPService extends java.rmi.Remote {
	public TopupIAPResponseData topupInAppPurchase(TopupIAPRequestData requestData) throws java.rmi.RemoteException;
}
