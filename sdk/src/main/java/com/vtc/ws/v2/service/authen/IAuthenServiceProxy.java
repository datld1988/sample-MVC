package com.vtc.ws.v2.service.authen;

public class IAuthenServiceProxy implements com.vtc.ws.v2.service.authen.IAuthenService {
  private String _endpoint = null;
  private com.vtc.ws.v2.service.authen.IAuthenService iAuthenService = null;
  
  public IAuthenServiceProxy() {
    _initIAuthenServiceProxy();
  }
  
  public IAuthenServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIAuthenServiceProxy();
  }
  
  private void _initIAuthenServiceProxy() {
    try {
      iAuthenService = (new com.vtc.ws.v2.service.authen.AuthenServiceLocator()).getBasicHttpBinding_IAuthenService();
      if (iAuthenService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iAuthenService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iAuthenService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iAuthenService != null)
      ((javax.xml.rpc.Stub)iAuthenService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.vtc.ws.v2.service.authen.IAuthenService getIAuthenService() {
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService;
  }
  
  public com.vtc.ws.v2.model.authen.AuthenResponseData authentication(com.vtc.ws.v2.model.authen.AuthenRequestData requestData) throws java.rmi.RemoteException{
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService.authentication(requestData);
  }
  
  public com.vtc.ws.v2.model.authen.AuthenResponseData reAuthen(com.vtc.ws.v2.model.authen.ReAuthenRequestData requestData) throws java.rmi.RemoteException{
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService.reAuthen(requestData);
  }
  
  
}