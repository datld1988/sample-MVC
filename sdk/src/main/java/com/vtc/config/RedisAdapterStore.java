package com.vtc.config;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.stereotype.Service;


/**
 * Token store that mirrors InMemoryTokenStore, but uses Redis instead of
 * ConcurrentHashMaps
 *
 *
 */
@Service
public class RedisAdapterStore {
	private static final Logger log = Logger.getLogger(RedisAdapterStore.class);

	private static final StringRedisSerializer STRING_SERIALIZER = new StringRedisSerializer();
	private static final JdkSerializationRedisSerializer OBJECT_SERIALIZER = new JdkSerializationRedisSerializer();
	public static final String USER_RATE = "user_rate:";
	public static final String USER_WARNING = "user_warning:";

	@Autowired
	private RedisConnectionFactory jedisConnFactory;

//	public RedisAdapterStore(RedisConnectionFactory connectionFactory) {
//		this.connectionFactory = connectionFactory;
//	}

	private RedisConnection getConnection() {
		int count = 5;
		while (count != 0) {
			try {
				return jedisConnFactory.getConnection();
			} catch (Exception e) {
				count --;
			}
		}
		return jedisConnFactory.getConnection();
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

	public void storeUserRate(String trackerId, String rate) {
		RedisConnection conn = getConnection();
		try {
			byte[] field = serialize(rate);
			conn.rPush(serialize(USER_RATE + trackerId), field);
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

	public void storeWarningRate(String trackerId) {
		RedisConnection conn = getConnection();
		try {
			long t = System.currentTimeMillis();
			byte[] key = serialize(USER_WARNING + trackerId);
			byte[] field = serialize(String.valueOf(t));
			conn.del(key);
			conn.rPush(key, field);
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

	public String getUserWarning(String trackerId) {
		RedisConnection conn = getConnection();
		try {
			byte[] key = serialize(USER_WARNING + trackerId);
			List<byte[]> byteList = conn.lRange(key, 0, -1);
			if (byteList == null || byteList.size() == 0) {
				return null;
			}
			List<String> listRate = new ArrayList<>(byteList.size());
			for (byte[] bytes : byteList) {
				String accessToken = deserializeString(bytes);
				listRate.add(accessToken);
			}
			if (listRate == null || listRate.size() == 0) {
				return null;
			}
			return listRate.get(0);
		} finally {
			conn.close();
		}
	}
	public List<String> getUserRate(String trackerId) {
		RedisConnection conn = getConnection();
		try {
			byte[] unameKey = serialize(USER_RATE + trackerId);
			List<byte[]> byteList = conn.lRange(unameKey, 0, -1);
			if (byteList == null || byteList.size() == 0) {
				return null;
			}
			List<String> listRate = new ArrayList<>(byteList.size());
			for (byte[] bytes : byteList) {
				String accessToken = deserializeString(bytes);
				listRate.add(accessToken);
			}
			if (listRate == null || listRate.size() == 0) {
				return null;
			}
			return listRate;
		} finally {
			conn.close();
		}
	}

	public void removeAll(String trackerId) {
		RedisConnection conn = getConnection();
		try {
			conn.del(serialize(USER_RATE + trackerId));
			conn.closePipeline();
		} finally {
			conn.close();
		}
	}

}