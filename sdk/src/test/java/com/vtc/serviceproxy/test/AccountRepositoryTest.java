package com.vtc.serviceproxy.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtc.mongocore.Accounts;
import com.vtc.mongorepository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-mongo.xml "})
public class AccountRepositoryTest {

	@Autowired
	protected AccountRepository accountRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		PageRequest request = new PageRequest(0, 2, new Sort(Sort.Direction.DESC, "accountName"));
		List<Accounts> accounts = accountRepository.findAllByAccountIdOrAccountName(117815994, "vtctest90");
		System.out.println("");
	}

}
