package com.vtc.serviceproxy;

import java.io.IOException;

import com.google.api.services.oauth2.model.Userinfoplus;

public interface GoogleService {
	
	void getUserInfoTemp(String accessToken) throws IOException;
	
	Userinfoplus getUserInfo(String accessToken) throws IOException;
}
