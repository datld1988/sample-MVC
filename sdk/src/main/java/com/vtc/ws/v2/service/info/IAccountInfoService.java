/**
 * IAccountInfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.info;

public interface IAccountInfoService extends java.rmi.Remote {
    public com.vtc.ws.v2.model.info.Account getAccountByAccountName(java.lang.String accountName) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.Account getAccountByAccountID(java.lang.Integer accountId) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.Account getAccountVerifyMobile(java.lang.Integer accountId) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.AccountFull getAccountFullByAccountName(java.lang.String accountName) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.AccountFull getAccountFullByAccountID(java.lang.Integer accountId) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData checkVTCAccount(java.lang.String accountName) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData checkAccountStatus(java.lang.String accountName) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData checkEmailExists(java.lang.String email) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData checkMobileExists(java.lang.String mobile) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData checkAccessToken(java.lang.Integer serviceId, java.lang.String accountName, java.lang.String accessToken) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.ResponseData getBalanceByCurrencyType(java.lang.Integer accountId, java.lang.Integer currencyType) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.BalanceResponseData getAllBalance(java.lang.Integer accountId, java.lang.String accountName) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.BalanceFreezeResponseData getBalanceFreeze(java.lang.Integer accountId) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.TransactionHistory[] getListAccountTransaction(java.lang.Integer accountId, java.lang.Integer serviceId, java.util.Calendar fromDate, java.util.Calendar toDate) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.info.AccountInfoCheckResponseData checkAccountInfo(com.vtc.ws.v2.model.info.AccountInfoCheckRequestData requestData) throws java.rmi.RemoteException;
}
