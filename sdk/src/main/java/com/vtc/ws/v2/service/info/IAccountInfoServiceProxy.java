package com.vtc.ws.v2.service.info;

public class IAccountInfoServiceProxy implements com.vtc.ws.v2.service.info.IAccountInfoService {
  private String _endpoint = null;
  private com.vtc.ws.v2.service.info.IAccountInfoService iAccountInfoService = null;
  
  public IAccountInfoServiceProxy() {
    _initIAccountInfoServiceProxy();
  }
  
  public IAccountInfoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIAccountInfoServiceProxy();
  }
  
  private void _initIAccountInfoServiceProxy() {
    try {
      iAccountInfoService = (new com.vtc.ws.v2.service.info.AccountInfoServiceLocator()).getBasicHttpBinding_IAccountInfoService();
      if (iAccountInfoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iAccountInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iAccountInfoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iAccountInfoService != null)
      ((javax.xml.rpc.Stub)iAccountInfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vtc.ws.v2.service.info.IAccountInfoService getIAccountInfoService() {
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService;
  }
  
  public com.vtc.ws.v2.model.info.Account getAccountByAccountName(java.lang.String accountName) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getAccountByAccountName(accountName);
  }
  
  public com.vtc.ws.v2.model.info.Account getAccountByAccountID(java.lang.Integer accountId) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getAccountByAccountID(accountId);
  }
  
  public com.vtc.ws.v2.model.info.Account getAccountVerifyMobile(java.lang.Integer accountId) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getAccountVerifyMobile(accountId);
  }
  
  public com.vtc.ws.v2.model.info.AccountFull getAccountFullByAccountName(java.lang.String accountName) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getAccountFullByAccountName(accountName);
  }
  
  public com.vtc.ws.v2.model.info.AccountFull getAccountFullByAccountID(java.lang.Integer accountId) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getAccountFullByAccountID(accountId);
  }
  
  public com.vtc.ws.v2.model.ResponseData checkVTCAccount(java.lang.String accountName) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.checkVTCAccount(accountName);
  }
  
  public com.vtc.ws.v2.model.ResponseData checkAccountStatus(java.lang.String accountName) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.checkAccountStatus(accountName);
  }
  
  public com.vtc.ws.v2.model.ResponseData checkEmailExists(java.lang.String email) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.checkEmailExists(email);
  }
  
  public com.vtc.ws.v2.model.ResponseData checkMobileExists(java.lang.String mobile) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.checkMobileExists(mobile);
  }
  
  public com.vtc.ws.v2.model.ResponseData checkAccessToken(java.lang.Integer serviceId, java.lang.String accountName, java.lang.String accessToken) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.checkAccessToken(serviceId, accountName, accessToken);
  }
  
  public com.vtc.ws.v2.model.ResponseData getBalanceByCurrencyType(java.lang.Integer accountId, java.lang.Integer currencyType) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getBalanceByCurrencyType(accountId, currencyType);
  }
  
  public com.vtc.ws.v2.model.info.BalanceResponseData getAllBalance(java.lang.Integer accountId, java.lang.String accountName) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getAllBalance(accountId, accountName);
  }
  
  public com.vtc.ws.v2.model.info.BalanceFreezeResponseData getBalanceFreeze(java.lang.Integer accountId) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getBalanceFreeze(accountId);
  }
  
  public com.vtc.ws.v2.model.info.TransactionHistory[] getListAccountTransaction(java.lang.Integer accountId, java.lang.Integer serviceId, java.util.Calendar fromDate, java.util.Calendar toDate) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.getListAccountTransaction(accountId, serviceId, fromDate, toDate);
  }
  
  public com.vtc.ws.v2.model.info.AccountInfoCheckResponseData checkAccountInfo(com.vtc.ws.v2.model.info.AccountInfoCheckRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountInfoService == null)
      _initIAccountInfoServiceProxy();
    return iAccountInfoService.checkAccountInfo(requestData);
  }
  
  
}