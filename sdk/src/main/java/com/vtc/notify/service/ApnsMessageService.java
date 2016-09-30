package com.vtc.notify.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

@Service
public class ApnsMessageService {
	protected static Calendar lastCreated = null;
	protected static final int      ALERT_BADGE = 1;
	protected static final String   ALERT_SOUND = "SOS.wav";
	private ApnsService service;
	public ApnsMessageService() {
		System.out.println(getClass().getClassLoader().getResource(""));
//		service = APNS.newService().withCert(getClass().getClassLoader().getResourceAsStream("/apns/Certificates.p12"), "clpt").withSandboxDestination().build();
		service = APNS.newService().withCert(getClass().getClassLoader().getResourceAsStream("/apns/Iot_dev_push.p12"), "123456").withSandboxDestination().build();
	}

	public void send(String message, String deviceToken) {
		String payload = APNS.newPayload()
				.badge(ALERT_BADGE)
                .sound(ALERT_SOUND)
				.alertBody(message).build();
		service.start();
		service.push(deviceToken, payload);
		service.stop();
	}

}
