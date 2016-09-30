/**
 * AccountUpdateServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.update;

public class AccountUpdateServiceLocator extends org.apache.axis.client.Service implements AccountUpdateService {

    public AccountUpdateServiceLocator() {
    }


    public AccountUpdateServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountUpdateServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IAccountUpdateService
    private java.lang.String BasicHttpBinding_IAccountUpdateService_address = "http://sandbox.vtcgame.vn/billing2.0/accountservice/Service/AccountUpdateService.svc";

    public java.lang.String getBasicHttpBinding_IAccountUpdateServiceAddress() {
        return BasicHttpBinding_IAccountUpdateService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IAccountUpdateServiceWSDDServiceName = "BasicHttpBinding_IAccountUpdateService";

    public java.lang.String getBasicHttpBinding_IAccountUpdateServiceWSDDServiceName() {
        return BasicHttpBinding_IAccountUpdateServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IAccountUpdateServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IAccountUpdateServiceWSDDServiceName = name;
    }

    public IAccountUpdateService getBasicHttpBinding_IAccountUpdateService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IAccountUpdateService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IAccountUpdateService(endpoint);
    }

    public IAccountUpdateService getBasicHttpBinding_IAccountUpdateService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            BasicHttpBinding_IAccountUpdateServiceStub _stub = new BasicHttpBinding_IAccountUpdateServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IAccountUpdateServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IAccountUpdateServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IAccountUpdateService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IAccountUpdateService.class.isAssignableFrom(serviceEndpointInterface)) {
                BasicHttpBinding_IAccountUpdateServiceStub _stub = new BasicHttpBinding_IAccountUpdateServiceStub(new java.net.URL(BasicHttpBinding_IAccountUpdateService_address), this);
                _stub.setPortName(getBasicHttpBinding_IAccountUpdateServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IAccountUpdateService".equals(inputPortName)) {
            return getBasicHttpBinding_IAccountUpdateService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "AccountUpdateService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IAccountUpdateService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IAccountUpdateService".equals(portName)) {
            setBasicHttpBinding_IAccountUpdateServiceEndpointAddress(address);
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

}
