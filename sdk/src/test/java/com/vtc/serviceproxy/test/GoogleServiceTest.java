package com.vtc.serviceproxy.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.api.services.oauth2.model.Userinfoplus;
import com.vtc.serviceproxy.impl.GoogleServiceImpl;

public class GoogleServiceTest {

	private GoogleServiceImpl googleService = new GoogleServiceImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getUserInfo() throws IOException {
		String accessToken = "ya29.CjAhA7OeKRYm0yQrvk9IdGEX_nUm3fD1sW7Fz4rwg9sC6lAqrTSdeCQJV-PMoZBnqRg";
		Userinfoplus userinfo = googleService.getUserInfo(accessToken);
		
		System.out.println(userinfo);
	}

}
