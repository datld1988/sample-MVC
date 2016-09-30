package com.vtc.serviceproxy.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtc.model.KeyValueModel;
import com.vtc.serviceproxy.impl.LoadConfigImpl;

public class GaConfigurationTest{
	public LoadConfigImpl config;
	
	@Before
	public void setUp() throws Exception {
		config = new LoadConfigImpl();
	}

	@Test
	public void loadConfig() {
		Properties prop = new Properties();
		try {
			prop = config.gaLoadConfig();
			Assert.assertEquals(prop.getProperty("ga.view_id"), "119839357"); //102284901
			Assert.assertEquals(prop.getProperty("ga.service_account_email"), "sdk-ga@mini-sport-news.iam.gserviceaccount.com");
			Assert.assertEquals(prop.getProperty("ga.file_name"), "ga/3ba5ecf84fa6.p12");
			Assert.assertEquals(prop.getProperty("ga.application_name"), "GA Reporting");
			Assert.assertEquals(prop.getProperty("ga.endpoint_single"), "https://www.google-analytics.com/collect");
		} catch (IOException e) {
			System.out.println(e.toString());
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void SomeMethod() throws JsonParseException, JsonMappingException, IOException {
		String str = "[{\"key\":\"100000\", \"value\":\"0544ed93c22d5e1c869010c4515a7401\"}, {\"key\":\"87687\",\"value\":\"adfadsf2\"}]";
		ObjectMapper mapper = new ObjectMapper();
		
		
		List<KeyValueModel> list = mapper.readValue(str, mapper.getTypeFactory().constructCollectionType(List.class, KeyValueModel.class));
		
		
		System.out.println(list.stream().filter(x -> Integer.valueOf(x.getKey()).compareTo(new Integer("100000"))==0).findFirst().get().getValue());
	}

}
