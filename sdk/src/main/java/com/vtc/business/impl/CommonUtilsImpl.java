package com.vtc.business.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Report;
import com.google.api.services.analyticsreporting.v4.model.ReportRow;
import com.google.api.services.androidpublisher.AndroidPublisher;
import com.google.api.services.androidpublisher.model.InappPurchase;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.vtc.aspect.Loggable;
import com.vtc.business.CommonUtils;
import com.vtc.config.ISysConfig;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.DataConstants.ActivityTypes;
import com.vtc.model.AppleReceiptResponse;
import com.vtc.model.GoogleVerifyResponse;
import com.vtc.model.KeyValueModel;
import com.vtc.model.UserInfoFb;
import com.vtc.request.AccountRegisterRequest;
import com.vtc.request.AuthenSocialRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.response.CmsQueryResponse;
import com.vtc.serviceproxy.FacebookService;
import com.vtc.serviceproxy.GoogleService;
import com.vtc.serviceproxy.LoadConfig;

public class CommonUtilsImpl implements CommonUtils {
	private static Logger log = Logger.getLogger(CommonUtilsImpl.class);
	
	@Autowired
	private ISysConfig sysConfig;

	@Autowired
	private FacebookService facebookService;
	
	@Autowired
	private GoogleService googleService;
	
	@Autowired
	private LoadConfig config;
	
	@Loggable
	@Override
	public String findServiceKeyById(Integer serviceId) throws JsonParseException, JsonMappingException, IOException {
		String arrJson = sysConfig.getServiceKeyValue();
		ObjectMapper mapper = new ObjectMapper();

		List<KeyValueModel> list = mapper.readValue(arrJson,
				mapper.getTypeFactory().constructCollectionType(List.class, KeyValueModel.class));

		return list.stream().filter(x -> Integer.valueOf(x.getKey()).compareTo(serviceId) == 0).findFirst().get().getValue();
	}

	@Loggable
	@Override
	public String mappingActivityType(Integer type) {
		return Arrays.stream(DataConstants.ActivityTypes.values())
				.filter(item -> item.getValue().compareTo(type) == 0)
				.findAny()
				.orElse(ActivityTypes.NOTFOUND)
				.getDisplay();
	}

	@Loggable
	@Override
	public String getTypeLoginByAuthSystemId(Integer oauthSystemId) {
		String typeLogin = "";
		switch (oauthSystemId.intValue()) {
		case 1:
			typeLogin = DataConstants.EventTypes.LoginByYahoo;
			break;
		case 2:
			typeLogin = DataConstants.EventTypes.LoginByGoogle;
			break;
		case 3:
			typeLogin = DataConstants.EventTypes.LoginByFB;
		default:
			break;
		}
		
		return typeLogin;
	}

	@Loggable
	@Override
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

	@Override
	public String parseToken(String authorization) {
//		if(authorization == null || authorization.isEmpty()){
//			return "";
//		}
		return "";
		
	}

	@Override
	public HashMap<String, String> utmLinkToMap(String utm) {
		HashMap<String, String> mapping = new HashMap<String, String>();
		if(utm == null || utm.isEmpty()){
			return mapping;
		}
		//democlpt://?utm_source=facebook&utm_campaign=demo&utm_medium=1706
		String[] arr = utm.split("\\?");
		String utmParam = Arrays.asList(arr).stream().reduce((a,b) -> b).orElse("");
		Arrays.asList(utmParam.split("&")).stream().forEach(item -> {
			List<String> subItem = Arrays.asList(item.split("="));
			String key = subItem.stream().reduce((a, b) -> a).orElse("");
			String value = subItem.stream().reduce((a, b) -> b).orElse("");
			mapping.put(key, value);
		});
		
		return mapping;
	}

	@Loggable
	@Override
	public AuthenSocialRequest linkToSocial(AuthenSocialRequest request, Integer socialType, String accessToken) throws BadCredentialsException {
		AuthenSocialRequest data = request;
		try {
			switch (socialType) {
				case 1: // Yahoo
					break;
				case 2: // Google
				Userinfoplus userGoogle;
					userGoogle = googleService.getUserInfo(accessToken);
				
					if(userGoogle == null){
						break;
					}
					data.setEmail(userGoogle.getEmail());
					data.setFbEmail(userGoogle.getEmail());
					data.setoAuthAccount(userGoogle.getId());
					data.setFbBussinessIds(userGoogle.getId());
					data.setAccessToken(accessToken);
					
					break;
				case 3: // Facebook
					UserInfoFb userFacebook = facebookService.getUserInfoByHttp(accessToken);
					if(userFacebook == null){
						break;
					}
					
					data.setEmail(userFacebook.getEmail());
					data.setFbEmail(userFacebook.getEmail());
					data.setoAuthAccount(userFacebook.getId());
					String businessIds = userFacebook.getId();
					if(userFacebook.getIdsForBusiness() != null && !CollectionUtils.isEmpty(userFacebook.getIdsForBusiness().getData())){
						List<String> ids = new ArrayList<>();
						userFacebook.getIdsForBusiness().getData().stream().forEach(item ->{
							ids.add(item.getId());
						});
						businessIds = String.join(",", ids);
					}
					
					data.setFbBussinessIds(businessIds);
					data.setAccessToken(accessToken);
					
					break;
				default:
					break;
			}
		
		} catch (IOException e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public AccountRegisterRequest convertToAccountRegisterRequest(AuthenticationRequest request) {
		AccountRegisterRequest data = new AccountRegisterRequest();
		data.setAccessToken(request.getAccessToken());
		data.setAccountId(request.getAccountId());
		data.setAccountName(request.getAccountName());
		data.setAgency(request.getAgency());
		data.setCampaign(request.getCampaign());
		data.setClientId(request.getClientId());
		data.setClientIp(request.getClientIp());
		data.setClientSecret(request.getClientSecret());
		data.setDeviceToken(request.getDeviceToken());
		data.setDeviceType(request.getDeviceType());
		data.setEmail(request.getEmail());
		data.setFbBussinessIds(request.getFbBussinessIds());
		data.setFbEmail(request.getFbEmail());
		data.setIsDisableCheckSecure(request.getIsDisableCheckSecure());
		data.setManufacture(request.getManufacture());
		data.setMedium(request.getMedium());
		data.setModelName(request.getModelName());
		data.setoAuthAccount(request.getoAuthAccount());
		data.setoAuthSystemId(request.getoAuthSystemId());
		data.setOperatingSystem(request.getOperatingSystem());
		data.setOperatingSystemVersion(request.getOperatingSystemVersion());
		data.setPassword(request.getPassword());
		data.setServiceId(request.getServiceId());
		data.setServiceKey(request.getServiceKey());
		data.setSignDisableSecure(request.getSignDisableSecure());
		data.setSource(request.getSource());
		data.setTrackingModel(request.getTrackingModel());
		data.setUtm(request.getUtm());
		data.setIsAutoAuthen(request.getIsAutoAuthen());
		
		return data;
	}

	@Loggable
	@Override
	public String hashMD5(String data){
		if(StringUtils.isEmpty(data)){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data.getBytes("UTF-8"), 0, data.length());
			byte[] digest = md.digest();
			
			for (int i = 0; i < digest.length; i++) {
				if ((0xff & digest[i]) < 0x10) {
					sb.append("0" + Integer.toHexString((0xFF & digest[i])));
				} else {
					sb.append(Integer.toHexString(0xFF & digest[i]));
				}
			}
		}catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
			log.error("ERROR ", e);
		}
		
		return sb.toString();
	}

	public ISysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(ISysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}

	@Override
	public <T> String toJsonString(T obj) {
		ObjectMapper objectMapper = new ObjectMapper();//.writer().withDefaultPrettyPrinter();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
//			e.printStackTrace();
			log.error("[ERROR ParseJSON] ", e);
			return obj.toString();
		}
	}

	@Override
	public <T> T jsonStringToObject(String obj, Class<T> clazz) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			return objectMapper.readValue(obj, clazz);
		} catch (IOException e) {
//			 TODO Auto-generated catch block
//			e.printStackTrace();
			log.error("[ERROR] ", e);
			return null;
		}
	}

	@Loggable
	@Override
	public HashMap<String, List<String>> getMapDimensionName(GetReportsResponse response) {
		HashMap<String, List<String>> mapFilterData = new HashMap<>();
		
//		response.getReports().stream().forEach(report -> {
//			String dimensionName = report.getColumnHeader().getDimensions().stream().findFirst().get();
//			mapFilterData.put(dimensionName, null);
//			List<ReportRow> rows = report.getData().getRows();
//			rows.stream().forEach(row ->{
//				Set<String> 
//				mapFilterData.put(dimensionName, value)
//			});
//		});
		
		for (Report report : response.getReports()) {
			String dimension = report.getColumnHeader().getDimensions().stream().findFirst().get();
			mapFilterData.put(dimension, null);
			
			List<ReportRow> rows = report.getData().getRows();
			if (rows == null) {
				continue;
			}
			List<String> dimensionNames = new ArrayList<>();
			for (ReportRow row : rows) {
				String dimensionName = row.getDimensions().stream().findFirst().get();
				dimensionNames.add(dimensionName);
			}
			
			mapFilterData.put(dimension, dimensionNames);
		}
		
		return mapFilterData;
	}

	@Loggable
	@Override
	public String CallPostRequest(String domain, String json) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost(domain);
		// post.addHeader("Content-Type", "application/x-www-form-urlencoded");
		post.addHeader("Content-Type", "application/json");

		post.setEntity(new StringEntity(json, ContentType.create("application/json")));

		HttpResponse response1 = httpClient.execute(post);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		return result.toString();
	}

	@Loggable
	@Override
	public HashMap<String, HashMap<String, String>> toMappingCMS(GetReportsResponse response) {
		HashMap<String, HashMap<String, String>> mapResponse = new HashMap<>();
		
		// Map: Install - NRU - PU - Revenue
		HashMap<String, String> mapChildren = new HashMap<>();
		for (Report report : response.getReports()) {
			String metricName = report.getColumnHeader().getMetricHeader().getMetricHeaderEntries().stream().findFirst().get().getName();
			
			List<ReportRow> rows = report.getData().getRows();
			if (rows == null) {
				continue;
			}
			
			for (ReportRow row : rows) {
				String campaign = row.getDimensions().stream().findFirst().get();
				String value = row.getMetrics().stream().findFirst().get().getValues().stream().findFirst().get();
				value = StringUtils.isEmpty(value) ? "0": value;
				mapChildren = new HashMap<>();
				HashMap<String, String> mapDataBelongDate = mapResponse.get(campaign);
				if(mapDataBelongDate == null){
					mapChildren.put(metricName, value);
					
					mapResponse.put(campaign, mapChildren);
				} else{
					mapDataBelongDate.put(metricName, value);
					
					mapResponse.put(campaign, mapDataBelongDate);
				}
				
			}
		}
		
		return mapResponse;
	}

	@Loggable
	@Override
	public List<CmsQueryResponse> convertToCmsQueryResponses(HashMap<String, HashMap<String, String>> mapResponse) {
		List<CmsQueryResponse> response = new ArrayList<>();
		mapResponse.entrySet().stream().forEach(item -> {
			String campaign = item.getKey();
			HashMap<String, String> mapping = item.getValue();
			CmsQueryResponse temp = new CmsQueryResponse();
			temp.setChannel(campaign);
			temp.setInstall(mapping.get(DataConstants.GaMappingValue.AliasInstall) != null ? Long.parseLong(mapping.get(DataConstants.GaMappingValue.AliasInstall)) : 0);
			temp.setNru(mapping.get(DataConstants.GaMappingValue.AliasNRU) != null ? Long.parseLong(mapping.get(DataConstants.GaMappingValue.AliasNRU)) : 0);
			temp.setPu(mapping.get(DataConstants.GaMappingValue.AliasPU) != null ? Long.parseLong(mapping.get(DataConstants.GaMappingValue.AliasPU)) : 0);
			temp.setRevenue(mapping.get(DataConstants.GaMappingValue.AliasRevenues) != null ? Long.parseLong(mapping.get(DataConstants.GaMappingValue.AliasRevenues)) : 0);
			
			response.add(temp);
		});
		
		return response;
	}

	@Loggable
	@Override
	public String autoGenOrderNo(String clientId, String accountName, String packageId) {
		long timeNow = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer();
		sb.append(clientId).append(accountName).append(packageId).append(timeNow);
		String result = hashMD5(sb.toString());
		
		return new StringBuffer().append(DataConstants.PrefixOrder).append(result).toString();
	}

	@Loggable
	@Override
	public HttpURLConnection createHttpPost(String requestUrl, String jsonData) throws IOException {
		URL url = new URL(requestUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		conn.setRequestProperty("Accept", "application/json");
		
		OutputStream os = conn.getOutputStream();
		os.write(jsonData.getBytes("UTF-8"));
		os.flush();
		os.close();
		
		return conn;
	}

	@Override
	public String hashMD5_1(String input) {
		String md5 = null;
		
		if(null == input) return null;
		
		try {
			
			//Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			
			//Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());
	
			//Converts message digest value in base 16 (hex) 
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}

	@Loggable
	@Override
	public AppleReceiptResponse verifyPayment_Apple(String receipt) {
//	    final String receiptData = Base64.getEncoder().encodeToString(receipt.getBytes());
	    final String jsonData = "{\"receipt-data\" : \"" + receipt + "\"}";

//	    System.out.println(receipt);
//	    System.out.println(jsonData);

	    try
	    {
	        final URL url = new URL(DataConstants.SandboxUriAppleVerify);
	        final HttpURLConnection conn = (HttpsURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Accept", "application/json");
	        
	        final OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	        wr.write(jsonData);
	        wr.flush();

	        // Get the response
	        final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String line;
	        StringBuffer sb = new StringBuffer();
	        AppleReceiptResponse response = new AppleReceiptResponse();
	        while ((line = rd.readLine()) != null)
	        {
//	            System.out.println(line);
	            sb.append(line);
	        }
	        wr.close();
	        rd.close();
	        
	        response = new ObjectMapper().readValue(sb.toString(), AppleReceiptResponse.class);
	        return response;
	    }
	    catch (IOException e)
	    {
	    	log.error("ERROR", e);
	    	return null;
	    }
	}

	@Loggable
	@Override
	public GoogleVerifyResponse verifyPayment_Google(String packageName, String productId, String purchaseToken) {
		GoogleVerifyResponse response = new GoogleVerifyResponse();
		try {
			JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
			NetHttpTransport TRANSPORT = new NetHttpTransport();
			URL url = getClass().getClassLoader().getResource(config.googleIAPConfig().getProperty("googleiap.file_name"));
			String serviceAccount = config.googleIAPConfig().getProperty("googleiap.service_account_email");
			Set<String> scopes = Collections.singleton(config.googleIAPConfig().getProperty("googleiap.scopes"));
			
			GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY)
					.setTransport(TRANSPORT)
					.setServiceAccountId(serviceAccount)
					.setServiceAccountScopes(scopes)
					.setServiceAccountPrivateKeyFromP12File(new File(url.getFile()))
					.build();
			AndroidPublisher publisher = new AndroidPublisher.Builder(TRANSPORT, JSON_FACTORY, credential)
					.setApplicationName(packageName)
					.build();
			
			AndroidPublisher.Inapppurchases.Get get = publisher.inapppurchases().get(
					packageName,
				    productId,
				    purchaseToken);
			InappPurchase iap = get.execute();
			String iapStr = toJsonString(iap);
			
			response = new ObjectMapper().readValue(iapStr, GoogleVerifyResponse.class);
		} catch (Exception e) {
			log.error("[ERROR]", e);
		} 
		
		return response;
	}

	@Loggable
	@Override
	public String base64(String data) {
		return Base64.getEncoder().withoutPadding().encodeToString(data.getBytes());
	}

	@Loggable
	@Override
	public String decodeBase64(String data) {
		return Base64.getDecoder().decode(data).toString();
	}

	public LoadConfig getConfig() {
		return config;
	}

	public void setConfig(LoadConfig config) {
		this.config = config;
		
	}
}
