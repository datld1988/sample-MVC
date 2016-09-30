package com.vtc.business.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vtc.business.GameService;
import com.vtc.dataconstant.DataConstants;
import com.vtc.dataconstant.DataConstants.OsType;
import com.vtc.mongocore.Game;
import com.vtc.mongocore.GameEnvironmentData;
import com.vtc.mongocore.PackagesData;
import com.vtc.mongorepository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Override
	public PackagesData findPackageByClientIdAndKey(String clientId, String key, Integer packageType) {
		List<Game> games = gameRepository.findAllByClientId(clientId);
		if (CollectionUtils.isEmpty(games)) {
			return new PackagesData();
		}

		Game game = games.stream().findFirst().get();
		List<PackagesData> listPackage = game.getPackages(); //packageType.compareTo(DataConstants.PackageType.VCOIN.getValue()) == 0 ? game.getPackagesVcoin() : game.getPackagesIAP(); game.getPackagesVcoin();
		if (CollectionUtils.isEmpty(listPackage)) {
			return new PackagesData();
		}
		
		if(packageType == null){
			return listPackage.stream().filter(item -> item.getKey().equals(key))
									  .findFirst()
									  .orElse(new PackagesData());
		}
		
		PackagesData result = listPackage.stream().filter(item -> item.getKey().equals(key) && item.getPackageType().compareTo(packageType) == 0)
												  .findFirst()
												  .orElse(null);

		return result;
	}

	@Override
	public String findTrackingIdByClientId(String clientId) {
		List<Game> games = gameRepository.findAllByClientId(clientId);
		if (CollectionUtils.isEmpty(games)) {
			return "";
		}

		Game game = games.stream().findFirst().get();

		return game == null ? "" : game.getGaTrackingId();
	}

	@Override
	public Game findGameInfoByClientId(String clientId) {
		List<Game> games = gameRepository.findAllByClientId(clientId);
		if (CollectionUtils.isEmpty(games)) {
			return new Game();
		}

		return games.stream().findFirst().get();
	}

	@Override
	public List<PackagesData> getAllPackage(String clientId) {
		List<PackagesData> listData = new ArrayList<>();
		List<Game> games = gameRepository.findAllByClientId(clientId);
		if (CollectionUtils.isEmpty(games)) {
			return listData;
		}

		Game game = games.stream().findFirst().get();
		if (game == null) {
			return listData;
		}
		List<PackagesData> listPackage = game.getPackages(); //packageType.compareTo(DataConstants.PackageType.VCOIN.getValue()) == 0 ? game.getPackagesVcoin() : game.getPackagesIAP();
		
		return listPackage;
	}

	@Override
	public GameEnvironmentData findEnvironmentByClientIdAndOS(String clientId, Integer os) {
		GameEnvironmentData data = new GameEnvironmentData();
		String osType = Arrays.stream(DataConstants.OsType.values())
				.filter(item -> item.getValue().compareTo(os) == 0)
				.findAny()
				.orElse(OsType.ALL)
				.getDisplay();
		List<Game> games = gameRepository.findAllByClientId(clientId);
		if(CollectionUtils.isEmpty(games)){
			return data;
		}
		
		Game gameItem = games.stream().findFirst().get();
		if(gameItem == null){
			return data;
		}
		
		List<GameEnvironmentData> environments = gameItem.getEnvironments();
		if(CollectionUtils.isEmpty(environments)){
			return data;
		}
		
		GameEnvironmentData gameEnvironment = environments.stream()
															.filter(item -> item.getName().equals(osType))
															.findAny()
															.orElse(new GameEnvironmentData());
		return gameEnvironment;
		
	}

	@Override
	public List<GameEnvironmentData> findEnvironmentsByClientId(String clientId) {
		List<GameEnvironmentData> data = new ArrayList<>();
		
		List<Game> games = gameRepository.findAllByClientId(clientId);
		if(CollectionUtils.isEmpty(games)){
			return data;
		}
		
		Game gameItem = games.stream().findFirst().get();
		if(gameItem == null){
			return data;
		}
		
		return gameItem.getEnvironments();
	}

	@Override
	public List<PackagesData> getPackagesByPackageType(String clientId, Integer packageType) {
		List<Game> games = gameRepository.findAllByClientId(clientId);
		List<PackagesData> packages = new ArrayList<>();
		if (CollectionUtils.isEmpty(games)) {
			return packages;
		}

		Game game = games.stream().findFirst().get();
		List<PackagesData> listPackage = game.getPackages(); 
		if (CollectionUtils.isEmpty(listPackage)) {
			return packages;
		}
		
		try{
			packages = listPackage.stream().filter(item -> item.getPackageType().compareTo(packageType) == 0)
												  .collect(Collectors.toList());
		}catch(Exception e){
			return new ArrayList<>();
		}
												 
		return packages;
	}
	
}
