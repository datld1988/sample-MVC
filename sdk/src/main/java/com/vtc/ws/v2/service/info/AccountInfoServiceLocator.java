/**
 * AccountInfoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.service.info;

import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;

//@Configuration
//@PropertySource("classpath:config/server.properties")
public class AccountInfoServiceLocator extends org.apache.axis.client.Service implements com.vtc.ws.v2.service.info.AccountInfoService {
	private static final long serialVersionUID = 1L;
	private ISysConfig sysConfig;

	public AccountInfoServiceLocator() {
		
	}
	public AccountInfoServiceLocator(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
		BasicHttpBinding_IAccountInfoService_address = sysConfig.getBillingInfoAddress();
    }


    public AccountInfoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountInfoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IAccountInfoService
//    private java.lang.String BasicHttpBinding_IAccountInfoService_address = "http://117.103.207.22/accountservice/Service/AccountInfoService.svc";
    private java.lang.String BasicHttpBinding_IAccountInfoService_address;

    public java.lang.String getBasicHttpBinding_IAccountInfoServiceAddress() {
        return BasicHttpBinding_IAccountInfoService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IAccountInfoServiceWSDDServiceName = "BasicHttpBinding_IAccountInfoService";

    public java.lang.String getBasicHttpBinding_IAccountInfoServiceWSDDServiceName() {
        return BasicHttpBinding_IAccountInfoServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IAccountInfoServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IAccountInfoServiceWSDDServiceName = name;
    }

    public com.vtc.ws.v2.service.info.IAccountInfoService getBasicHttpBinding_IAccountInfoService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IAccountInfoService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IAccountInfoService(endpoint);
    }

    public com.vtc.ws.v2.service.info.IAccountInfoService getBasicHttpBinding_IAccountInfoService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.vtc.ws.v2.service.info.BasicHttpBinding_IAccountInfoServiceStub _stub = new com.vtc.ws.v2.service.info.BasicHttpBinding_IAccountInfoServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IAccountInfoServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IAccountInfoServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IAccountInfoService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.vtc.ws.v2.service.info.IAccountInfoService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.vtc.ws.v2.service.info.BasicHttpBinding_IAccountInfoServiceStub _stub = new com.vtc.ws.v2.service.info.BasicHttpBinding_IAccountInfoServiceStub(new java.net.URL(BasicHttpBinding_IAccountInfoService_address), this);
                _stub.setPortName(getBasicHttpBinding_IAccountInfoServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IAccountInfoService".equals(inputPortName)) {
            return getBasicHttpBinding_IAccountInfoService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "AccountInfoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IAccountInfoService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IAccountInfoService".equals(portName)) {
            setBasicHttpBinding_IAccountInfoServiceEndpointAddress(address);
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
