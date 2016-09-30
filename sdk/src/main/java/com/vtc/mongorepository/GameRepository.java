package com.vtc.mongorepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vtc.mongocore.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, String>{
	
	@Query("{'clientId': ?0}")
	List<Game> findAllByClientId(String clientId);
	
//	@Query("{'clientId': ?0, 'environments.name': ?0}")
//	List<Game> findAllByClientIdAndEnvironment(String clientId, String environmentName);
}
