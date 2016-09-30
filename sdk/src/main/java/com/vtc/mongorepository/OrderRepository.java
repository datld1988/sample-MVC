package com.vtc.mongorepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vtc.mongocore.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	List<Order> findAllByOrderNo(String orderNo);
	List<Order> findAllByAccessTokenAndBillingAccessTokenAndStatus(String accessToken, String billingAccessToken, Integer status);
	List<Order> findAllByAccessToken(String accessToken);
	List<Order> findAllByAccessTokenAndBillingAccessToken(String accessToken, String billingAccessToken);
}
