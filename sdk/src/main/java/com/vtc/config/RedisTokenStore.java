package com.vtc.config;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.vtc.aspect.Loggable;
import com.vtc.entity.authen.UserRepositoryUserDetails;
import com.vtc.model.AccountInfoFullModel;
import com.vtc.model.BillingTokenModel;

/**
 * Token store that mirrors InMemoryTokenStore, but uses Redis instead of
 * ConcurrentHashMaps
 *
 *
 */
public class RedisTokenStore implements TokenStore {
	private static final Logger log = Logger.getLogger(RedisTokenStore.class);

	private static final StringRedisSerializer STRING_SERIALIZER = new StringRedisSerializer();
	private static final JdkSerializationRedisSerializer OBJECT_SERIALIZER = new JdkSerializationRedisSerializer();
	private static final byte[] ACCESS = serialize("access");
	private static final byte[] AUTH_TO_ACCESS = serialize("auth_to_access");
	private static final byte[] AUTH = serialize("auth");
	private static final byte[] REFRESH_AUTH = serialize("refresh_auth");
	private static final byte[] ACCESS_TO_REFRESH = serialize("access_to_refresh");
	private static final byte[] REFRESH = serialize("refresh");
	private static final byte[] REFRESH_TO_ACCESS = serialize("refresh_to_access");
	private static final String CLIENT_ID_TO_ACCESS = "client_id_to_access:";
	public static final String UNAME_TO_ACCESS = "uname_to_access:";
	public static final String USER_INFO_ACCOUNT = "user_info_account:";
//	public static final String USER_BILLING_TOKEN = "user_billing_token:";
//	public static final String USER_AUTHENTICATION = "user_authentication:";

	private final AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();

	private final RedisConnectionFactory connectionFactory;

	public RedisTokenStore(RedisConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	private RedisConnection getConnection() {
		int count = 5;
		while (count != 0) {
			try {
				return connectionFactory.getConnection();
			} catch (Exception e) {
				count --;
			}
		}
		return connectionFactory.getConnection();
	}

	private static byte[] serialize(Object object) {
		return OBJECT_SERIALIZER.serialize(object);
	}

	private static OAuth2AccessToken deserializeAccessToken(byte[] bytes) {
		return (OAuth2AccessToken) OBJECT_SERIALIZER.deserialize(bytes);
	}

	private static OAuth2Authentication deserializeAuthentication(byte[] bytes) {
		return (OAuth2Authentication) OBJECT_SERIALIZER.deserialize(bytes);
	}

	private static OAuth2RefreshToken deserializeRefreshToken(byte[] bytes) {
		return (OAuth2RefreshToken) OBJECT_SERIALIZER.deserialize(bytes);
	}

	private static byte[] serialize(String string) {
		return STRING_SERIALIZER.serialize(string);
	}

	private static String deserializeString(byte[] bytes) {
		return STRING_SERIALIZER.deserialize(bytes);
	}

	@Loggable
	@Override
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		RedisConnection conn = getConnection();
		try {
			String key = authenticationKeyGenerator.extractKey(authentication);
			byte[] bytes = conn.hGet(AUTH_TO_ACCESS, serialize(key));
			OAuth2AccessToken accessToken = deserializeAccessToken(bytes);
			if (accessToken != null
					&& !key.equals(authenticationKeyGenerator.extractKey(readAuthentication(accessToken.getValue())))) {
				// Keep the stores consistent (maybe the same user is
				// represented by this authentication but the details have
				// changed)
				storeAccessToken(accessToken, authentication);
			}
			return accessToken;
		
		} catch (Exception e) {
			System.out.println("RedisTokenStore.getAccessToken()");
			log.error("ERROR", e);
		} finally {
			conn.close();
		}
		return null;
		
	}

	@Override
	public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
		return readAuthentication(token.getValue());
	}

	@Override
	public OAuth2Authentication readAuthentication(String token) {
		RedisConnection conn = getConnection();
		try {
			byte[] bytes = conn.hGet(AUTH, serialize(token));
			OAuth2Authentication auth = deserializeAuthentication(bytes);
			return auth;
		} finally {
			conn.close();
		}
	}

	@Override
	public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
		return readAuthenticationForRefreshToken(token.getValue());
	}

	public OAuth2Authentication readAuthenticationForRefreshToken(String token) {
		RedisConnection conn = getConnection();
		try {
			byte[] bytes = conn.hGet(REFRESH_AUTH, serialize(token));
			OAuth2Authentication auth = deserializeAuthentication(bytes);
			return auth;
		} finally {
			conn.close();
		}
	}

	@Override
	public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
		RedisConnection conn = getConnection();
		String tokenKey = token.getValue();
		try {
			byte[] field = serialize(tokenKey);
			byte[] serializedAccessToken = serialize(token);
			byte[] serializedAuth = serialize(authentication);
			conn.openPipeline();

			// bachnx store token billing
//			Object object = authentication.getDetails();
//			if (object instanceof UserRepositoryUserDetails) {
//				UserRepositoryUserDetails userDetail = (UserRepositoryUserDetails) object;
//				BillingTokenModel billing = new BillingTokenModel();
//				billing.setId(userDetail.getId());
//				billing.setUserName(userDetail.getUserName());
//				billing.setPassword(userDetail.getPassword());
//				billing.setServiceId(userDetail.getServiceId());
//				billing.setServiceKey(userDetail.getServiceKey());
//				billing.setBillingAccessToken(userDetail.getBillingAccessToken());
//
//				byte[] serializedBilling = serialize(billing.toString());
//				byte[] tokenKeyBilling = serialize(new StringBuffer(USER_BILLING_TOKEN).append(tokenKey).toString());
//				conn.del(tokenKeyBilling);
//				conn.rPush(tokenKeyBilling, serializedBilling);
//			}

			conn.hSet(ACCESS, field, serializedAccessToken);
			conn.hSet(AUTH, field, serializedAuth);
			conn.hSet(AUTH_TO_ACCESS, serialize(authenticationKeyGenerator.extractKey(authentication)),
					serializedAccessToken);
			if (!authentication.isClientOnly()) {
//				String approvalKey = UNAME_TO_ACCESS + getApprovalKey(authentication);
				String approvalKey = UNAME_TO_ACCESS + authentication.getUserAuthentication().getName();
				conn.del(serialize(approvalKey));
				conn.rPush(serialize(approvalKey), serializedAccessToken);
			}
			
//			String clientId = CLIENT_ID_TO_ACCESS + authentication.getOAuth2Request().getClientId();
			String clientId = CLIENT_ID_TO_ACCESS + authentication.getAuthorizationRequest().getClientId();
			conn.del(serialize(clientId));
			conn.rPush(serialize(clientId), serializedAccessToken);
			if (token.getExpiration() != null) {
				// TODO
				// TokenExpiry expiry = new TokenExpiry(token.getValue(),
				// token.getExpiration());
				// // Remove existing expiry for this token if present
				// expiryQueue.remove(expiryMap.put(token.getValue(), expiry));
				// expiryQueue.put(expiry);
			}
			if (token.getRefreshToken() != null && token.getRefreshToken().getValue() != null) {
				byte[] refresh = serialize(token.getRefreshToken().getValue());
				byte[] auth = serialize(token.getValue());
				conn.hSet(REFRESH_TO_ACCESS, refresh, auth);
				conn.hSet(ACCESS_TO_REFRESH, auth, refresh);
			}
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

//	public void storeAccountInfo(UserAuthen user) {
//		RedisConnection conn = getConnection();
//		user.setTimeStored(System.currentTimeMillis());
//		try {
//			byte[] field = serialize(user.toString());
//			conn.del(serialize(USER_INFO_ACCOUNT + user.getUserName()));
//			conn.rPush(serialize(USER_INFO_ACCOUNT + user.getUserName()), field);
//			conn.closePipeline();
//		} finally {
//			conn.close();
//		}
//	}

	public void storeAccountInfo(AccountInfoFullModel user) {
		RedisConnection conn = getConnection();
		user.setTimeStored(System.currentTimeMillis());
		try {
			byte[] field = serialize(user.toString());
			conn.del(serialize(USER_INFO_ACCOUNT + user.getUserName()));
			conn.rPush(serialize(USER_INFO_ACCOUNT + user.getUserName()), field);
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

	public String getAccountInfo(String userName) {
		RedisConnection conn = getConnection();
		try {
			byte[] unameKey = serialize(USER_INFO_ACCOUNT + userName);
			List<byte[]> byteList = conn.lRange(unameKey, 0, -1);
			if (byteList == null || byteList.size() == 0) {
				return null;
			}
			List<String> accessTokens = new ArrayList<>(byteList.size());
			for (byte[] bytes : byteList) {
				String accessToken = deserializeString(bytes);
				accessTokens.add(accessToken);
			}
			if (accessTokens == null || accessTokens.size() == 0) {
				return null;
			}
			return accessTokens.get(0);
		} finally {
			conn.close();
		}
	}

//	public List<String> getBillingAccessToken(String tokenKey) {
//		RedisConnection conn = getConnection();
//		try {
//			byte[] unameKey = serialize(USER_BILLING_TOKEN + tokenKey);
//			List<byte[]> byteList = conn.lRange(unameKey, 0, -1);
//			if (byteList == null || byteList.size() == 0) {
//				return null;
//			}
//			List<String> accessTokens = new ArrayList<>(byteList.size());
//			for (byte[] bytes : byteList) {
//				String accessToken = deserializeString(bytes);
//				accessTokens.add(accessToken);
//			}
//			if (accessTokens == null || accessTokens.size() == 0) {
//				return null;
//			}
//			return accessTokens;
//		} finally {
//			conn.close();
//		}
//	}


	@Override
	public void removeAccessToken(OAuth2AccessToken accessToken) {
		removeAccessToken(accessToken.getValue());
	}

	@Override
	public OAuth2AccessToken readAccessToken(String tokenValue) {
		RedisConnection conn = getConnection();
		try {
			byte[] bytes = conn.hGet(ACCESS, serialize(tokenValue));
			OAuth2AccessToken accessToken = deserializeAccessToken(bytes);
			return accessToken;
		} finally {
			conn.close();
		}
	}

	public void removeAccessToken(String tokenValue) {
		RedisConnection conn = getConnection();
		try {
			byte[] field = serialize(tokenValue);
			conn.openPipeline();
			conn.hGet(ACCESS, field);
			conn.hGet(AUTH, field);
			List<Object> results = conn.closePipeline();
			byte[] removedBytes = (byte[]) results.get(0);
			byte[] authBytes = (byte[]) results.get(1);
			OAuth2Authentication authentication = deserializeAuthentication(authBytes);
			conn.openPipeline();
			conn.hDel(ACCESS, field);
			conn.hDel(ACCESS_TO_REFRESH, field);
			// Don't remove the refresh token - it's up to the caller to do that
			conn.hDel(AUTH, field);
			if (authentication != null) {
				byte[] authKey = serialize(authenticationKeyGenerator.extractKey(authentication));
				conn.hDel(AUTH_TO_ACCESS, authKey);
				byte[] unameKey = serialize(UNAME_TO_ACCESS + authentication.getName());
				conn.lRem(unameKey, 1, removedBytes);
//				byte[] clientId = serialize(CLIENT_ID_TO_ACCESS + authentication.getOAuth2Request().getClientId());
				byte[] clientId = serialize(CLIENT_ID_TO_ACCESS + authentication.getAuthorizationRequest().getClientId());
				conn.lRem(clientId, 1, removedBytes);
				conn.hDel(ACCESS, authKey);
			}
			conn.del(serialize(USER_INFO_ACCOUNT + authentication.getName()));
//			conn.del(serialize(USER_AUTHENTICATION + authentication.getName()));
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

	@Override
	public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
		RedisConnection conn = getConnection();
		try {
			byte[] field = serialize(refreshToken.getValue());
			conn.openPipeline();
			conn.hSet(REFRESH, field, serialize(refreshToken));
			conn.hSet(REFRESH_AUTH, field, serialize(authentication));
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

	@Override
	public OAuth2RefreshToken readRefreshToken(String tokenValue) {
		RedisConnection conn = getConnection();
		try {
			byte[] bytes = conn.hGet(REFRESH, serialize(tokenValue));
			OAuth2RefreshToken refreshToken = deserializeRefreshToken(bytes);
			return refreshToken;
		} finally {
			conn.close();
		}
	}

	@Override
	public void removeRefreshToken(OAuth2RefreshToken refreshToken) {
		removeRefreshToken(refreshToken.getValue());
	}

	public void removeRefreshToken(String tokenValue) {
		RedisConnection conn = getConnection();
		try {
			byte[] field = serialize(tokenValue);
			conn.openPipeline();
			conn.hDel(REFRESH, field);
			conn.hDel(REFRESH_TO_ACCESS, field);
			conn.hDel(ACCESS_TO_REFRESH, field);
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

	@Override
	public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
		removeAccessTokenUsingRefreshToken(refreshToken.getValue());
	}

	private void removeAccessTokenUsingRefreshToken(String refreshToken) {
		RedisConnection conn = getConnection();
		try {
			byte[] field = serialize(refreshToken);
			byte[] bytes = conn.hGet(REFRESH_TO_ACCESS, field);
			String accessToken = deserializeString(bytes);
			conn.hDel(REFRESH_TO_ACCESS, field);
			if (accessToken != null) {
				removeAccessToken(accessToken);
			}
		} finally {
			conn.close();
		}
	}

//	@Override
//	public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
//		RedisConnection conn = getConnection();
//		try {
//			byte[] approvalKey = serialize(UNAME_TO_ACCESS + getApprovalKey(clientId, userName));
//			List<byte[]> byteList = conn.lRange(approvalKey, 0, -1);
//			if (byteList == null || byteList.size() == 0) {
//				return Collections.<OAuth2AccessToken> emptySet();
//			}
//			List<OAuth2AccessToken> accessTokens = new ArrayList<>(byteList.size());
//			for (byte[] bytes : byteList) {
//				OAuth2AccessToken accessToken = deserializeAccessToken(bytes);
//				accessTokens.add(accessToken);
//			}
//			return Collections.<OAuth2AccessToken> unmodifiableCollection(accessTokens);
//		} finally {
//			conn.close();
//		}
//	}
	@Override
	public Collection<OAuth2AccessToken> findTokensByUserName(String userName) {
		RedisConnection conn = getConnection();
		try {
			byte[] unameKey = serialize(UNAME_TO_ACCESS + userName);
//			byte[] approvalKey = serialize(UNAME_TO_ACCESS + getApprovalKey(clientId, userName));
			List<byte[]> byteList = conn.lRange(unameKey, 0, -1);
			if (byteList == null || byteList.size() == 0) {
				return Collections.<OAuth2AccessToken> emptySet();
			}
			List<OAuth2AccessToken> accessTokens = new ArrayList<>(byteList.size());
			for (byte[] bytes : byteList) {
				OAuth2AccessToken accessToken = deserializeAccessToken(bytes);
				accessTokens.add(accessToken);
			}
			return Collections.<OAuth2AccessToken> unmodifiableCollection(accessTokens);
		} finally {
			conn.close();
		}
	}

	@Override
	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
		RedisConnection conn = getConnection();
		try {
			String key = CLIENT_ID_TO_ACCESS + clientId;
			List<byte[]> byteList = conn.lRange(serialize(key), 0, -1);
			if (byteList == null || byteList.size() == 0) {
				return Collections.<OAuth2AccessToken> emptySet();
			}
			List<OAuth2AccessToken> accessTokens = new ArrayList<>(byteList.size());
			for (byte[] bytes : byteList) {
				OAuth2AccessToken accessToken = deserializeAccessToken(bytes);
				accessTokens.add(accessToken);
			}
			return Collections.<OAuth2AccessToken> unmodifiableCollection(accessTokens);
		} finally {
			conn.close();
		}

	}

}