package com.vtc.serviceproxy.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.vtc.serviceproxy.LoadConfig;

public class LoadConfigImpl implements LoadConfig {
	
	public LoadConfigImpl(){
	}
	
	@Override
	public Properties gaLoadConfig() throws IOException {
		Properties result = new Properties();
		InputStream input = getClass().getResourceAsStream("/ga/ga.properties");
		result.load(input);
		
		return result;
	}
	
	public Properties googleIAPConfig() throws IOException {
		Properties result = new Properties();
		InputStream input = getClass().getResourceAsStream("/googleiap/googleiap.properties");
		result.load(input);
		
		return result;
	}

}
