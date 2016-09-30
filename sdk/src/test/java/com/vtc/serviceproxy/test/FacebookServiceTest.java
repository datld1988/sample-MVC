package com.vtc.serviceproxy.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;
import com.vtc.config.SysConfig;
import com.vtc.model.UserInfoFb;
import com.vtc.serviceproxy.impl.FacebookServiceImpl;

import facebook4j.FacebookException;
import facebook4j.User;

@Configuration
@PropertySource("classpath:config/server.properties")
public class FacebookServiceTest {

	private FacebookServiceImpl facebookService = new FacebookServiceImpl();

	@Autowired
	private SysConfig sysConfig;
	
	@Before
	public void setUp() throws Exception {
		facebookService.setSysConfig(sysConfig);
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void getUserInfo() throws FacebookException {
		String accessToken = "EAAVZC0ivVapkBAPuoEq0wZAuL9NT0Rixvi2KL3CY5YNN17lvKKdqHNZAHVGtHS6WmfZBmFTZCdgbYqFeZBmb8QzlRWWhMhQoFpkTRTKjQTrbe5GUet8vWDl5WpK4YCuSdhsR1Ky1OxM7Hp0anRlxj16M9KaSNuwJcqJlGgofg5YLV5hVrrr92wWhP5CKfzqIEZD";
		User user = facebookService.getUserInfo(accessToken);
		
		System.out.println(user);
	}
	
	@Test
	public void getUserInfoByHttp() throws IOException {
		String accessToken = "EAACEdEose0cBAGjdvITawXe5hpUo3TGV640CV1hQgWCcVGAKBW9zS0fyV5Fdipgztkg06FT4vDw4V3N9DejNqZAbdNX7kBV5NjfNzvQBYueEk9ZCMZB9qt52WP5q7R9DcE9mYBjSZAypxiAwDREw33e3whYx3KW2F7GojpPVQQZDZD";
		String user = "{"
				+ "\"id\": \"1457183521\","
				+ " \"ids_for_business\": {"
				+ "\"data\": ["
				+ "{"
				     + "\"id\": \"1457183521\","
				       + "\"app\": {"
				        +  "\"category\": \"Entertainment\","
				        +  "\"link\": \"https://apps.facebook.com/vggentertainjsc\","
				         + "\"name\": \"VGG ID\","
				         + "\"namespace\": \"vggentertainjsc\","
				         + "\"id\": \"601926256515072\" "
				         + "} "
				      + "}, "
				      + "{ "
				      + "\"id\": \"10205803704039272\","
				      + "\"app\": {"
				      + "\"category\": \"Games\","
				      + "\"link\": \"https://www.facebook.com/games/vosongtamquoc/?fbs=-1\","
				      + "\"name\": \"Vô Song Tam Quốc\","
				      + "\"namespace\": \"vosongtamquoc\","
				      + "\"id\": \"839417099414184\""
				      + "}"
				      + "}"
				      + "]"
				      + "}"
				      + "}";//facebookService.getUserInfoByHttp(accessToken);
		
		
		
		UserInfoFb fb = new UserInfoFb();
		ObjectMapper om = new ObjectMapper();
		fb = om.readValue(user, UserInfoFb.class);
		
		List<String> ids = new ArrayList<>();
		fb.getIdsForBusiness().getData().stream().forEach(item ->{
			ids.add(item.getId());
		});
		String businessId = String.join(",", ids);
		
		System.out.println(businessId);
	}


}
