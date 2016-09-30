package com.vtc.ws.v2.service.plus;

import com.vtc.ws.v2.model.ResponseData;

public class IAccountPlusServiceProxy implements IAccountPlusService {
  private String _endpoint = null;
  private IAccountPlusService iAccountPlusService = null;
  
  public IAccountPlusServiceProxy() {
    _initIAccountPlusServiceProxy();
  }
  
  public IAccountPlusServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIAccountPlusServiceProxy();
  }
  
  private void _initIAccountPlusServiceProxy() {
    try {
      iAccountPlusService = (new AccountPlusServiceLocator()).getBasicHttpBinding_IAccountPlusService();
      if (iAccountPlusService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iAccountPlusService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iAccountPlusService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iAccountPlusService != null)
      ((javax.xml.rpc.Stub)iAccountPlusService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public IAccountPlusService getIAccountPlusService() {
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService;
  }
  
  public ResponseData getAuthenSecureInfo(java.lang.String accountName) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.getAuthenSecureInfo(accountName);
  }
  
  public com.vtc.ws.v2.model.plus.AccountOAuth[] getAccountOAuth(java.lang.String accountName, java.lang.Integer oAuthSystemId, java.lang.String oAuthAccounts) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.getAccountOAuth(accountName, oAuthSystemId, oAuthAccounts);
  }
  
  public com.vtc.ws.v2.model.ResponseData setupAuthenSecure(com.vtc.ws.v2.model.plus.AuthenSecureRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.setupAuthenSecure(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData checkSmsPlusStatus(java.lang.Integer accountId) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.checkSmsPlusStatus(accountId);
  }
  
  public com.vtc.ws.v2.model.ResponseData registerSmsPlus(java.lang.Integer accountId, java.lang.String accountName, java.lang.String smsplusMobile) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.registerSmsPlus(accountId, accountName, smsplusMobile);
  }
  
  public com.vtc.ws.v2.model.ResponseData activeSmsPlus(java.lang.Integer accountId, java.lang.String otp, java.lang.String smsplusMobile) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.activeSmsPlus(accountId, otp, smsplusMobile);
  }
  
  public com.vtc.ws.v2.model.ResponseData updateSMSPlus(com.vtc.ws.v2.model.plus.UpdateSMSPlusRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.updateSMSPlus(requestData);
  }
  
  public com.vtc.ws.v2.model.plus.SMSPlusListResponseData getListSmsPlus(java.lang.Integer accountId) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.getListSmsPlus(accountId);
  }
  
  public com.vtc.ws.v2.model.ResponseData insertAccountOAuth(com.vtc.ws.v2.model.plus.AccountOAuthRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.insertAccountOAuth(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData deleteAccountOAuth(java.lang.Integer oAuthID) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.deleteAccountOAuth(oAuthID);
  }
  
  public com.vtc.ws.v2.model.ResponseData freezeVcoin(com.vtc.ws.v2.model.plus.FreezeVcoinRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.freezeVcoin(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData unFreezeVcoin(com.vtc.ws.v2.model.plus.UnFreezeVcoinRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountPlusService == null)
      _initIAccountPlusServiceProxy();
    return iAccountPlusService.unFreezeVcoin(requestData);
  }
  
  
}