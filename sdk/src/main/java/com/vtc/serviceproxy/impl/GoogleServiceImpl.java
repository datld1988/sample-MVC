package com.vtc.serviceproxy.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.google.api.services.plus.PlusScopes;
import com.vtc.config.ISysConfig;
import com.vtc.config.SysConfig;
import com.vtc.serviceproxy.GoogleService;

public class GoogleServiceImpl implements GoogleService{

	@Autowired
	private ISysConfig sysConfig;
	 
	@Override
	public Userinfoplus getUserInfo(String accessToken) throws IOException {
		
		String CLIENT_ID = "4973062632-lh2oesfn3t83ai3c9iu8blmogoc9veqn.apps.googleusercontent.com";
		String CLIENT_SECRET = "Y2tvvpSmSn3jpYycPbHrcGBm";
		JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
		NetHttpTransport TRANSPORT = new NetHttpTransport();
		
		GoogleTokenResponse googleTokenResponse = new GoogleTokenResponse()
												.setAccessToken(accessToken)
												.setExpiresInSeconds(new Long(3600));
		GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY)
				.setTransport(TRANSPORT)
				.setClientSecrets(CLIENT_ID, CLIENT_SECRET).build()
//				.setClientSecrets(sysConfig.getGoogleClientId(), sysConfig.getGoogleClientSecret()).build()
				.setFromTokenResponse(googleTokenResponse);
		
		Oauth2 oauth2 = new Oauth2.Builder(TRANSPORT, JSON_FACTORY, credential)
					.setApplicationName("Oauth2")
					.build();
		
		return oauth2.userinfo().get().execute();
					 
	}

	@Override
	public void getUserInfoTemp(String accessToken) throws IOException {
//		 Oauth2 oauth2 = new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), credential)
//				 					.setApplicationName("Oauth2")
//				 					.build();
		 Userinfoplus userinfo = null;//oauth2.userinfo().get().execute();
//		 userinfo.toPrettyString();
		 JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
		NetHttpTransport TRANSPORT = new NetHttpTransport();
		String CLIENT_ID = "4973062632-lh2oesfn3t83ai3c9iu8blmogoc9veqn.apps.googleusercontent.com";
		String CLIENT_SECRET = "Y2tvvpSmSn3jpYycPbHrcGBm";
		String APPLICATION_NAME = "APPTEST";
		
		
		 String accessToken1 = "ya29.Ci8hAxnbi5GcKm1a3zxwashE9sn5_c0RSq1ZSA6mqkiyHFYrAMK1NQX_TGYE_-b5bg";
		 List<String> applicationScopes = Arrays.asList(
				  PlusScopes.USERINFO_EMAIL,
				  PlusScopes.USERINFO_PROFILE,
				  PlusScopes.PLUS_ME,
				  PlusScopes.PLUS_LOGIN
				);
		 String idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjQwYWE0MmVkYWMwNjE0ZDdjYTNmNTdmOTdlZTg2NmNkZmJhM2I2MWEifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXRfaGFzaCI6IlZVQ1BRb0dHUGNjQlcxSmRveGE3c0EiLCJhdWQiOiI0OTczMDYyNjMyLWxoMm9lc2ZuM3Q4M2FpM2M5aXU4Ymxtb2dvYzl2ZXFuLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA5ODYzMDYwNjEwNjgyODEyNDcyIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF6cCI6IjQ5NzMwNjI2MzItbGgyb2VzZm4zdDgzYWkzYzlpdThibG1vZ29jOXZlcW4uYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJlbWFpbCI6InBob25naXQ5MEBnbWFpbC5jb20iLCJpYXQiOjE0Njg1NjU2MTAsImV4cCI6MTQ2ODU2OTIxMCwibmFtZSI6IlN0b21lciIsInBpY3R1cmUiOiJodHRwczovL2xoNC5nb29nbGV1c2VyY29udGVudC5jb20vLXdHZ2Y0OUdQaUVJL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUVBL1JMNW5MVllHcldjL3M5Ni1jL3Bob3RvLmpwZyIsImdpdmVuX25hbWUiOiJTdG9tZXIiLCJsb2NhbGUiOiJ2aSJ9.35n0QTnmR5f9FZDjlc_ZIxMqMaFBr9SsqigCpOQMu42SKgC5hSKRWNwQ7v0JmQ8LV57uRX8gvvTLFki9U2ot2foVULulDvhJYrrAqoZVMJH-zaPH2AQ68nvdEkMhKWIrYH10K5YmKVWAJUSd0ktJAnX0liP6QPeF_nFrUq7kbjrnf8mgVN8T9O7XAsaLBS8aRAzz61qIW6i49KHg5H2_P_6SrmdXVB-R24vMoldVgols0Qjk5ho7-taOnxo6EV1Di2EO4qNAyDaxFV1HmdZFxCpsxeIK3sODo3haU8ZUO1vfYVOjdLcKkSqGATlI2PdRcn8LV1zIQH7S5KUgT7BKog";
		// Build credential from stored token data.
		 GoogleAuthorizationCodeFlow flow
		  = new GoogleAuthorizationCodeFlow.Builder(
		    TRANSPORT,
		    JSON_FACTORY,
		    CLIENT_ID,
		    CLIENT_SECRET,
		    applicationScopes).build();
		 GoogleTokenResponse googleTokenResponse = new GoogleTokenResponse()
//				 .setIdToken(idToken)
				 .setAccessToken(accessToken1)
				 .setExpiresInSeconds(new Long(3600));
//				 .setScope("https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/plus.me openid email profile")
//				 .setTokenType("Bearer")
//				 .setRefreshToken("offline"); 
		 GoogleCredential credential = new GoogleCredential.Builder()
	          .setJsonFactory(JSON_FACTORY)
	          .setTransport(TRANSPORT)
	          .setClientSecrets(CLIENT_ID, CLIENT_SECRET).build()
	          .setFromTokenResponse(googleTokenResponse);
	      // Create a new authorized API client.
//		 String userId = "109863060610682812472";//googleTokenResponse.parseIdToken().getPayload().getSubject();
//			Credential credential = flow.createAndStoreCredential(googleTokenResponse, userId);
	      
	      
//		 GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken1);   
//	      Plus service = new Plus.Builder(TRANSPORT, JSON_FACTORY, credential)
//	          .setApplicationName(APPLICATION_NAME)
//	          .build();
			
			 Oauth2 oauth2 = new Oauth2.Builder(TRANSPORT, JSON_FACTORY, credential)
	 					.setApplicationName("Oauth2")
	 					.build();
//	       //Get a list of people that this user has shared with this app.
					 userinfo = oauth2.userinfo().get().execute();
		
		// Load client secrets.
//	        InputStream in =
//	            GoogleServiceImpl.class.getResourceAsStream("ga/client_secret.json");
//	        GoogleClientSecrets clientSecrets =
//	            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//	        // Build flow and trigger user authorization request.
//	        GoogleAuthorizationCodeFlow flow =
//	                new GoogleAuthorizationCodeFlow.Builder(
//	                        TRANSPORT, JSON_FACTORY, clientSecrets, Arrays.asList("https://www.googleapis.com/auth/plus.login", "https://www.googleapis.com/auth/userinfo.email"))
////	                .setDataStoreFactory(DATA_STORE_FACTORY)
//	                .setAccessType("offline")
//	                .build();
//	        Credential credential = new AuthorizationCodeInstalledApp(
//	            flow, new LocalServerReceiver()).authorize("user");
//	        System.out.println(
//	                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
//	        return credential;
	        
//	        Plus service = new Plus.Builder(TRANSPORT, JSON_FACTORY, credential)
//	  	          .setApplicationName(APPLICATION_NAME)
//	  	          .build();
		 
		 
//		 GoogleTokenResponse googleTokenResponse = new GoogleTokenResponse()
//				 .setIdToken(idToken)
//				 .setAccessToken(accessToken1)
//				 .setExpiresInSeconds(new Long(3600))
//				 .setScope("https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/plus.me openid email profile")
//				 .setTokenType("Bearer")
//				 .setRefreshToken("offline");
//		 List<String> applicationScopes = Arrays.asList(
//				  PlusScopes.USERINFO_EMAIL,
//				  PlusScopes.USERINFO_PROFILE
//				);
//
//				GoogleAuthorizationCodeFlow flow
//				  = new GoogleAuthorizationCodeFlow.Builder(
//				    TRANSPORT,
//				    JSON_FACTORY,
//				    CLIENT_ID,
//				    CLIENT_SECRET,
//				    applicationScopes).build();
//
//				String userId = "109863060610682812472";//googleTokenResponse.parseIdToken().getPayload().getSubject();
//				Credential credential = flow.createAndStoreCredential(googleTokenResponse, userId);
//				HttpRequestFactory requestFactory = TRANSPORT.createRequestFactory(credential);
//
//				GenericUrl url = new GenericUrl("https://www.googleapis.com/oauth2/v1/userinfo");
//				HttpRequest request = requestFactory.buildGetRequest(url);
//				String userIdentity = request.execute().parseAsString();
		 
//		 GoogleCredential credential1 = new GoogleCredential.Builder()
//				 .setTransport(TRANSPORT).setJsonFactory(JSON_FACTORY)
//				 .setClientSecrets(CLIENT_ID, CLIENT_SECRET).setRequestInitializer((new HttpRequestInitializer(){
//				                 @Override
//				                 public void initialize(HttpRequest request)
//				                         throws IOException {
//				                     request.getHeaders().put("Authorization", "Bearer " + accessToken1);
//				                 }
//				             })).build();
//		 
//	        Oauth2 oauth2 = new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), credential1)
//					.setApplicationName("Oauth2")
//					.build();
//	        userinfo = oauth2.userinfo().get().execute();
		
	}

	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}

}
