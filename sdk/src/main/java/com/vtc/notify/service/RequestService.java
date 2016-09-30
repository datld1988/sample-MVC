package com.vtc.notify.service;


import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.lang.CharEncoding;

public abstract class RequestService {

    protected HttpURLConnection httpsURLConnection;

    protected abstract void setBody() throws UnsupportedEncodingException;

    protected StringBuilder body = new StringBuilder();
    private String          httpUrl;
    private Boolean         https = false;

    protected void executeRequest(String url) throws IOException {

    	https = url.startsWith("https://");
    	httpUrl = url;
        getConnection();
        setBody();
        execute();
    }

    protected void getConnection() throws IOException {

        URL url = new URL(httpUrl);
        if (https) {
	        HttpsURLConnection
	                .setDefaultHostnameVerifier(new CustomizedHostnameVerifier());
        }
        httpsURLConnection = (HttpURLConnection)url.openConnection();
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded;charset=UTF-8");
    }

    private void execute() throws IOException {

        OutputStream out = null;
        try {
       		out = httpsURLConnection.getOutputStream();
            out.write(body.toString().getBytes(CharEncoding.UTF_8));
            out.close();
        }
        catch (IOException e) {
            throw new IOException(e);
        }
        finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public int getResponseCode() throws IOException {
        return httpsURLConnection.getResponseCode();

    }

    protected class CustomizedHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
