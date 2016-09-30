/**
 * ITransactionInput_TopupByCardService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.transaction;

import com.vtc.ws.v2.model.ResponseData;

public interface ITransactionInput_TopupByCardService extends java.rmi.Remote {
    public com.vtc.ws.v2.model.transaction.TopupByCardResponseData topupVcoinByCard(com.vtc.ws.v2.model.transaction.TopupByCardRequestData requestData) throws java.rmi.RemoteException;
    public ResponseData checkCard(com.vtc.ws.v2.model.transaction.CheckCardRequestData requestData) throws java.rmi.RemoteException;
    public com.vtc.ws.v2.model.transaction.CheckCardOrderResponseData checkCardUse(com.vtc.ws.v2.model.transaction.CheckCardOrderRequestData requestData) throws java.rmi.RemoteException;
}
