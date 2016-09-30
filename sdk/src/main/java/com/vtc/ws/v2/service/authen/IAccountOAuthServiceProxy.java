package com.vtc.ws.v2.service.authen;

public class IAccountOAuthServiceProxy implements com.vtc.ws.v2.service.authen.IAccountOAuthService {
  private String _endpoint = null;
  private com.vtc.ws.v2.service.authen.IAccountOAuthService iAccountOAuthService = null;
  
  public IAccountOAuthServiceProxy() {
    _initIAccountOAuthServiceProxy();
  }
  
  public IAccountOAuthServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIAccountOAuthServiceProxy();
  }
  
  private void _initIAccountOAuthServiceProxy() {
    try {
      iAccountOAuthService = (new com.vtc.ws.v2.service.authen.AccountOAuthServiceLocator()).getBasicHttpBinding_IAccountOAuthService();
      if (iAccountOAuthService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iAccountOAuthService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iAccountOAuthService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iAccountOAuthService != null)
      ((javax.xml.rpc.Stub)iAccountOAuthService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vtc.ws.v2.service.authen.IAccountOAuthService getIAccountOAuthService() {
    if (iAccountOAuthService == null)
      _initIAccountOAuthServiceProxy();
    return iAccountOAuthService;
  }
  
  public com.vtc.ws.v2.model.authen.OAuthResponseData OAuthentication(com.vtc.ws.v2.model.authen.OAuthRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountOAuthService == null)
      _initIAccountOAuthServiceProxy();
    return iAccountOAuthService.OAuthentication(requestData);
  }
  
  public com.vtc.ws.v2.model.authen.OAuthCreateResponseData createAccountOAuth(com.vtc.ws.v2.model.authen.OAuthCreateRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountOAuthService == null)
      _initIAccountOAuthServiceProxy();
    return iAccountOAuthService.createAccountOAuth(requestData);
  }
  
  
}