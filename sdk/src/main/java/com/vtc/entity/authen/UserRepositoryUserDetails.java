package com.vtc.entity.authen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vtc.model.AccountInfoFullModel;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;

public class UserRepositoryUserDetails extends UserAuthen implements UserDetails {

		private static final long serialVersionUID = 1L;

		public UserRepositoryUserDetails(UserAuthen user) {
			super(user);
		}
		public UserRepositoryUserDetails(AuthenResponseData user) {
			super(user);
		}
		public UserRepositoryUserDetails(OAuthResponseData user) {
			super(user);
		}
		public UserRepositoryUserDetails(AccountInfoFullModel user) {
			super(user);
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> authos = new ArrayList<GrantedAuthority>();
			GrantedAuthority g = new SimpleGrantedAuthority("ROLE_USER");
			authos.add(g);
			return authos;
		}

		@Override
		public String getUsername() {
			return getUserName();
		}

	}