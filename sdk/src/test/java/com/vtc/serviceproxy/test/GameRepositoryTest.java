package com.vtc.serviceproxy.test;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtc.mongocore.Game;
import com.vtc.mongorepository.GameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-mongo.xml "})
public class GameRepositoryTest {

	@Autowired
	public GameRepository gameRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String json = "{"
						   + "\"clientId\" : \"353b302c44574f565045687e534e7d6a1\","
						   + "\"gaTrackingId\" : \"UA-80367317-1\","
						   + "\"serverGame\" : \"Sv1\","
						   + "\"gameCode\" : \"DONGHAN\","
						   + "\"gameName\" : \"Dong han\","
						   + "\"packages\" : [" 
						   +     "{"
						   +       "\"key\" : \"K1\","
						   +       "\"packageType\" : 1,"
						   +       "\"mappingKeyApple\" : \"\","
						   +       "\"mappingKeyGoogle\" : \"\","
						   +       "\"name\" : \"Goi500V\","
						   +       "\"priceGold\" : 1000,"
						   +       "\"priceVcoin\" : 100,"
						   +       "\"priceUsd\" : 5,"
						   +       "\"priceVnd\" : 100000,"
						   +       "\"moneyScale\" : 100,"
						   +       "\"currency\" : \"KNB\","
						   +       "\"promotionalPercent\" : 0,"
						   +       "\"imageUrl\" : \"\","
						   +       "\"description\" : \"Mua 500 vang bang 5 vcoin\""
						   +     "}," 
						   +     "{"
						   +       "\"key\" : \"K2\","
						   +       "\"packageType\" : 1,"
						   +       "\"mappingKeyApple\" : \"\","
						   +       "\"mappingKeyGoogle\" : \"\","
						   +       "\"name\" : \"Goi1500V\","
						   +       "\"priceGold\" : 20000,"
						   +       "\"priceVcoin\" : 200,"
						   +       "\"priceUsd\" : 10,"
						   +	   "\"priceVnd\" : 200000,"
						   + 	   "\"moneyScale\" : 100,"
						   + 	   "\"currency\" : \"KNB\","
						   + 	   "\"promotionalPercent\" : 0,"
						   +       "\"imageUrl\" : \"\","
						   + 	   "\"description\" : \"Mua 1500 vang bang 10 vcoin\""
						   +     "},"
						   + 	"{"
						   + 		"\"key\" : \"P1\","
						   +       "\"packageType\" : 2,"
						   + 		"\"mappingKeyApple\" : \"com.vtc.mobile.idol.099\","
						   + 		"\"mappingKeyGoogle\" : \"com.vtc.sdk\","
						   + 		"\"name\" : \"Goi500V\","
						   + 		"\"priceGold\" : 200,"
						   + 		"\"priceVcoin\" : 5,"
						   + 		"\"priceUsd\" : 1,"
						   + 		"\"priceVnd\" : 20000,"
						   + 		"\"moneyScale\" : 100,"
						   + 		"\"currency\" : \"KNB\","
						   + 		"\"promotionalPercent\" : 0,"
						   + 		"\"imageUrl\" : \"\","
						   + 		"\"description\" : \"Mua 500 vang bang 5 vcoin\""
						   + 	"},"
						   + 	"{"
						   + 		"\"key\" : \"P2\","
						   +       "\"packageType\" : 2,"
						   + 		"\"mappingKeyApple\" : \"com.vtc.mobile.idol.099\","
						   + 		"\"mappingKeyGoogle\" : \"com.vtc.sdk\","
						   + 		"\"name\" : \"Goi1500V\","
						   + 		"\"priceGold\" : 300,"
						   + 		"\"priceVcoin\" : 10,"
						   + 		"\"priceUsd\" : 3,"
						   + 		"\"priceVnd\" : 60000,"
						   + 		"\"moneyScale\" : 100,"
						   + 		"\"currency\" : \"KNB\","
						   + 		"\"promotionalPercent\" : 0,"
						   + 		"\"imageUrl\" : \"\","
						   + 		"\"description\" : \"Mua 1500 vang bang 10 vcoin\""
						   + 	"}"
						   + "],"
						   + "\"environments\" : ["
						   + 	"{"
						   + 		"\"name\" : \"iOS\","
						   + 		"\"version\" : \"1\""
						   + 	"},"
						   + 	"{"
						   + 		"\"name\" : \"Android\","
						   + 		"\"version\" : \"1\""
						   + 	"}"
						   + "],"
						   + "\"status\" : 1,"
						   + "\"description\" : \"\","
						   + "\"version\" : 1,"
						   + "\"createdTime\" : \"2016-07-28T03:22:34.666Z\","
						   + "\"updatedTime\" : \"2016-07-28T03:22:34.666Z\""
			    + "}";
		Game game = new Game();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			game = objectMapper.readValue(json, Game.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		gameRepository.save(game);
	}
}
