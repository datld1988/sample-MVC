package com.vtc.notify.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GcmMessageService extends RequestService {

    public static final String  SEND_OK                        = "OK";
    public static final String  SEND_UNAUTHORIZED              = "UnAuthorized";
    public static final String  SEND_SERVICE_UNAVAILABLE       = "ServiceUnavailable";

    public static final String  SEND_ERR_INVALID_REGISTRATION  = "InvalidRegistration";
    public static final String  SEND_ERR_NOT_REGISTERED        = "NotRegistered";
    public static final String  SEND_ERR_QUOTA_EXCEEDED        = "QuotaExceeded";
    public static final String  SEND_ERR_DEVICE_QUOTA_EXCEEDED = "DeviceQuotaExceeded";

    protected static Logger     log                            = Logger.getLogger(GcmMessageService.class);

//    private static final String PARAM_TYPE                     = "type";
//    private static final String PARAM_USER_ID                  = "user_id";
//    private static final String PARAM_NICKNAME                 = "nickname";
//    private static final String PARAM_GROUP_ID                 = "group_id";
//    private static final String PARAM_GROUP_NAME                 = "group_name";
//    private static final String PARAM_CONTENT_TYPE = "content_type";
    private static final String PARAM_MESSAGE                  = "message";
    private static final String SEND_URL                       = "http://android.googleapis.com/gcm/send";
    public static final String TYPE_MESSAGE                    = "MESSAGE";
    public static final String TYPE_TIMELINE                   = "TIMELINE";
    public static final String TYPE_DEVICE_CHANGED             = "DEVICE_CHANGED";
    
    public static final String TYPE_FRIEND             = "FRIEND";

    private String              mAuthToken;
    private String              mMessage;
    private String              mToRegistrationId;

//    private String              mType;
//    private String              mFromUserId;
//    private String              mFromNickname;
//    private String              mGroupId;
//    private String              mGroupName;
//    private String              mContentType;

//    public void setType(String type) {
//        mType = type;
//    }

    public void setAuthToken(String auth_token) {
        mAuthToken = auth_token;
    }

//    public void setFromUserId(String user_id) {
//        mFromUserId = user_id;
//    }
//
//    public void setFromNickname(String nickname) {
//        mFromNickname = nickname;
//    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public void setToRegistrationId(String registration_id) {
        mToRegistrationId = registration_id;
    }

    @Override
    protected void getConnection() throws IOException
    {
        super.getConnection();

        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
    }

    public String request() throws IOException {

    	if (mAuthToken == null || mToRegistrationId == null)
//        if (mAuthToken == null || mType == null || mFromUserId == null || mToRegistrationId == null)
            throw new IllegalArgumentException("IllegalArgumentException");

        executeRequest(SEND_URL);

        int responseCode = getResponseCode();
        log.info(responseCode + " " + httpsURLConnection.getResponseMessage());

        if (responseCode == HttpServletResponse.SC_OK) {

            String[] responseParts = getResponseLine();

            if (responseParts[0].equals("Error"))
                return responseParts[1];
        }

        else if (responseCode == HttpServletResponse.SC_UNAUTHORIZED) {
            return SEND_UNAUTHORIZED;
        }

        else if (responseCode == HttpServletResponse.SC_SERVICE_UNAVAILABLE) {
            return SEND_SERVICE_UNAVAILABLE;
        }

        return SEND_OK;
    }

    public String[] getResponseLine() throws IOException {

        String responseLine = new BufferedReader(new InputStreamReader(
                httpsURLConnection.getInputStream())).readLine();
        log.info("getResponseLine: " + responseLine);

        return responseLine.split("=", 2);
    }

    @Override
    protected void setBody() throws UnsupportedEncodingException
    {
        httpsURLConnection.setRequestProperty("Authorization", "key=" + mAuthToken);

        HashMap<String, Object> responseList = new HashMap<String, Object>(2);
        ArrayList<String> ids = new ArrayList<String>();
        ids.add(mToRegistrationId);
        responseList.put("registration_ids", ids);

        HashMap<String, String> responseList2 = new HashMap<String, String>(3);
//        responseList2.put(PARAM_TYPE, mType);
//        responseList2.put(PARAM_USER_ID, mFromUserId);
//        responseList2.put(PARAM_NICKNAME, mFromNickname);
//        responseList2.put(PARAM_GROUP_ID, mGroupId);
//        responseList2.put(PARAM_GROUP_NAME, mGroupName);
//        responseList2.put(PARAM_CONTENT_TYPE, mContentType);
        if (mMessage != null) {
            responseList2.put(PARAM_MESSAGE, mMessage);
        }
        responseList.put("data", responseList2);

        //TODO to json
        body.append(responseList);
    }

//	public String getGroupId() {
//		return mGroupId;
//	}
//
//	public void setGroupId(String mGroupId) {
//		this.mGroupId = mGroupId;
//	}
//
//	public String getGroupName() {
//		return mGroupName;
//	}
//
//	public void setGroupName(String mGroupName) {
//		this.mGroupName = mGroupName;
//	}
//
//	public String getContentType() {
//		return mContentType;
//	}
//
//	public void setContentType(String mContentType) {
//		this.mContentType = mContentType;
//	}
}
