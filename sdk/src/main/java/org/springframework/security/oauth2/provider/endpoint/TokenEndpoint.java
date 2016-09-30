/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.oauth2.provider.endpoint;

import java.security.MessageDigest;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.VtcOAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.DefaultAuthorizationRequest;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtc.aspect.Loggable;
import com.vtc.aspect.LoggableServlet;
import com.vtc.business.GameService;
import com.vtc.dataconstant.DataConstants;
import com.vtc.response.ResponseModel;
import com.vtc.service.impl.CustomUserDetailsService;
import com.vtc.util.MathUtil;
import com.vtc.util.PConstants;

/**
 * <p>
 * Endpoint for token requests as described in the OAuth2 spec. Clients post requests with a <code>grant_type</code>
 * parameter (e.g. "authorization_code") and other parameters as determined by the grant type. Supported grant types are
 * handled by the provided {@link #setTokenGranter(org.springframework.security.oauth2.provider.TokenGranter) token
 * granter}.
 * </p>
 * 
 * <p>
 * Clients must be authenticated using a Spring Security {@link Authentication} to access this endpoint, and the client
 * id is extracted from the authentication token. The best way to arrange this (as per the OAuth2 spec) is to use HTTP
 * basic authentication for this endpoint with standard Spring Security support.
 * </p>
 * 
 * @author Dave Syer
 * 
 */
@FrameworkEndpoint
@RequestMapping(value = "/oauth/token")
public class TokenEndpoint extends AbstractEndpoint {

	@Value("${sha.salt}")
	private String shaSalt;

	@Autowired
	private HttpServletRequest httpRequest;

	//	@Autowired
//	private RedisTokenStore tokenStore;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private GameService gameService;

	@LoggableServlet
	@RequestMapping
	public ResponseEntity<ResponseModel> getAccessToken(Principal principal,
			@RequestParam("grant_type") String grantType, @RequestParam Map<String, String> parameters) {
		VtcOAuth2AccessToken result = new VtcOAuth2AccessToken();
		ResponseModel response = new ResponseModel();
//		Integer otpCheck = 1;
		try {
			if (!(principal instanceof Authentication)) {
				throw new InsufficientAuthenticationException(
						"There is no client authentication. Try adding an appropriate authentication filter.");
			}

			Authentication client = (Authentication) principal;
			if (!client.isAuthenticated()) {
				throw new InsufficientAuthenticationException("The client is not authenticated.");
			}

			HashMap<String, String> request = new HashMap<String, String>(parameters);
			String clientId = client.getName();
			request.put(DataConstants.RequestParams.ClientId, clientId);

			getAuthorizationRequestManager().validateParameters(parameters, getClientDetailsService().loadClientByClientId(clientId));

			DefaultAuthorizationRequest authorizationRequest = new DefaultAuthorizationRequest(getAuthorizationRequestManager().createAuthorizationRequest(request));
			if (isAuthCodeRequest(parameters) || isRefreshTokenRequest(parameters)) {
				// The scope was requested or determined during the authorization step
				if (!authorizationRequest.getScope().isEmpty()) {
					logger.debug("Clearing scope of incoming auth code request");
					authorizationRequest.setScope(Collections.<String> emptySet());
				}
			}
			if (isRefreshTokenRequest(parameters)) {
				// A refresh token has its own default scopes, so we should ignore any added by the factory here.
				authorizationRequest.setScope(OAuth2Utils.parseParameterList(parameters.get("scope")));
			}

			authorizationRequest.setApprovalParameters(parameters);
			OAuth2AccessToken token = getTokenGranter().grant(grantType, authorizationRequest);
			if (token == null) {
				throw new UnsupportedGrantTypeException("Unsupported grant type: " + grantType);
			}

			result = getResponse(token);
			result.setGameVersion(gameService.findEnvironmentByClientIdAndOS(clientId, MathUtil.parseInt(request.get(DataConstants.RequestParams.osType))).getVersion());
			result.setAvatarUrl("");
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, result);
		} catch (Exception e) {
			e.printStackTrace();
			String tokenKey = null;
			DefaultOAuth2AccessToken errorToken = new DefaultOAuth2AccessToken(tokenKey);
			Map<String, Object> map = new HashMap<String, Object>();
			Integer errorCode = 0;
			String message = "";
			if (e instanceof BadCredentialsException) {
				errorCode = ((BadCredentialsException) e).getErrorCode();
				message = e.getMessage();
				map.put("error", String.valueOf(errorCode));
				map.put("message", message);
				map.put("user_name", parameters.get(DataConstants.RequestParams.UserName));
				
			} else {
				errorCode = -404;
				message = e.toString();
				map.put("error", errorCode);
				map.put("message", message);
				map.put("user_name", parameters.get(DataConstants.RequestParams.UserName));
			}
			errorToken.setAdditionalInformation(map);
			result = getResponse(errorToken);
			
			response = new ResponseModel(errorCode, message, result);
		}
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Cache-Control", "no-store");
		headers.set("Pragma", "no-cache");
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseModel>(response, headers, HttpStatus.OK);
	}

	@ExceptionHandler(NoSuchClientException.class)
	public ResponseEntity<OAuth2Exception> handleNoSuchClientException(Exception e) throws Exception {
		return handleException(new BadClientCredentialsException());
	}

	@ExceptionHandler(OAuth2Exception.class)
	public ResponseEntity<OAuth2Exception> handleException(Exception e) throws Exception {
		logger.info("Handling error: " + e.getClass().getSimpleName() + ", " + e.getMessage());
		return getExceptionTranslator().translate(e);
	}

	@Loggable
	private VtcOAuth2AccessToken getResponse(OAuth2AccessToken accessToken) {
		Map<String, Object> map = accessToken.getAdditionalInformation();
//		boolean isOtp = false;
		String errorCode = null;
		String accountId = null;
		String message = null;
		String billingAccessToken = null;
		String userName = null;
		String accountEmail = null;
		String accountMobile = null;
		Integer accountUserStatus = null;
		if (map != null && map.size() != 0) {
			Object id = map.get("id");
			Object error = map.get("error");
			Object mess = map.get("message");
			Object billing = map.get("billing_token");
			Object user_name = map.get("user_name");
			Object email = map.get("email");
			Object mobile = map.get("mobile");
			Object userStatus = map.get("user_status");

			userName = user_name == null ? null : String.valueOf(user_name);
			billingAccessToken = billing == null ? null : String.valueOf(billing);
			message = error == null ? null : String.valueOf(mess);
			errorCode = error == null ? null : String.valueOf(error);
			accountId = id == null ? null : String.valueOf(id);
			accountEmail = email == null ? "" : String.valueOf(email);
			accountMobile = mobile == null ? "" : String.valueOf(mobile);
			accountUserStatus = userStatus == null ? null : Integer.valueOf(userStatus.toString());
			
//			if (String.valueOf(PConstants.ERROR_CODE.OTP_REQUIRE).equalsIgnoreCase(errorCode)) {
//				isOtp = true;
//			}
		}

//		if (isOtp) {
//			VtcOAuth2AccessToken token = new VtcOAuth2AccessToken();
//			token.setAccountId(accountId);
//			token.setOtpRequire(true);
//			token.setErrorCode(errorCode == null ? String.valueOf(PConstants.HTTP_STATUS.UNAUTHORIZED) : errorCode);
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.set("Cache-Control", "no-store");
//			headers.set("Pragma", "no-cache");
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			return new ResponseEntity<VtcOAuth2AccessToken>(token, headers, HttpStatus.OK);
//		}

		VtcOAuth2AccessToken token = new VtcOAuth2AccessToken();
		token.setAccountId(accountId);
		token.setAccountName(userName);
		token.setErrorMessage(message);
		token.setBillingAccessToken(billingAccessToken);
		token.setAccessToken(accessToken.getValue());
		token.setExpiration(accessToken.getExpiration());
		token.setEmail(accountEmail);
		token.setMobile(accountMobile);
		token.setUserStatus(accountUserStatus);
		token.setErrorCode(errorCode != null ? errorCode : accountId);
		
		return token;

//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Cache-Control", "no-store");
//		headers.set("Pragma", "no-cache");
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		return new ResponseEntity<VtcOAuth2AccessToken>(token, headers, HttpStatus.OK);
	}

//	private ResponseEntity<VtcOAuth2AccessToken> getResponse(VtcOAuth2AccessToken vtcToken) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Cache-Control", "no-store");
//		headers.set("Pragma", "no-cache");
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		return new ResponseEntity<VtcOAuth2AccessToken>(vtcToken, headers, HttpStatus.OK);
//	}

	private boolean isRefreshTokenRequest(Map<String, String> parameters) {
		return "refresh_token".equals(parameters.get("grant_type")) && parameters.get("refresh_token") != null;
	}

	private boolean isAuthCodeRequest(Map<String, String> parameters) {
		return "authorization_code".equals(parameters.get("grant_type")) && parameters.get("code") != null;
	}

//	private boolean validateCode(Map<String, String> parameters) {
//		if (parameters == null || parameters.size() == 0) {
//			return false;
//		}
//		String encript = buildSha(parameters);
//		String isTime = parameters.get("time");
//		String code = parameters.get("code");
//		if ("0".equals(isTime)) {
//			return encript.equals(code);
//		}
//
//		int index = code.indexOf(encript);
//		if (index == -1) {
//			return false;
//		}
//		String time = code.substring(index + encript.length(), code.length());
//		try {
//			long rq = Long.parseLong(time);
//			long current = System.currentTimeMillis();
//			if (current > rq && rq > current - 10000) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			return false;
//		}
//	}

//	private String buildSha(Map<String, String> parameters) {
//		String grantType = parameters.get("grant_type");
//		String clientId = parameters.get("client_id");
//		String clientSecret = parameters.get("client_secret");
//		String username = parameters.get("username");
//		String password = parameters.get("password");
//
//		String url = new StringBuffer("grant_type=").append(grantType)
//				.append("&client_id=").append(clientId)
//				.append("&client_secret=").append(clientSecret)
//				.append("&username=").append(username)
//				.append("&password=").append(password).append(shaSalt).toString();
//		String encript = encryptSha(url);
//		return encript;
//	}

	public static String encryptSha(String url) {
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-256");
			byte[] hash = null;
			hash = crypt.digest(url.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (byte b : hash) {
		    	sb.append(String.format("%02x", b));
		    }
			String encode = sb.toString();
			return encode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public CustomUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}
}
