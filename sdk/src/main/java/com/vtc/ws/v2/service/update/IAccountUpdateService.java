/**
 * IAccountUpdateService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.update;

public interface IAccountUpdateService extends java.rmi.Remote {
    public com.vtc.ws.v2.model.ResponseData insertAccountInfo(com.vtc.ws.v2.model.update.AccountInfoRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData updateAccountProfile(com.vtc.ws.v2.model.update.ProfileRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData changePassword(com.vtc.ws.v2.model.update.ChangePasswordRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData changeEmail(com.vtc.ws.v2.model.update.ChangeEmailRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData changeQuestion(com.vtc.ws.v2.model.update.ChangeQuestionRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData changeMobile(com.vtc.ws.v2.model.update.ChangeMobileRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData verifyMobile(com.vtc.ws.v2.model.update.VerifyMobileRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData unVerifyMobile(com.vtc.ws.v2.model.update.UnVerifyMobileRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData resetPasswordBySecureCode(com.vtc.ws.v2.model.update.ResetPasswordBySecureCodeRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData resetPasswordByEmail(com.vtc.ws.v2.model.update.ResetPasswordByEmailRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData reActiveAccount(com.vtc.ws.v2.model.update.ReActiveRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData resetPasswordByAdmin(com.vtc.ws.v2.model.update.ResetPasswordByAdminRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData blockAccountByAdmin(com.vtc.ws.v2.model.update.BlockAccountRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData unBlockAccountByAdmin(com.vtc.ws.v2.model.update.UnBlockAccountRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData changeEmailByAdmin(com.vtc.ws.v2.model.update.ChangeEmailByAdminRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData changeQuestionByAdmin(com.vtc.ws.v2.model.update.ChangeQuestionByAdminRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData unVerifyMobileByAdmin(com.vtc.ws.v2.model.update.UnVerifyMobileByAdminRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData unVerifyMobileBySms(com.vtc.ws.v2.model.update.UnVerifyMobileBySmsRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.update.SMSResponseData blockBySMS(com.vtc.ws.v2.model.update.BlocBySmsRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.update.SMSResponseData unBlockBySMS(com.vtc.ws.v2.model.update.UnBlocBySmsRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.update.SMSResponseData cancelAuthenSecureBySMS(com.vtc.ws.v2.model.update.CancelAuthenSecureBySmsRequestData requestData) throws java.rmi.RemoteException;
}
