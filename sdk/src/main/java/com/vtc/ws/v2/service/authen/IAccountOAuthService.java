/**
 * IAccountOAuthService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.authen;

public interface IAccountOAuthService extends java.rmi.Remote {
    public com.vtc.ws.v2.model.authen.OAuthResponseData OAuthentication(com.vtc.ws.v2.model.authen.OAuthRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.authen.OAuthCreateResponseData createAccountOAuth(com.vtc.ws.v2.model.authen.OAuthCreateRequestData requestData) throws java.rmi.RemoteException;
}
