package com.vtc.ws.v2.service.transaction;

public class ITransactionInput_TopupByVTCPayServiceProxy implements com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByVTCPayService {
  private String _endpoint = null;
  private com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByVTCPayService iTransactionInput_TopupByVTCPayService = null;
  
  public ITransactionInput_TopupByVTCPayServiceProxy() {
    _initITransactionInput_TopupByVTCPayServiceProxy();
  }
  
  public ITransactionInput_TopupByVTCPayServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initITransactionInput_TopupByVTCPayServiceProxy();
  }
  
  private void _initITransactionInput_TopupByVTCPayServiceProxy() {
    try {
      iTransactionInput_TopupByVTCPayService = (new com.vtc.ws.v2.service.transaction.TransactionInput_TopupByVTCPayServiceLocator()).getBasicHttpBinding_ITransactionInput_TopupByVTCPayService();
      if (iTransactionInput_TopupByVTCPayService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iTransactionInput_TopupByVTCPayService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iTransactionInput_TopupByVTCPayService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iTransactionInput_TopupByVTCPayService != null)
      ((javax.xml.rpc.Stub)iTransactionInput_TopupByVTCPayService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vtc.ws.v2.service.transaction.ITransactionInput_TopupByVTCPayService getITransactionInput_TopupByVTCPayService() {
    if (iTransactionInput_TopupByVTCPayService == null)
      _initITransactionInput_TopupByVTCPayServiceProxy();
    return iTransactionInput_TopupByVTCPayService;
  }
  
  public com.vtc.ws.v2.model.transaction.TopupByVTCPayResponseData topupVcoinByVTCPay(com.vtc.ws.v2.model.transaction.TopupByVTCPayRequestData requestData) throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByVTCPayService == null)
      _initITransactionInput_TopupByVTCPayServiceProxy();
    return iTransactionInput_TopupByVTCPayService.topupVcoinByVTCPay(requestData);
  }
  
  
}