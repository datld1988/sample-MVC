package com.vtc.serviceproxy.test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.vtc.dataconstant.GaParams;
import com.vtc.serviceproxy.LoadConfig;
import com.vtc.serviceproxy.impl.GaBuilderImpl;
import com.vtc.serviceproxy.impl.GaConfigurationImpl;
import com.vtc.serviceproxy.impl.GaTrackingImpl;
import com.vtc.serviceproxy.impl.LoadConfigImpl;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class GaTrackingTest {
	
	private GaTrackingImpl gaTracking;
	
//	@Spy
	private GaBuilderImpl gaBuilder; 
	
//	@Spy
	private GaConfigurationImpl configuration; 
	
//	@Spy
	private LoadConfig loadConfig; 
	
	@Before
	public void setUp() throws Exception {
		loadConfig = new LoadConfigImpl();
		configuration = new GaConfigurationImpl();
		gaBuilder = new GaBuilderImpl();
		gaTracking = new GaTrackingImpl();
		
		configuration.setConfig(loadConfig);
		gaBuilder.setConfiguration(configuration);
		gaTracking.setBuilder(gaBuilder);
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	@Parameters({
		"payment, ingame, vcoin, 100, Campaign_1708, TTCL_1708, 12floor",
		"inappEvent, firstOpen, , , Campaign_1708, TTCL_1708, 12floor",
		"inappEvent, openApp, , , Campaign_1708, TTCL_1708, 12floor",
		"inappEvent, closeApp, , , Campaign_1708, TTCL_1708, 12floor",
		"inappEvent, installed, , , Campaign_1708, TTCL_1708, 12floor",
	})
	public void HitTypeEvent(String category, String action, String label, String value, String campaign, String source, String medium) throws IOException {
		/**
		 * v=1&t=transaction&tid=UA-80367317-1&cid=b315fa96-28ee-4c6a-b8b4-e9911b2bf161&ti=testrevenue1
		 * &tr=10&cn=1207_dat&cs=chienluoc&medium=12floor
		 */
		
		String gaTrackingId="UA-80367317-1"; 
		String gaClientId= UUID.randomUUID().toString();
		String hitType=GaParams.TypeEventHit.Event;
		Map<String, String> params = new HashMap<>();
		params.put(GaParams.ParamTracking.Category, category);
		params.put(GaParams.ParamTracking.Action, action);
		params.put(GaParams.ParamTracking.Label, label);
		params.put(GaParams.ParamTracking.Value, value);
		params.put(GaParams.ParamTracking.CampaignName, campaign);
		params.put(GaParams.ParamTracking.CampaignSource, source);
		params.put(GaParams.ParamTracking.CampaignMedium, medium);
//		params.put(GaParams.ParamTracking.TransactionId, UUID.randomUUID().toString());
//		params.put(GaParams.ParamTracking.TransactionRevenue, transactionRevenue);
		
		gaTracking.TrackEvent(gaTrackingId, gaClientId, hitType, params);
	}

}
