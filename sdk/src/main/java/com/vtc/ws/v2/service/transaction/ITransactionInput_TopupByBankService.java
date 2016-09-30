/**
 * ITransactionInput_TopupByBankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.transaction;

import com.vtc.ws.v2.model.transaction.BankPayment;
import com.vtc.ws.v2.model.transaction.CheckOrderRequestData;
import com.vtc.ws.v2.model.transaction.CheckOrderResponseData;
import com.vtc.ws.v2.model.transaction.TopupByBankCallBackRequestData;
import com.vtc.ws.v2.model.transaction.TopupByBankRequestData;
import com.vtc.ws.v2.model.transaction.TopupByBankResponseData;

public interface ITransactionInput_TopupByBankService extends java.rmi.Remote {
    public BankPayment[] getListBankPayment() throws java.rmi.RemoteException;
    public TopupByBankResponseData topupVcoinByBank(TopupByBankRequestData requestData) throws java.rmi.RemoteException;
    public TopupByBankResponseData topupVcoinByBankCallBack(TopupByBankCallBackRequestData requestData) throws java.rmi.RemoteException;
    public CheckOrderResponseData checkStatusOrder(CheckOrderRequestData requestData) throws java.rmi.RemoteException;
}
