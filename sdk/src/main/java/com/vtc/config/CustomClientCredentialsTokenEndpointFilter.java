package com.vtc.config;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;

import com.google.gson.Gson;
import com.vtc.aspect.Loggable;
import com.vtc.aspect.LoggableServlet;
import com.vtc.dataconstant.DataConstants;
import com.vtc.request.AuthenticationRequest;

public class CustomClientCredentialsTokenEndpointFilter extends ClientCredentialsTokenEndpointFilter {
	private static final Logger log = Logger.getLogger(CustomClientCredentialsTokenEndpointFilter.class);

	public CustomClientCredentialsTokenEndpointFilter() {
		super("/login");
	}

	@Loggable
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String clientIp = request.getRemoteHost();
		String clientId = request.getParameter(DataConstants.RequestParams.ClientId);
		String clientSecret = request.getParameter(DataConstants.RequestParams.ClientSecret);
//		String code = request.getParameter("code");
		String grantType = request.getParameter(DataConstants.RequestParams.Grant_Type);
		String username = request.getParameter(DataConstants.RequestParams.UserName);
		String isTime = request.getParameter(DataConstants.RequestParams.Time);
		String otp = request.getParameter(DataConstants.RequestParams.Otp);
		String otpCheck = request.getParameter(DataConstants.RequestParams.Otp_Check);
		String osType = request.getParameter(DataConstants.RequestParams.osType);

		log.info(new StringBuffer("\n====================================================================================================\n")
				.append("\n====================================================================================================\n"));
		
		String logs = new StringBuffer("[START] LOGIN clientIp = ").append(clientIp)
				.append(", username = ").append(username)
				.append(", clientId = ").append(clientId)
				.append(", clientSecret = ").append(clientSecret)
//				.append(", code = ").append(code)
				.append(", grantType = ").append(grantType)
				.append(", isTime = ").append(isTime)
				.append(", otp = ").append(otp)
				.append(", otpCheck = ").append(otpCheck)
				.append(", osType = ").append(osType).toString();
		log.info(logs);

		if (clientId == null) {
			clientId = "";
		}

		if (clientSecret == null) {
			clientSecret = "";
		}

//		if (code == null) {
//			code = "";
//		}

		//		boolean valid = true;
//		valid = validateCode(request, code);
//		if (!valid) {
//			clientId = "";
//			clientSecret = "";
//		}

		clientId = clientId.trim();
		Authentication authen = null;
		try {
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(clientId, clientSecret, null);
			authen = this.getAuthenticationManager().authenticate(authRequest);
		} catch (Exception e) {
			log.error("LOGIN username = " + username);
		}

		logs = new StringBuffer("[END] LOGIN clientIp = ").append(clientIp)
				.append(", username = ").append(username)
				.append(", clientId = ").append(clientId)
				.append(", clientSecret = ").append(clientSecret)
//				.append(", code = ").append(code)
				.append(", grantType = ").append(grantType)
				.append(", isTime = ").append(isTime)
				.append(", otp = ").append(otp)
				.append(", otpCheck = ").append(otpCheck).toString();
		log.info(logs);
		return authen;
	}

//	private boolean validateCode(HttpServletRequest request, String code) {
//		if (code == null || code.trim().length() == 0) {
//			return false;
//		}
//		String encript = buildSha(request);
//		String isTime = request.getParameter("time");
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

//	private String buildSha(HttpServletRequest request) {
//		String grantType = request.getParameter("grant_type");
//		String clientId = request.getParameter("client_id");
//		String clientSecret = request.getParameter("client_secret");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		String url = new StringBuffer("grant_type=").append(grantType)
//				.append("&client_id=").append(clientId)
//				.append("&client_secret=").append(clientSecret)
//				.append("&username=").append(username)
//				.append("&password=").append(password).append(shaSalt).toString();
//		String encript = encryptSha(url);
//		return encript;
//	}

//	public static String encryptSha(String url) {
//		try {
//			MessageDigest crypt = MessageDigest.getInstance("SHA-256");
//			byte[] hash = null;
//			hash = crypt.digest(url.getBytes("UTF-8"));
//			StringBuilder sb = new StringBuilder();
//			for (byte b : hash) {
//		    	sb.append(String.format("%02x", b));
//		    }
//			String encode = sb.toString();
//			return encode;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}

//	public String getShaSalt() {
//		return shaSalt;
//	}
//
//	public void setShaSalt(String shaSalt) {
//		this.shaSalt = shaSalt;
//	}
}
