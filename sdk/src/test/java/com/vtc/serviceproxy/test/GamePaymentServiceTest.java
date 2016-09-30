package com.vtc.serviceproxy.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtc.business.impl.CommonUtilsImpl;
import com.vtc.config.SysConfig;
import com.vtc.request.GamePaymentRequest;
import com.vtc.response.GamePaymentResponseData;
import com.vtc.serviceproxy.impl.GamePaymentServiceImpl;
import com.vtc.util.DateUtil;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:WEB-INF/spring-di.xml" })
public class GamePaymentServiceTest {
	private  GamePaymentServiceImpl gamePaymentService = new GamePaymentServiceImpl();
	
	@Autowired
	private SysConfig sysConfig;
	
	@Autowired
	private CommonUtilsImpl commonUtils;
	
	@Before
	public void setUp() throws Exception {
		gamePaymentService.setSysConfig(sysConfig);
		gamePaymentService.setCommonUtils(commonUtils);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Test(){
		System.out.println(DateUtil.toString(Calendar.getInstance(), DateUtil.PATTERN_YYYYMMDD_T_HHMMSS_Z)); 
	}
	
//	@Test
	public void gamePayment() {
		GamePaymentRequest request = new GamePaymentRequest();
		request.setAccountName("vtctest90");
		request.setAccountId(new Integer("117813858"));
		request.setToAccountName("vtctest90");
		request.setPartnerCode("Software");
		request.setAmount(new Integer(2000));
		request.setPartnerAmount(new Integer(200));
		request.setServerGame("ServerGame1");
		request.setFromIp("::1");
		request.setGameCode("VANTRUNGCA");
		request.setPaymentType("BUYVCOIN");
		request.setBillingAccessToken("636050554250070000.b7502cd99c7ec5efd9eb66090a9eb2ed");
		request.setFunctionName("CREATE");
		request.setPaymentFrom("VTC");
		request.setDescription("Dich vu nap tien game");
		GamePaymentResponseData response = null;
		try {
//			GamePaymentResponseData response = new GamePaymentResponseData();
			String jsonBody = request.toJsonCreateOrder();
			
			String endpoint = "http://sandbox3.vtcebank.vn/PaymentGames/GamesPayment.aspx?Sign=";//sysConfig.getGamePaymentEndPoint();
			String signSecretKey = "123456";//sysConfig.getSignSecretKey();
			String hashMd5 = commonUtils.hashMD5(new StringBuffer(jsonBody).append(signSecretKey).toString());
			
			URL url = new URL(new StringBuffer(endpoint).append(hashMd5).toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30000);
			conn.setDoOutput(true);
//			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("POST");
			
			
			OutputStream os = conn.getOutputStream();
			os.write(jsonBody.getBytes("UTF-8"));
			os.flush();
			
			InputStream in = new BufferedInputStream(conn.getInputStream());
	        String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
			
			
//			response = gamePaymentService.transactionPayment(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commonUtils.toJsonString(response);
	}

}
