package com.vtc.util;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.vtc.model.DeviceTokenModel;

public class JacksonUtil {

	public static List<DeviceTokenModel> toListDeviceTokenModel(String s) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<DeviceTokenModel> user = mapper.readValue(s, new TypeReference<List<DeviceTokenModel>>(){});
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Set<String> toListString(String s) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<String> listString = mapper.readValue(s, new TypeReference<List<String>>(){});
			Set<String> setString = new HashSet<>(listString);
			return setString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String listToJson(List<? extends Object> list) {
	    try {
	    	final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    	final ObjectMapper mapper = new ObjectMapper();
	    	mapper.writeValue(out, list);
	    	String val = new String(out.toByteArray());
	    	return val;
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return null;
	}

	public static String add2Json(String json1, String json2) {
		if (json1 == null || json1.length() == 0)
			return json2;

		if (json2 == null || json2.length() == 0) {
			return json1;
		}

		int leng1 = json1.length();
		int leng2 = json2.length();

		StringBuffer bf = new StringBuffer(json1).deleteCharAt(leng1 - 1).append(",").append(json2.substring(1, leng2));
		String val = bf.toString();
		return val;
	}
}
