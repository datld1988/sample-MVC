package com.vtc.business.impl.test;

import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtc.business.impl.CommonUtilsImpl;
import com.vtc.business.impl.ServiceUtilsImpl;
import com.vtc.config.SysConfig;
import com.vtc.request.AccountRegisterRequest;
import com.vtc.util.DateUtil;

public class ServiceUtilsTest {

	private ServiceUtilsImpl serviceUtils = new ServiceUtilsImpl();
	private CommonUtilsImpl commonUtils = new CommonUtilsImpl(); 
	
	@Autowired
	private SysConfig sysConfig;
	
	@Before
	public void setUp() throws Exception {
		commonUtils.setSysConfig(sysConfig);
		serviceUtils.setCommonUtils(commonUtils);
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void test() {
		AccountRegisterRequest request = new AccountRegisterRequest();
		request.setUtm("democlpt://?utm_source=facebook&utm_campaign=demo&utm_medium=1706");
		request = (AccountRegisterRequest) serviceUtils.modifyRequest(request);
		
		Assert.assertNotNull(request);
		Assert.assertTrue(request.getCampaign().equals("demo"));
		Assert.assertTrue(request.getTrackingModel().getCampaignName().equals("demo"));
	}
	
//	@Test
	public void TestJsonObject() throws JsonProcessingException{
		AccountRegisterRequest request = new AccountRegisterRequest();
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(request);
		System.out.println(str);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong("1470208047539"));
		System.out.println(DateUtil.toString(c, DateUtil.PATTERN_YYYYMMDD_T_HHMMSS_Z));
	}
	
	@Test
	public void generateMapClientIdByGame(){
		String gameCode = "HOATHIENCOT";
		String partnerCode = "NATIVESDK";
		String sdkKeySign = "11111990";
		String data = new StringBuffer(gameCode).append(partnerCode).append(sdkKeySign).toString();
		String key = commonUtils.hashMD5(data);
		String value = commonUtils.hashMD5(commonUtils.base64(data));
		System.out.println("Key:" + key);
		System.out.println("Value:" + value);
	}

}
