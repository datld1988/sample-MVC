package com.vtc.notify.service;

import java.io.IOException;

import org.apache.log4j.Logger;

public class GcmService {

	protected GcmMessageService gcmMessageService;

	private static final int MAX_RETRY_COUNT = 1;

	protected static Logger _log = Logger.getLogger(GcmService.class);

	// for DoodleDo
	public static final Integer _registration_type = 4;
	public static final String _auth_token = "AIzaSyAjagc8tXYgGXwbGpxS7W_uCgjwRJ2N-mY";

	// for Conan
	public static final Integer _registration_type_conan = 3;
	public static final String _auth_token_conan = "AIzaSyAjagc8tXYgGXwbGpxS7W_uCgjwRJ2N-mY"; // change
																								// later

	public String gcmSendMessage(String from_user_id, String send_user_id, Integer registration_type)
			throws IOException {

//		gcmMessageService.setType(GcmMessageService.TYPE_MESSAGE);
//		gcmMessageService.setFromUserId(from_user_id);

		String nickName = "";
//		gcmMessageService.setFromNickname(nickName);
		gcmMessageService.setMessage(null);

		if (registration_type == _registration_type_conan) {
			gcmMessageService.setAuthToken(_auth_token_conan);
		} else {
			gcmMessageService.setAuthToken(_auth_token);
		}

		String responseCode = gcmMessageService.request();
		_log.info(responseCode);

		if (responseCode.equals(C2dmMessageService.SEND_ERR_INVALID_REGISTRATION)
				|| responseCode.equals(C2dmMessageService.SEND_ERR_NOT_REGISTERED)) {

		}

		return responseCode;
	}

	public static boolean isValidRegistrationType(int type) {
		return (type == _registration_type || type == _registration_type_conan);
	}

}
