/*
 * Copyright 2006-2011 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.springframework.security.oauth2.provider.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import com.vtc.aspect.Loggable;

/**
 * @author Dave Syer
 * 
 */
@Configuration
@PropertySource("classpath:config/server.properties")
public class ClientDetailsUserDetailsService implements UserDetailsService {

	@Value("${oauth.client.time}")
	private Long loadClient;

	private ClientDetailsService clientDetailsService;
	private String emptyPassword = "";
	private long firstTime = 0;

	public ClientDetailsUserDetailsService(ClientDetailsService clientDetailsService) {
		firstTime = System.currentTimeMillis();
		this.clientDetailsService = clientDetailsService;
		System.out.println("XXXXXXXXXXXXX: " + clientDetailsService.hashCode());
	}
	
	/**
	 * @param passwordEncoder the password encoder to set
	 */
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.emptyPassword = passwordEncoder.encode("");
	}

	@Loggable
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("XXXXXXXXXXXXX: " + clientDetailsService.hashCode());
		ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
		String clientSecret = clientDetails.getClientSecret();
		if (clientSecret== null || clientSecret.trim().length()==0) {
			clientSecret = emptyPassword;
		}
		return new User(username, clientSecret, clientDetails.getAuthorities());
	}
	
	@Loggable
	private ClientDetailsService getClientDetailsService() {
		long currentTime = System.currentTimeMillis();
		if (loadClient == null) {
			loadClient = 3600000L;
		}
		if (currentTime - firstTime > loadClient) {
//			load client service
		}
		
		return clientDetailsService;
		
	}

}
