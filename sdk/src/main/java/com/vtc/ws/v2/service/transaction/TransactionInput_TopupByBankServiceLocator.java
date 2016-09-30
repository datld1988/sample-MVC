/**
 * TransactionInput_TopupByBankServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.transaction;

import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;

public class TransactionInput_TopupByBankServiceLocator extends org.apache.axis.client.Service implements TransactionInput_TopupByBankService {
	private ISysConfig sysConfig;

    public TransactionInput_TopupByBankServiceLocator() {
    }

    public TransactionInput_TopupByBankServiceLocator(ISysConfig sysConfig) {
		this.setSysConfig(sysConfig);
		BasicHttpBinding_ITransactionInput_TopupByBankService_address = sysConfig.getTopupBankAddress();
	}

    public TransactionInput_TopupByBankServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TransactionInput_TopupByBankServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ITransactionInput_TopupByBankService
//    private java.lang.String BasicHttpBinding_ITransactionInput_TopupByBankService_address = "http://sandbox.vtcgame.vn/billing2.0/transactionservice/Service/TransactionInput_TopupByBankService.svc";
    private java.lang.String BasicHttpBinding_ITransactionInput_TopupByBankService_address;

    public java.lang.String getBasicHttpBinding_ITransactionInput_TopupByBankServiceAddress() {
        return BasicHttpBinding_ITransactionInput_TopupByBankService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ITransactionInput_TopupByBankServiceWSDDServiceName = "BasicHttpBinding_ITransactionInput_TopupByBankService";

    public java.lang.String getBasicHttpBinding_ITransactionInput_TopupByBankServiceWSDDServiceName() {
        return BasicHttpBinding_ITransactionInput_TopupByBankServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_ITransactionInput_TopupByBankServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ITransactionInput_TopupByBankServiceWSDDServiceName = name;
    }

    public ITransactionInput_TopupByBankService getBasicHttpBinding_ITransactionInput_TopupByBankService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ITransactionInput_TopupByBankService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ITransactionInput_TopupByBankService(endpoint);
    }

    public ITransactionInput_TopupByBankService getBasicHttpBinding_ITransactionInput_TopupByBankService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            BasicHttpBinding_ITransactionInput_TopupByBankServiceStub _stub = new BasicHttpBinding_ITransactionInput_TopupByBankServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ITransactionInput_TopupByBankServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ITransactionInput_TopupByBankServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ITransactionInput_TopupByBankService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ITransactionInput_TopupByBankService.class.isAssignableFrom(serviceEndpointInterface)) {
                BasicHttpBinding_ITransactionInput_TopupByBankServiceStub _stub = new BasicHttpBinding_ITransactionInput_TopupByBankServiceStub(new java.net.URL(BasicHttpBinding_ITransactionInput_TopupByBankService_address), this);
                _stub.setPortName(getBasicHttpBinding_ITransactionInput_TopupByBankServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_ITransactionInput_TopupByBankService".equals(inputPortName)) {
            return getBasicHttpBinding_ITransactionInput_TopupByBankService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "TransactionInput_TopupByBankService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_ITransactionInput_TopupByBankService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ITransactionInput_TopupByBankService".equals(portName)) {
            setBasicHttpBinding_ITransactionInput_TopupByBankServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}

}
