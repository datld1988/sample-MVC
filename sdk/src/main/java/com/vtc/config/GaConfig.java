package com.vtc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

@Configuration
@PropertySource("classpath:ga/ga.properties")
public class GaConfig {
	@Value("${ga.application_name}")
	private String applicationName;
	
	@Value("${ga.file_name}")
	private String keyFileLocation;
	
	@Value("${ga.service_account_email}")
	private String serviceAccountEmail;
	
	@Value("${ga.view_id}")
	private String viewId;
	
	@Value("${ga.endpoint_single}")
	private String urlEndpointSingle;
	
	@Value("${ga.header_contentType}")
	private String contentType;
	
	public GaConfig() {
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getKeyFileLocation() {
		return keyFileLocation;
	}

	public void setKeyFileLocation(String keyFileLocation) {
		this.keyFileLocation = keyFileLocation;
	}

	public String getServiceAccountEmail() {
		return serviceAccountEmail;
	}

	public void setServiceAccountEmail(String serviceAccountEmail) {
		this.serviceAccountEmail = serviceAccountEmail;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	public String getUrlEndpointSingle() {
		return urlEndpointSingle;
	}

	public void setUrlEndpointSingle(String urlEndpointSingle) {
		this.urlEndpointSingle = urlEndpointSingle;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public JsonFactory getJsonFactory() {
		return GsonFactory.getDefaultInstance();
	}
}
