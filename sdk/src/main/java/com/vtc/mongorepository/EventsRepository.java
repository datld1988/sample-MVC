package com.vtc.mongorepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vtc.mongocore.Events;

@Repository
public interface EventsRepository extends MongoRepository<Events, String> {
	List<Events> findAllByTypeAndAdsId(String type, String adsId);
}
