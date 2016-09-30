package com.vtc.serviceproxy.test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vtc.serviceproxy.LoadConfig;
import com.vtc.serviceproxy.impl.GaBuilderImpl;
import com.vtc.serviceproxy.impl.GaConfigurationImpl;
import com.vtc.serviceproxy.impl.LoadConfigImpl;

public class GaBuilderTest {

	private LoadConfig loadConfig = new LoadConfigImpl();
	private GaConfigurationImpl configuration = new GaConfigurationImpl();
	
	private GaBuilderImpl builder = new GaBuilderImpl();
	
	@Before
	public void setUp() throws Exception {
		configuration.setConfig(loadConfig);
		builder.setConfiguration(configuration);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getPostData() {
		Map<String, String> map = new HashMap<>();
		map.put("a1", "valueA1");
		map.put("a2", "3");
		map.put("a3", "3.5");
		
		builder.getPostData(map);
	}

}
