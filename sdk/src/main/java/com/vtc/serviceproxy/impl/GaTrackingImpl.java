package com.vtc.serviceproxy.impl;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.vtc.aspect.Loggable;
import com.vtc.dataconstant.GaParams;
import com.vtc.serviceproxy.GaBuilder;
import com.vtc.serviceproxy.GaTracking;

public class GaTrackingImpl implements GaTracking{
	@Autowired
	private GaBuilder builder;
	
//	public GaTrackingImpl(GaBuilder builder) {
//		this.builder = builder;
//	}
	
	@Loggable
	@Override
	public int TrackEvent(String gaTrackingId, String gaClientId, String hitType, Map<String, String> params) throws IOException {
		Map<String, String> map = new LinkedHashMap<String, String>();
	    map.put(GaParams.ParamTracking.Version, "1");             // Version.
	    map.put(GaParams.ParamTracking.TrackingId, gaTrackingId);
	    map.put(GaParams.ParamTracking.ClientId, gaClientId);
	    map.put(GaParams.ParamTracking.EventHitType, hitType == null || hitType.isEmpty() ? GaParams.TypeEventHit.Event : hitType);         // Event hit type.
	    
	    if(params != null && !params.isEmpty()){
	    	params.forEach((key,value) -> {
	    		try {
	    			if(!((String)value).isEmpty())
	    			{
	    				map.put(key, builder.encode(value, true));
	    			}
				} catch (Exception e) {
//					e.printStackTrace();
				}
	    	});
	    }

	    HttpTransport transport = new NetHttpTransport();

	    HttpContent content = new ByteArrayContent(builder.getContentType(), builder.getPostData(map));
		HttpResponse revokeResponse = transport.createRequestFactory()
											   .buildPostRequest(new GenericUrl(builder.getEndpointSingle()), content)
											   .execute();
	    
		return revokeResponse.getStatusCode();
	}

	public GaBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(GaBuilder builder) {
		this.builder = builder;
	}

}
