package com.vtc.serviceproxy.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtc.business.CommonUtils;
import com.vtc.config.ISysConfig;
import com.vtc.dataconstant.DataConstants;
import com.vtc.request.GamePaymentRequest;
import com.vtc.response.GamePaymentResponseData;
import com.vtc.serviceproxy.GamePaymentService;

@Service
public class GamePaymentServiceImpl implements GamePaymentService {

	@Autowired
	private ISysConfig sysConfig;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Override
	public GamePaymentResponseData transactionPayment(GamePaymentRequest request) throws IOException, NoSuchAlgorithmException {
		GamePaymentResponseData response = new GamePaymentResponseData();
		String jsonBody = "";
		if(StringUtils.isEmpty(request.getFunctionName())){
			return response;
		}
		
		if(request.getFunctionName().equals(DataConstants.GamePaymentFunctionName.CREATE)){
			jsonBody = request.toJsonCreateOrder();
		}else if(request.getFunctionName().equals(DataConstants.GamePaymentFunctionName.UPDATE)){
			jsonBody = request.toJsonUpdateOrder();
		} else{
			return response;
		}
		
		String endpoint = sysConfig.getGamePaymentEndPoint();
		String signSecretKey = sysConfig.getGamePaymentSignSecretKey();
		String hashMd5 = commonUtils.hashMD5(new StringBuffer(jsonBody.trim().toLowerCase()).append(signSecretKey).toString());
		
		HttpURLConnection conn = commonUtils.createHttpPost(new StringBuffer(endpoint).append(hashMd5).toString(), jsonBody);
		
		int responseCode = conn.getResponseCode();
//		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			InputStream in = new BufferedInputStream(conn.getInputStream());
	        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
	        response = commonUtils.jsonStringToObject(result, GamePaymentResponseData.class);

	        in.close();
		} else if(responseCode == HttpURLConnection.HTTP_INTERNAL_ERROR){
			response.setResponseCode(responseCode);
		}
		conn.disconnect();
		
		return response;
	}

	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}

	public CommonUtils getCommonUtils() {
		return commonUtils;
	}

	public void setCommonUtils(CommonUtils commonUtils) {
		this.commonUtils = commonUtils;
	}

}
