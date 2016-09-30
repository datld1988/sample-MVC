package com.vtc.ws.v2.service.transaction;

import com.vtc.config.ISysConfig;

public class TransactionOutput_DeductVcoinServiceLocator extends org.apache.axis.client.Service implements com.vtc.ws.v2.service.transaction.TransactionOutput_DeductVcoinService {

	private ISysConfig sysConfig;

	public TransactionOutput_DeductVcoinServiceLocator() {
	}

	public TransactionOutput_DeductVcoinServiceLocator(ISysConfig sysConfig) {
		this.setSysConfig(sysConfig);
		BasicHttpBinding_ITransactionOutput_DeductVcoinService_address = sysConfig.getDeductVcoinAddress();
	}

	public TransactionOutput_DeductVcoinServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public TransactionOutput_DeductVcoinServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for
	// BasicHttpBinding_ITransactionInput_TopupByVTCPayService
	// private java.lang.String
	// BasicHttpBinding_ITransactionInput_TopupByVTCPayService_address =
	// "http://sandbox.vtcgame.vn/billing2.0/transactionservice/Service/TransactionInput_TopupByVTCPayService.svc";
	private java.lang.String BasicHttpBinding_ITransactionOutput_DeductVcoinService_address;

	public java.lang.String getBasicHttpBinding_ITransactionOutput_DeductVcoinServiceAddress() {
		return BasicHttpBinding_ITransactionOutput_DeductVcoinService_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String BasicHttpBinding_ITransactionOutput_DeductVcoinServiceWSDDServiceName = "BasicHttpBinding_ITransactionOutput_DeductVcoinService";

	public java.lang.String getBasicHttpBinding_ITransactionOutput_DeductVcoinServiceWSDDServiceName() {
		return BasicHttpBinding_ITransactionOutput_DeductVcoinServiceWSDDServiceName;
	}

	public void setBasicHttpBinding_ITransactionOutput_DeductVcoinServiceWSDDServiceName(java.lang.String name) {
		BasicHttpBinding_ITransactionOutput_DeductVcoinServiceWSDDServiceName = name;
	}

	public com.vtc.ws.v2.service.transaction.ITransactionOutput_DeductVcoinService getBasicHttpBinding_ITransactionOutput_DeductVcoinService()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(BasicHttpBinding_ITransactionOutput_DeductVcoinService_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getBasicHttpBinding_ITransactionOutput_DeductVcoinService(endpoint);
	}

	public com.vtc.ws.v2.service.transaction.ITransactionOutput_DeductVcoinService getBasicHttpBinding_ITransactionOutput_DeductVcoinService(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			com.vtc.ws.v2.service.transaction.BasicHttpBinding_ITransactionOutput_DeductVcoinServiceStub _stub = new com.vtc.ws.v2.service.transaction.BasicHttpBinding_ITransactionOutput_DeductVcoinServiceStub(
					portAddress, this);
			_stub.setPortName(getBasicHttpBinding_ITransactionOutput_DeductVcoinServiceWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setBasicHttpBinding_ITransactionOutput_DeductVcoinServiceEndpointAddress(java.lang.String address) {
		BasicHttpBinding_ITransactionOutput_DeductVcoinService_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (com.vtc.ws.v2.service.transaction.ITransactionOutput_DeductVcoinService.class
					.isAssignableFrom(serviceEndpointInterface)) {
				com.vtc.ws.v2.service.transaction.BasicHttpBinding_ITransactionOutput_DeductVcoinServiceStub _stub = new com.vtc.ws.v2.service.transaction.BasicHttpBinding_ITransactionOutput_DeductVcoinServiceStub(
						new java.net.URL(BasicHttpBinding_ITransactionOutput_DeductVcoinService_address), this);
				_stub.setPortName(getBasicHttpBinding_ITransactionOutput_DeductVcoinServiceWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("BasicHttpBinding_ITransactionOutput_DeductVcoinService".equals(inputPortName)) {
			return getBasicHttpBinding_ITransactionOutput_DeductVcoinService();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://tempuri.org/", "TransactionOutput_DeductVcoinService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://tempuri.org/",
					"BasicHttpBinding_ITransactionOutput_DeductVcoinService"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {

		if ("BasicHttpBinding_ITransactionOutput_DeductVcoinService".equals(portName)) {
			setBasicHttpBinding_ITransactionOutput_DeductVcoinServiceEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}
//	@Override
//	public String getBasicHttpBinding_ITransactionOutput_DeductVcoinServiceAddress() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ITransactionOutput_DeductVcoinService getBasicHttpBinding_ITransactionOutput_DeductVcoinService()
//			throws ServiceException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ITransactionOutput_DeductVcoinService getBasicHttpBinding_ITransactionOutput_DeductVcoinService(
//			URL portAddress) throws ServiceException {
//		
//		return null;
//	}

}
