/**
 * AuthenServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.authen;

import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;

public class AuthenServiceLocator extends org.apache.axis.client.Service implements com.vtc.ws.v2.service.authen.AuthenService {

	private ISysConfig sysConfig;
	public AuthenServiceLocator(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
		BasicHttpBinding_IAuthenService_address = sysConfig.getBillingAuthenAddress();
    }
    public AuthenServiceLocator() {
    }


    public AuthenServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthenServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IAuthenService
//    private java.lang.String BasicHttpBinding_IAuthenService_address = "http://sandbox.vtcgame.vn/billing2.0/accountservice/Service/AuthenService.svc";
    private java.lang.String BasicHttpBinding_IAuthenService_address;

    public java.lang.String getBasicHttpBinding_IAuthenServiceAddress() {
        return BasicHttpBinding_IAuthenService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IAuthenServiceWSDDServiceName = "BasicHttpBinding_IAuthenService";

    public java.lang.String getBasicHttpBinding_IAuthenServiceWSDDServiceName() {
        return BasicHttpBinding_IAuthenServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IAuthenServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IAuthenServiceWSDDServiceName = name;
    }

    public com.vtc.ws.v2.service.authen.IAuthenService getBasicHttpBinding_IAuthenService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IAuthenService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IAuthenService(endpoint);
    }

    public com.vtc.ws.v2.service.authen.IAuthenService getBasicHttpBinding_IAuthenService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.vtc.ws.v2.service.authen.BasicHttpBinding_IAuthenServiceStub _stub = new com.vtc.ws.v2.service.authen.BasicHttpBinding_IAuthenServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IAuthenServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IAuthenServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IAuthenService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.vtc.ws.v2.service.authen.IAuthenService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.vtc.ws.v2.service.authen.BasicHttpBinding_IAuthenServiceStub _stub = new com.vtc.ws.v2.service.authen.BasicHttpBinding_IAuthenServiceStub(new java.net.URL(BasicHttpBinding_IAuthenService_address), this);
                _stub.setPortName(getBasicHttpBinding_IAuthenServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IAuthenService".equals(inputPortName)) {
            return getBasicHttpBinding_IAuthenService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "AuthenService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IAuthenService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IAuthenService".equals(portName)) {
            setBasicHttpBinding_IAuthenServiceEndpointAddress(address);
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
