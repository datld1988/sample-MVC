package com.vtc.ws.v2.service.register;

public class IRegisterServiceProxy implements com.vtc.ws.v2.service.register.IRegisterService {
  private String _endpoint = null;
  private com.vtc.ws.v2.service.register.IRegisterService iRegisterService = null;
  
  public IRegisterServiceProxy() {
    _initIRegisterServiceProxy();
  }
  
  public IRegisterServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIRegisterServiceProxy();
  }
  
  private void _initIRegisterServiceProxy() {
    try {
      iRegisterService = (new com.vtc.ws.v2.service.register.RegisterServiceLocator()).getBasicHttpBinding_IRegisterService();
      if (iRegisterService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iRegisterService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iRegisterService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iRegisterService != null)
      ((javax.xml.rpc.Stub)iRegisterService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vtc.ws.v2.service.register.IRegisterService getIRegisterService() {
    if (iRegisterService == null)
      _initIRegisterServiceProxy();
    return iRegisterService;
  }
  
  public com.vtc.ws.v2.model.register.RegisterResponseData accountRegister(com.vtc.ws.v2.model.register.RegisterRequestData requestData) throws java.rmi.RemoteException{
    if (iRegisterService == null)
      _initIRegisterServiceProxy();
    return iRegisterService.accountRegister(requestData);
  }
  
  
}