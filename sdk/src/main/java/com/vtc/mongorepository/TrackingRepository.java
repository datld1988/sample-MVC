package com.vtc.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vtc.mongocore.Tracking;

@Repository
public interface TrackingRepository extends MongoRepository<Tracking, String> {

}
