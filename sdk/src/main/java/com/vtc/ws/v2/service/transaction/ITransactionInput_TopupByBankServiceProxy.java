package com.vtc.ws.v2.service.transaction;

import com.vtc.ws.v2.model.transaction.BankPayment;
import com.vtc.ws.v2.model.transaction.CheckOrderRequestData;
import com.vtc.ws.v2.model.transaction.CheckOrderResponseData;
import com.vtc.ws.v2.model.transaction.TopupByBankCallBackRequestData;
import com.vtc.ws.v2.model.transaction.TopupByBankRequestData;
import com.vtc.ws.v2.model.transaction.TopupByBankResponseData;

public class ITransactionInput_TopupByBankServiceProxy implements ITransactionInput_TopupByBankService {
  private String _endpoint = null;
  private ITransactionInput_TopupByBankService iTransactionInput_TopupByBankService = null;
  
  public ITransactionInput_TopupByBankServiceProxy() {
    _initITransactionInput_TopupByBankServiceProxy();
  }
  
  public ITransactionInput_TopupByBankServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initITransactionInput_TopupByBankServiceProxy();
  }
  
  private void _initITransactionInput_TopupByBankServiceProxy() {
    try {
      iTransactionInput_TopupByBankService = (new TransactionInput_TopupByBankServiceLocator()).getBasicHttpBinding_ITransactionInput_TopupByBankService();
      if (iTransactionInput_TopupByBankService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iTransactionInput_TopupByBankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iTransactionInput_TopupByBankService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iTransactionInput_TopupByBankService != null)
      ((javax.xml.rpc.Stub)iTransactionInput_TopupByBankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ITransactionInput_TopupByBankService getITransactionInput_TopupByBankService() {
    if (iTransactionInput_TopupByBankService == null)
      _initITransactionInput_TopupByBankServiceProxy();
    return iTransactionInput_TopupByBankService;
  }
  
  public BankPayment[] getListBankPayment() throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByBankService == null)
      _initITransactionInput_TopupByBankServiceProxy();
    return iTransactionInput_TopupByBankService.getListBankPayment();
  }
  
  public TopupByBankResponseData topupVcoinByBank(TopupByBankRequestData requestData) throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByBankService == null)
      _initITransactionInput_TopupByBankServiceProxy();
    return iTransactionInput_TopupByBankService.topupVcoinByBank(requestData);
  }
  
  public TopupByBankResponseData topupVcoinByBankCallBack(TopupByBankCallBackRequestData requestData) throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByBankService == null)
      _initITransactionInput_TopupByBankServiceProxy();
    return iTransactionInput_TopupByBankService.topupVcoinByBankCallBack(requestData);
  }
  
  public CheckOrderResponseData checkStatusOrder(CheckOrderRequestData requestData) throws java.rmi.RemoteException{
    if (iTransactionInput_TopupByBankService == null)
      _initITransactionInput_TopupByBankServiceProxy();
    return iTransactionInput_TopupByBankService.checkStatusOrder(requestData);
  }
  
  
}