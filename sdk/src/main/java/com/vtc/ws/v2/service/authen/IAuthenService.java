/**
 * IAuthenService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.authen;

public interface IAuthenService extends java.rmi.Remote {
    public com.vtc.ws.v2.model.authen.AuthenResponseData authentication(com.vtc.ws.v2.model.authen.AuthenRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.authen.AuthenResponseData reAuthen(com.vtc.ws.v2.model.authen.ReAuthenRequestData requestData) throws java.rmi.RemoteException;
}
