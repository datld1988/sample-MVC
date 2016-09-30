package com.vtc.serviceproxy;

import java.io.IOException;
import java.net.URL;

import com.google.api.client.json.JsonFactory;

public interface GaConfiguration {
	String GetApplicationName() throws IOException;
	String GetKeyFileLocation() throws IOException;
	String GetServiceAccountEmail() throws IOException;
	String GetViewId() throws IOException;
	JsonFactory GetJsonFactory();
	String GetUrlEndpointSingle() throws IOException ;
	String GetContentType() throws IOException ;
}
