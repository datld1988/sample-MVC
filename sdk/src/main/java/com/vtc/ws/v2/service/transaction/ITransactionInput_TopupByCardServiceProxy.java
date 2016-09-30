package com.vtc.ws.v2.service.transaction;

import com.vtc.ws.v2.model.ResponseData;

public class ITransactionInput_TopupByCardServiceProxy implements com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByCardService {
  private String _endpoint = null;
  private com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByCardService iTransactionInput_TopupByCardService = null;
  
  public ITransactionInput_TopupByCardServiceProxy() {
    _initITransactionInput_TopupByCardServiceProxy();
  }
  
  public ITransactionInput_TopupByCardServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initITransactionInput_TopupByCardServiceProxy();
  }
  
  private void _initITransactionInput_TopupByCardServiceProxy() {
    try {
      iTransactionInput_TopupByCardService = (new com.vtc.ws.v2.service.transaction.TransactionInput_TopupByCardServiceLocator()).getBasicHttpBinding_ITransactionInput_TopupByCardService();
      if (iTransactionInput_TopupByCardService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iTransactionInput_TopupByCardService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iTransactionInput_TopupByCardService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iTransactionInput_TopupByCardService != null)
      ((javax.xml.rpc.Stub)iTransactionInput_TopupByCardService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByCardService getITransactionInput_TopupByCardService() {
    if (iTransactionInput_TopupByCardService == null)
      _initITransactionInput_TopupByCardServiceProxy();
    return iTransactionInput_TopupByCardService;
  }
  
  public com.vtc.ws.v2.model.transaction.TopupByCardResponseData topupVcoinByCard(com.vtc.ws.v2.model.transaction.TopupByCardRequestData requestData) throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByCardService == null)
      _initITransactionInput_TopupByCardServiceProxy();
    return iTransactionInput_TopupByCardService.topupVcoinByCard(requestData);
  }
  
  public ResponseData checkCard(com.vtc.ws.v2.model.transaction.CheckCardRequestData requestData) throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByCardService == null)
      _initITransactionInput_TopupByCardServiceProxy();
    return iTransactionInput_TopupByCardService.checkCard(requestData);
  }
  
  public com.vtc.ws.v2.model.transaction.CheckCardOrderResponseData checkCardUse(com.vtc.ws.v2.model.transaction.CheckCardOrderRequestData requestData) throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByCardService == null)
      _initITransactionInput_TopupByCardServiceProxy();
    return iTransactionInput_TopupByCardService.checkCardUse(requestData);
  }
  
  
}