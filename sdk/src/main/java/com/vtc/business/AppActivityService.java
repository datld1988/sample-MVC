package com.vtc.business;

import java.io.IOException;

import com.vtc.mongocore.AppActivityMetadata;
import com.vtc.mongocore.Events;
import com.vtc.request.AppActivityRequest;

public interface AppActivityService {
	Events<AppActivityMetadata> appActivity(AppActivityRequest request) throws IOException;
	
	Integer checkFirst(String type, String adsId);
}
