package com.vtc.notify.service;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class C2dmMessageService extends RequestService {

    public static final String  SEND_OK                        = "OK";
    public static final String  SEND_UNAUTHORIZED              = "UnAuthorized";
    public static final String  SEND_SERVICE_UNAVAILABLE       = "ServiceUnavailable";

    public static final String  SEND_ERR_INVALID_REGISTRATION  = "InvalidRegistration";
    public static final String  SEND_ERR_NOT_REGISTERED        = "NotRegistered";
    public static final String  SEND_ERR_QUOTA_EXCEEDED        = "QuotaExceeded";
    public static final String  SEND_ERR_DEVICE_QUOTA_EXCEEDED = "DeviceQuotaExceeded";

    protected static Logger     log                            = Logger.getLogger(C2dmMessageService.class);

    private static final String C2DM_COLLAPSE_KEY              = System
                                                                       .getenv("C2DM_COLLAPSE_KEY");
    private static final String C2DM_DELAY_WHILE_IDLE          = System
                                                                       .getenv("C2DM_DELAY_WHILE_IDLE");

    private static final String PARAM_USER_ID                  = "data.user_id";
    private static final String PARAM_NICKNAME                 = "data.nickname";
    private static final String SEND_URL                       = "https://android.clients.google.com/c2dm/send";

    private String              mAuthToken;
    private String              mFromUserId;
    private String              mFromNickname;
    private String              mToRegistrationId;

    public void setAuthToken(String auth_token) {
        mAuthToken = auth_token;
    }

    public void setFromUserId(String user_id) {
        mFromUserId = user_id;
    }

    public void setFromNickname(String nickname) {
        mFromNickname = nickname;
    }

    public void setToRegistrationId(String registration_id) {
        mToRegistrationId = registration_id;
    }
    public String request() throws IOException {

        if (mAuthToken == null || mFromUserId == null || mToRegistrationId == null)
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
    protected void setBody() throws UnsupportedEncodingException {

        httpsURLConnection.setRequestProperty("Authorization",
                "GoogleLogin auth=" + mAuthToken);

        body.append("registration_id").append("=")
                .append(mToRegistrationId);

        String collapseKey = "0";
        if (C2DM_COLLAPSE_KEY != null && C2DM_COLLAPSE_KEY.equals("true"))
            collapseKey = String.valueOf(Math.random());

        body.append("&").append("collapse_key").append("=").append(collapseKey);

        if (C2DM_DELAY_WHILE_IDLE != null
                && C2DM_DELAY_WHILE_IDLE.equals("true"))
            body.append("&").append("delay_while_idle").append("=").append("1");

        body.append("&")
                .append(PARAM_USER_ID)
                .append("=")
                .append(URLEncoder.encode(mFromUserId,
                        CharEncoding.UTF_8));
        body.append("&")
                .append(PARAM_NICKNAME)
                .append("=")
                .append(URLEncoder.encode(
                        StringUtils.defaultString(mFromNickname),
                        CharEncoding.UTF_8));
    }
}
