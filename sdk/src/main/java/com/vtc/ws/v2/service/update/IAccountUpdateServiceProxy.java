package com.vtc.ws.v2.service.update;

public class IAccountUpdateServiceProxy implements IAccountUpdateService {
  private String _endpoint = null;
  private IAccountUpdateService iAccountUpdateService = null;
  
  public IAccountUpdateServiceProxy() {
    _initIAccountUpdateServiceProxy();
  }
  
  public IAccountUpdateServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIAccountUpdateServiceProxy();
  }
  
  private void _initIAccountUpdateServiceProxy() {
    try {
      iAccountUpdateService = (new AccountUpdateServiceLocator()).getBasicHttpBinding_IAccountUpdateService();
      if (iAccountUpdateService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iAccountUpdateService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iAccountUpdateService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iAccountUpdateService != null)
      ((javax.xml.rpc.Stub)iAccountUpdateService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public IAccountUpdateService getIAccountUpdateService() {
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService;
  }
  
  public com.vtc.ws.v2.model.ResponseData insertAccountInfo(com.vtc.ws.v2.model.update.AccountInfoRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.insertAccountInfo(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData updateAccountProfile(com.vtc.ws.v2.model.update.ProfileRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.updateAccountProfile(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData changePassword(com.vtc.ws.v2.model.update.ChangePasswordRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.changePassword(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData changeEmail(com.vtc.ws.v2.model.update.ChangeEmailRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.changeEmail(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData changeQuestion(com.vtc.ws.v2.model.update.ChangeQuestionRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.changeQuestion(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData changeMobile(com.vtc.ws.v2.model.update.ChangeMobileRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.changeMobile(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData verifyMobile(com.vtc.ws.v2.model.update.VerifyMobileRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.verifyMobile(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData unVerifyMobile(com.vtc.ws.v2.model.update.UnVerifyMobileRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.unVerifyMobile(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData resetPasswordBySecureCode(com.vtc.ws.v2.model.update.ResetPasswordBySecureCodeRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.resetPasswordBySecureCode(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData resetPasswordByEmail(com.vtc.ws.v2.model.update.ResetPasswordByEmailRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.resetPasswordByEmail(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData reActiveAccount(com.vtc.ws.v2.model.update.ReActiveRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.reActiveAccount(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData resetPasswordByAdmin(com.vtc.ws.v2.model.update.ResetPasswordByAdminRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.resetPasswordByAdmin(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData blockAccountByAdmin(com.vtc.ws.v2.model.update.BlockAccountRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.blockAccountByAdmin(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData unBlockAccountByAdmin(com.vtc.ws.v2.model.update.UnBlockAccountRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.unBlockAccountByAdmin(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData changeEmailByAdmin(com.vtc.ws.v2.model.update.ChangeEmailByAdminRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.changeEmailByAdmin(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData changeQuestionByAdmin(com.vtc.ws.v2.model.update.ChangeQuestionByAdminRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.changeQuestionByAdmin(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData unVerifyMobileByAdmin(com.vtc.ws.v2.model.update.UnVerifyMobileByAdminRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.unVerifyMobileByAdmin(requestData);
  }
  
  public com.vtc.ws.v2.model.ResponseData unVerifyMobileBySms(com.vtc.ws.v2.model.update.UnVerifyMobileBySmsRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.unVerifyMobileBySms(requestData);
  }
  
  public com.vtc.ws.v2.model.update.SMSResponseData blockBySMS(com.vtc.ws.v2.model.update.BlocBySmsRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.blockBySMS(requestData);
  }
  
  public com.vtc.ws.v2.model.update.SMSResponseData unBlockBySMS(com.vtc.ws.v2.model.update.UnBlocBySmsRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.unBlockBySMS(requestData);
  }
  
  public com.vtc.ws.v2.model.update.SMSResponseData cancelAuthenSecureBySMS(com.vtc.ws.v2.model.update.CancelAuthenSecureBySmsRequestData requestData) throws java.rmi.RemoteException{
    if (iAccountUpdateService == null)
      _initIAccountUpdateServiceProxy();
    return iAccountUpdateService.cancelAuthenSecureBySMS(requestData);
  }
  
  
}