/**
 * IAccountPlusService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.plus;

public interface IAccountPlusService extends java.rmi.Remote {
	public com.vtc.ws.v2.model.ResponseData getAuthenSecureInfo(
			java.lang.String accountName) throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.plus.AccountOAuth[] getAccountOAuth(
			java.lang.String accountName, java.lang.Integer oAuthSystemId, java.lang.String oAuthAccounts)
			throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData setupAuthenSecure(
			com.vtc.ws.v2.model.plus.AuthenSecureRequestData requestData)
			throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData checkSmsPlusStatus(
			java.lang.Integer accountId) throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData registerSmsPlus(
			java.lang.Integer accountId, java.lang.String accountName, java.lang.String smsplusMobile)
			throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData activeSmsPlus(
			java.lang.Integer accountId, java.lang.String otp, java.lang.String smsplusMobile)
			throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData updateSMSPlus(
			com.vtc.ws.v2.model.plus.UpdateSMSPlusRequestData requestData)
			throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.plus.SMSPlusListResponseData getListSmsPlus(
			java.lang.Integer accountId) throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData insertAccountOAuth(
			com.vtc.ws.v2.model.plus.AccountOAuthRequestData requestData)
			throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData deleteAccountOAuth(
			java.lang.Integer oAuthID) throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData freezeVcoin(
			com.vtc.ws.v2.model.plus.FreezeVcoinRequestData requestData)
			throws java.rmi.RemoteException;

	public com.vtc.ws.v2.model.ResponseData unFreezeVcoin(
			com.vtc.ws.v2.model.plus.UnFreezeVcoinRequestData requestData)
			throws java.rmi.RemoteException;
}
