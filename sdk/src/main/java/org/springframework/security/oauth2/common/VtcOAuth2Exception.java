package org.springframework.security.oauth2.common;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
@JsonSerialize(using = OAuth2AccessTokenSerializer.class)
@JsonDeserialize(using = OAuth2AccessTokenDeserializer.class)
public class VtcOAuth2Exception {
	private String error;
	private String message;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
