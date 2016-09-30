package com.vtc.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

/**
 * TwilioClient 
 * 
 * @author Nguyen Xuan Bach
 *
 */
@Service
public class TwilioService {
//	private static TwilioClient instance;
	private TwilioRestClient client;
	private String from;

	public TwilioService() {
		String sId = "AC675d3bd1d961242f72b589638cc6252b";
		String token = "07229d6152167226aed7c8d16357f404";
		from = "+84902286954";
		client = new TwilioRestClient(sId, token);
	}

//	public static TwilioClient getInstance() {
//		if (instance == null) {
//			instance = new TwilioClient();
//		}
//		return instance;
//	}

	public void sendSms(String to, String content) {
		System.out.println("TwilioClient.sendSms(): " + to + "Content: " + content);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body", content));
		params.add(new BasicNameValuePair("To", to));
		params.add(new BasicNameValuePair("From", from));
		
		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		try {
			Message message = messageFactory.create(params);
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
