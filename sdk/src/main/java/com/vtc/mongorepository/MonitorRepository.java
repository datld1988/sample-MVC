package com.vtc.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vtc.mongocore.Monitor;

@Repository
public interface MonitorRepository extends MongoRepository<Monitor, String>{

}
