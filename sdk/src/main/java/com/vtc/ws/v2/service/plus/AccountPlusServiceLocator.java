/**
 * AccountPlusServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.plus;

public class AccountPlusServiceLocator extends org.apache.axis.client.Service implements AccountPlusService {

    public AccountPlusServiceLocator() {
    }


    public AccountPlusServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountPlusServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IAccountPlusService
    private java.lang.String BasicHttpBinding_IAccountPlusService_address = "http://sandbox.vtcgame.vn/billing2.0/accountservice/Service/AccountPlusService.svc";

    public java.lang.String getBasicHttpBinding_IAccountPlusServiceAddress() {
        return BasicHttpBinding_IAccountPlusService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IAccountPlusServiceWSDDServiceName = "BasicHttpBinding_IAccountPlusService";

    public java.lang.String getBasicHttpBinding_IAccountPlusServiceWSDDServiceName() {
        return BasicHttpBinding_IAccountPlusServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IAccountPlusServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IAccountPlusServiceWSDDServiceName = name;
    }

    public IAccountPlusService getBasicHttpBinding_IAccountPlusService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IAccountPlusService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IAccountPlusService(endpoint);
    }

    public IAccountPlusService getBasicHttpBinding_IAccountPlusService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            BasicHttpBinding_IAccountPlusServiceStub _stub = new BasicHttpBinding_IAccountPlusServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IAccountPlusServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IAccountPlusServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IAccountPlusService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IAccountPlusService.class.isAssignableFrom(serviceEndpointInterface)) {
                BasicHttpBinding_IAccountPlusServiceStub _stub = new BasicHttpBinding_IAccountPlusServiceStub(new java.net.URL(BasicHttpBinding_IAccountPlusService_address), this);
                _stub.setPortName(getBasicHttpBinding_IAccountPlusServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IAccountPlusService".equals(inputPortName)) {
            return getBasicHttpBinding_IAccountPlusService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "AccountPlusService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IAccountPlusService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IAccountPlusService".equals(portName)) {
            setBasicHttpBinding_IAccountPlusServiceEndpointAddress(address);
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
