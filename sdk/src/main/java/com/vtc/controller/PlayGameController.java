package com.vtc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtc.business.CommonUtils;
import com.vtc.business.GameService;
import com.vtc.business.ServiceUtils;
import com.vtc.dataconstant.DataConstants;
import com.vtc.model.GoogleVerifyResponse;
import com.vtc.mongocore.Game;
import com.vtc.mongocore.GameEnvironmentData;
import com.vtc.mongocore.PackagesData;
import com.vtc.request.GamePaymentRequest;
import com.vtc.response.PackagesDataResponse;
import com.vtc.response.ResponseModel;
import com.vtc.util.PConstants;

import facebook4j.internal.logging.Logger;

@Controller
public class PlayGameController {
	private static Logger log = Logger.getLogger(PlayGameController.class);
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private ServiceUtils serviceUtils;
	
	@Autowired
	private CommonUtils commonUtils;
	
	/**
	 * @api {GET} /manage/packagenormal?client_id={clientId}&package_key={package_key} Get Packages Normal
	 * @apiName GetPackageNormal
	 * @apiGroup Manage
	 * 
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} client_id	Mandatory Client_Id for mapping with server
	 * @apiParam {String} package_key	Mandatory package_key for mapping with server if not input then get all package
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *	HTTP/1.1 200 OK
	 *	{
	 *		"error": 200,			
	 *		"message": "Success",									
	 *		"info": [
	 *			{
	 *				"key": "P1",
	 *				"packageType": 1,
	 *				"packagePaymentType": 1,
	 *				"name": "Goi500V",
	 *				"priceGold": 500,
	 *				"priceVcoin": 5,
	 *				"priceUsd": 5,
	 *				"priceVnd": 500,
	 *				"moneyScale": 0,
	 *				"currency": "KNB",
	 *				"promotionalPercent": 0,
	 *				"imageUrl": "",
	 *				"description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold":` 1000
	 *			},
	 *			{
	 *				"key": "P2",
	 *				"packageType": 1,
	 *				"packagePaymentType": 1,
	 *				"name": "Goi1500V",
	 *				"priceGold": 1500,
	 *				"priceVcoin": 10,
	 *				"priceUsd": 10,
	 *				"priceVnd": 1500,
	 *				"moneyScale": 0,
	 *				"currency": "KNB",
	 *				"promotionalPercent": 0,
	 *				"imageUrl": "",
	 *				"description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold": 1000
	 *			}
	 *		]
	 *	}
	 * @apiSuccess {String} packageType Type of packages in SDK (1:Normal, 2:MonthCard)
	 * @apiSuccess {String} packagePaymentType PaymentType of packages in SDK (1:All, 2:Vcoin, 3:InAppPurchase)
	 * @apiDescription This is the Description.
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/packagenormal", method = RequestMethod.GET)  
	@ResponseBody
	public ResponseModel getPackagesNormal(
			@RequestParam(value = DataConstants.RequestParams.ClientId, required = true, defaultValue = "") String clientId,
			@RequestParam(value = DataConstants.RequestParams.Package, required = true, defaultValue = "") String packageKey
			){
		ResponseModel response = new ResponseModel();
		try {
			if(StringUtils.isEmpty(packageKey)){
				List<PackagesData> result = gameService.getPackagesByPackageType(clientId, DataConstants.PackageType.NORMAL.getValue());
				if(CollectionUtils.isEmpty(result)){
					return new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, null);
				}
				List<PackagesDataResponse> responseData = new ArrayList<PackagesDataResponse>();
				
				result.stream().forEach(item -> {
					responseData.add(new PackagesDataResponse(item));
				});
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}else{
				PackagesData result = gameService.findPackageByClientIdAndKey(clientId, packageKey, DataConstants.PackageType.NORMAL.getValue());
				if(result == null){
					return new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, null);
				}
				PackagesDataResponse responseData = new PackagesDataResponse(result); 
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {GET} /manage/packagemonthcard?client_id={clientId}&package_key={package_key} Get Package Month Card
	 * @apiName GetPackageMonthCard
	 * @apiGroup Manage
	 * 
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} client_id	Mandatory Client_Id for mapping with server
	 * @apiParam {String} package_key	Mandatory package_key for mapping with server if not input then get all package
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *	HTTP/1.1 200 OK
	 *	{
	 *		"error": 200,			
	 *		"message": "Success",									
	 *		"info": [
	 *			{
	 *				"key": "P1",
	 *				"packageType": 2,
	 *				"packagePaymentType": 2,
	 *				"name": "Goi500V",
	 *				"priceGold": 500,
	 *				"priceVcoin": 5,
	 *				"priceUsd": 5,
	 *				"priceVnd": 500,
	 *				"moneyScale": 0,
	 *				"currency": "KNB",
	 *				"promotionalPercent": 0,
	 *				"imageUrl": "",
	 *				"description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold":` 1000
	 *			},
	 *			{
	 *				"key": "P2",
	 *				"packageType": 2,
	 *				"packagePaymentType": 2,
	 *				"name": "Goi1500V",
	 *				"priceGold": 1500,
	 *				"priceVcoin": 10,
	 *				"priceUsd": 10,
	 *				"priceVnd": 1500,
	 *				"moneyScale": 0,
	 *				"currency": "KNB",
	 *				"promotionalPercent": 0,
	 *				"imageUrl": "",
	 *				"description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold": 1000
	 *			}
	 *		]
	 *	}
	 * @apiSuccess {String} packageType Type of packages in SDK (1:Normal, 2:MonthCard)
	 * @apiSuccess {String} packagePaymentType PaymentType of packages in SDK (1:All, 2:Vcoin, 3:InAppPurchase)
	 * @apiDescription This is the Description.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/packagemonthcard", method = RequestMethod.GET)  
	@ResponseBody
	public ResponseModel getPackageMonthCard(
			@RequestParam(value = DataConstants.RequestParams.ClientId, required = true, defaultValue = "") String clientId,
			@RequestParam(value = DataConstants.RequestParams.Package, required = true, defaultValue = "") String packageKey
			){
		ResponseModel response = new ResponseModel();
		try {
			if(StringUtils.isEmpty(packageKey)){
				List<PackagesData> result = gameService.getPackagesByPackageType(clientId, DataConstants.PackageType.MONTH_CARD.getValue());
				if(CollectionUtils.isEmpty(result)){
					return new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, null);
				}
				List<PackagesDataResponse> responseData = new ArrayList<PackagesDataResponse>();
				result.stream().forEach(item -> {
					responseData.add(new PackagesDataResponse(item));
				});
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}else{
				PackagesData result = gameService.findPackageByClientIdAndKey(clientId, packageKey, DataConstants.PackageType.MONTH_CARD.getValue());
				if(result == null){
					return new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, null);
				}
				PackagesDataResponse responseData = new PackagesDataResponse(result);
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {GET} /manage/packages?client_id={clientId}&package_key={package_key} Get All Package
	 * @apiName GetPackage
	 * @apiGroup Manage
	 * 
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} client_id	Mandatory Client_Id for mapping with server
	 * @apiParam {String} package_key	Optional package_key for mapping with server if not input then get all package
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *	HTTP/1.1 200 OK
	 *	{
	 *		"error": 200,			
	 *		"message": "Success",									
	 *		"info": [
	 *			{
	 *				"key": "P1",
	 *				"packageType": 1,
	 *				"packagePaymentType": 1,
	 *				"name": "Goi500V",
	 *				"priceGold": 500,
	 *				"priceVcoin": 5,
	 *				"priceUsd": 5,
	 *				"priceVnd": 500,
	 *				"moneyScale": 0,
	 *				"currency": "KNB",
	 *				"promotionalPercent": 0,
	 *				"imageUrl": "",
	 *				"description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold":` 1000
	 *			},
	 *			{
	 *				"key": "P2",
	 *				"packageType": 2,
	 *				"packagePaymentType": 2,
	 *				"name": "Goi1500V",
	 *				"priceGold": 1500,
	 *				"priceVcoin": 10,
	 *				"priceUsd": 10,
	 *				"priceVnd": 1500,
	 *				"moneyScale": 0,
	 *				"currency": "KNB",
	 *				"promotionalPercent": 0,
	 *				"imageUrl": "",
	 *				"description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold": 1000
	 *			}
	 *		]
	 *	}
	 *
	 * @apiSuccess {String} packageType Type of packages in SDK (1:Normal, 2:MonthCard)
	 * @apiSuccess {String} packagePaymentType PaymentType of packages in SDK (1:All, 2:Vcoin, 3:InAppPurchase)
	 * @apiDescription This is the Description.
	 *	
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/packages", method = RequestMethod.GET)  
	@ResponseBody
	public ResponseModel getPackages(
			@RequestParam(value = DataConstants.RequestParams.ClientId, required = true, defaultValue = "") String clientId,
			@RequestParam(value = DataConstants.RequestParams.Package, required = true, defaultValue = "") String packageKey
			){
		ResponseModel response = new ResponseModel();
		try {
			if(StringUtils.isEmpty(packageKey)){
				List<PackagesData> result = gameService.getAllPackage(clientId);
				if(CollectionUtils.isEmpty(result)){
					return new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, null);
				}
				List<PackagesDataResponse> responseData = new ArrayList<PackagesDataResponse>();
				result.stream().forEach(item -> {
					responseData.add(new PackagesDataResponse(item));
				});
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}else{
				PackagesData result = gameService.findPackageByClientIdAndKey(clientId, packageKey, null);
				if(result == null){
					return new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, null);
				}
				PackagesDataResponse responseData = new PackagesDataResponse(result);
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {GET} /manage/trackingid/{clientId} Get GA TrackingId by ClientId
	 * @apiName getGATrackingId
	 * @apiGroup Manage
	 * 
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": "Success",									
	 *			  "info": "UA-80367317-1"
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/manage/trackingid/{clientId}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel getTrackingIdByClientId(@PathVariable String clientId){
		ResponseModel response = new ResponseModel(); 
		try {
			String gaTrackingId = gameService.findTrackingIdByClientId(clientId);
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, gaTrackingId);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {GET} /manage/gameInfo/{clientId} Get GameInfo By ClientId
	 * @apiName GetGameInfo
	 * @apiGroup Manage
	 * 
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
	 *		    "id": "5799b00c7debaaaee5c88f3f",
	 *		    "clientId": "353b302c44574f565045687e534e7d6a",
	 *		    "gaTrackingId": "UA-80367317-1",
	 *		    "serverGame": "Sv1",
	 *		    "gameCode": "ORION",
	 *		    "gameName": "Orion Test",
	 *		    "packagesData": [
	 *		      {
	 *		        "key": "K1",
	 *		        "name": "Goi500V",
	 *		        "priceGold": 500,
	 *		        "priceVcoin": 5,
	 *		        "priceUsd": 5,
	 *		        "priceVnd": 500,
	 *				"moneyScale": 100,
	 *				"currency": "KNB",
	 *		        "promotionalPercent": 0,
	 *		        "imageUrl": "",
	 *		        "description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold": 1000
	 *		      },
	 *		      {
	 *		        "key": "K2",
	 *		        "name": "Goi1500V",
	 *		        "priceGold": 1500,
	 *		        "priceVcoin": 10,
	 *		        "priceUsd": 10,
	 *		        "priceVnd": 1500,
	 *				"moneyScale": 100,
	 *				"currency": "KNB",
	 *		        "promotionalPercent": 0,
	 *		        "imageUrl": "",
	 *		        "description": "Mua 500 vang bang 5 vcoin",
	 *				"totalVcoin": 100,
	 *				"totalGold": 1000
	 *		      }
	 *		    ],
	 *		    "status": 1,
	 *		    "description": "",
	 *		    "version": 1,
	 *		    "createdTime": 1469676154666,
	 *		    "updatedTime": 1469676154666
	 *		  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/manage/gameinfo/{clientId}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel gameInfo(@PathVariable String clientId){
		ResponseModel response = new ResponseModel(); 
		try {
			Game game = gameService.findGameInfoByClientId(clientId);
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, game);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	/**
	 * @api {GET} /manage/gameEnvironment/{clientId}/{osType} Get Version GameEnviroment
	 * @apiName GetVersionGameEnviroment
	 * @apiGroup Manage
	 * 
	 * @apiHeader {String} client_id Mandatory client_id header
	 * 
	 * @apiParam {String} clientId	Mandatory ClientId for mapping with server
	 * @apiParam {int} osType	Optional Default is All (1-iOS, 2-Android)
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		{
	 *		  "error": 200,
	 *		  "message": "Success",
	 *		  "info": {
     *			"name": "iOS",
     *			"version": 1
  	 *		  }
	 *		}
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/manage/gameEnvironment/{clientId}",
							"/manage/gameEnvironment/{clientId}/{osType}"}, 
					method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel gameEnvironment(@PathVariable String clientId, @PathVariable Optional<Integer> osType){
		ResponseModel response = new ResponseModel(); 
		try {
			if(osType.isPresent()){
				GameEnvironmentData responseData = gameService.findEnvironmentByClientIdAndOS(clientId, osType.get());
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}else{
				List<GameEnvironmentData> responseData = gameService.findEnvironmentsByClientId(clientId);
				response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
			}
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/manage/verifyGoogle", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel veryfiGoogle(
			@RequestBody GamePaymentRequest request, 
			@RequestParam(value = DataConstants.RequestParams.ClientId, required = true, defaultValue = "") String clientId
				) {
		ResponseModel response = new ResponseModel();
		try {
			GoogleVerifyResponse responseData = commonUtils.verifyPayment_Google(request.getPackageName(), request.getProductId(), request.getReceiptData());
			
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch (Exception e) {
			log.error("ERROR", e);
			response = new ResponseModel(PConstants.RESPONSE.CODE_ERROR, PConstants.RESPONSE.MESS_SYSTEM);
		}

		return response;
	}
}
