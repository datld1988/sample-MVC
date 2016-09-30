package com.vtc.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.vtc.aspect.Loggable;
import com.vtc.config.RedisTokenStore;
import com.vtc.dataconstant.DataConstants;

public class CommonController {

	private static final Logger log = Logger.getLogger(CommonController.class);

	@Autowired
	private RedisTokenStore tokenStore;

	@Autowired
	private HttpServletRequest httpRequest;

	public String getIp() {
		return httpRequest.getRemoteAddr();
	}
	
	@Loggable
	public boolean validateToken() {
		String tokenKey = httpRequest.getParameter(DataConstants.RequestParams.AccessToken);
		String accountName = httpRequest.getParameter(DataConstants.RequestParams.UserName);

		if (accountName == null) {
			log.error("user_name is null");
			return false;
		}
		if (tokenKey == null) {
			log.error("token_key is null");
			return false;
		}
		Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByUserName(accountName);

		if (tokens == null || tokens.size() == 0) {
			log.error("Not exist token.");
			return false;
		}

		boolean valid = false;
		for (OAuth2AccessToken token : tokens) {
			if (token.getValue().equals(tokenKey)) {
				valid = true;
			}
		}
		return valid;
	}

	public RedisTokenStore getTokenStore() {
		return tokenStore;
	}

	public void setTokenStore(RedisTokenStore tokenStore) {
		this.tokenStore = tokenStore;
	}

	public String normalizePhone(String phone) {
		if (phone == null) {
			return null;
		}
		phone.trim();

		phone = phone.replaceAll("\\s", "");
		while (phone.startsWith("+")) {
			phone = new String(phone.toString().substring(1));
		}
		if (phone.indexOf("84") == 0) {
			phone = phone.replaceFirst("84", "0");
		}
		System.out.println(phone);
		if (phone.matches("^\\s*\\d+\\s*$")) {

			System.out.println("match" + phone);
			if (phone.length() == 10 || phone.length() == 11) {
				System.out.println("lenght correct ");
			} else {
				System.out.println("lenght not correct !");
				return null;
			}
		} else {
			System.out.println("Char not allowed !");
			return null;
		}

		return phone;
	}

	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}
}

