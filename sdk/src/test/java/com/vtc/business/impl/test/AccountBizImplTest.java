package com.vtc.business.impl.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import javax.xml.rpc.ServiceException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vtc.business.AccountService;
import com.vtc.business.CommonUtils;
import com.vtc.business.ModelUtils;
import com.vtc.business.impl.AccountServiceImpl;
import com.vtc.dataconstant.DataConstants;
import com.vtc.mongocore.Events;
import com.vtc.mongocore.LoginData;
import com.vtc.mongorepository.EventsRepository;
import com.vtc.request.AuthenticationRequest;
import com.vtc.serviceproxy.GaTracking;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.service.BillingService;

public class AccountBizImplTest {

	private AccountService accountBiz;

	@Mock
	private BillingService billingService;
	@Mock
	private GaTracking gaTracking;
	@Mock
	private CommonUtils commonUtils;
	@Mock
	private EventsRepository eventsRepository;
	@Mock
	private ModelUtils modelUtils;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
//		accountBiz = new AccountBizImpl(billingService, gaTracking, commonUtils, eventsRepository, modelUtils);
	}

//	@Test
	public void AuthenLoginVTC_ServiceIdInvalid_ReturnNull()
			throws JsonParseException, JsonMappingException, IOException, ServiceException {
		Mockito.when(commonUtils.findServiceKeyById(Mockito.anyInt())).thenReturn("");

		AuthenResponseData response = accountBiz.authenLoginVTC(new AuthenticationRequest());
		Assert.assertEquals(response.getResponseCode(), null);
	}

//	@Test
	public void AuthenLoginVTC_CallBillingAuthen_ResponseCodeLargerThanZero()
			throws JsonParseException, JsonMappingException, IOException, ServiceException {
//		accountBiz = new AccountBizImpl(billingService, gaTracking, new CommonUtilsImpl(), eventsRepository, modelUtils);
		AuthenticationRequest request = createRequestData();
		AuthenResponseData responseData = new AuthenResponseData();
		responseData.setResponseCode(new Integer(1));

		LoginData loginData = new LoginData();
		Events<LoginData> event = new Events<LoginData>();
		String serviceKey = "abc";

		Mockito.when(commonUtils.findServiceKeyById(request.getServiceId())).thenReturn(serviceKey);
//		Mockito.when(modelUtils.CreateLoginData(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(),
//				Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyString()))
//				.thenReturn(loginData);
//		Mockito.when(modelUtils.CreateEventLogin(DataConstants.EventTypeLoginByVTC, request.getClientId(),
//				request.getDeviceType(), request.getCampaign(), request.getMedium(), request.getSource(),
//				request.getAgency(), request.getAccountName(), "", loginData))
//				.thenReturn(event);
		Mockito.when(billingService.authen(request.getAccountName(), request.getClientIp(), request.getDeviceType(),
				request.getPassword(), request.getSecureCode(), request.getSecureType(), request.getServiceId(), "abc"))
				.thenReturn(responseData);

		AuthenResponseData response = accountBiz.authenLoginVTC(request);

		Mockito.verify(commonUtils, Mockito.times(1)).findServiceKeyById(request.getServiceId());
		Mockito.verify(gaTracking, Mockito.times(1)).TrackEvent(request.getTrackingModel().getGaTrackingId(), request.getTrackingModel().getGaClientId(), request.getTrackingModel().getHitType(),
				new HashMap<>());
//		Mockito.verify(modelUtils, Mockito.times(1)).CreateLoginData(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(),
//				Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyString());
//		Mockito.verify(modelUtils, Mockito.times(1)).CreateEventLogin(DataConstants.EventTypeLoginByVTC, request.getClientId(),
//				request.getDeviceType(), request.getCampaign(), request.getMedium(), request.getSource(),
//				request.getAgency(), request.getAccountName(), "", loginData);		
		Mockito.verify(eventsRepository, Mockito.times(1)).save(event);
		Assert.assertEquals(response, responseData);
	}

	public AuthenticationRequest createRequestData() {
		AuthenticationRequest request = new AuthenticationRequest();

		request.setCampaign("TestCampaign");
		request.setMedium("TestMedium");
		request.setSource("TestSource");
		request.setAgency("TestAgency");
		request.setClientId("5555");
		request.setAccountName("AccountName");
		request.setClientIp("ClientIp");
		request.setDeviceType(new Integer(1));
		request.setPassword("123");
		request.setSecureCode("secureCode");
		request.setSecureType(new Integer(0));
		request.setServiceId(new Integer("100000"));
//		request.setGaTrackingId("UA-59062861-18");
//		request.setEventCategory("TestCategory");
//		request.setEventAction("TestAction");
//		request.setEventLabel("TestLabel");

		return request;
	}
}
