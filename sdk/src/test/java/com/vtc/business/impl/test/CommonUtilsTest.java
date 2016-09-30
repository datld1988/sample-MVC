package com.vtc.business.impl.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.androidpublisher.AndroidPublisher;
import com.google.api.services.androidpublisher.model.InappPurchase;
import com.google.api.services.androidpublisher.model.SubscriptionPurchase;
import com.google.gson.Gson;
import com.vtc.business.CommonUtils;
import com.vtc.business.impl.CommonUtilsImpl;
import com.vtc.request.AccountRegisterRequest;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

public class CommonUtilsTest {

	private CommonUtilsImpl commonUtils = new CommonUtilsImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void utmLinkToMap() {
		String utm = "democlpt://?utm_source=facebook&utm_campaign=demo&utm_medium=1706";
		HashMap<String, String> mapping = commonUtils.utmLinkToMap(utm);
		
		Assert.assertNotNull(mapping);
		Assert.assertTrue(mapping.get("utm_source").equals("facebook"));
		Assert.assertTrue(mapping.get("utm_campaign").equals("demo"));
		Assert.assertTrue(mapping.get("utm_medium").equals("1706"));
	}
	
//	@Test
	public void toJsonObject(){
		String str = "{	 \"manufacture\": \"Iphone\",	 \"modelName\": \"Iphone6\",	 \"operatingSystem\": \"IOS 8.0\",	 \"operatingSystemVersion\": \"8.0\",	 \"utm\": \"democlpt://?utm_source=TestSource1&utm_campaign=TestCampaign1&utm_medium=TestMedium1\",	 \"campaign\": \"TestCampaign1\",          						 \"medium\": \"TestMedium1\",								 \"source\": \"TestSource1\",									 \"clientId\": \"353b302c44574f565045687e534e7d6a\",			 \"accountName\": \"testvtc20160714\",		 \"deviceType\": 1,			 \"deviceId\": \"abababba\",	 \"password\": \"Vtctest@123\",									 \"trackingModel\":{				       \"gaTrackingId\": \"UA-59062861-18\",				       \"gaClientId\": \"a1b2c3d4e5f6g7h8j9k10\",			       \"hitType\": \"event\",				       \"category\": \"TestCategory1\",						           \"action\": \"TestAction1\",							           \"label\": \"TestLabel1\"									 },	 \"registerType\": 2,			 \"serviceId\": 100000,		 \"clientIp\": \"192.168.1.1\"								}";
		JSONObject obj = (JSONObject) JSONValue.parse(str);
		AccountRegisterRequest temp = new Gson().fromJson(str, AccountRegisterRequest.class);
		
		System.out.println( obj.get("manufacture") + " " + obj.get("modelName") ); 
	}
	
//	@Test
	public void mappingActivityType(){
		System.out.println(commonUtils.mappingActivityType(9));
	}
	
//	@Test
	public void hashMd5(){
			String secretKey = "123456";//0544ed93c22d5e1c869010c4515a7401
//			String jsonString90 = "{"
//					+ "\"AccountName\":\"vtctest90\","
//					+ "\"AccountID\":117813858,"
//					+ "\"ToAccountName\":\"vtctest90\","
//					+ "\"PartnerCode\":\"NATIVESDK\","
//					+ "\"Amount\":0,"
//					+ "\"PartnerAmount\":100,"
//					+ "\"ServerGame\":\"ServerTest_TTCL\","
//					+ "\"FromIP\":\"127.0.0.1\","
//					+ "\"GameCode\":\"GameTest_TTCL\","
//					+ "\"PaymentType\":\"CARDVCOIN\","
//					+ "\"CardSerial\":\"010101010101\","
//					+ "\"CardCode\":\"101010101010\","
//					+ "\"AccessToken\":\"636047083928000000.c6983b760b60f4cee09dd7b0b11ff273\","
//					+ "\"FunctionName\":\"CREATE\","
//					+ "\"PaymentFrom\":\"TTCL_TEST\""
//					+ "}";
			
			String jsonString01 = "{\"AccountName\":\"vtctest90\",\"AccountID\":117813858,\"ToAccountName\":\"vtctest90\",\"PartnerCode\":\"Software\",\"Amount\":0,\"PartnerAmount\":100,\"Servergame\":\"Server 1\",\"FromIP\":\"::1\",\"GameCode\":\"VANTRUNGCA\",\"PaymentType\":\"BUYVCOIN\",\"AccessToken\":\"636051369795470000.0ba8401716be430c7ee234c827c6d456\",\"FunctionName\":\"CREATE\",\"PaymentFrom\":\"VTC\",\"Description\":\"Nap dich vu game\"}";
			
			String jsonString02="{\"accountname\":\"vtctest90\",\"accountid\":117813858,\"toaccountname\":\"vtctest90\",\"partnercode\":\"sofware\",\"amount\":15000,\"partneramount\":150,\"servergame\":\"sv1\",\"fromip\":\"::1\",\"gamecode\":\"vantrungca\",\"paymenttype\":\"buybank\",\"accesstoken\":\"636057405633770000.64f943a60c32fd44ebc5d8c6cf0de6f7\",\"functionname\":\"create\",\"paymentfrom\":\"vtc\",\"bankcode\":\"bidv\"}";

			
//			String updateOrder = "{\"VTCTransID\":651,\"GameCode\":\"VANTRUNGCA\",\"FunctionName\":\"UPDATE\",\"PartnerCode\":\"Software\",\"Description\":\"Update Order\"}";
			String hashMd5 = commonUtils.hashMD5(jsonString02.trim().toLowerCase() + secretKey);
			
			System.out.println(jsonString02);
			System.out.println(jsonString02.trim().toLowerCase() + secretKey);
			System.out.println(hashMd5);
		
	}
	
//	@Test
	public void CallPostRequest(){
		String url = "http://sandbox3.vtcebank.vn/PaymentGames/GamesPayment.aspx?Sign=fa9846e5ba0d60a23023f7226eb5f02d";
		String json = "{\"AccountName\":\"vtctest90\",\"AccountID\":117813858,\"ToAccountName\":\"vtctest90\",\"PartnerCode\":\"Software\",\"Amount\":0,\"PartnerAmount\":100,\"Servergame\":\"Server 1\",\"FromIP\":\"::1\",\"GameCode\":\"VANTRUNGCA\",\"PaymentType\":\"BUYVCOIN\",\"AccessToken\":\"636051369795470000.0ba8401716be430c7ee234c827c6d456\",\"FunctionName\":\"CREATE\",\"PaymentFrom\":\"VTC\",\"Description\":\"Nap dich vu game\"}";
		
		try {
			commonUtils.CallPostRequest(url, json);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testVerifyApple(){
		String data = "{"
			  + "\"signature\" = \"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\";"
			  + "\"purchase-info\" = \"ewoJIm9yaWdpbmFsLXB1cmNoYXNlLWRhdGUtcHN0IiA9ICIyMDE2LTA4LTA1IDAxOjIyOjAxIEFtZXJpY2EvTG9zX0FuZ2VsZXMiOwoJInVuaXF1ZS1pZGVudGlmaWVyIiA9ICIwZjc2NjY1YWVlYzE4NDcyZTUyYWRlMzYyMWUwZGI2YjAyOWE4NWQwIjsKCSJvcmlnaW5hbC10cmFuc2FjdGlvbi1pZCIgPSAiMTAwMDAwMDIyNzk0NjM2NiI7CgkiYnZycyIgPSAiMiI7CgkidHJhbnNhY3Rpb24taWQiID0gIjEwMDAwMDAyMjc5NDYzNjYiOwoJInF1YW50aXR5IiA9ICIxIjsKCSJvcmlnaW5hbC1wdXJjaGFzZS1kYXRlLW1zIiA9ICIxNDcwMzg1MzIxMTYwIjsKCSJ1bmlxdWUtdmVuZG9yLWlkZW50aWZpZXIiID0gIjJFODAxNTM2LTkzNDktNDZBMi1BMkQ4LUMyMTFFNTZDMjU2QyI7CgkicHJvZHVjdC1pZCIgPSAidnRjLmludGVjb20ubWluaXNwb3J0bmV3cy5wYWNrMSI7CgkiaXRlbS1pZCIgPSAiMTEzOTcyMzQwNSI7CgkiYmlkIiA9ICJ2dGMuaW50ZWNvbS4uTWluaVNwb3J0TmV3cyI7CgkicHVyY2hhc2UtZGF0ZS1tcyIgPSAiMTQ3MDM4NTMyMTE2MCI7CgkicHVyY2hhc2UtZGF0ZSIgPSAiMjAxNi0wOC0wNSAwODoyMjowMSBFdGMvR01UIjsKCSJwdXJjaGFzZS1kYXRlLXBzdCIgPSAiMjAxNi0wOC0wNSAwMToyMjowMSBBbWVyaWNhL0xvc19BbmdlbGVzIjsKCSJvcmlnaW5hbC1wdXJjaGFzZS1kYXRlIiA9ICIyMDE2LTA4LTA1IDA4OjIyOjAxIEV0Yy9HTVQiOwp9\";"
			  + "\"environment\" = \"Sandbox\";"
			  + "\"pod\" = \"100\";"
			  + "\"signing-status\" = \"0\";}";
		System.out.println("ReceiptData: " + data);
		
		System.out.println("Response: " + commonUtils.verifyPayment_Apple("MIIT9gYJKoZIhvcNAQcCoIIT5zCCE+MCAQExCzAJBgUrDgMCGgUAMIIDlwYJKoZIhvcNAQcBoIIDiASCA4QxggOAMAoCAQgCAQEEAhYAMAoCARQCAQEEAgwAMAsCAQECAQEEAwIBADALAgEDAgEBBAMMATEwCwIBCwIBAQQDAgEAMAsCAQ4CAQEEAwIBUjALAgEPAgEBBAMCAQAwCwIBEAIBAQQDAgEAMAsCARkCAQEEAwIBAzAMAgEKAgEBBAQWAjQrMA0CAQ0CAQEEBQIDAWC+MA0CARMCAQEEBQwDMS4wMA4CAQkCAQEEBgIEUDI0NzAYAgEEAgECBBAsRvC+UhCRShvERjy2xmulMBsCAQACAQEEEwwRUHJvZHVjdGlvblNhbmRib3gwHAIBBQIBAQQU4K7Ap0EGYr13cBcRvvSGNExu+pEwHgIBDAIBAQQWFhQyMDE2LTA4LTEwVDA4OjUyOjA4WjAeAgESAgEBBBYWFDIwMTMtMDgtMDFUMDc6MDA6MDBaMCMCAQICAQEEGwwZdnRjLmludGVjb20uTW9iaWxlU0RLRGVtbzBKAgEHAgEBBEKgkz+ws5Saa8oPVlkev5yk7iCFhBuiagLG95KvcRSHgfWMESXchDMOwSld+4WvLY2giolk37zX8G/0Qhcv5vl+lnIwYQIBBgIBAQRZY8Cbk8BkzmABPbkaOZIdpL0jM4KABDypjqBY4jvlXsqrksmz6g6W7v3h4MqnGsz9uSocmtP8YZnHV14dYLpIX5ValJs+maPuqGk6VpfOBZ8EmDGPqyHdJIYwggFkAgERAgEBBIIBWjGCAVYwCwICBqwCAQEEAhYAMAsCAgatAgEBBAIMADALAgIGsAIBAQQCFgAwCwICBrICAQEEAgwAMAsCAgazAgEBBAIMADALAgIGtAIBAQQCDAAwCwICBrUCAQEEAgwAMAsCAga2AgEBBAIMADAMAgIGpQIBAQQDAgEBMAwCAgarAgEBBAMCAQEwDAICBq4CAQEEAwIBADAMAgIGrwIBAQQDAgEAMAwCAgaxAgEBBAMCAQAwGwICBqcCAQEEEgwQMTAwMDAwMDIyODgxNDk1MzAbAgIGqQIBAQQSDBAxMDAwMDAwMjI4ODE0OTUzMB8CAgaoAgEBBBYWFDIwMTYtMDgtMTBUMDg6NTI6MDdaMB8CAgaqAgEBBBYWFDIwMTYtMDgtMTBUMDg6NTI6MDdaMCoCAgamAgEBBCEMH3Z0Yy5pbnRlY29tLk1vYmlsZVNES0RlbW8ucGFjazGggg5lMIIFfDCCBGSgAwIBAgIIDutXh+eeCY0wDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNVBAYTAlVTMRMwEQYDVQQKDApBcHBsZSBJbmMuMSwwKgYDVQQLDCNBcHBsZSBXb3JsZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9uczFEMEIGA1UEAww7QXBwbGUgV29ybGR3aWRlIERldmVsb3BlciBSZWxhdGlvbnMgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkwHhcNMTUxMTEzMDIxNTA5WhcNMjMwMjA3MjE0ODQ3WjCBiTE3MDUGA1UEAwwuTWFjIEFwcCBTdG9yZSBhbmQgaVR1bmVzIFN0b3JlIFJlY2VpcHQgU2lnbmluZzEsMCoGA1UECwwjQXBwbGUgV29ybGR3aWRlIERldmVsb3BlciBSZWxhdGlvbnMxEzARBgNVBAoMCkFwcGxlIEluYy4xCzAJBgNVBAYTAlVTMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApc+B/SWigVvWh+0j2jMcjuIjwKXEJss9xp/sSg1Vhv+kAteXyjlUbX1/slQYncQsUnGOZHuCzom6SdYI5bSIcc8/W0YuxsQduAOpWKIEPiF41du30I4SjYNMWypoN5PC8r0exNKhDEpYUqsS4+3dH5gVkDUtwswSyo1IgfdYeFRr6IwxNh9KBgxHVPM3kLiykol9X6SFSuHAnOC6pLuCl2P0K5PB/T5vysH1PKmPUhrAJQp2Dt7+mf7/wmv1W16sc1FJCFaJzEOQzI6BAtCgl7ZcsaFpaYeQEGgmJjm4HRBzsApdxXPQ33Y72C3ZiB7j7AfP4o7Q0/omVYHv4gNJIwIDAQABo4IB1zCCAdMwPwYIKwYBBQUHAQEEMzAxMC8GCCsGAQUFBzABhiNodHRwOi8vb2NzcC5hcHBsZS5jb20vb2NzcDAzLXd3ZHIwNDAdBgNVHQ4EFgQUkaSc/MR2t5+givRN9Y82Xe0rBIUwDAYDVR0TAQH/BAIwADAfBgNVHSMEGDAWgBSIJxcJqbYYYIvs67r2R1nFUlSjtzCCAR4GA1UdIASCARUwggERMIIBDQYKKoZIhvdjZAUGATCB/jCBwwYIKwYBBQUHAgIwgbYMgbNSZWxpYW5jZSBvbiB0aGlzIGNlcnRpZmljYXRlIGJ5IGFueSBwYXJ0eSBhc3N1bWVzIGFjY2VwdGFuY2Ugb2YgdGhlIHRoZW4gYXBwbGljYWJsZSBzdGFuZGFyZCB0ZXJtcyBhbmQgY29uZGl0aW9ucyBvZiB1c2UsIGNlcnRpZmljYXRlIHBvbGljeSBhbmQgY2VydGlmaWNhdGlvbiBwcmFjdGljZSBzdGF0ZW1lbnRzLjA2BggrBgEFBQcCARYqaHR0cDovL3d3dy5hcHBsZS5jb20vY2VydGlmaWNhdGVhdXRob3JpdHkvMA4GA1UdDwEB/wQEAwIHgDAQBgoqhkiG92NkBgsBBAIFADANBgkqhkiG9w0BAQUFAAOCAQEADaYb0y4941srB25ClmzT6IxDMIJf4FzRjb69D70a/CWS24yFw4BZ3+Pi1y4FFKwN27a4/vw1LnzLrRdrjn8f5He5sWeVtBNephmGdvhaIJXnY4wPc/zo7cYfrpn4ZUhcoOAoOsAQNy25oAQ5H3O5yAX98t5/GioqbisB/KAgXNnrfSemM/j1mOC+RNuxTGf8bgpPyeIGqNKX86eOa1GiWoR1ZdEWBGLjwV/1CKnPaNmSAMnBjLP4jQBkulhgwHyvj3XKablbKtYdaG6YQvVMpzcZm8w7HHoZQ/Ojbb9IYAYMNpIr7N4YtRHaLSPQjvygaZwXG56AezlHRTBhL8cTqDCCBCIwggMKoAMCAQICCAHevMQ5baAQMA0GCSqGSIb3DQEBBQUAMGIxCzAJBgNVBAYTAlVTMRMwEQYDVQQKEwpBcHBsZSBJbmMuMSYwJAYDVQQLEx1BcHBsZSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEWMBQGA1UEAxMNQXBwbGUgUm9vdCBDQTAeFw0xMzAyMDcyMTQ4NDdaFw0yMzAyMDcyMTQ4NDdaMIGWMQswCQYDVQQGEwJVUzETMBEGA1UECgwKQXBwbGUgSW5jLjEsMCoGA1UECwwjQXBwbGUgV29ybGR3aWRlIERldmVsb3BlciBSZWxhdGlvbnMxRDBCBgNVBAMMO0FwcGxlIFdvcmxkd2lkZSBEZXZlbG9wZXIgUmVsYXRpb25zIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyjhUpstWqsgkOUjpjO7sX7h/JpG8NFN6znxjgGF3ZF6lByO2Of5QLRVWWHAtfsRuwUqFPi/w3oQaoVfJr3sY/2r6FRJJFQgZrKrbKjLtlmNoUhU9jIrsv2sYleADrAF9lwVnzg6FlTdq7Qm2rmfNUWSfxlzRvFduZzWAdjakh4FuOI/YKxVOeyXYWr9Og8GN0pPVGnG1YJydM05V+RJYDIa4Fg3B5XdFjVBIuist5JSF4ejEncZopbCj/Gd+cLoCWUt3QpE5ufXN4UzvwDtIjKblIV39amq7pxY1YNLmrfNGKcnow4vpecBqYWcVsvD95Wi8Yl9uz5nd7xtj/pJlqwIDAQABo4GmMIGjMB0GA1UdDgQWBBSIJxcJqbYYYIvs67r2R1nFUlSjtzAPBgNVHRMBAf8EBTADAQH/MB8GA1UdIwQYMBaAFCvQaUeUdgn+9GuNLkCm90dNfwheMC4GA1UdHwQnMCUwI6AhoB+GHWh0dHA6Ly9jcmwuYXBwbGUuY29tL3Jvb3QuY3JsMA4GA1UdDwEB/wQEAwIBhjAQBgoqhkiG92NkBgIBBAIFADANBgkqhkiG9w0BAQUFAAOCAQEAT8/vWb4s9bJsL4/uE4cy6AU1qG6LfclpDLnZF7x3LNRn4v2abTpZXN+DAb2yriphcrGvzcNFMI+jgw3OHUe08ZOKo3SbpMOYcoc7Pq9FC5JUuTK7kBhTawpOELbZHVBsIYAKiU5XjGtbPD2m/d73DSMdC0omhz+6kZJMpBkSGW1X9XpYh3toiuSGjErr4kkUqqXdVQCprrtLMK7hoLG8KYDmCXflvjSiAcp/3OIK5ju4u+y6YpXzBWNBgs0POx1MlaTbq/nJlelP5E3nJpmB6bz5tCnSAXpm4S6M9iGKxfh44YGuv9OQnamt86/9OBqWZzAcUaVc7HGKgrRsDwwVHzCCBLswggOjoAMCAQICAQIwDQYJKoZIhvcNAQEFBQAwYjELMAkGA1UEBhMCVVMxEzARBgNVBAoTCkFwcGxlIEluYy4xJjAkBgNVBAsTHUFwcGxlIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRYwFAYDVQQDEw1BcHBsZSBSb290IENBMB4XDTA2MDQyNTIxNDAzNloXDTM1MDIwOTIxNDAzNlowYjELMAkGA1UEBhMCVVMxEzARBgNVBAoTCkFwcGxlIEluYy4xJjAkBgNVBAsTHUFwcGxlIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRYwFAYDVQQDEw1BcHBsZSBSb290IENBMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5JGpCR+R2x5HUOsF7V55hC3rNqJXTFXsixmJ3vlLbPUHqyIwAugYPvhQCdN/QaiY+dHKZpwkaxHQo7vkGyrDH5WeegykR4tb1BY3M8vED03OFGnRyRly9V0O1X9fm/IlA7pVj01dDfFkNSMVSxVZHbOU9/acns9QusFYUGePCLQg98usLCBvcLY/ATCMt0PPD5098ytJKBrI/s61uQ7ZXhzWyz21Oq30Dw4AkguxIRYudNU8DdtiFqujcZJHU1XBry9Bs/j743DN5qNMRX4fTGtQlkGJxHRiCxCDQYczioGxMFjsWgQyjGizjx3eZXP/Z15lvEnYdp8zFGWhd5TJLQIDAQABo4IBejCCAXYwDgYDVR0PAQH/BAQDAgEGMA8GA1UdEwEB/wQFMAMBAf8wHQYDVR0OBBYEFCvQaUeUdgn+9GuNLkCm90dNfwheMB8GA1UdIwQYMBaAFCvQaUeUdgn+9GuNLkCm90dNfwheMIIBEQYDVR0gBIIBCDCCAQQwggEABgkqhkiG92NkBQEwgfIwKgYIKwYBBQUHAgEWHmh0dHBzOi8vd3d3LmFwcGxlLmNvbS9hcHBsZWNhLzCBwwYIKwYBBQUHAgIwgbYagbNSZWxpYW5jZSBvbiB0aGlzIGNlcnRpZmljYXRlIGJ5IGFueSBwYXJ0eSBhc3N1bWVzIGFjY2VwdGFuY2Ugb2YgdGhlIHRoZW4gYXBwbGljYWJsZSBzdGFuZGFyZCB0ZXJtcyBhbmQgY29uZGl0aW9ucyBvZiB1c2UsIGNlcnRpZmljYXRlIHBvbGljeSBhbmQgY2VydGlmaWNhdGlvbiBwcmFjdGljZSBzdGF0ZW1lbnRzLjANBgkqhkiG9w0BAQUFAAOCAQEAXDaZTC14t+2Mm9zzd5vydtJ3ME/BH4WDhRuZPUc38qmbQI4s1LGQEti+9HOb7tJkD8t5TzTYoj75eP9ryAfsfTmDi1Mg0zjEsb+aTwpr/yv8WacFCXwXQFYRHnTTt4sjO0ej1W8k4uvRt3DfD0XhJ8rxbXjt57UXF6jcfiI1yiXV2Q/Wa9SiJCMR96Gsj3OBYMYbWwkvkrL4REjwYDieFfU9JmcgijNq9w2Cz97roy/5U2pbZMBjM3f3OgcsVuvaDyEO2rpzGU+12TZ/wYdV2aeZuTJC+9jVcZ5+oVK3G72TQiQSKscPHbZNnF5jyEuAF1CqitXa5PzQCQc3sHV1ITGCAcswggHHAgEBMIGjMIGWMQswCQYDVQQGEwJVUzETMBEGA1UECgwKQXBwbGUgSW5jLjEsMCoGA1UECwwjQXBwbGUgV29ybGR3aWRlIERldmVsb3BlciBSZWxhdGlvbnMxRDBCBgNVBAMMO0FwcGxlIFdvcmxkd2lkZSBEZXZlbG9wZXIgUmVsYXRpb25zIENlcnRpZmljYXRpb24gQXV0aG9yaXR5AggO61eH554JjTAJBgUrDgMCGgUAMA0GCSqGSIb3DQEBAQUABIIBAA2mQqhAdvA8EfksK/ad+Kx2wD2XLghbBqWPnoedpk2/5ZY3ZOtBMbb5kiafdxdWzI8foYJxxFbExih7IQN9YJI5E65yjl5/cQ7QfwxqVd0cv33SgQGPqHpfeqfO1fupcAms+/0x04eP8lLQllZrcYfVJGr8xJDinbLypGOrZZ7GKDFcPlmG5R4bHKR5FJok1b/OVQ3fugRcgvkGeb7oz0I+rGaxZuPtDUYz/1o4LmCqnqa/MMKFlhbjyWkwfiGiPq3kU54pa7Ofuagh55AZrEB7DKhDVm+QpnsEtUUzA7Zr77Dq1safw7rgbA+sA8YPzNt7kulC13l1xsTwQUCTdtU=")); 
	}
	
//	@Test
	public void testPostGoogle(){
		HttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet("");
		HttpPost post = new HttpPost("https://accounts.google.com/o/oauth2/token");
		try 
		{
			String client_id = "470577299356-1vnhtg51vf0hp0m5c7aqi5ltns834cph.apps.googleusercontent.com";
			String client_secret = "QcERNj2PCKzCy7wBANUGm17Y";
			String redirect_uri = "https://vtcgame.vn";
			String code = "4/Esh9qBBcbM3KOVbQDmYHY5A7r8DHgk1vsH3aGMEfxpA#";
		    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
		    nameValuePairs.add(new BasicNameValuePair("grant_type",    "authorization_code"));
		    nameValuePairs.add(new BasicNameValuePair("code",    code));
		    nameValuePairs.add(new BasicNameValuePair("client_id",     client_id));
		    nameValuePairs.add(new BasicNameValuePair("client_secret", client_secret));
		    nameValuePairs.add(new BasicNameValuePair("redirect_uri", redirect_uri));
		    post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		    org.apache.http.HttpResponse response = client.execute(post);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		    StringBuffer buffer = new StringBuffer();
		    for (String line = reader.readLine(); line != null; line = reader.readLine())
		    {
		        buffer.append(line);
		    }

//		    JSONObject json = new JSONObject(buffer.toString());
		    String accessToken = ""; //json.getString("access_token");
		    System.out.println(buffer.toString());	

		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
//	@Test
	public void decodeBase64(){
		String base64 = "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";
		System.out.println(commonUtils.decodeBase64(base64)); 
		System.out.println("");
	}
	
//	@Test
	public void TestGoogleCredential() throws GeneralSecurityException, IOException{
		JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
		NetHttpTransport TRANSPORT = new NetHttpTransport();
		URL url = this.getClass().getClassLoader().getResource("/src/test/resources/GooglePlayAndroidDeveloper-6ffb5e71e6f0.p12");
		String APPLICATION_NAME = "com.vtc.mcare.monitor";
		String PRODUCT_ID = "57ad4db4fd845e21e0ecec97";
		String token = "cmgimhjmakldfhocgollomdd.AO-J1Oz21JX9QrJlu_OP0ztU7ma08dcBdk_a1Dhkt49m4NQ6EVvkqDJnGqGS7vq8sptuLTEtD8IRbKTrhZi2OGG4TrJqybQ9Wzd6TwVlI2fAupLaYHHIRYMbJPUTFtXOtIuPbel9MnCM";
		GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY)
				.setTransport(TRANSPORT)
				.setServiceAccountId("sdkserver@api-6271720320318533452-453952.iam.gserviceaccount.com")
				.setServiceAccountScopes(Collections.singleton("https://www.googleapis.com/auth/androidpublisher"))
				.setServiceAccountPrivateKeyFromP12File(new File("D:/workspaces/test/sdk/src/test/resource/GooglePlayAndroidDeveloper-6ffb5e71e6f0.p12"))
				.build();
		AndroidPublisher publisher = new AndroidPublisher.Builder(TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME)
				.build();
		
		AndroidPublisher.Inapppurchases.Get get = publisher.inapppurchases().get(
			    APPLICATION_NAME,
			    PRODUCT_ID,
			    token);
		InappPurchase response = get.execute();
		
			System.out.println(response.toString());
//		System.out.println(credential.getAccessToken());
	}
	
}
