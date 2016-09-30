package com.vtc.mongorepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vtc.mongocore.Accounts;

@Repository
public interface AccountRepository extends MongoRepository<Accounts, String>{
	List<Accounts> findAllByAccountName(String accountName);
	List<Accounts> findAllByAccountId(Integer accountId);
	@Override
	default Page<Accounts> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Query("{'$or':[{'accountId': ?0},{'accountName':?1}]}")
	List<Accounts> findAllByAccountIdOrAccountName(Integer accountId, String accountName);
}
