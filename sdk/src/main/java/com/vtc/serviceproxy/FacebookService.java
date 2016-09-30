package com.vtc.serviceproxy;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;

import com.vtc.model.UserInfoFb;

import facebook4j.FacebookException;

public interface FacebookService {
	facebook4j.User getUserInfo(String accessToken) throws FacebookException;
	UserInfoFb getUserInfoByHttp(String accessToken) throws BadCredentialsException, IOException;
}
