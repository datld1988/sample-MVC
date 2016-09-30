package com.vtc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtc.business.AppActivityService;
import com.vtc.dataconstant.DataConstants;
import com.vtc.mongocore.AppActivityMetadata;
import com.vtc.mongocore.Events;
import com.vtc.request.AppActivityRequest;
import com.vtc.response.ResponseModel;
import com.vtc.util.PConstants;

@Controller
public class AppActivityController {
	private static final Logger log = Logger.getLogger(AppActivityController.class);

	@Autowired
	private AppActivityService appActivityService;
	
	/**
	 * @api {POST} /app/activity Log activities
	 * @apiName LogActivity
	 * @apiGroup AppActivity
	 * 
	 * @apiParam {String} manufacture	Manufacture
	 * @apiParam {String} modelName	Model Name of device
	 * @apiParam {String} operatingSystem	Operating system of device
	 * @apiParam {String} operatingSystemVersion	Version of Operation System
	 * @apiParam {String} utm	Mandatory utm link
	 * @apiParam {String} campaign	Name of campaign
	 * @apiParam {String} medium	Name of medium
	 * @apiParam {String} source	Name of source
	 * @apiParam {String} agency	Name of agency
	 * @apiParam {String} clientId	Mandatory  ClientId mapping with server
	 * @apiParam {int} deviceType	Mandatory 1:Web, 2:Mobile
	 * @apiParam {String} deviceId		Mandatory Id of device
	 * @apiParam {String} adsId	Mandatory adsId of device
	 * @apiParam {int} activityType	Manadatory //1:FirstOpen, 2: OpenApp, 3:CloseApp, 4:Crash, 5: Click, 6: Payment
	 * @apiParam {Object} trackingModel	Tracking information that your send GA , server only save data
	 * @apiParam {String} 	trackingModel.gaTrackingId		TrackingId send to Google Analytics
	 * @apiParam {String} 	trackingModel.gaClientId		ClientId of device/user send to Google Analytics
	 * @apiParam {String} 	[trackingModel.hitType="event"]	HitType send to GA default "event"
	 * @apiParam {String} 	trackingModel.category	Name of eventCategory
	 * @apiParam {String} 	trackingModel.action	Name of eventAction
	 * @apiParam {String} 	[trackingModel.label]	Optional Name of eventLabel
	 * @apiParam {String} 	[trackingModel.value]	Optional value of eventvalue
	 *
	 * 
	 * @apiParamExample {json} Request-Example:
	 *		{
	 *			"manufacture": "Iphone",
	 *			"modelName": "Iphone6",
	 *			"operatingSystem": "IOS 8.0",
	 *			"operatingSystemVersion": "8.0",
	 *			"utm": "democlpt://?utm_source=facebook&utm_campaign=demo&utm_medium=1706",
	 *			"campaign": "demo",          					
	 *			"medium": "1706",							
	 *			"source": "facebook",															
	 *			"clientId": "353b302c44574f565045687e534e7d6a",		
	 *			"deviceType": 1,		
	 *			"deviceId": "abababba",
	 *			"adsId": "oiutre-sdf123-df",
	 *			"activityType": 1,
	 *			"trackingModel":{			
	 *					"gaTrackingId": "UA-59062861-18",			
	 *					"gaClientId": "a1b2c3d4e5f6g7h8j9k10",		
	 *					"hitType": "event",			
	 *					"category": "TestCategory1",						
	 *					"action": "TestAction1",															
	 *		    }							
	 *		}
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": null,									
	 *			  "info": {
	 *				    
	 *			  }
	 *		}
	 * @apiSuccess {Object} info It will show data that you send
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/app/activity", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel appActivity(@RequestBody AppActivityRequest request) {
		ResponseModel response = new ResponseModel();

		try {
			Events<AppActivityMetadata> result = appActivityService.appActivity(request);
			if(result == null){
				log.error(new StringBuffer("[ERROR] requestActivityType is incompatible!!!"));
				return new ResponseModel(DataConstants.ResponseCode.ERROR_SYSTEM.getValue(), DataConstants.ResponseCode.ERROR_SYSTEM.getDisplay());
			}
			
			response.setError(PConstants.RESPONSE.CODE_SUCCESS);
			response.setMessage(PConstants.RESPONSE.MESS_SUCCESS);
			response.setInfo(result);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(DataConstants.ResponseCode.ERROR_SYSTEM.getValue(), DataConstants.ResponseCode.ERROR_SYSTEM.getDisplay());
		}
		return response;
	}
	
	/**
	 * @api {GET} /app/firstinstall?ads_id={ads_id} Check first installed
	 * @apiName CheckFirstInstalled
	 * @apiGroup AppActivity
	 * 
	 * @apiParam {String} ads_id	Mandatory ads_id for device
	 *
	 * @apiSuccessExample {json} Success-Response:
	 *     	HTTP/1.1 200 OK
	 *		 {
	 *			  "error": 200,			
	 *			  "message": "Success",									
	 *			  "info": 0
	 *		}
	 * @apiSuccess {Integer} info If it is not install then info = 0, else > 0
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/app/firstinstall", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseModel checkFirstInstall(
			@RequestParam(value = DataConstants.RequestParams.AdsId, required = true, defaultValue = "") String adsId
			){
		ResponseModel response = new ResponseModel();
		try {
			Integer responseData = appActivityService.checkFirst(DataConstants.ActivityTypes.INSTALLED.getDisplay(), adsId);
			response = new ResponseModel(PConstants.RESPONSE.CODE_SUCCESS, PConstants.RESPONSE.MESS_SUCCESS, responseData);
		} catch (Exception e) {
			log.error("[ERROR] ", e);
			response = new ResponseModel(DataConstants.ResponseCode.ERROR_SYSTEM.getValue(), DataConstants.ResponseCode.ERROR_SYSTEM.getDisplay());
		}
		
		return response;
	}
}
