package com.vtc.serviceproxy.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.vtc.aspect.Loggable;
import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;
import com.vtc.model.UserInfoFb;
import com.vtc.serviceproxy.FacebookService;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookServiceImpl implements FacebookService {
	private static Logger log = Logger.getLogger(FacebookServiceImpl.class);

	@Autowired
	private ISysConfig sysConfig;
	
	@Loggable
	@Override
	public facebook4j.User getUserInfo(String accessToken) throws FacebookException {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true);
//		configurationBuilder.setOAuthAppId(sysConfig.getFacebookAppId());
//		configurationBuilder.setOAuthAppSecret(sysConfig.getFacebookAppSecret());
		configurationBuilder.setOAuthAppId("1547915538819737");
		configurationBuilder.setOAuthAppSecret("23db7dbf6f4a48d6ca4ce10a7c8dad44");
		configurationBuilder.setOAuthAccessToken(accessToken);
//		configurationBuilder.setOAuthPermissions(sysConfig.getFacebookPermissions());
		configurationBuilder.setOAuthPermissions("email, public_profile");
		configurationBuilder.setUseSSL(true);
		configurationBuilder.setJSONStoreEnabled(true);

		Configuration configuration = configurationBuilder.build();
		FacebookFactory ff = new FacebookFactory(configuration);
		Facebook facebook = ff.getInstance();
		facebook4j.User user = null;
		
		user = facebook.getMe();
		
		return user;
	}

	@Loggable
	@Override
	public UserInfoFb getUserInfoByHttp(String accessToken) throws BadCredentialsException, IOException {
		HttpTransport TRANSPORT = new NetHttpTransport();

		HttpResponse revokeResponse =
				TRANSPORT.createRequestFactory().buildGetRequest(new GenericUrl(String.format("https://graph.facebook.com/v2.7/me?access_token=" + accessToken + "&debug=all&fields=ids_for_business,id,email,first_name,gender,last_name,link,locale,middle_name,name,timezone,updated_time,verified&format=json&method=get&pretty=0&suppress_http_code=1"))).execute();
		InputStream in = revokeResponse.getContent();
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while (read != null)
		{
			sb.append(read);
			read = br.readLine();
		}
		
		UserInfoFb fb = new UserInfoFb();
		ObjectMapper om = new ObjectMapper();
		fb = om.readValue(sb.toString(), UserInfoFb.class);
		
		if(fb.getError() != null){
			throw new BadCredentialsException(-190, fb.getError().getMessage());
		}
		
		return fb;
	}

	public ISysConfig getSysConfig() {
		return sysConfig;
	}
	
	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}
}
