package com.vtc.serviceproxy.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.vtc.serviceproxy.GaConfiguration;
import com.vtc.serviceproxy.LoadConfig;

public class GaConfigurationImpl implements GaConfiguration {
	@Autowired
	private LoadConfig config;
	
//	public GaConfigurationImpl(LoadConfig config) {
//		this.config = config;
//	}
	
	@Override
	public String GetApplicationName() throws IOException {
		return config.gaLoadConfig().getProperty("ga.application_name");
	}

	@Override
	public String GetKeyFileLocation() throws IOException {
		return getClass().getClassLoader().getResource(config.gaLoadConfig().getProperty("ga.file_name")).getFile();
	}

	@Override
	public String GetServiceAccountEmail() throws IOException  {
		return config.gaLoadConfig().getProperty("ga.service_account_email");
	}

	@Override
	public String GetViewId() throws IOException  {
		return config.gaLoadConfig().getProperty("ga.view_id");
	}

	@Override
	public JsonFactory GetJsonFactory() {
		return GsonFactory.getDefaultInstance();
	}

	@Override
	public String GetUrlEndpointSingle() throws IOException {
		return config.gaLoadConfig().getProperty("ga.endpoint_single");
	}

	@Override
	public String GetContentType() throws IOException {
		return config.gaLoadConfig().getProperty("ga.header_contentType");
	}

	public LoadConfig getConfig() {
		return config;
	}

	public void setConfig(LoadConfig config) {
		this.config = config;
	}

}
