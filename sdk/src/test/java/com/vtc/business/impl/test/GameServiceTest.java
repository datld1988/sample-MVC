package com.vtc.business.impl.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtc.mongocore.Events;
import com.vtc.mongorepository.EventsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/WEB-INF/spring-mongo.xml","classpath:**/WEB-INF/web.xml",})
public class GameServiceTest {

	@Resource
	EventsRepository eventsRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readData() {
		List<Events> listEvent = eventsRepository.findAllByTypeAndAdsId("INSTALLED", "1bc16b8f-7b0c-46dc-958f-2313fb2749b6");

		System.out.println("1111");
	}

}
