package com.vtc.ws.v2.service.transaction;

import java.rmi.RemoteException;

import com.vtc.ws.v2.model.transaction.TopupIAPRequestData;
import com.vtc.ws.v2.model.transaction.TopupIAPResponseData;

public class ITransactionInput_TopupByIAPServiceProxy
		implements com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByIAPService {
	private String _endpoint = null;
	private com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByIAPService iTransactionInput_TopupByIAPService = null;
	
	public ITransactionInput_TopupByIAPServiceProxy() {
		_initITransactionInput_TopupByIAPServiceProxy();
	  }
	  
	  public ITransactionInput_TopupByIAPServiceProxy(String endpoint) {
	    _endpoint = endpoint;
	    _initITransactionInput_TopupByIAPServiceProxy();
	  }
	  
	  private void _initITransactionInput_TopupByIAPServiceProxy() {
	    try {
	    	iTransactionInput_TopupByIAPService = (new com.vtc.ws.v2.service.transaction.TransactionInput_TopupByIAPServiceLocator()).getBasicHttpBinding_ITransactionInput_TopupByIAPService();
	      if (iTransactionInput_TopupByIAPService != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)iTransactionInput_TopupByIAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)iTransactionInput_TopupByIAPService)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }
	  
	  public String getEndpoint() {
	    return _endpoint;
	  }
	  
	  public void setEndpoint(String endpoint) {
	    _endpoint = endpoint;
	    if (iTransactionInput_TopupByIAPService != null)
	      ((javax.xml.rpc.Stub)iTransactionInput_TopupByIAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	    
	  }
	  
	@Override
	public TopupIAPResponseData topupInAppPurchase(TopupIAPRequestData requestData) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
