/**
 * AccountOAuthServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.authen;

import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;

public class AccountOAuthServiceLocator extends org.apache.axis.client.Service implements com.vtc.ws.v2.service.authen.AccountOAuthService {
	private ISysConfig sysConfig;
	public AccountOAuthServiceLocator() {
		
	}
	public AccountOAuthServiceLocator(ISysConfig sysConfig) {
		this.setSysConfig(sysConfig);
		BasicHttpBinding_IAccountOAuthService_address = sysConfig.getBillingOauthAddress();
    }

    public AccountOAuthServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IAccountOAuthService
//    private java.lang.String BasicHttpBinding_IAccountOAuthService_address = "http://sandbox.vtcgame.vn/billing2.0/accountservice/Service/AccountOAuthService.svc";
    private java.lang.String BasicHttpBinding_IAccountOAuthService_address;

    public java.lang.String getBasicHttpBinding_IAccountOAuthServiceAddress() {
        return BasicHttpBinding_IAccountOAuthService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IAccountOAuthServiceWSDDServiceName = "BasicHttpBinding_IAccountOAuthService";

    public java.lang.String getBasicHttpBinding_IAccountOAuthServiceWSDDServiceName() {
        return BasicHttpBinding_IAccountOAuthServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IAccountOAuthServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IAccountOAuthServiceWSDDServiceName = name;
    }

    public com.vtc.ws.v2.service.authen.IAccountOAuthService getBasicHttpBinding_IAccountOAuthService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IAccountOAuthService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IAccountOAuthService(endpoint);
    }

    public com.vtc.ws.v2.service.authen.IAccountOAuthService getBasicHttpBinding_IAccountOAuthService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.vtc.ws.v2.service.authen.BasicHttpBinding_IAccountOAuthServiceStub _stub = new com.vtc.ws.v2.service.authen.BasicHttpBinding_IAccountOAuthServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IAccountOAuthServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IAccountOAuthServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IAccountOAuthService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.vtc.ws.v2.service.authen.IAccountOAuthService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.vtc.ws.v2.service.authen.BasicHttpBinding_IAccountOAuthServiceStub _stub = new com.vtc.ws.v2.service.authen.BasicHttpBinding_IAccountOAuthServiceStub(new java.net.URL(BasicHttpBinding_IAccountOAuthService_address), this);
                _stub.setPortName(getBasicHttpBinding_IAccountOAuthServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IAccountOAuthService".equals(inputPortName)) {
            return getBasicHttpBinding_IAccountOAuthService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "AccountOAuthService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IAccountOAuthService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IAccountOAuthService".equals(portName)) {
            setBasicHttpBinding_IAccountOAuthServiceEndpointAddress(address);
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
