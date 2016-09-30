package com.vtc.ws.v2.service.transaction;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.vtc.ws.v2.model.transaction.TransactionOutputRequestData;
import com.vtc.ws.v2.model.transaction.TransactionOutputResponseData;

public class ITransactionOutput_DeductVcoinServiceProxy 
		implements com.vtc.ws.v2.service.transaction.ITransactionOutput_DeductVcoinService{

	private String _endpoint = null;
	private com.vtc.ws.v2.service.transaction.ITransactionOutput_DeductVcoinService iTransactionOutput_DeductVcoinService = null;

	public ITransactionOutput_DeductVcoinServiceProxy() {
		_initITransactionOutput_DeductVcoinServiceProxy();
	}

	public ITransactionOutput_DeductVcoinServiceProxy(String endpoint) {
		_endpoint = endpoint;
		_initITransactionOutput_DeductVcoinServiceProxy();
	}

	private void _initITransactionOutput_DeductVcoinServiceProxy() {
		try {
			iTransactionOutput_DeductVcoinService 
				= (new com.vtc.ws.v2.service.transaction.TransactionOutput_DeductVcoinServiceLocator())
					.getBasicHttpBinding_ITransactionOutput_DeductVcoinService();
			if(iTransactionOutput_DeductVcoinService != null) {
				if(_endpoint != null) {
					((javax.xml.rpc.Stub)iTransactionOutput_DeductVcoinService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
				} else {
					_endpoint = (String)((javax.xml.rpc.Stub)iTransactionOutput_DeductVcoinService)._getProperty("javax.xml.rpc.service.endpoint.address");
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TransactionOutputResponseData transactionDeductVcoin(
			TransactionOutputRequestData requestData) throws RemoteException {
		if (iTransactionOutput_DeductVcoinService == null) {
			_initITransactionOutput_DeductVcoinServiceProxy();
		}
		return iTransactionOutput_DeductVcoinService.transactionDeductVcoin(requestData);
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (iTransactionOutput_DeductVcoinService != null)
			((javax.xml.rpc.Stub) iTransactionOutput_DeductVcoinService)
				._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	}
}
