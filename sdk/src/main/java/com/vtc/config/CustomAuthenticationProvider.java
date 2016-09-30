package com.vtc.config;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.vtc.business.CommonUtils;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.GaParams;
import com.vtc.entity.authen.UserRepositoryUserDetails;
import com.vtc.model.TrackingModel;
import com.vtc.request.AuthenSocialRequest;
import com.vtc.request.AuthenticationRequest;
import com.vtc.service.impl.CustomUserDetailsService;
import com.vtc.util.MathUtil;
import com.vtc.ws.v2.model.authen.AuthenResponseData;
import com.vtc.ws.v2.model.authen.OAuthResponseData;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private static final Logger log = Logger.getLogger(CustomAuthenticationProvider.class);
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private HttpServletRequest httpRequest;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info(new StringBuffer("[START] CustomAuthenticationProvider.authenticate(). ")
				.append(" AccountName: ").append(authentication.getName())
				.append(", Password: ").append((String) authentication.getCredentials())
				.append(", AuthenType: ").append(httpRequest.getParameter(DataConstants.RequestParams.AuthenType))
				.append(", DeviceType: ").append(httpRequest.getParameter(DataConstants.RequestParams.DeviceType))
				.append(", SecureCode: ").append(httpRequest.getParameter(DataConstants.RequestParams.SecureCode))
				.append(", SecureType: ").append(httpRequest.getParameter(DataConstants.RequestParams.SecureType))
				.append(", ClientIp: ").append(httpRequest.getParameter(DataConstants.RequestParams.ClientIp))
				.append(", ServiceId: ").append(httpRequest.getParameter(DataConstants.RequestParams.ServiceId))
				.append(", Campaign: ").append(httpRequest.getParameter(DataConstants.RequestParams.Campaign))
				.append(", Medium: ").append(httpRequest.getParameter(DataConstants.RequestParams.Medium))
				.append(", Source: ").append(httpRequest.getParameter(DataConstants.RequestParams.Source))
				.append(", Agency: ").append(httpRequest.getParameter(DataConstants.RequestParams.Agency))
				.append(", ClientId: ").append(httpRequest.getParameter(DataConstants.RequestParams.ClientId))
				.append(", GaTrackingId: ").append(httpRequest.getParameter(DataConstants.RequestParams.GaTrackingId))
				.append(", GaClientId: ").append( httpRequest.getParameter(DataConstants.RequestParams.GaClientId))
				.append(", EventCategory: ").append(httpRequest.getParameter(DataConstants.RequestParams.EventCategory))
				.append(", EventAction: ").append(httpRequest.getParameter(DataConstants.RequestParams.EventAction))
				.append(", EventLabel: ").append(httpRequest.getParameter(DataConstants.RequestParams.EventLabel)));
		try {
			// bachnx
			String loginSocial = httpRequest.getParameter(DataConstants.RequestParams.AuthenSocial);
			if (loginSocial != null && Integer.parseInt(loginSocial) > 0) {
				return authenticateSocial();
			}
			
			AuthenticationRequest request = createAuthenticationRequest(authentication);
			AuthenResponseData userAuthen = userDetailsService.authenBilling(request);

			Integer responseCode = userAuthen == null ? null : userAuthen.getResponseCode();
			if (responseCode == null || responseCode < 0) {
				if (userAuthen == null) {
					log.error(new StringBuffer("Username not found. userName = ").append(request.getAccountName()));
					throw new BadCredentialsException(responseCode, "Username not found.");
				}

				log.error(userAuthen.getDescription());
				throw new BadCredentialsException(responseCode, userAuthen.getDescription());
			}
			UserDetails detail = new UserRepositoryUserDetails(userAuthen);

			Collection<? extends GrantedAuthority> authorities = detail.getAuthorities();
			Authentication authen = new UsernamePasswordAuthenticationToken(detail, request.getPassword(), authorities);
			if (detail instanceof UserRepositoryUserDetails) {
				UserRepositoryUserDetails userDetail = (UserRepositoryUserDetails) detail;
				userDetail.setPassword(request.getPassword());
				authen.setDetails((Object) detail);
			}
			log.info("[END] CustomAuthenticationProvider.authenticate() is successfully!!!.");
			return authen;
		} catch (Exception e) {
			log.error("ERROR", e);
			log.info("[END] CustomAuthenticationProvider.authenticate() is failed.");
			throw e;
		}
	}

	private AuthenticationRequest createAuthenticationRequest(Authentication authentication) {
		String accountName = authentication.getName();
		String password = (String) authentication.getCredentials();
		String authenType = httpRequest.getParameter(DataConstants.RequestParams.AuthenType);
		String deviceType = httpRequest.getParameter(DataConstants.RequestParams.DeviceType);
		String deviceToken = httpRequest.getParameter(DataConstants.RequestParams.DeviceToken);
		String secureCode = httpRequest.getParameter(DataConstants.RequestParams.SecureCode);
		String secureType = httpRequest.getParameter(DataConstants.RequestParams.SecureType);
		String clientIp = httpRequest.getParameter(DataConstants.RequestParams.ClientIp);
		String serviceIdParam = httpRequest.getParameter(DataConstants.RequestParams.ServiceId);
		String campaign = httpRequest.getParameter(DataConstants.RequestParams.Campaign);
		String medium = httpRequest.getParameter(DataConstants.RequestParams.Medium);
		String source = httpRequest.getParameter(DataConstants.RequestParams.Source);
		String agency = httpRequest.getParameter(DataConstants.RequestParams.Agency);
		String clientId = httpRequest.getParameter(DataConstants.RequestParams.ClientId);
		String gaTrackingId = httpRequest.getParameter(DataConstants.RequestParams.GaTrackingId);
		String gaClientId = httpRequest.getParameter(DataConstants.RequestParams.GaClientId);
		String hitType = httpRequest.getParameter(DataConstants.RequestParams.HitType);
		String eventCategory = httpRequest.getParameter(DataConstants.RequestParams.EventCategory);
		String eventAction = httpRequest.getParameter(DataConstants.RequestParams.EventAction);
		String eventLabel = httpRequest.getParameter(DataConstants.RequestParams.EventLabel);
		String manufacture = httpRequest.getParameter(DataConstants.RequestParams.Manufacture);
		String modelName = httpRequest.getParameter(DataConstants.RequestParams.ModelName);
		String operatingSystem = httpRequest.getParameter(DataConstants.RequestParams.OperatingSystem);
		String operatingSystemVersion = httpRequest.getParameter(DataConstants.RequestParams.OperatingSystemVersion);

		Integer serviceId = MathUtil.parseInt(serviceIdParam);
		// authen billing
		Integer auType = MathUtil.parseInt(authenType);
		Integer deType = MathUtil.parseInt(deviceType);
		Integer secureTypeInteger = MathUtil.parseInt(secureType);
		
		AuthenticationRequest request = new AuthenticationRequest();
		request.setAccountName(accountName);
		request.setPassword(password);
		request.setAuthenType(auType);
		request.setDeviceType(deType);
		request.setSecureType(secureTypeInteger);
		request.setSecureCode(secureCode);
		request.setClientIp(clientIp);
		request.setClientId(clientId);
		request.setCampaign(campaign);
		request.setMedium(medium);
		request.setSource(source);
		request.setAgency(agency);
		request.setManufacture(manufacture);
		request.setModelName(modelName);
		request.setOperatingSystem(operatingSystem);
		request.setOperatingSystemVersion(operatingSystemVersion);
		TrackingModel trackingModel = new TrackingModel()
				.setGaTrackingId(gaTrackingId)
				.setGaClientId(gaClientId)
				.setHitType(StringUtils.isEmpty(hitType) ? GaParams.TypeEventHit.Event : hitType)
				.setCampaignName(campaign)
				.setCampaignSource(source)
				.setCampaignMedium(medium)
				.setCategory(eventCategory)
				.setAction(eventAction)
				.setLabel(eventLabel);
		request.setTrackingModel(trackingModel);
		request.setServiceId(serviceId);
		request.setDeviceToken(deviceToken);
		
		return request;
		
	}

	private Authentication authenticateSocial() throws AuthenticationException {
		try {
//			 String authen_social = httpRequest.getParameter("authenSocial");

			String oAuthSystemIdParam = httpRequest.getParameter(DataConstants.RequestParams.OAuthSystemId);
			String oAuthAccount = httpRequest.getParameter(DataConstants.RequestParams.OAuthAccount);
			String serviceIdParam = httpRequest.getParameter(DataConstants.RequestParams.ServiceId);
			String secureCode = httpRequest.getParameter(DataConstants.RequestParams.SecureCode);
			String secureTypeParam = httpRequest.getParameter(DataConstants.RequestParams.SecureType);
			String deviceTypeParam = httpRequest.getParameter(DataConstants.RequestParams.DeviceType);
			String deviceToken = httpRequest.getParameter(DataConstants.RequestParams.DeviceToken);
			String clientIp = httpRequest.getParameter(DataConstants.RequestParams.ClientIp);
			String clientId = httpRequest.getParameter(DataConstants.RequestParams.ClientId);
			String isAutoCreateParam = httpRequest.getParameter(DataConstants.RequestParams.IsAutoCreate);
			String accountName = httpRequest.getParameter(DataConstants.RequestParams.UserName);
			String manufacture = httpRequest.getParameter(DataConstants.RequestParams.Manufacture);
			String modelName = httpRequest.getParameter(DataConstants.RequestParams.ModelName);
			String operatingSystem = httpRequest.getParameter(DataConstants.RequestParams.OperatingSystem);
			String operatingSystemVersion = httpRequest.getParameter(DataConstants.RequestParams.OperatingSystemVersion);
			
			String campaign = httpRequest.getParameter(DataConstants.RequestParams.Campaign);
			String medium = httpRequest.getParameter(DataConstants.RequestParams.Medium);
			String source = httpRequest.getParameter(DataConstants.RequestParams.Source);
			String agency = httpRequest.getParameter(DataConstants.RequestParams.Agency);
			String gaTrackingId = httpRequest.getParameter(DataConstants.RequestParams.GaTrackingId);
			String gaClientId = httpRequest.getParameter(DataConstants.RequestParams.GaClientId);
			String hitType = httpRequest.getParameter(DataConstants.RequestParams.HitType);
			String eventCategory = httpRequest.getParameter(DataConstants.RequestParams.EventCategory);
			String eventAction = httpRequest.getParameter(DataConstants.RequestParams.EventAction);
			String eventLabel = httpRequest.getParameter(DataConstants.RequestParams.EventLabel);
			String accessToken = httpRequest.getParameter(DataConstants.RequestParams.AccessToken);
			String isAutoAuthenParam = httpRequest.getParameter(DataConstants.RequestParams.IsAutoAuthen);

			String isDisableCheckSecureParam = httpRequest.getParameter(DataConstants.RequestParams.IsDisableCheckSecure);
			String signDisableSecure = httpRequest.getParameter(DataConstants.RequestParams.SignDisableSecure);

			Integer deviceType = MathUtil.parseInt(deviceTypeParam);
			Integer isAutoCreate = MathUtil.parseInt(isAutoCreateParam);
			Integer isDisableCheckSecure = MathUtil.parseInt(isDisableCheckSecureParam);
			Integer oAuthSystemId = MathUtil.parseInt(oAuthSystemIdParam);
			Integer secureType = MathUtil.parseInt(secureTypeParam);
			Integer serviceId = MathUtil.parseInt(serviceIdParam);
			Integer isAutoAuthen = MathUtil.parseInt(isAutoAuthenParam);
			
			AuthenticationRequest request = new AuthenticationRequest();
			request.setDeviceType(deviceType);
			request.setDeviceToken(deviceToken);
			request.setSecureType(secureType);
			request.setSecureCode(secureCode);
			request.setClientIp(clientIp);
			request.setClientId(clientId);
			request.setCampaign(campaign);
			request.setMedium(medium);
			request.setSource(source);
			request.setAgency(agency);
			request.setManufacture(manufacture);
			request.setModelName(modelName);
			request.setOperatingSystem(operatingSystem);
			request.setOperatingSystemVersion(operatingSystemVersion);
			request.setIsAutoAuthen(isAutoAuthen);
			TrackingModel trackingModel = new TrackingModel()
					.setGaTrackingId(gaTrackingId)
					.setGaClientId(gaClientId)
					.setHitType(hitType)
					.setCampaignName(campaign)
					.setCampaignSource(source)
					.setCampaignMedium(medium)
					.setCategory(eventCategory)
					.setAction(eventAction)
					.setLabel(eventLabel);
			request.setTrackingModel(trackingModel);
			request.setServiceId(serviceId);
			request.setSignDisableSecure(signDisableSecure);
			request.setIsDisableCheckSecure(isDisableCheckSecure);
			request.setSignDisableSecure(signDisableSecure);
			request.setIsAutoCreate(isAutoCreate);
			request.setAccessToken(accessToken);
			request.setoAuthSystemId(oAuthSystemId);
			request.setoAuthAccount(oAuthAccount);
			request.setAccountName(accountName);
		
			AuthenSocialRequest socialRequest = commonUtils.linkToSocial(request, request.getoAuthSystemId(), request.getAccessToken());
			request.setEmail(socialRequest.getEmail());
			request.setFbEmail(socialRequest.getFbEmail());
			request.setoAuthAccount(socialRequest.getoAuthAccount());
			request.setFbBussinessIds(socialRequest.getFbBussinessIds());
			
			OAuthResponseData oauthSocial = userDetailsService.authenBySocial(request);
//			OAuthResponseData oauthSocial = userDetailsService.authenBySocial(clientIp, deviceType, fbBussinessIds,
//					fbEmail, isAutoCreate, isDisableCheckSecure, oAuthAccount, oAuthSystemId, secureCode, secureType,
//					serviceId, serviceKey, signDisableSecure);

			Integer responseCode = oauthSocial == null ? null : oauthSocial.getResponseCode();
			if (responseCode == null || responseCode < 0) {
				if (oauthSocial == null) {
					log.error(new StringBuffer("Username not found. fbBussinessIds = ").append(request.getFbBussinessIds()));
					throw new BadCredentialsException(responseCode, "Username not found.");
				}

				log.error(oauthSocial.getDescription());
				throw new BadCredentialsException(responseCode, oauthSocial.getDescription());
			}
			UserRepositoryUserDetails detail = new UserRepositoryUserDetails(oauthSocial);
			detail.setPassword(request.getFbBussinessIds());

			Collection<? extends GrantedAuthority> authorities = detail.getAuthorities();
			Authentication authen = new UsernamePasswordAuthenticationToken(detail, request.getFbBussinessIds(), authorities);
			authen.setDetails((Object) detail);
			return authen;
		} catch (Exception e) {
//			throw e;
//			throw new BadCredentialsException(-99, new StringBuffer("System error.").append(e.getMessage()).toString());
//			try {
//				throw e;
//			} catch (Exception e1) {
//				e1.printStackTrace();
//				log.error("ERROR", e);
//				throw new BadCredentialsException(, new StringBuffer(e.getMessage()).toString());
//			}
			if (e instanceof BadCredentialsException){
				throw (BadCredentialsException) e;
			}else{
				throw new BadCredentialsException(-190, new StringBuffer(e.getMessage()).toString());
			}
		}
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	public CustomUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}
}