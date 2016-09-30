package com.vtc.business;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.security.authentication.BadCredentialsException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.vtc.model.AppleReceiptResponse;
import com.vtc.model.GoogleVerifyResponse;
import com.vtc.request.AccountRegisterRequest;
import com.vtc.request.AuthenSocialRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.response.CmsQueryResponse;

public interface CommonUtils {
	String findServiceKeyById(Integer serviceId) throws JsonParseException, JsonMappingException, IOException;

	String mappingActivityType(Integer type);

	String getTypeLoginByAuthSystemId(Integer oauthSystemId);

	String normalizePhone(String phone);

	String parseToken(String authorization);

	HashMap<String, String> utmLinkToMap(String utm);

	AuthenSocialRequest linkToSocial(AuthenSocialRequest request, Integer socialType, String accessToken) throws BadCredentialsException;
	
	AccountRegisterRequest convertToAccountRegisterRequest(AuthenticationRequest request);
	
	String hashMD5(String data);
	
	<T> String toJsonString(T obj);
	<T> T jsonStringToObject(String obj, Class<T> clazz);
	
	HashMap<String, List<String>> getMapDimensionName(GetReportsResponse response);
	
	String CallPostRequest(String domain, String json) throws ClientProtocolException, IOException ;
	
	HashMap<String, HashMap<String, String>> toMappingCMS(GetReportsResponse response) ;
	
	List<CmsQueryResponse> convertToCmsQueryResponses(HashMap<String, HashMap<String, String>> mapResponse);
	
	String autoGenOrderNo(String clientId, String accountName, String packageId);
	
	HttpURLConnection createHttpPost(String requestUrl, String jsonData) throws IOException;
	
	String hashMD5_1(String data);
	
	AppleReceiptResponse verifyPayment_Apple(String receipt);
	
	GoogleVerifyResponse verifyPayment_Google(String packageName, String productId, String purchaseToken);
	
	String base64(String data);
	String decodeBase64(String data);
}
