package com.vtc.business;

import java.util.List;

import com.vtc.mongocore.Game;
import com.vtc.mongocore.GameEnvironmentData;
import com.vtc.mongocore.PackagesData;

public interface GameService {
	PackagesData findPackageByClientIdAndKey(String clientId, String key, Integer packageType);
	
	List<PackagesData> getAllPackage(String clientId);
	
	String findTrackingIdByClientId(String clientId);
	
	Game findGameInfoByClientId(String clientId);
	
	GameEnvironmentData findEnvironmentByClientIdAndOS(String clientId, Integer os);
	
	List<GameEnvironmentData> findEnvironmentsByClientId(String clientId);
	
	List<PackagesData> getPackagesByPackageType(String clientId, Integer packageType);
}
